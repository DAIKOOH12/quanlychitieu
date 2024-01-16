package com.example.quanlichitieu;

public class LoaiChi {
    private int iID;
    private String sLoaiChi;

    public LoaiChi(int iID, String sLoaiChi) {
        this.iID = iID;
        this.sLoaiChi = sLoaiChi;
    }

    public int getiID() {
        return iID;
    }

    public void setiID(int iID) {
        this.iID = iID;
    }

    public String getsLoaiChi() {
        return sLoaiChi;
    }

    public void setsLoaiChi(String sLoaiChi) {
        this.sLoaiChi = sLoaiChi;
    }
}
