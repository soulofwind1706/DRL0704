package com.tranxuanqui.danhgiarenluyenlv.Model;

public class Chitietdanhgia {
    private int idchitiet;
    private int iduser;
    private String ten;
    private int hocki;
    private int diem_phongctsv;
    private int sodiem;
    private int idtieuchi;
    private int diem_covan;
    private int diem_sinhvien;
    private int idhocki;
    private int idmucdanhgia;

    public Chitietdanhgia() {
    }

    public Chitietdanhgia(int idchitiet, int iduser, String ten, int hocki, int diem_phongctsv, int sodiem, int idtieuchi, int diem_covan, int diem_sinhvien, int idhocki, int idmucdanhgia) {
        this.idchitiet = idchitiet;
        this.iduser = iduser;
        this.ten = ten;
        this.hocki = hocki;
        this.diem_phongctsv = diem_phongctsv;
        this.sodiem = sodiem;
        this.idtieuchi = idtieuchi;
        this.diem_covan = diem_covan;
        this.diem_sinhvien = diem_sinhvien;
        this.idhocki = idhocki;
        this.idmucdanhgia = idmucdanhgia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getIdchitiet() {
        return idchitiet;
    }

    public void setIdchitiet(int idchitiet) {
        this.idchitiet = idchitiet;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getHocki() {
        return hocki;
    }

    public void setHocki(int hocki) {
        this.hocki = hocki;
    }

    public int getDiem_phongctsv() {
        return diem_phongctsv;
    }

    public void setDiem_phongctsv(int diem_phongctsv) {
        this.diem_phongctsv = diem_phongctsv;
    }

    public int getSodiem() {
        return sodiem;
    }

    public void setSodiem(int sodiem) {
        this.sodiem = sodiem;
    }

    public int getIdtieuchi() {
        return idtieuchi;
    }

    public void setIdtieuchi(int idtieuchi) {
        this.idtieuchi = idtieuchi;
    }

    public int getDiem_covan() {
        return diem_covan;
    }

    public void setDiem_covan(int diem_covan) {
        this.diem_covan = diem_covan;
    }

    public int getDiem_sinhvien() {
        return diem_sinhvien;
    }

    public void setDiem_sinhvien(int diem_sinhvien) {
        this.diem_sinhvien = diem_sinhvien;
    }

    public int getIdhocki() {
        return idhocki;
    }

    public void setIdhocki(int idhocki) {
        this.idhocki = idhocki;
    }

    public int getIdmucdanhgia() {
        return idmucdanhgia;
    }

    public void setIdmucdanhgia(int idmucdanhgia) {
        this.idmucdanhgia = idmucdanhgia;
    }

    @Override
    public String toString() {
        return idchitiet + "" + iduser + "" + hocki + "" + diem_phongctsv + "" + sodiem + "" + idtieuchi + "" + diem_covan + "" + diem_sinhvien + "" + idhocki + "" + idmucdanhgia;
    }
}
