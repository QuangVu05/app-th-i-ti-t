package com.example.myapplication;

public class Thoi_tiet {
    int idAnh;
    String ngay;
    String nhietDo;

    public Thoi_tiet(int idAnh, String ngay, String nhietDo) {
        this.idAnh = idAnh;
        this.ngay = ngay;
        this.nhietDo = nhietDo;
    }

    public int getIdAnh() {
        return idAnh;
    }

    public String getNgay() {
        return ngay;
    }

    public String getNhietDo() {
        return nhietDo;
    }

    public void setIdAnh(int idAnh) {
        this.idAnh = idAnh;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public void setNhietDo(String nhietDo) {
        this.nhietDo = nhietDo;
    }
}
