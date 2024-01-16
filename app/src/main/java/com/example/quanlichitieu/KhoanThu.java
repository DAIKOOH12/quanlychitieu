package com.example.quanlichitieu;

public class KhoanThu {
    private int iID;
    private String sKhoanThu;
    private long lCostThu;

    public KhoanThu(int iID, String sKhoanThu, long lCostThu) {
        this.iID = iID;
        this.sKhoanThu = sKhoanThu;
        this.lCostThu = lCostThu;
    }

    public int getiID() {
        return iID;
    }

    public void setiID(int iID) {
        this.iID = iID;
    }

    public String getsKhoanThu() {
        return sKhoanThu;
    }

    public void setsKhoanThu(String sKhoanThu) {
        this.sKhoanThu = sKhoanThu;
    }

    public long getlCostThu() {
        return lCostThu;
    }

    public void setlCostThu(long lCostThu) {
        this.lCostThu = lCostThu;
    }
}
