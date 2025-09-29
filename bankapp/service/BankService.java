package com.mycompany.bankapp.service;

import com.mycompany.bankapp.model.*;
import java.util.ArrayList;
import java.util.List;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.time.YearMonth;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BankService {

    private final ArrayList<Nasabah> daftarNasabah = new ArrayList<>();
    private long noRekCounter = 2025001;

    private static final double SALDO_MINIMUM   = 50_000.0;
    private static final double MIN_SETOR_AWAL  = 50_000.0;
    private static final double MIN_PRIORITAS   = 10_000_000.0;
    private static final double ADMIN_BULANAN_BIASA = 5_000.0;    
    private static final double ADMIN_BULANAN_PRIORITAS = 3_000.0; 
    private static final double RATE_BUNGA_PRIORITAS = 0.02;

    private static final DecimalFormat DF = new DecimalFormat("#,###");
    private static String rp(double v) { return "Rp" + DF.format(Math.round(v)); }

    private final Map<String, YearMonth> lastAdminFeeMonth = new HashMap<>();

    public void buatDataAwal() {
        tambahNasabah("Budi Santoso", 500_000);
        tambahNasabah("Citra Lestari", 12_000_000); 
    }

    public void tambahNasabah(String nama, double setoranAwal) {
        if (setoranAwal < MIN_SETOR_AWAL) {
            System.out.println("Gagal: setoran awal minimal " + rp(MIN_SETOR_AWAL) + ".");
            return;
        }
        String noRek = String.valueOf(noRekCounter++);
        Nasabah n = (setoranAwal >= MIN_PRIORITAS)
                ? new NasabahPrioritas(noRek, nama, setoranAwal)
                : new NasabahBiasa(noRek, nama, setoranAwal);

        daftarNasabah.add(n);
        System.out.println("Nasabah ditambahkan. No Rek: " + noRek);
    }

    public void tampilkanSemuaNasabah() {
        if (daftarNasabah.isEmpty()) {
            System.out.println("Belum ada nasabah.");
            return;
        }
        for (Nasabah n : daftarNasabah) {
            n.tampilkanInfo();
        }
    }

    private Nasabah cariByNoRek(String noRek) {
        for (Nasabah n : daftarNasabah) {
            if (n.getNomorRekening().equals(noRek)) return n;
        }
        return null;
    }

    public Nasabah cariNasabah(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            System.out.println("Keyword pencarian kosong.");
            return null;
        }
        Nasabah byRek = cariByNoRek(keyword.trim());
        if (byRek != null) {
            System.out.println("Ditemukan (berdasarkan No.Rek):");
            byRek.tampilkanInfo();
            return byRek;
        }
        
        String kw = keyword.trim().toLowerCase();
        List<Nasabah> hasil = new ArrayList<>();
        for (Nasabah n : daftarNasabah) {
            if (n.getNama().toLowerCase().contains(kw)) hasil.add(n);
        }
        if (hasil.isEmpty()) {
            System.out.println("Tidak ada nasabah dengan nama/no.rek: " + keyword);
            return null;
        }
        System.out.println("Hasil pencarian nama mengandung \"" + keyword + "\":");
        for (Nasabah n : hasil) n.tampilkanInfo();
        return hasil.get(0);
    }

    public void ubahNamaNasabah(String noRek, String namaBaru) {
        Nasabah n = cariByNoRek(noRek);
        if (n == null) { System.out.println("Rekening tidak ditemukan."); return; }
        n.setNama(namaBaru);
        n.getMutasiRekening().add("Ubah nama nasabah menjadi: " + namaBaru);
        System.out.println("Nama berhasil diubah.");
    }

    public void hapusNasabah(String noRek) {
        Nasabah n = cariByNoRek(noRek);
        if (n == null) { System.out.println("Rekening tidak ditemukan."); return; }
        daftarNasabah.remove(n);
        lastAdminFeeMonth.remove(noRek);
        System.out.println("Nasabah dengan rekening " + noRek + " dihapus.");
    }

    public void setorTunai(String noRek, double jumlah) {
        Nasabah n = cariByNoRek(noRek);
        if (n == null) { System.out.println("Rekening tidak ditemukan."); return; }
        ((Transaksi) n).setor(jumlah);
        System.out.println("Setor sukses. Saldo: " + rp(n.getSaldo()));
    }

    public void tarikTunai(String noRek, double jumlah) {
        Nasabah n = cariByNoRek(noRek);
        if (n == null) { System.out.println("Rekening tidak ditemukan."); return; }
        if (!((Transaksi) n).tarik(jumlah)) return;
        if (n.getSaldo() < SALDO_MINIMUM) {
            System.out.println("Peringatan: saldo di bawah minimum (" + rp(SALDO_MINIMUM) + ").");
        }
        System.out.println("Tarik sukses. Saldo: " + rp(n.getSaldo()));
    }

    public void transferDana(String noRekPengirim, String noRekPenerima, double jumlah) {
        Nasabah pengirim = cariByNoRek(noRekPengirim);
        Nasabah penerima = cariByNoRek(noRekPenerima);
        if (pengirim == null || penerima == null) {
            System.out.println("Rekening pengirim/penerima tidak ditemukan.");
            return;
        }
        if (noRekPengirim.equals(noRekPenerima)) {
            System.out.println("Tidak bisa transfer ke rekening sendiri.");
            return;
        }
        boolean ok = ((Transaksi) pengirim).transfer(penerima, jumlah,
                "Transfer ke " + noRekPenerima);
        if (ok) {
            System.out.println("Transfer sukses. Saldo pengirim: " + rp(pengirim.getSaldo()));
        }
    }

    private void prosesBiayaAdminBulananOtomatis(String noRek) {
        Nasabah n = cariByNoRek(noRek);
        if (n == null) return;
        
        double biayaAdmin;
        String jenisNasabah;
        if (n instanceof NasabahPrioritas) {
            biayaAdmin = ADMIN_BULANAN_PRIORITAS; 
            jenisNasabah = "Prioritas";
        } else {
            biayaAdmin = ADMIN_BULANAN_BIASA; 
            jenisNasabah = "Biasa";
        }

        YearMonth sekarang = YearMonth.now();
        YearMonth terakhir = lastAdminFeeMonth.get(noRek);

        if (!sekarang.equals(terakhir)) {
            if (n.getSaldo() >= biayaAdmin) {
                n.setSaldo(n.getSaldo() - biayaAdmin);
                DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
                String ts = LocalDateTime.now().format(fmt);
                n.getMutasiRekening().add(ts + " | Biaya admin bulanan " + jenisNasabah + ": -" + rp(biayaAdmin)
                        + " | Saldo: " + rp(n.getSaldo()));
                lastAdminFeeMonth.put(noRek, sekarang);
                System.out.println("Biaya admin bulan " + sekarang + " (" + jenisNasabah + ") dipotong untuk "
                        + noRek + " sebesar " + rp(biayaAdmin) + ".");
            } else {
                lastAdminFeeMonth.put(noRek, sekarang); 
                System.out.println("Saldo tidak cukup untuk biaya admin bulan " + sekarang
                        + " (" + jenisNasabah + ", Rek " + noRek + ").");
            }
        }
    }

    public void lihatMutasiRekening(String noRek) {
        prosesBiayaAdminBulananOtomatis(noRek);

        Nasabah n = cariByNoRek(noRek);
        if (n == null) { System.out.println("Rekening tidak ditemukan."); return; }
        System.out.println("== Mutasi Rekening " + noRek + " ==");
        if (n.getMutasiRekening().isEmpty()) {
            System.out.println("(kosong)");
            return;
        }
        for (String m : n.getMutasiRekening()) {
            System.out.println("- " + m);
        }
    }

    public void beriBungaNasabahPrioritas() {
        int hitung = 0;
        for (Nasabah n : daftarNasabah) {
            if (n instanceof NasabahPrioritas) {
                double bunga = n.getSaldo() * RATE_BUNGA_PRIORITAS;
                n.setSaldo(n.getSaldo() + bunga);
                n.getMutasiRekening().add("Bunga tabungan: +" + rp(bunga));
                System.out.println("Bunga diberikan ke " + n.getNama() + " "
                        + rp(bunga) + ". Saldo baru: " + rp(n.getSaldo()));
                hitung++;
            }
        }
        if (hitung == 0) {
            System.out.println("Tidak ada Nasabah Prioritas yang diproses.");
            System.out.println("Tip: setoran awal ≥ " + rp(MIN_PRIORITAS) + " akan menjadi Prioritas.");
        } else {
            System.out.println("Total Nasabah Prioritas diproses: " + hitung);
        }
    }
}