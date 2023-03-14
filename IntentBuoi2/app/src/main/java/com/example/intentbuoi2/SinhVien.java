package com.example.intentbuoi2;

import java.io.Serializable;

public class SinhVien implements Serializable {
    private int maSV;
    private String queQuan;

    public SinhVien(int maSV, String queQuan) {
        this.maSV = maSV;
        this.queQuan = queQuan;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    @Override
    public String toString() {
        return maSV + "\n" + this.queQuan;
    }
}
