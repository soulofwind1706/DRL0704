package com.tranxuanqui.danhgiarenluyenlv.Model;

import androidx.annotation.NonNull;

public class Lop {
    private int idlop;
    private String tenlop;
    private int idkhoa;

    public int getIdlop() {
        return idlop;
    }

    public void setIdlop(int idlop) {
        this.idlop = idlop;
    }

    public String getTenlop() {
        return tenlop;
    }

    public void setTenlop(String tenlop) {
        this.tenlop = tenlop;
    }

    public int getIdkhoa() {
        return idkhoa;
    }

    public void setIdkhoa(int idkhoa) {
        this.idkhoa = idkhoa;
    }

    public Lop(int idlop, String tenlop, int idkhoa) {
        this.idlop = idlop;
        this.tenlop = tenlop;
        this.idkhoa = idkhoa;
    }

    public Lop() {
    }

    @NonNull
    @Override
    public String toString() {
        return idlop + " - " + tenlop + " - " + idkhoa ;
    }
}
