package com.tranxuanqui.danhgiarenluyenlv.Model;

public class Hocki {
    private int idhocki;
    private String tenhocki;
    private int hockihientai;

    public Hocki() {
    }

    public Hocki(int idhocki, String tenhocki, int hockihientai) {
        this.idhocki = idhocki;
        this.tenhocki = tenhocki;
        this.hockihientai = hockihientai;
    }

    public int getIdhocki() {
        return idhocki;
    }

    public void setIdhocki(int idhocki) {
        this.idhocki = idhocki;
    }

    public String getTenhocki() {
        return tenhocki;
    }

    public void setTenhocki(String tenhocki) {
        this.tenhocki = tenhocki;
    }

    public int getHockihientai() {
        return hockihientai;
    }

    public void setHockihientai(int hockihientai) {
        this.hockihientai = hockihientai;
    }

    @Override
    public String toString() {
        return idhocki + "" + tenhocki + "" + hockihientai;
    }
}
