package com.mycompany.bankapp.model;

public class NasabahBiasa extends Nasabah {
    public NasabahBiasa(String nomorRekening, String nama, double saldoAwal) {
        super(nomorRekening, nama, saldoAwal);
    }

    @Override
    public String getJenisNasabah() { return "Nasabah Biasa"; }

    @Override
    protected double biayaTransfer(double jumlah) {
        return (jumlah <= 1_000_000) ? 2500.0 : 5000.0;
    }

    @Override
    public void tampilkanInfo() {
        System.out.print("[Nasabah Biasa] ");
        super.tampilkanInfo();
    }
}
