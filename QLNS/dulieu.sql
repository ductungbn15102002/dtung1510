-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th8 04, 2023 lúc 11:35 AM
-- Phiên bản máy phục vụ: 10.4.28-MariaDB
-- Phiên bản PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dulieu`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `luong`
--

CREATE TABLE `luong` (
  `luongcoban` decimal(8,0) NOT NULL,
  `luongphucap` decimal(8,0) NOT NULL,
  `luongthuong` decimal(8,0) NOT NULL,
  `phat` decimal(8,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `messages`
--

CREATE TABLE `messages` (
  `id` int(11) NOT NULL,
  `sender` varchar(255) DEFAULT NULL,
  `receiver` varchar(255) DEFAULT NULL,
  `message` text DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `nguoidung`
--

CREATE TABLE `nguoidung` (
  `tendangnhap` varchar(50) NOT NULL,
  `matkhau` varchar(30) NOT NULL,
  `ho` varchar(10) NOT NULL,
  `ten` varchar(10) NOT NULL,
  `banla` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `nguoidung`
--

INSERT INTO `nguoidung` (`tendangnhap`, `matkhau`, `ho`, `ten`, `banla`) VALUES
('nguyễn', '123', 'nguyễn', 'Huy', 'Manager'),
('Trần', '123', 'Trần', 'Huy', 'Nhân viên'),
('Nguyễn Thanh', '123', 'Nguyen', 'Thanh', 'Nhân viên'),
('minhhuyen@gmail.com', '123', 'Huyền', 'Huyền', 'Manager'),
('vcl', '33', 'oc cho ', 'vcl', 'Nhân viên'),
('Giabao', '1', 'gia', 'bảo', 'Nhân viên'),
('tùngg', '1234', 'nguyễn', 'Tùng', 'Manager'),
('t2', '2', 't', 't', 'Nhân viên'),
('huanhoahong', '123', 'huan', 'hoa hong', 'Manager'),
('dfd', 'dfd', 'fdf', 'fdf', 'Manager'),
('ngu', 'ngu', 'ngu', 'ngu', 'Manager'),
('tung', 'tung', 'tung', 'yy', 'Manager'),
('t', 't', 't', 't', 'Manager'),
('ty', 'ty', 't', 't', 'Manager'),
('t', 't', 't', 't', 'Manager'),
('nguvcl', 'nguvcl', 'stk', 's', 'Nhân viên');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `messages`
--
ALTER TABLE `messages`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `messages`
--
ALTER TABLE `messages`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
