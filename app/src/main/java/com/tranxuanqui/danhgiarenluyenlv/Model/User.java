package com.tranxuanqui.danhgiarenluyenlv.Model;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class User implements Serializable {
    private int iduser;
    private String tenuser;
    private String emailuser;
    private String password;
    private int idrole;
    private int idlop;

    public User(int iduser, String tenuser, String emailuser, String password, int idrole,int idlop) {
        this.iduser = iduser;
        this.tenuser = tenuser;
        this.emailuser = emailuser;
        this.password = password;
        this.idrole = idrole;
        this.idlop = idlop;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(Integer iduser) {
        this.iduser = iduser;
    }

    public String getTenuser() {
        return tenuser;
    }

    public void setTenuser(String tenuser) {
        this.tenuser = tenuser;
    }

    public String getEmailuser() {
        return emailuser;
    }

    public void setEmailuser(String emailuser) {
        this.emailuser = emailuser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public int getIdlop() {
        return idlop;
    }

    public void setIdlop(int idlop) {
        this.idlop = idlop;
    }

    public User() {
    }



    @NonNull
    @Override
    public String toString() {
        return  " " + tenuser  + " - " + idrole;
    }
}