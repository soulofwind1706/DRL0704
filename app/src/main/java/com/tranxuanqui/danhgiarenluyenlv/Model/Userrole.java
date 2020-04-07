package com.tranxuanqui.danhgiarenluyenlv.Model;

public class Userrole {
    private int idrole;
    private String tenrole;

    public Userrole() {
    }

    public Userrole(int idrole, String tenrole) {
        this.idrole = idrole;
        this.tenrole = tenrole;
    }

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public String getTenrole() {
        return tenrole;
    }

    public void setTenrole(String tenrole) {
        this.tenrole = tenrole;
    }

    @Override
    public String toString() {
        return idrole + "" + tenrole;
    }
}
