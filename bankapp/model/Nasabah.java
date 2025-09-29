package com.mycompany.bankapp.model;

import java.util.ArrayList;
import java.util.List;
import java.text.DecimalFormat; 
import java.util.Locale;      

public abstract class Nasabah implements Transaksi {
    private String nomorRekening;
    private String nama;
    protected double saldo;
    private final List<String> mutasiRekening = new ArrayList<>();

    private static final DecimalFormat DF_LOCAL = (DecimalFormat) DecimalFormat.getInstance(new Locale("id", "ID"));
    static {
        DF_LOCAL.applyPattern("#,###");
    }
    
    private String rp(double v) { return "Rp" + DF_LOCAL.format(Math.round(v)); }

    public Nasabah(String nomorRekening, String nama, double saldoAwal) {
        this.nomorRekening = nomorRekening;
        this.nama = nama;
        this.saldo = saldoAwal;
        catat("Buka rekening, setoran awal " + rp(saldoAwal)); 
    }

    public abstract String getJenisNasabah();
    protected abstract double biayaTransfer(double jumlah);

    public String getNomorRekening() { return nomorRekening; }
    public void setNomorRekening(String nomorRekening) { this.nomorRekening = nomorRekening; }

    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }

    public double getSaldo() { return saldo; }
    public void setSaldo(double saldo) { this.saldo = saldo; }

    public List<String> getMutasiRekening() { return mutasiRekening; }

    protected void catat(String k) { mutasiRekening.add(k); }

    @Override
    public void setor(double jumlah) { setor(jumlah, "Setoran tunai"); }

    @Override
    public void setor(double jumlah, String keterangan) {
        if (jumlah <= 0) {
            System.out.println("Jumlah setoran harus > 0");
            return;
        }
        saldo += jumlah;
        catat(keterangan + ": +Rp" + rp(jumlah) + " | Saldo: " + rp(saldo)); 
    }

    @Override
    public boolean tarik(double jumlah) { return tarik(jumlah, "Tarik tunai"); }

    @Override
    public boolean tarik(double jumlah, String keterangan) {
        if (jumlah <= 0) {
            System.out.println("Jumlah penarikan harus > 0");
            return false;
        }
        if (jumlah > saldo) {
            System.out.println("Saldo tidak cukup.");
            return false;
        }
        saldo -= jumlah;
        catat(keterangan + ": -Rp" + rp(jumlah) + " | Saldo: " + rp(saldo)); 
        return true;
    }

    @Override
    public boolean transfer(Nasabah tujuan, double jumlah) {
        return transfer(tujuan, jumlah, "Transfer ke " + (tujuan != null ? tujuan.getNomorRekening() : "-"));
    }

    @Override
    public boolean transfer(Nasabah tujuan, double jumlah, String keterangan) {
        if (tujuan == null) {
            System.out.println("Rekening tujuan tidak valid.");
            return false;
        }
        if (jumlah <= 0) {
            System.out.println("Jumlah transfer harus > 0");
            return false;
        }
        double fee = biayaTransfer(jumlah);
        double total = jumlah + fee;
        if (total > saldo) {
            System.out.println("Saldo tidak cukup (termasuk biaya " + rp(fee) + ").");
            return false;
        }
        this.saldo -= total;
        tujuan.saldo += jumlah;

        catat(keterangan + ": -Rp" + rp(jumlah) + " | Biaya: " + rp(fee) + " | Saldo: " + rp(saldo));
        tujuan.catat("Terima " + keterangan.replace("ke", "dari") + ": +Rp" + rp(jumlah) + " | Saldo: " + rp(tujuan.saldo));
        return true;
    }

    public void tampilkanInfo() {
        System.out.println("[" + getJenisNasabah() + "] Rek: " + nomorRekening +
                " | Nama: " + nama + " | Saldo: " + rp(saldo));
    }
}