package com.mycompany.bankapp.model;

public class NasabahPrioritas extends Nasabah {
    public NasabahPrioritas(String nomorRekening, String nama, double saldoAwal) {
        super(nomorRekening, nama, saldoAwal);
    }

    @Override
    public String getJenisNasabah() { return "Nasabah Prioritas"; }

    @Override
    protected double biayaTransfer(double jumlah) {
        if (jumlah <= 25_000_000) return 0.0;
        double fee = Math.ceil(jumlah * 0.0002);
        return Math.max(fee, 2000.0);
    }

    @Override
    public void tampilkanInfo() {
        System.out.print("[Nasabah Prioritas] ");
        super.tampilkanInfo();
    }
}
