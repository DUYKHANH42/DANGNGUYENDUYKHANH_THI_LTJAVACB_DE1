/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author THANH
 */
public class SanPham {
    private int maSP;
    private String tenSP;
    private double gia;
    private String trangThai;

    public SanPham(int maSP, String tenSP, double gia, String trangThai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public SanPham(String tenSP, double gia, String trangThai) {
        this.tenSP = tenSP;
        this.gia = gia;
        this.trangThai = trangThai;
    }

    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public String toString() {
        return "SanPham{" + "maSP=" + maSP + ", tenSP=" + tenSP + ", gia=" + gia + ", trangThai=" + trangThai + '}';
    }    
    
}
