package com.example.quanlichitieu;

public class KhoanChi {
    private int iID;
    private String sKhoanChi;
    private long lCostChi;

    public KhoanChi(int iID, String sKhoanChi, long lCostChi) {
        this.iID = iID;
        this.sKhoanChi = sKhoanChi;
        this.lCostChi = lCostChi;
    }

    public int getiID() {
        return iID;
    }

    public void setiID(int iID) {
        this.iID = iID;
    }

    public String getsKhoanChi() {
        return sKhoanChi;
    }

    public void setsKhoanChi(String sKhoanChi) {
        this.sKhoanChi = sKhoanChi;
    }

    public long getlCostChi() {
        return lCostChi;
    }

    public void setlCostChi(long lCostChi) {
        this.lCostChi = lCostChi;
    }
}
