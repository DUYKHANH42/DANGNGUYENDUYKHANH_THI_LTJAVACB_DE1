CREATE DATABASE QLSV;
GO

-- Sử dụng database
USE QLSV;
GO

-- Tạo bảng SinhVien
CREATE TABLE SinhVien (
    MaSV INT IDENTITY(1,1) PRIMARY KEY,   -- Tự tăng
    HoTen NVARCHAR(100) NOT NULL,
    Tuoi INT NOT NULL,
    GioiTinh NVARCHAR(10) NOT NULL CHECK (GioiTinh IN (N'Nam', N'Nữ'))
);
GO

-- Thêm dữ liệu mẫu
INSERT INTO SinhVien (HoTen, Tuoi, GioiTinh) VALUES
(N'Nguyễn Văn An', 20, N'Nam'),
(N'Trần Thị Bình', 21, N'Nữ'),
(N'Lê Văn Cường', 19, N'Nam'),
(N'Phạm Thị Dung', 22, N'Nữ');
GO