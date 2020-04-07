package com.tranxuanqui.danhgiarenluyenlv.Model;


import androidx.annotation.NonNull;

import java.io.Serializable;

public class Tieuchi implements Serializable {
    private int idtieuchi;
    private String noidung;
    private int maxdiem;
    private int idmucdanhgia;
    private boolean check;

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public Tieuchi(String noidung, int maxdiem, int idmucdanhgia) {
        this.noidung = noidung;
        this.maxdiem = maxdiem;
        this.idmucdanhgia = idmucdanhgia;
    }

    public Tieuchi() {
    }

    public int getIdtieuchi() {
        return idtieuchi;
    }

    public void setIdtieuchi(Integer idtieuchi) {
        this.idtieuchi = idtieuchi;
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

    public int getIdmucdanhgia() {
        return idmucdanhgia;
    }

    public void setIdmucdanhgia(int idmucdanhgia) {
        this.idmucdanhgia = idmucdanhgia;
    }

    public Tieuchi(int idtieuchi, String noidung, int maxdiem, int idmucdanhgia) {
        this.idtieuchi = idtieuchi;
        this.noidung = noidung;
        this.maxdiem = maxdiem;
        this.idmucdanhgia = idmucdanhgia;
    }




    @NonNull
    @Override
    public String toString() {
        return   " " + noidung + " " + maxdiem + " ";
    }
}
