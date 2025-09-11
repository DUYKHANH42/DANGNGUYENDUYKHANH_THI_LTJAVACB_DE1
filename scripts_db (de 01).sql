CREATE DATABASE QLBH
GO
USE QLBH
GO

CREATE TABLE SanPham (
    maSP INT PRIMARY KEY IDENTITY(1,1),
    tenSP NVARCHAR(100) NOT NULL,
    gia DECIMAL(18,2),
    trangThai NVARCHAR(20) -- Còn hàng / Hết hàng
);

INSERT INTO SanPham(tenSP, gia, trangThai) VALUES
(N'Laptop Dell', 15000000, N'Còn hàng'),
(N'Điện thoại Samsung', 8000000, N'Hết hàng'),
(N'Tai nghe Sony', 1200000, N'Còn hàng');