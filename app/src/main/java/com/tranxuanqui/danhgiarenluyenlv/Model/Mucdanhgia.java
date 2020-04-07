package com.tranxuanqui.danhgiarenluyenlv.Model;

import androidx.annotation.NonNull;

import java.io.Serializable;
import java.util.ArrayList;

public class Mucdanhgia implements Serializable{
    private int idmucdanhgia;
    private String noidung;
    private int maxdiem;
    private int iduser;

    private int diem;

    //private ArrayList<Tieuchi> listTieuChi;

    public int getDiem() {
        return diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    public Mucdanhgia(String noidung) {
        this.noidung = noidung;
    }


    public int getIdmucdanhgia() {
        return idmucdanhgia;
    }

    public void setMucdanhgia(int mucdanhgia) {
        this.idmucdanhgia = mucdanhgia;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getMaxdiem() {
        return maxdiem;
    }

    public void setMaxdiem(int maxdiem) {
        this.maxdiem = maxdiem;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }


    public Mucdanhgia() {
    }

    public Mucdanhgia(int idmucdanhgia, String noidung, int maxdiem, int iduser) {
        this.idmucdanhgia = idmucdanhgia;
        this.noidung = noidung;
        this.maxdiem = maxdiem;
        this.iduser = iduser;
    }

    @NonNull
    @Override
    public String toString() {
        return " " + noidung + " " + maxdiem + " ";
    }
}
