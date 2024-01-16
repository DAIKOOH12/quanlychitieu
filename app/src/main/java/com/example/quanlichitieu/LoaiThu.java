package com.example.quanlichitieu;

public class LoaiThu {
    private int iID;
    private String sLoaiThu;

    public LoaiThu(int iID, String sLoaiThu) {
        this.iID = iID;
        this.sLoaiThu = sLoaiThu;
    }

    public int getiID() {
        return iID;
    }

    public void setiID(int iID) {
        this.iID = iID;
    }

    public String getsLoaiThu() {
        return sLoaiThu;
    }

    public void setsLoaiThu(String sLoaiThu) {
        this.sLoaiThu = sLoaiThu;
    }
}
