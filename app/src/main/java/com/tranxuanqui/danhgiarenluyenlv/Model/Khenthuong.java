package com.tranxuanqui.danhgiarenluyenlv.Model;

public class Khenthuong {
    private int idkhenthuong;
    private String danhhieu;
    private int maxdiem;
    private String noidung;
    private int iduser;

    public Khenthuong() {
    }

    public Khenthuong(int idkhenthuong, String danhhieu, int maxdiem, String noidung, int iduser) {
        this.idkhenthuong = idkhenthuong;
        this.danhhieu = danhhieu;
        this.maxdiem = maxdiem;
        this.noidung = noidung;
        this.iduser = iduser;
    }

    public int getIdkhenthuong() {
        return idkhenthuong;
    }

    public void setIdkhenthuong(int idkhenthuong) {
        this.idkhenthuong = idkhenthuong;
    }

    public String getDanhhieu() {
        return danhhieu;
    }

    public void setDanhhieu(String danhhieu) {
        this.danhhieu = danhhieu;
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
        return idkhenthuong + "" + danhhieu + "" + maxdiem + "" + noidung+ "" + iduser;
    }
}
