package com.mycompany.bankapp.model;

public interface Transaksi {
    void setor(double jumlah);
    void setor(double jumlah, String keterangan);

    boolean tarik(double jumlah);
    boolean tarik(double jumlah, String keterangan);

    boolean transfer(Nasabah tujuan, double jumlah);
    boolean transfer(Nasabah tujuan, double jumlah, String keterangan);
}
