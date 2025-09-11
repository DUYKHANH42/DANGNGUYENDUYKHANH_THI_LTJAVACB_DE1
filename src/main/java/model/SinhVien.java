/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class SinhVien {

    private int maSV;
    private String hoTen;
    private int tuoi;
    private String gioiTinh;

    public SinhVien() {
    }

    public SinhVien(int maSV, String hoTen, int tuoi, String gioiTinh) {
        this.maSV = maSV;
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
    }

    public SinhVien(String hoTen, int tuoi, String gioiTinh) {
        this.hoTen = hoTen;
        this.tuoi = tuoi;
        this.gioiTinh = gioiTinh;
    }

    public int getMaSV() {
        return maSV;
    }

    public void setMaSV(int maSV) {
        this.maSV = maSV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    @Override
    public String toString() {
        return "SinhVien{" + "maSV=" + maSV + ", hoTen=" + hoTen + ", tuoi=" + tuoi + ", gioiTinh=" + gioiTinh + '}';
    }
    
}
