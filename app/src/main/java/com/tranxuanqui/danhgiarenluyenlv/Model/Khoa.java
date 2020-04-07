package com.tranxuanqui.danhgiarenluyenlv.Model;

public class Khoa {
    private int idkhoa;
    private String tenkhoa;

    public Khoa() {
    }

    public Khoa(int idkhoa, String tenkhoa) {
        this.idkhoa = idkhoa;
        this.tenkhoa = tenkhoa;
    }

    public int getIdkhoa() {
        return idkhoa;
    }

    public void setIdkhoa(int idkhoa) {
        this.idkhoa = idkhoa;
    }

    public String getTenkhoa() {
        return tenkhoa;
    }

    public void setTenkhoa(String tenkhoa) {
        this.tenkhoa = tenkhoa;
    }

    @Override
    public String toString() {
        return idkhoa + "" + tenkhoa;
    }
}
