package com.example.studylistview;

public class SinhVien {
    private String hoTen;
    private Integer namSinh;
    private Integer hinh;
    public SinhVien(String hoTen, Integer namSinh, Integer hinh) {
        this.hoTen = hoTen;
        this.namSinh = namSinh;
        this.hinh = hinh;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Integer getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Integer namSinh) {
        this.namSinh = namSinh;
    }

    public Integer getHinh() {
        return hinh;
    }

    public void setHinh(Integer namSinh) {
        this.hinh = namSinh;
    }
}
