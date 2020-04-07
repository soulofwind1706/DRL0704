package com.tranxuanqui.danhgiarenluyenlv.Model;

public class Kiluat {
    private int idkiluat;
    private String mucdo;
    private int maxdiem;
    private String noidung;
    private int iduser;

    public Kiluat() {
    }

    public Kiluat(int idkiluat, String mucdo, int maxdiem, String noidung, int iduser) {
        this.idkiluat = idkiluat;
        this.mucdo = mucdo;
        this.maxdiem = maxdiem;
        this.noidung = noidung;
        this.iduser = iduser;
    }

    public int getIdkiluat() {
        return idkiluat;
    }

    public void setIdkiluat(int idkiluat) {
        this.idkiluat = idkiluat;
    }

    public String getMucdo() {
        return mucdo;
    }

    public void setMucdo(String mucdo) {
        this.mucdo = mucdo;
    }

    public int getMaxdiem() {
        return maxdiem;
    }

    public void setMaxdiem(int maxdiem) {
        this.maxdiem = maxdiem;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    @Override
    public String toString() {
        return idkiluat + "" + mucdo + "" + maxdiem + "'" + noidung + "" + iduser ;
    }
}
