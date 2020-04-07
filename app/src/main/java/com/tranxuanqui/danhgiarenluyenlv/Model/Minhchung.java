package com.tranxuanqui.danhgiarenluyenlv.Model;

import java.util.Arrays;

public class Minhchung {
    private int idminhchung;
    private String noidung;
    private byte[] hinhanh;
    private int idchitiet;

    public Minhchung() {
    }

    public Minhchung(int idminhchung, String noidung, byte[] hinhanh, int idchitiet) {
        this.idminhchung = idminhchung;
        this.noidung = noidung;
        this.hinhanh = hinhanh;
        this.idchitiet = idchitiet;
    }

    public int getIdminhchung() {
        return idminhchung;
    }

    public void setIdminhchung(int idminhchung) {
        this.idminhchung = idminhchung;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public byte[] getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(byte[] hinhanh) {
        this.hinhanh = hinhanh;
    }

    public int getIdchitiet() {
        return idchitiet;
    }

    public void setIdchitiet(int idchitiet) {
        this.idchitiet = idchitiet;
    }

    @Override
    public String toString() {
        return idminhchung +
                "" + noidung + "" + Arrays.toString(hinhanh) + "" + idchitiet;
    }
}
