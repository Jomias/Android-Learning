package com.example.memorygame;

public class HinhAnh {
    private String Ten;
    private int Hinh;

    public HinhAnh(String ten, int hinh) {
        Ten = ten;
        Hinh = hinh;
    }
    public HinhAnh(HinhAnh hinhAnh) {
        Ten = hinhAnh.Ten;
        Hinh = hinhAnh.Hinh;
    }
    public String getTen() {
        return Ten;
    }

    public void setTen(String ten) {
        Ten = ten;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}
