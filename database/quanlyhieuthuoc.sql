-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th12 24, 2019 lúc 05:22 AM
-- Phiên bản máy phục vụ: 10.3.16-MariaDB
-- Phiên bản PHP: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `quanlyhieuthuoc`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `inhoadon`
--

CREATE TABLE `inhoadon` (
  `mahoadon` varchar(100) NOT NULL,
  `tenthuoc` varchar(255) NOT NULL,
  `soluong` int(11) NOT NULL,
  `thanhtien` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
--

CREATE TABLE `nguoidung` (
  `manguoidung` varchar(100) NOT NULL,
  `tendangnhap` varchar(255) NOT NULL,
  `matkhau` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  `hoten` varchar(255) NOT NULL,
  `vaitro` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `nguoidung`
--

INSERT INTO `nguoidung` (`manguoidung`, `tendangnhap`, `matkhau`, `email`, `hoten`, `vaitro`) VALUES
('1', 'a1', '123', 'anhphamm7@gmail.com', 'Pham Thi Lan Anh', 'admmin'),
('2', 'a2', '123', 'dinhhonghanh080299@gmail.com', 'Dinh Thi Hong Hanh', 'admin'),
('3', 'a3', '1234', 'buithixuananh_t62@hus.edu.vn', 'Bui Thi Xuan Anh', 'user'),
('4', 'a4', '1234', 'nguyenngochien_t62@hus.edu.vn', 'Nguyen Ngoc Hien', 'user');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `thuoc`
--

CREATE TABLE `thuoc` (
  `mathuoc` varchar(50) NOT NULL,
  `tenthuoc` varchar(150) NOT NULL,
  `soluong` int(11) NOT NULL,
  `gia` varchar(255) NOT NULL,
  `donvi` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Đang đổ dữ liệu cho bảng `thuoc`
--

INSERT INTO `thuoc` (`mathuoc`, `tenthuoc`, `soluong`, `gia`, `donvi`) VALUES
('AJU', 'Ajuakinol', 50, '10000', 'vi'),
('ARC', 'Arcoxia', 300, '50000', 'vien'),
('BVC', 'Broncho-Vaxom Children', 300, '100000', 'vi'),
('CON', 'Contractubex', 10, '20000', 'vi'),
('FOL', 'Folitop', 200, '20000', 'vi'),
('HER', 'Heramama', 100, '10000', 'vi'),
('KLA', 'Klacid MR', 70, '2000', 'vien'),
('TAM', 'Tamiflu', 40, '5000', 'vi'),
('VIA', 'Viagra', 100, '100000', 'vien');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `inhoadon`
--
ALTER TABLE `inhoadon`
  ADD PRIMARY KEY (`mahoadon`);

--
-- Chỉ mục cho bảng `nguoidung`
--
ALTER TABLE `nguoidung`
  ADD PRIMARY KEY (`manguoidung`);

--
-- Chỉ mục cho bảng `thuoc`
--
ALTER TABLE `thuoc`
  ADD PRIMARY KEY (`mathuoc`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
