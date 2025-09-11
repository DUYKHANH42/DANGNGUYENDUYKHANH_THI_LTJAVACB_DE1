/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.SinhVien;
import util.DBConnection;

public class SinhVienDAO {

     // Lấy tất cả sinh viên
    public List<SinhVien> getAll() {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM SinhVien";
        try (Connection conn = DBConnection.getConnection(); Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new SinhVien(
                        rs.getInt("MaSV"),
                        rs.getString("HoTen"),
                        rs.getInt("Tuoi"),
                        rs.getString("GioiTinh")
                ));
            }
        } catch (Exception e) {
            System.out.println("Loi:" + e.toString());
        }
        return list;
    }
    
    // Thêm sinh viên
    public boolean insert(SinhVien sv) {
        String sql = "INSERT INTO SinhVien (HoTen, Tuoi, GioiTinh) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sv.getHoTen());
            ps.setInt(2, sv.getTuoi());
            ps.setString(3, sv.getGioiTinh());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Loi:" + e.toString());
        }
        return false;
    }

    // Cập nhật sinh viên
    public boolean update(SinhVien sv) {
        String sql = "UPDATE SinhVien SET HoTen=?, Tuoi=?, GioiTinh=? WHERE MaSV=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, sv.getHoTen());
            ps.setInt(2, sv.getTuoi());
            ps.setString(3, sv.getGioiTinh());
            ps.setInt(4, sv.getMaSV());
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Loi:" + e.toString());
        }
        return false;
    }

    // Xóa sinh viên
    public boolean delete(int maSV) {
        String sql = "DELETE FROM SinhVien WHERE MaSV=?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maSV);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Loi:" + e.toString());
        }
        return false;
    }   

    // Lấy thông tin 1 sinh viên theo mã
    public SinhVien getById(int maSV) {
        SinhVien sv = null;
        String sql = "SELECT * FROM SinhVien WHERE MaSV = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, maSV);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                sv = new SinhVien(
                        rs.getInt("MaSV"),
                        rs.getString("HoTen"),
                        rs.getInt("Tuoi"),
                        rs.getString("GioiTinh")
                );
            }
        } catch (Exception e) {
            System.out.println("Loi:" + e.toString());
        }
        return sv;
    }

    // Tìm sinh viên theo tên
    public List<SinhVien> searchByName(String keyword) {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM SinhVien WHERE HoTen LIKE ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SinhVien(
                        rs.getInt("MaSV"),
                        rs.getString("HoTen"),
                        rs.getInt("Tuoi"),
                        rs.getString("GioiTinh")
                ));
            }
        } catch (Exception e) {
            System.out.println("Loi:" + e.toString());
        }
        return list;
    }

    // Lọc theo giới tính
    public List<SinhVien> filterByGender(String gioiTinh) {
        List<SinhVien> list = new ArrayList<>();
        String sql = "SELECT * FROM SinhVien WHERE GioiTinh = ?";
        try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, gioiTinh);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new SinhVien(
                        rs.getInt("MaSV"),
                        rs.getString("HoTen"),
                        rs.getInt("Tuoi"),
                        rs.getString("GioiTinh")
                ));
            }
        } catch (Exception e) {
            System.out.println("Loi:" + e.toString());
        }
        return list;
    }
}
