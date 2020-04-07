-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1:3306
-- Thời gian đã tạo: Th1 14, 2020 lúc 07:53 AM
-- Phiên bản máy phục vụ: 5.7.26
-- Phiên bản PHP: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `dacn`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `chitietdanhgia`
--

DROP TABLE IF EXISTS `chitietdanhgia`;
CREATE TABLE IF NOT EXISTS `chitietdanhgia` (
  `idchitiet` int(11) NOT NULL AUTO_INCREMENT,
  `iduser` int(11) NOT NULL,
  `ten` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `hocki` int(11) DEFAULT NULL,
  `diem_phongctsv` int(11) DEFAULT NULL,
  `sodiem` int(11) DEFAULT NULL,
  `idtieuchi` int(11) DEFAULT NULL,
  `diem_covan` int(11) DEFAULT NULL,
  `diem_sinhvien` int(11) NOT NULL,
  `idhocki` int(11) DEFAULT NULL,
  `idmucdanhgia` int(11) DEFAULT NULL,
  PRIMARY KEY (`idchitiet`),
  KEY `iduser` (`iduser`,`idtieuchi`,`idhocki`),
  KEY `idmucdanhgia` (`idmucdanhgia`),
  KEY `idtieuchi` (`idtieuchi`),
  KEY `idhocki` (`idhocki`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `chitietdanhgia`
--

INSERT INTO `chitietdanhgia` (`idchitiet`, `iduser`, `ten`, `hocki`, `diem_phongctsv`, `sodiem`, `idtieuchi`, `diem_covan`, `diem_sinhvien`, `idhocki`, `idmucdanhgia`) VALUES
(17, 1, 'Phan Văn Hiếu', NULL, NULL, NULL, NULL, 10, 30, NULL, NULL),
(19, 5, 'Nguyễn Thị Trang', NULL, NULL, NULL, NULL, NULL, 91, NULL, NULL),
(20, 14, 'Nguyễn Thiện Nhân', NULL, NULL, NULL, NULL, 9, 22, NULL, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `hocki`
--

DROP TABLE IF EXISTS `hocki`;
CREATE TABLE IF NOT EXISTS `hocki` (
  `idhocki` int(11) NOT NULL AUTO_INCREMENT,
  `tenhocki` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `hockihientai` int(11) NOT NULL,
  PRIMARY KEY (`idhocki`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khenthuong`
--

DROP TABLE IF EXISTS `khenthuong`;
CREATE TABLE IF NOT EXISTS `khenthuong` (
  `idkhenthuong` int(11) NOT NULL AUTO_INCREMENT,
  `danhhieu` text COLLATE utf8_unicode_ci NOT NULL,
  `maxdiem` int(11) NOT NULL,
  `noidung` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `iduser` int(11) NOT NULL,
  PRIMARY KEY (`idkhenthuong`),
  KEY `iduser` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `khoa`
--

DROP TABLE IF EXISTS `khoa`;
CREATE TABLE IF NOT EXISTS `khoa` (
  `idkhoa` int(11) NOT NULL AUTO_INCREMENT,
  `tenkhoa` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`idkhoa`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `khoa`
--

INSERT INTO `khoa` (`idkhoa`, `tenkhoa`) VALUES
(1, 'Công nghệ thông tin'),
(2, 'Điện Điện Tử'),
(3, 'Quản Trị Kinh Doanh'),
(4, 'Kĩ thuật công trình'),
(5, 'Công nghệ thực phẩm'),
(6, 'Cơ khí'),
(7, 'Design');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `kiluat`
--

DROP TABLE IF EXISTS `kiluat`;
CREATE TABLE IF NOT EXISTS `kiluat` (
  `idkiluat` int(11) NOT NULL AUTO_INCREMENT,
  `mucdo` text COLLATE utf8_unicode_ci NOT NULL,
  `maxdiem` int(11) NOT NULL,
  `noidung` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `iduser` int(11) NOT NULL,
  PRIMARY KEY (`idkiluat`),
  KEY `iduser` (`iduser`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `lop`
--

DROP TABLE IF EXISTS `lop`;
CREATE TABLE IF NOT EXISTS `lop` (
  `idlop` int(11) NOT NULL AUTO_INCREMENT,
  `tenlop` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idkhoa` int(11) NOT NULL,
  PRIMARY KEY (`idlop`),
  KEY `idkhoa` (`idkhoa`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `lop`
--

INSERT INTO `lop` (`idlop`, `tenlop`, `idkhoa`) VALUES
(1, 'D15-TH01', 1),
(2, 'D15-QT01', 3),
(3, 'D15-TH02', 1),
(4, 'D15-TH03', 1),
(5, 'D15-TH04', 1),
(6, 'D15-TH05', 1),
(7, 'D15-DDT02', 2),
(8, 'D15-DDT03', 2),
(9, 'D15-DDT01', 2),
(10, 'D15-DDT04', 2),
(11, 'D15-QT02', 3),
(12, 'D15-QT03', 3),
(13, 'D15-QT04', 3),
(14, 'D15-QT05', 3),
(15, 'D15-KTCT01', 4),
(16, 'D15-KTCT02', 4),
(17, 'D15-KTCT03', 4),
(18, 'D15-KTCT04', 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `minhchung`
--

DROP TABLE IF EXISTS `minhchung`;
CREATE TABLE IF NOT EXISTS `minhchung` (
  `idminhchung` int(11) NOT NULL AUTO_INCREMENT,
  `noidung` varchar(255) NOT NULL,
  `hinhanh` varchar(50) NOT NULL,
  `idchitiet` int(11) NOT NULL,
  PRIMARY KEY (`idminhchung`),
  KEY `idchitiet` (`idchitiet`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `mucdanhgia`
--

DROP TABLE IF EXISTS `mucdanhgia`;
CREATE TABLE IF NOT EXISTS `mucdanhgia` (
  `idmucdanhgia` int(11) NOT NULL AUTO_INCREMENT,
  `noidung` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `maxdiem` int(11) NOT NULL,
  `iduser` int(11) DEFAULT NULL,
  PRIMARY KEY (`idmucdanhgia`),
  KEY `iduser` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `mucdanhgia`
--

INSERT INTO `mucdanhgia` (`idmucdanhgia`, `noidung`, `maxdiem`, `iduser`) VALUES
(1, 'I.1.a.Ý thức học tập', 10, NULL),
(2, 'I.1.b.Kết quả học tập (chỉ chọn 1 mục dưới đây)', 12, NULL),
(3, 'I.1.c.Nghiên cứu khoa học, nâng cao ngoại ngữ, tin học, tham gia các hoạt động học thuật', 8, NULL),
(4, 'II. Ý thức và kết quả chấp hành nội quy, quy chế nhà trường.', 25, NULL),
(5, 'III. Ý thức và kết quả tham gia các hoạt động công tác xã hội, văn hóa, văn nghệ, thể thao, phòng chống các tệ nạn xã hội.', 20, NULL),
(6, 'IV. Phẩm chất công dân và quan hệ cộng đồng.', 15, NULL),
(7, 'V. Ý thức và kết quả tham gia công tác phụ trách lớp, các đoàn thể, tổ chức trong nhà trường.', 10, NULL);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `tieuchidanhgia`
--

DROP TABLE IF EXISTS `tieuchidanhgia`;
CREATE TABLE IF NOT EXISTS `tieuchidanhgia` (
  `idtieuchi` int(11) NOT NULL AUTO_INCREMENT,
  `noidung` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `maxdiem` int(11) NOT NULL,
  `idmucdanhgia` int(11) NOT NULL,
  PRIMARY KEY (`idtieuchi`),
  KEY `idmucdanhgia` (`idmucdanhgia`)
) ENGINE=InnoDB AUTO_INCREMENT=60 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `tieuchidanhgia`
--

INSERT INTO `tieuchidanhgia` (`idtieuchi`, `noidung`, `maxdiem`, `idmucdanhgia`) VALUES
(1, 'Đi học đầy đủ, đúng giờ, không bỏ tiết', 3, 1),
(2, 'Nghiêm túc trong tất cả buổi học', 3, 1),
(3, 'Không vi phạm quy chế về thi, kiểm tra', 4, 1),
(4, 'Điểm trung bình học tập < 5.00', 6, 2),
(5, 'Điểm trung bình học tập từ 5.00 đến 5.99', 8, 2),
(6, 'Điểm trung bình học tập từ 6.00 đến 6.99', 9, 2),
(7, 'Điểm trung bình học tập từ 7.00 đến 7.99', 10, 2),
(8, 'Điểm trung bình học tập từ 8.00 đến 8.99', 11, 2),
(9, 'Điểm trung bình học tập ≥ 9.00', 12, 2),
(10, 'Điểm trung bình học tập > 5.00 và cao hơn học kỳ ngay trước học kỳ đang chấm rèn luyện', 12, 2),
(11, 'Tham gia các buổi hội thảo học thuật do trường, khoa tổ chức( 2đ/ lần)', 8, 3),
(12, 'Tham gia các hội thi học thuật do Trường, Khoa, Đoàn – Hội Sinh viên các cấp (Thành phố, Trường, Khoa) tổ chức( 2đ/lần)', 8, 3),
(13, 'Thành viên tích cực của câu lạc bộ học thuật cấp Khoa, Trường (Ban Chủ nhiệm câu lạc bộ xác nhận)( 3đ/lần)', 8, 3),
(14, 'Thành viên các đội thiết kế Robot, Robocon( 3đ/lần)', 8, 3),
(15, 'Đạt giải trong các kỳ thi chuyên ngành, Olympic, Robocon... (cao hơn cấp Trường)( 7đ/lần)', 8, 3),
(16, 'Có tham gia nghiên cứu khoa học của HS - SV hoặc của Khoa, Trường (đạt yêu cầu, được giảng viên hướng dẫn xác nhận; không tính các bài tập, tiểu luận, đồ án môn học, luận văn)( 3đ/lần)', 8, 3),
(17, 'Có bằng khen, giấy khen về nghiên cứu khoa học( 5đ/lần)', 8, 3),
(18, 'Có bài nghiên cứu khoa học được đăng trên kỷ yếu, nội san của khoa, trường( 6đ/lần)', 8, 3),
(19, 'Có bài báo trong và ngoài nước trong hoạt động nghiên cứu khoa học( 8đ/lần)', 8, 3),
(20, 'Đạt chứng chỉ ngoại ngữ, tin học quốc gia (cao hơn học kỳ trước đó)( 3đ/lần)', 8, 3),
(21, 'Đạt Chứng nhận TOEFL  ≥ 400 điểm, TOEFL  iBT ≥ 50 điểm, IELTS ≥ 5,0, TOEIC  ≥ 300 điểm( 4đ/lần)', 8, 3),
(22, 'Tham gia đầy đủ tất cả các buổi sinh hoạt của lớp', 5, 4),
(23, 'Đảm bảo mặc trang phục phù hợp với môi trường học đường suốt học kỳ (không mặc quần lửng, quần cụt, lưng trễ quá sâu, váy ngắn quá gối, áo sát nách, áo hai dây, áo hở lưng hở bụng, áo lửng)', 10, 4),
(24, 'Để tóc phù hợp môi trường học đường (tóc nhuộm màu quá sặc sỡ, nhuộm nhiều màu)', 5, 4),
(25, 'Tích cực giữ gìn an ninh, trật tự nơi công cộng                         ', 5, 4),
(26, 'Tích cực giữ gìn vệ sinh, bảo vệ cảnh quan môi trường.', 5, 4),
(27, 'Tích cực hưởng ứng và thực hiện nếp sống văn minh trong trường học', 5, 4),
(28, 'Thực hiện khám sức khỏe định kỳ đúng quy định', 5, 4),
(29, 'Không tham gia các hoạt động chính trị - xã hội, văn hóa, văn nghệ, thể thao, phòng chống các tệ nạn xã hội trong Trường', 0, 5),
(30, 'Tham gia các hoạt động văn nghệ, thể thao do lớp, Khoa, Trường tổ chức( 2đ/lần)', 20, 5),
(31, 'Thành viên tích cực các đội hình văn nghệ, thể thao cấp Khoa (Đội trưởng xác nhận)( 3đ/đội)', 20, 5),
(32, 'Thành viên tích cực các đội hình văn nghệ, thể thao cấp Trường (Đội trưởng xác nhận)( 5đ/đội)', 20, 5),
(33, 'Tham gia các hoạt động do Trường huy động lực lượng( 3đ/ lần)', 20, 5),
(34, 'Tham gia các hoạt động tình nguyện, công tác xã hội do Khoa, Trường tổ chức( 3đ/lần)', 20, 5),
(35, 'Phân loại cuối năm đạt đoàn viên xuất sắc', 7, 5),
(36, 'Phân loại cuối năm đạt đoàn viên ưu tú', 8, 5),
(37, 'Được kết nạp Đảng', 15, 5),
(38, 'Là chiến sĩ tình nguyện tham gia ít nhất 1/2 thời gian của chiến dịch Mùa hè xanh', 8, 5),
(39, 'Được công nhận là chiến sĩ giỏi của chiến dịch Mùa hè xanh', 10, 5),
(40, 'Được khen thưởng cấp Trường trong việc tham gia các hoạt động( 5đ/lần)', 20, 5),
(41, 'Được khen thưởng cấp Quận, Thành phố (và tương đương) trong việc tham gia các hoạt động( 7đ/lần)', 20, 5),
(42, 'Được khen thưởng cấp Trung Ương (và tương đương) trong việc tham gia các hoạt động( 10đ/lần)', 20, 5),
(43, 'Sinh viên nộp giấy xác nhận ngoại trú, giấy nhận xét ngoại trú đúng thời hạn quy định', 5, 6),
(44, 'Sinh viên nộp giấy xác nhận ngoại trú, giấy nhận xét ngoại trú trễ thời hạn quy định', 3, 6),
(45, 'Sinh viên có giấy xác nhận ngoại trú tốt', 5, 6),
(46, 'Sinh viên có thư khen ngợi hoặc giấy khen ở nơi cư trú', 10, 6),
(47, 'Sinh viên có tinh thần giúp đỡ bạn bè gặp khó khăn trong học tập, trong cuộc sống (được tập thể lớp và GVCN xác nhận)', 5, 6),
(48, 'Thành viên tích cực các đội hình công tác xã hội từ cấp Khoa trở lên (Ban Chủ nhiệm đội xác nhận)', 2, 6),
(49, 'Được biểu dương, khen thưởng (từ cấp trường trở lên) về tham gia giữ gìn trật tự an toàn xã hội, về thành tích đấu tranh bảo vệ pháp luật, về hành vi giúp người, cứu người', 10, 6),
(50, 'Không tham gia các công tác phụ trách lớp, đoàn thể, tổ chức trong nhà trường', 2, 7),
(51, 'Ban Cán sự lớp; Ban Chấp hành Đoàn – Hội các cấp; Ban Chủ nhiệm các câu lạc bộ, đội, nhóm các cấp không hoàn thành nhiệm vụ (theo đề nghị của GVCN, Cố vấn học tập, các đoàn thể)', 0, 7),
(52, 'Ban Cán sự lớp; Ban Chấp hành Đoàn – Hội các cấp; Ban Chủ nhiệm các câu lạc bộ, đội, nhóm các cấp hoàn thành nhiệm vụ ở mức độ trung bình (theo đề nghị của GVCN, Cố vấn học tập, các đoàn thể)', 6, 7),
(53, 'Ban Cán sự lớp; Ban Chấp hành Đoàn – Hội các cấp; Ban Chủ nhiệm các câu lạc bộ, đội, nhóm các cấp hoàn thành nhiệm vụ ở mức độ khá (theo đề nghị của GVCN, Cố vấn học tập, các đoàn thể)', 8, 7),
(54, 'Ban Cán sự lớp; Ban Chấp hành Đoàn – Hội các cấp; Ban Chủ nhiệm các câu lạc bộ, đội, nhóm các cấp hoàn thành tốt nhiệm vụ (theo đề nghị của GVCN, Cố vấn học tập các đoàn thể)', 9, 7),
(55, 'Ban Cán sự lớp; Ban Chấp hành Đoàn – Hội các cấp; Ban Chủ nhiệm các câu lạc bộ, đội, nhóm các cấp hoàn thành xuất sắc nhiệm vụ (theo đề nghị của GVCN, Cố vấn học tập, các đoàn thể)', 10, 7);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `tenuser` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `emailuser` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `idrole` int(11) DEFAULT NULL,
  `idlop` int(11) DEFAULT NULL,
  PRIMARY KEY (`iduser`),
  KEY `idlop` (`idlop`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`iduser`, `tenuser`, `emailuser`, `password`, `idrole`, `idlop`) VALUES
(1, 'Phan Văn Hiếu', 'hieuphan2211@gmail.com', '111', 1, 1),
(2, 'Trần Chân', 'chantran2321@gmail.com', '122', 2, 2),
(3, 'Phan Cường', 'cuongphan223@gmail.com', '111', 3, NULL),
(5, 'Nguyễn Thị Trang', 'trangtrang223@gmail.com', '111', 1, 1),
(6, 'Trần Xuân Quí', 'xuanqui1221@gmail.com', '111', 1, 2),
(7, 'Nguyễn Dũng', 'dungaba223@gmail.com', '111', 4, NULL),
(9, 'Ngọc Anh', 'twolillizs2112@gmail.com', '111', 2, 1),
(14, 'Nguyễn Thiện Nhân', 'thiennhan123@gmail.com', '111', 1, 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `usersrole`
--

DROP TABLE IF EXISTS `usersrole`;
CREATE TABLE IF NOT EXISTS `usersrole` (
  `idrole` int(11) NOT NULL AUTO_INCREMENT,
  `tenrole` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `iduser` int(11) NOT NULL,
  PRIMARY KEY (`idrole`),
  KEY `iduser` (`iduser`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `usersrole`
--

INSERT INTO `usersrole` (`idrole`, `tenrole`, `iduser`) VALUES
(1, 'Sinh Viên', 2),
(2, 'Giảng viên', 3),
(3, 'Cán bộ phòng CTHSSV', 5),
(4, 'Admin', 6);

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `chitietdanhgia`
--
ALTER TABLE `chitietdanhgia`
  ADD CONSTRAINT `chitietdanhgia_ibfk_1` FOREIGN KEY (`idtieuchi`) REFERENCES `tieuchidanhgia` (`idtieuchi`),
  ADD CONSTRAINT `chitietdanhgia_ibfk_2` FOREIGN KEY (`idhocki`) REFERENCES `hocki` (`idhocki`);

--
-- Các ràng buộc cho bảng `khenthuong`
--
ALTER TABLE `khenthuong`
  ADD CONSTRAINT `khenthuong_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`);

--
-- Các ràng buộc cho bảng `kiluat`
--
ALTER TABLE `kiluat`
  ADD CONSTRAINT `kiluat_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`);

--
-- Các ràng buộc cho bảng `lop`
--
ALTER TABLE `lop`
  ADD CONSTRAINT `lop_ibfk_1` FOREIGN KEY (`idkhoa`) REFERENCES `khoa` (`idkhoa`);

--
-- Các ràng buộc cho bảng `minhchung`
--
ALTER TABLE `minhchung`
  ADD CONSTRAINT `minhchung_ibfk_1` FOREIGN KEY (`idchitiet`) REFERENCES `chitietdanhgia` (`idchitiet`);

--
-- Các ràng buộc cho bảng `mucdanhgia`
--
ALTER TABLE `mucdanhgia`
  ADD CONSTRAINT `mucdanhgia_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`);

--
-- Các ràng buộc cho bảng `tieuchidanhgia`
--
ALTER TABLE `tieuchidanhgia`
  ADD CONSTRAINT `tieuchidanhgia_ibfk_1` FOREIGN KEY (`idmucdanhgia`) REFERENCES `mucdanhgia` (`idmucdanhgia`);

--
-- Các ràng buộc cho bảng `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`idlop`) REFERENCES `lop` (`idlop`);

--
-- Các ràng buộc cho bảng `usersrole`
--
ALTER TABLE `usersrole`
  ADD CONSTRAINT `usersrole_ibfk_1` FOREIGN KEY (`iduser`) REFERENCES `user` (`iduser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
