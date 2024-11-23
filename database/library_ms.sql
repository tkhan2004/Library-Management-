-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 23, 2024 at 11:06 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `library_ms`
--

-- --------------------------------------------------------

--
-- Table structure for table `book_details`
--

CREATE TABLE `book_details` (
  `book_id` int(11) NOT NULL,
  `book_name` varchar(50) DEFAULT NULL,
  `author` varchar(50) DEFAULT NULL,
  `quantity` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `book_details`
--

INSERT INTO `book_details` (`book_id`, `book_name`, `author`, `quantity`) VALUES
(1, 'The Godather', 'Mario Puzo', 5),
(2, 'Tây Du Ký', 'Ngô Thừa Ân', 10),
(3, 'The Great Gatsby', 'Scott Fitzgerald', 6),
(4, 'LỊCH SỬ ĐẢNG CỘNG SẢN VIỆT NAM', 'Bộ giáo dục và đào đạo', 20),
(5, 'The Pragmatic Programmer', 'Andy Hunt', 5),
(6, 'Doraemon: Nobita và chuyến phiêu lưu vào xứ quỷ', 'Fujiko F.Fujio', 10),
(7, 'Truc\'\'s Books', 'Minh Chực', 69),
(8, 'I-chan is me-chan', 'Nguyễn Tấn Dồng', 6),
(9, 'Haha', 'Khang', 2);

-- --------------------------------------------------------

--
-- Table structure for table `issue_book_details`
--

CREATE TABLE `issue_book_details` (
  `id` int(11) NOT NULL,
  `book_id` int(11) DEFAULT NULL,
  `book_name` varchar(50) DEFAULT NULL,
  `student_id` int(11) DEFAULT NULL,
  `student_name` varchar(50) DEFAULT NULL,
  `issue_date` date DEFAULT NULL,
  `due_date` date DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Dumping data for table `issue_book_details`
--

INSERT INTO `issue_book_details` (`id`, `book_id`, `book_name`, `student_id`, `student_name`, `issue_date`, `due_date`, `status`) VALUES
(11, 1, 'The Godather', 1, 'Nguyễn Minh Trực', '2024-11-03', '2024-11-30', 'returned'),
(12, 5, 'The Pragmatic Programmer', 4, 'Nguyễn Gia Cường', '2024-11-03', '2024-11-30', 'pending'),
(14, 1, 'The Godather', 2, 'Nguyễn Thanh Khang', '2024-11-05', '2024-11-29', 'returned'),
(15, 5, 'The Pragmatic Programmer', 5, 'Nguyễn Văn A', '2024-11-01', '2024-11-11', 'pending');

-- --------------------------------------------------------

--
-- Table structure for table `staffs`
--

CREATE TABLE `staffs` (
  `staff_id` int(11) NOT NULL,
  `staff_fullname` varchar(50) NOT NULL,
  `staff_username` varchar(50) NOT NULL,
  `staff_contact` varchar(50) NOT NULL,
  `staff_password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staffs`
--

INSERT INTO `staffs` (`staff_id`, `staff_fullname`, `staff_username`, `staff_contact`, `staff_password`) VALUES
(1, 'khang dep trai', 'khangkeke', '123213123123', '1');

-- --------------------------------------------------------

--
-- Table structure for table `student_details`
--

CREATE TABLE `student_details` (
  `student_id` int(11) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `school_year` varchar(100) DEFAULT NULL,
  `branch` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `student_details`
--

INSERT INTO `student_details` (`student_id`, `name`, `school_year`, `branch`) VALUES
(1, 'Nguyễn Minh Trực', '2022 - 2024', 'CN'),
(2, 'Nguyễn Thanh Khang', '2022 - 2024', 'CN'),
(3, 'Phan Tấn Đồng', '2022 - 2024', 'CN'),
(4, 'Nguyễn Gia Cường', '2022 - 2024', 'CN'),
(5, 'Nguyễn Văn A', '2020 - 2024', 'KM'),
(6, 'Nguyễn Thanh Bình', '2021 - 2025', 'KM');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(11) NOT NULL,
  `name` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `password`) VALUES
(5, '1', '1'),
(6, '1', '1'),
(7, 'khang', '1'),
(8, 'khang', '1'),
(9, 'khang123', '1'),
(10, 'khang123', '1'),
(11, 'khang3', '1'),
(12, 'khang3', '1'),
(13, 'khang113', '1');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `staffs`
--
ALTER TABLE `staffs`
  ADD PRIMARY KEY (`staff_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;