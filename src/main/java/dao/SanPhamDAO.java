/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import model.SanPham;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SanPhamDAO {

    public List<SanPham> getAll() {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham";
        try (Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(
                        rs.getInt("maSP"),
                        rs.getString("tenSP"),
                        rs.getDouble("gia"),
                        rs.getString("trangThai")
                ));
            }
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());          
        }
        return list;
    }

    public void insert(SanPham sp) {
        String sql = "INSERT INTO SanPham(tenSP, gia, trangThai) VALUES (?,?,?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sp.getTenSP());
            ps.setDouble(2, sp.getGia());
            ps.setString(3, sp.getTrangThai());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());   
        }
    }

    public void update(SanPham sp) {
        String sql = "UPDATE SanPham SET tenSP=?, gia=?, trangThai=? WHERE maSP=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, sp.getTenSP());
            ps.setDouble(2, sp.getGia());
            ps.setString(3, sp.getTrangThai());
            ps.setInt(4, sp.getMaSP());
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());   
        }
    }

    public void delete(int maSP) {
        String sql = "DELETE FROM SanPham WHERE maSP=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maSP);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Loi:" + ex.toString());   
        }
    }

    public SanPham getById(int masp) {
        SanPham sp=null;
        String sql = "SELECT * FROM SanPham WHERE masp=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, masp);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sp=new SanPham(
                        rs.getInt("maSP"),
                        rs.getString("tenSP"),
                        rs.getDouble("gia"),
                        rs.getString("trangThai")
                );
            }
        } catch (Exception ex) {
             System.out.println("Loi:" + ex.toString());   
        }
        return sp;
    }
    public List<SanPham> searchByName(String keyword) {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham WHERE tenSP LIKE ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(
                        rs.getInt("maSP"),
                        rs.getString("tenSP"),
                        rs.getDouble("gia"),
                        rs.getString("trangThai")
                ));
            }
        } catch (Exception ex) {
             System.out.println("Loi:" + ex.toString());   
        }
        return list;
    }

    public List<SanPham> filterByTrangThai(String trangThai) {
        List<SanPham> list = new ArrayList<>();
        String sql = "SELECT * FROM SanPham WHERE trangThai = ?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, trangThai);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SanPham(
                        rs.getInt("maSP"),
                        rs.getString("tenSP"),
                        rs.getDouble("gia"),
                        rs.getString("trangThai")
                ));
            }
        } catch (Exception ex) {
             System.out.println("Loi:" + ex.toString());   
        }
        return list;
    }
}
