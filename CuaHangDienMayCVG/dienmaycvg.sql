-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th5 19, 2022 lúc 05:30 AM
-- Phiên bản máy phục vụ: 10.4.21-MariaDB
-- Phiên bản PHP: 7.3.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dienmaycvg`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
  `CUSTOMERCODE` varchar(10) NOT NULL,
  `FULLNAME` varchar(200) NOT NULL,
  `DATEOFBIRTH` varchar(10) NOT NULL,
  `GENDER` varchar(20) NOT NULL,
  `EMAIL` varchar(200) DEFAULT NULL,
  `TEL` varchar(200) NOT NULL,
  `CCCD` varchar(20) NOT NULL,
  `ADDRESS` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`CUSTOMERCODE`, `FULLNAME`, `DATEOFBIRTH`, `GENDER`, `EMAIL`, `TEL`, `CCCD`, `ADDRESS`) VALUES
('KH01', 'NGUYEN VAN A', '03/04/2001', 'Nam', 'khachhang@gmai.com', '0384319201', '123456987', 'Củ Chi'),
('KH02', 'Nam', 'NGUYE', '05/06/2001', '0384319201', 'abc@gmai', '123456', '4444444444');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
  `EMPLOYEECODE` varchar(10) NOT NULL,
  `FULLNAME` varchar(200) NOT NULL,
  `THUMBNAIL` varchar(200) NOT NULL,
  `DATEOFBIRTH` varchar(20) NOT NULL,
  `TEL` varchar(20) NOT NULL,
  `EMAIL` varchar(200) DEFAULT NULL,
  `CCCD` varchar(200) NOT NULL,
  `ADDRESS` varchar(200) NOT NULL,
  `GENDER` varchar(20) NOT NULL,
  `NATION` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`EMPLOYEECODE`, `FULLNAME`, `THUMBNAIL`, `DATEOFBIRTH`, `TEL`, `EMAIL`, `CCCD`, `ADDRESS`, `GENDER`, `NATION`) VALUES
('NV01', 'NGUYỄN VĂN HIỀN', 'nguyenvanhien.jpg', '05/06/2001', '0384319201', 'vanhien@gmail.com', '123456789', 'Bình Mỹ', 'Nam', 'Kinh'),
('NV02', 'NGUYỄN TUẤN BẢO', 'nguyentuanbao.jpg', '10/05/2001', '0384319201', 'nguyentuanbao@gmail.com', '12123213', 'Hốc Môn', 'Nam', 'Kinh'),
('NV03', 'PHAN THANH HẢI', 'phanthanhhai.jpg', '15/11/2001', '0384319201', 'phanthanhhai@gmail.com', '12123213', 'Hốc Môn', 'Nam', 'Kinh'),
('NV04', 'LÊ NGUYỄN ANH DŨNG', 'lenguyenanhdung.jpg', '06/12/2001', '0384319201', 'lenguyenanhdung@gmail.com', '12123213', 'Hốc Môn', 'Nam', 'Kinh'),
('NV05', 'TRẦN BÁ MINH', 'tranbaminh.jpg', '15/09/2001', '0384319201', 'tranbaminh@gmail.com', '12123213', 'Hốc Môn', 'Nam', 'Kinh'),
('NV06', 'NGUYEN VAN HIEN', 'nguyenvanhien.jpg', '05/06/2001', '0384319201', 'vanhiena4@gmail.com', '12123213323', 'dấdasdasad', 'Nam', 'Kinh');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `orders`
--

CREATE TABLE `orders` (
  `ORDERCODE` varchar(10) NOT NULL,
  `EMPLOYEECODE` varchar(10) NOT NULL,
  `CUSTOMERCODE` varchar(10) NOT NULL,
  `PRODUCTCODE` varchar(10) NOT NULL,
  `ORDERDATE` varchar(20) NOT NULL,
  `QUANTITY` int(200) NOT NULL,
  `AMOUNT` varchar(200) NOT NULL,
  `PAYMENTMETHOD` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `orders`
--

INSERT INTO `orders` (`ORDERCODE`, `EMPLOYEECODE`, `CUSTOMERCODE`, `PRODUCTCODE`, `ORDERDATE`, `QUANTITY`, `AMOUNT`, `PAYMENTMETHOD`) VALUES
('MA01', 'NV01', 'KH01', 'SP01', '01/01/2001', 2, '50000000', 'Tiền mặt'),
('MA11', 'NV11', 'KH11', 'SP11', '01/01/2022', 1, '1', '2');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `product`
--

CREATE TABLE `product` (
  `MaSP` varchar(10) NOT NULL,
  `TenSP` varchar(200) NOT NULL,
  `TYPE` varchar(200) NOT NULL,
  `PRICE` varchar(200) NOT NULL,
  `COLOR` varchar(200) NOT NULL,
  `SCREEN` varchar(200) NOT NULL,
  `THUMBNAIL` varchar(200) NOT NULL,
  `CARD` varchar(200) NOT NULL,
  `PIN` varchar(200) NOT NULL,
  `CPU` varchar(200) NOT NULL,
  `OS` varchar(200) NOT NULL,
  `SIZEWEIGHT` varchar(200) NOT NULL,
  `RAM` varchar(200) NOT NULL,
  `HARDDRIVE` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_german2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `product`
--

INSERT INTO `product` (`MaSP`, `TenSP`, `TYPE`, `PRICE`, `COLOR`, `SCREEN`, `THUMBNAIL`, `CARD`, `PIN`, `CPU`, `OS`, `SIZEWEIGHT`, `RAM`, `HARDDRIVE`) VALUES
('SP01', 'Laptopabc', 'WINDOWS', '20000000', 'ĐEN', '15.6\" Full HD', 'acer-aspire-3-a315-57g-573f-i5-nxhzrsv00b-120122-043700-600x600.jpg', 'Card rời', '60wh', 'i711800', 'WINDOWS', 'Dài 358 mm - Rộng 267 mm - Dày 23.4 mm - Nặng 2.38 Kg', '16GB', '512 GB SSD NVMe PCIe (Có thể tháo ra, lắp thanh khác tối đa 1TB (2280) / 512GB (2242))Hỗ trợ thêm 1 khe cắm SSD M.2 PCIe mở rộng'),
('SP0144', 'LaptopabcdAD', 'WINDOWS', '20000000', 'ĐEN', '15.6\" Full HD', 'acer-aspire-3-a315-57g-573f-i5-nxhzrsv00b-120122-043700-600x600.jpg', 'Card rờisâsaas', '60wh', 'i711800', 'WINDOWS', 'Dài 358 mm - Rộng 267 mm - Dày 23.4 mm - Nặng 2.38 Kg', '16GB', '512 GB SSD NVMe PCIe (Có thể tháo ra, lắp thanh khác tối đa 1TB (2280) / 512GB (2242))Hỗ trợ thêm 1 khe cắm SSD M.2 PCIe mở rộng'),
('SP02', 'Laptop Lenovo Gaming Legion 5', 'GAMING', '39990000', 'XANH', '15.6\"Full HD (1920 x 1080)165Hz\r\n', 'acer-nitro-5-gaming.jpg', 'Card rờiRTX 3050Ti 4GB\r\n', '60Wh', 'i711800H2.30 GHz\r\n', 'Windows 11 Home SL', 'Dài 358 mm - Rộng 267 mm - Dày 23.4 mm - Nặng 2.38 Kg\r\n', '16 GBDDR4 2 khe (1 khe 8GB + 1 khe 8GB)3200 MHz\r\n', '512 GB SSD NVMe PCIe (Có thể tháo ra, lắp thanh khác tối đa 1TB (2280) / 512GB (2242))Hỗ trợ thêm 1 khe cắm SSD M.2 PCIe mở rộng\r\n'),
('SP03', 'Laptop MSI Gaming GE66 Raider 11UG ', 'GAMING', '59990000', 'ĐEN', '15.6\"Full HD (1920 x 1080)360Hz\r\n', 'acer-nitro-5-gaming.jpg', 'Card rờiRTX 3070 8GB\r\n', '4-cell, 99.9 Wh', 'i711800H2.30 GHz', 'Windows 11 Home SL', 'Dài 358 mm - Rộng 267 mm - Dày 23.4 mm - Nặng 2.38 Kg\r\n', '16 GBDDR4 2 khe (1 khe 8GB + 1 khe 8GB)3200 MHz', '2 TB SSD NVMe PCIeHỗ trợ thêm 1 khe cắm SSD M.2 PCIe mở rộng (nâng cấp tối đa 2TB)\r\n'),
('SP04', 'Laptop Asus Gaming ROG Flow Z13 GZ301Z', 'GAMING', '49990000', 'ĐEN', '13.4\"WUXGA (1920 x 1200)120Hz\r\n', 'acer-nitro-5-gaming.jpg', 'Card rờiRTX 3050 4GB\r\n', '4-cell Li-ion, 56 Wh', 'i712700H2.30 GHz\r\n', 'Windows 11 Home SL', 'Dài 302 mm - Rộng 204 mm - Dày 12 mm - Nặng 1.18 kg\r\n', '16 GBLPDDR5 (8GB On board + 8GB On board)5200 MHz\r\n', '512 GB SSD NVMe PCIe (Có thể tháo ra, lắp thanh khác tối đa 1TB)\r\n'),
('SP05', 'Laptop Asus TUF Gaming FX516PC', 'GAMING', '28990000', 'XÁM', '15.6\"Full HD (1920 x 1080)144Hz\r\n', 'acer-nitro-5-gaming.jpg', 'Card rờiRTX 3050 4GB\r\n', '4-cell Li-ion, 76 Wh', 'i711370H3.3GHz\r\n', 'Windows 10 Home SL\r\n', 'Dài 360 mm - Rộng 252 mm - Dày 19.9 mm - Nặng 2 kg\r\n', '8 GBDDR4 2 khe (1 khe 8GB onboard + 1 khe trống)3200 MHz\r\n', 'Hỗ trợ thêm 1 khe cắm SSD M.2 PCIe mở rộng (nâng cấp tối đa 1TB)512 GB SSD NVMe PCIe (Có thể tháo ra, lắp thanh khác tối đa 1TB)\r\n'),
('SP06', 'Laptop MSI Gaming GS66 Stealth 11UG', 'GAMING', '64990000', 'ĐEN', '15.6\"Full HD (1920 x 1080)360Hz\r\n', 'acer-nitro-5-gaming.jpg', 'Card rờiRTX 3070 Max-Q 8GB\r\n', '4-cell, 99.9 Wh', 'i711800H2.30 GHz', 'Windows 10 Home SL\r\n', 'Dài 358.3 mm - Rộng 248 mm - Dày 19.8 mm - Nặng 2.1 Kg\r\n', '32 GBDDR4 2 khe (1 khe 16GB + 1 khe 16GB)3200 MHz\r\n', '2 TB SSD NVMe PCIeHỗ trợ thêm 1 khe cắm SSD M.2 PCIe mở rộng (nâng cấp tối đa 2TB)\r\n'),
('SP07', 'Laptop MacBook Pro 14 M1 Pro 2021', 'MAC', '48990000', 'BẠC', '14.2 inchLiquid Retina XDR display (3024 x 1964)120Hz\r\n', 'acer-nitro-5-gaming.jpg', 'Card tích hợp14 core-GPU\r\n', 'Khoảng 10 tiếng', 'Apple M1 Pro200GB/s memory bandwidth\r\n', 'Mac OS\r\n', 'Dài 312.6 mm - Rộng 221.2 mm - Dày 15.5 mm - Nặng 1.6 kg\r\n', '16 GB\r\n', '512 GB SSD\r\n'),
('SP08', 'Laptop Apple MacBook Pro 16 M1 Pro 2021', 'MAC', '60990000', 'XÁM', '16.2\"Liquid Retina XDR display (3456 x 2234)120Hz\r\n', 'acer-nitro-5-gaming.jpg', 'Card tích hợp16 core-GPU\r\n', 'Khoảng 10 tiếng', 'Apple M1 Pro200GB/s memory bandwidth\r\n', 'Mac OS\r\n', 'Dài 355.7 mm - Rộng 248.1 mm - Dày 16.8 mm - Nặng 2.2 kg\r\n', '16 GB\r\n', '512 GB SSD\r\n'),
('SP09', 'Laptop Apple MacBook Air M1 2020', 'MAC', '33490000', 'VÀNG', '13.3\"Retina (2560 x 1600)\r\n', 'acer-nitro-5-gaming.jpg', 'Card tích hợp7 nhân GPU\r\n', 'Khoảng 10 tiếng', 'Apple M1\r\n', 'Mac OS\r\n', 'Dài 304.1 mm - Rộng 212.4 mm - Dày 4.1 mm đến 16.1 mm - Nặng 1.29 kg\r\n', '16 GB\r\n', '256 GB SSD\r\n'),
('SP10', 'Laptop Acer TravelMate B3 TMB311 31 P49D', 'HOC TAP-VAN PHONG', '8490000', 'ĐEN', '11.6\"HD (1366 x 768)\r\n', 'acer-nitro-5-gaming.jpg', 'Card tích hợpIntel UHD 605\r\n', '3-cell Li-ion, 48 Wh', 'PentiumN50301.1GHz', 'Windows 11 Home SL\r\n', 'Dài 295 mm - Rộng 215 mm - Dày 20.99 mm - Nặng 1.4 kg\r\n', '4 GBDDR4 (1 khe)Từ 2400 MHz (Hãng công bố)\r\n', '256 GB SSD NVMe PCIe\r\n'),
('SP11', 'Laptop Acer Aspire A514 54 511G', 'HOC TAP-VAN PHONG', '17990000', 'BẠC', '14\"Full HD (1920 x 1080)\r\n', 'acer-nitro-5-gaming.jpg', 'Card tích hợpIntel Iris Xe\r\n', 'Li-ion, 48 Wh', 'i51135G72.4GHz\r\n', 'Windows 11 Home SL\r\n', 'Dài 328 mm - Rộng 223 mm - Dày 17.95 mm - Nặng 1.46 kg\r\n', '8 GBDDR4 (On board 4GB +1 khe 4GB)3200 MHz\r\n', '1 TB SSD M.2 PCIeHỗ trợ khe cắm HDD SATA (nâng cấp tối đa 2TB)\r\n'),
('SP12', 'Laptop Lenovo Ideapad 3 15ITL6', 'HOC TAP-VAN PHONG', '18490000', 'XÁM', '15.6\"Full HD (1920 x 1080)\r\n', 'acer-nitro-5-gaming.jpg', 'Card tích hợpIntel Iris Xe\r\n', '38 Wh', 'i51135G72.4GHz\r\n\r\n\r\n\r\n', 'Windows 11 Home SL\r\n', 'Dài 359.2 mm - Rộng 236.5 mm - Dày 19.9 mm - Nặng 1.65 kg\r\n', '8 GBDDR4 2 khe (1 khe 8GB onboard + 1 khe trống)3200 MHz\r\n', '512 GB SSD NVMe PCIe (Có thể tháo ra, lắp thanh khác tối đa 1TB (2280) / 512GB (2242))Hỗ trợ thêm 1 khe cắm HDD SATA (nâng cấp tối đa 1TB)\r\n'),
('SP13', 'Laptop HP 240 G8', 'HOC TAP-VAN PHONG', '12390000', 'XÁM', '14\"Full HD (1920 x 1080)\r\n', 'acer-nitro-5-gaming.jpg', 'Card tích hợpIntel UHD\r\n', '3-cell Li-ion, 41 Wh', 'i31005G11.2GHz\r\n\r\n\r\n', 'Windows 10 Home SL\r\n', 'Dài 324 mm - Rộng 225.9 mm - Dày 19.9 mm - Nặng 1.47 kg\r\n', '4 GBDDR4 (2 khe)2666 MHz\r\n', '256 GB SSD NVMe PCIe\r\n'),
('SP14', 'Laptop Asus VivoBook A415EA ', 'HOC TAP-VAN PHONG', '14990000', 'XÁM', '14\"Full HD (1920 x 1080)\r\n', 'acer-nitro-5-gaming.jpg', 'Card tích hợpIntel UHD\r\n', '3-cell Li-ion, 42 Wh', 'i31125G42GHz\r\n\r\n\r\n\r\n', 'Windows 10 Home SL\r\n', 'Dài 324 mm - Rộng 215 mm - Dày 17.9 mm - Nặng 1.4 kg\r\n', '8GB DDR4 (On board)3200 MHz\r\n', '512 GB SSD NVMe PCIe (Có thể tháo ra, lắp thanh khác tối đa 1TB)Hỗ trợ thêm 1 khe cắm SSD M.2 PCIe mở rộng (nâng cấp tối đa 1TB)\r\n'),
('SP15', 'Laptop Surface Pro 7', 'HOC TAP - VAN PHONG', '21890000', 'BẠC', '12.3\"2K\r\n', 'acer-nitro-5-gaming.jpg', 'Card tích hợpIntel Iris Plus\r\n', '4-cell Li-ion, 46.5 Wh', 'i51035G41.1GHz\r\n\r\n\r\n\r\n\r\n', 'Windows 10 Home SL\r\n', 'Dài 201 mm - Rộng 292 mm - Dày 8.5 mm - Nặng 0.775 kg\r\n', '8 GBLPDDR4X (On board)3733 MHz\r\n', '128 GB SSD M2 PCIe\r\n'),
('SP182', 'Laptopabcd', 'WINDOWS', 'ĐEN', '20000000', '15.6\" Full HD', 'acer-aspire-3-a315-57g-573f-i5-nxhzrsv00b-120122-043700-600x600.jpg', 'Card rời', '60wh', 'i711800', 'WINDOWS', 'Dài 358 mm - Rộng 267 mm - Dày 23.4 mm - Nặng 2.38 Kg', '16GB', '512 GB SSD NVMe PCIe (Có thể tháo ra, lắp thanh khác tối đa 1TB (2280) / 512GB (2242))Hỗ trợ thêm 1 khe cắm SSD M.2 PCIe mở rộng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user_account`
--

CREATE TABLE `user_account` (
  `username` varchar(20) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `password` varchar(20) NOT NULL,
  `DATEOFBIRTH` varchar(10) NOT NULL,
  `TEL` varchar(20) NOT NULL,
  `EMAIL` varchar(200) DEFAULT NULL,
  `ADDRESS` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Đang đổ dữ liệu cho bảng `user_account`
--

INSERT INTO `user_account` (`username`, `gender`, `password`, `DATEOFBIRTH`, `TEL`, `EMAIL`, `ADDRESS`) VALUES
('admin', 'Male', '11', '05/06/2001', '0384319201', 'nguyenvanhien050601@gmail.com', ''),
('admin1111111', 'Male', '1111111', '05/06/2001', '0384319201', 'vanhiena4@gmail.com', '11'),
('admin111111111111', 'Male', '11111111', '05/06/2001', '0384319201', 'vanhiena4@gmail.com', '11111111'),
('admin2', 'Female', '11', '05/06/2001', '0384319201', '', 'dd'),
('admin22', 'Male', '11', '10/05/2001', '0384319201', '', '11'),
('admin33', 'Male', '11', '05/06/2001', '0384319201', 'nguyenvanhien050601@gmail.com', 'Há»c mÃ´n'),
('admin554444', 'Male', '11', '05/06/2001', '0384319201', 'nguyenvanhien050601@gmail.com', 'Há»c mÃ´n'),
('adminfghfghfgh', 'Male', '11111111', '05/06/2001', '0384319201', 'vanhiena4@gmail.com', '11111111111111'),
('vanhiena4@gmail.com1', 'Male', '11', '10/05/2001', '0384319201', 'vanhiena4@gmail.com', '111');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`EMPLOYEECODE`);

--
-- Chỉ mục cho bảng `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`ORDERCODE`);

--
-- Chỉ mục cho bảng `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`MaSP`),
  ADD UNIQUE KEY `MaSP` (`MaSP`),
  ADD KEY `MaSP_2` (`MaSP`);

--
-- Chỉ mục cho bảng `user_account`
--
ALTER TABLE `user_account`
  ADD PRIMARY KEY (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
