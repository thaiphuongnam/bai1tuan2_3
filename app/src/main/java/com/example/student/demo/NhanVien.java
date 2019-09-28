package com.example.student.demo;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements  Serializable {
    private int id;
    private String hoTen;
    private boolean gioiTinhNam;

    public NhanVien(int id, String hoTen, boolean gioiTinh) {
        this.id = id;
        this.hoTen = hoTen;
        this.gioiTinhNam = gioiTinh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public boolean isGioiTinhNam() {
        return gioiTinhNam;
    }

    public void setGioiTinh(boolean gioiTinhNam) {
        this.gioiTinhNam = gioiTinhNam;
    }

    @Override
    public String toString() {
        String gioiTinh = "";
        if (gioiTinhNam)
            gioiTinh = "Nam";
        else
            gioiTinh = "Nu";
        return hoTen+" "+gioiTinh+" "+id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NhanVien nhanVien = (NhanVien) o;
        return id == nhanVien.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
