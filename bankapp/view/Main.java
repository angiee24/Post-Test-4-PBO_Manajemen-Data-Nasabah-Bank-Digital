package com.mycompany.bankapp.view;

import com.mycompany.bankapp.service.BankService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankService service = new BankService();
        service.buatDataAwal(); 
        
        while (true) {
            System.out.println("\n--- Program Bank Digital ---");
            System.out.println("1. Tambah Nasabah");
            System.out.println("2. Tampilkan Nasabah");
            System.out.println("3. Ubah Nama Nasabah");
            System.out.println("4. Hapus Nasabah");
            System.out.println("5. Lakukan Transaksi");
            System.out.println("6. Lihat Mutasi Rekening");
            System.out.println("7. Cari Nasabah (Nama/No. Rek)");
            System.out.println("8. Bonus untuk Nasabah Prioritas");
            System.out.println("9. Keluar");
            System.out.print("Pilih menu (1-9): ");

            String input = scanner.nextLine();
            int pilihan;

            try {
                pilihan = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, masukkan angka!");
                continue;
            }

            switch (pilihan) {
                case 1 -> { 
                    System.out.print("Nama Nasabah: ");
                    String nama = scanner.nextLine();

                    double saldoAwal;
                    while (true) {
                        System.out.print("Setoran Awal (min Rp50.000): ");
                        String s = scanner.nextLine().trim();
                        try {
                            saldoAwal = Double.parseDouble(s);
                            if (saldoAwal < 50_000) {
                                System.out.println("Setoran awal minimal Rp50.000. Coba lagi.");
                                continue;
                            }
                            break; 
                        } catch (NumberFormatException ex) {
                            System.out.println("Input harus ANGKA. Contoh: 75000");
                        }
                    }

                    service.tambahNasabah(nama, saldoAwal);
                }

                case 2 -> service.tampilkanSemuaNasabah();

                case 3 -> {
                    System.out.print("Masukkan No. Rekening: ");
                    String noRekUbah = scanner.nextLine();
                    System.out.print("Nama Baru: ");
                    String namaBaru = scanner.nextLine();
                    service.ubahNamaNasabah(noRekUbah, namaBaru);
                }

                case 4 -> {
                    System.out.print("Masukkan No. Rekening: ");
                    String noRekHapus = scanner.nextLine();
                    service.hapusNasabah(noRekHapus);
                }

                case 5 -> menuTransaksi(scanner, service);

                case 6 -> {
                    System.out.print("Masukkan No. Rekening: ");
                    String noRekMutasi = scanner.nextLine();
                    service.lihatMutasiRekening(noRekMutasi);
                }

                case 7 -> {
                    System.out.print("Masukkan Nama atau No. Rekening: ");
                    String keyword = scanner.nextLine();
                    service.cariNasabah(keyword);
                }

                case 8 -> service.beriBungaNasabahPrioritas();

                case 9 -> {
                    System.out.println("Terima kasih!");
                    return;
                }

                default -> System.out.println("Pilihan harus antara 1 sampai 9.");
            }
        }
    }

    private static void menuTransaksi(Scanner scanner, BankService service) {
        while (true) {
            System.out.println("\n--- Menu Transaksi ---");
            System.out.println("1. Setor Tunai");
            System.out.println("2. Tarik Tunai");
            System.out.println("3. Transfer Dana");
            System.out.println("4. Kembali ke Menu Utama");
            System.out.print("Pilih menu (1-4): ");

            String input = scanner.nextLine();
            int pilihan;

            try {
                pilihan = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Input tidak valid, masukkan angka!");
                continue;
            }

            switch (pilihan) {
                case 1 -> {
                    System.out.print("No.Rek: ");
                    String noRekSetor = scanner.nextLine();
                    double jumlahSetor;
                    while (true) {
                        System.out.print("Jumlah Setor: ");
                        String s = scanner.nextLine().trim();
                        try {
                            jumlahSetor = Double.parseDouble(s);
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Input harus ANGKA. Contoh: 100000");
                        }
                    }
                    service.setorTunai(noRekSetor, jumlahSetor);
                }

                case 2 -> {
                    System.out.print("No.Rek: ");
                    String noRekTarik = scanner.nextLine();
                    double jumlahTarik;
                    while (true) {
                        System.out.print("Jumlah Tarik: ");
                        String s = scanner.nextLine().trim();
                        try {
                            jumlahTarik = Double.parseDouble(s);
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Input harus ANGKA. Contoh: 50000");
                        }
                    }
                    service.tarikTunai(noRekTarik, jumlahTarik);
                }

                case 3 -> {
                    System.out.print("No.Rek Pengirim: ");
                    String noRekPengirim = scanner.nextLine();
                    System.out.print("No.Rek Penerima: ");
                    String noRekPenerima = scanner.nextLine();
                    double jumlahTransfer;
                    while (true) {
                        System.out.print("Jumlah Transfer: ");
                        String s = scanner.nextLine().trim();
                        try {
                            jumlahTransfer = Double.parseDouble(s);
                            break;
                        } catch (NumberFormatException ex) {
                            System.out.println("Input harus ANGKA. Contoh: 250000");
                        }
                    }
                    service.transferDana(noRekPengirim, noRekPenerima, jumlahTransfer);
                }

                case 4 -> { return; }

                default -> System.out.println("Pilihan tidak valid.");
            }
        }
    }
}