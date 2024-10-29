-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 29, 2024 at 09:38 PM
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
(5, 'The Pragmatic Programmer', 'Andy Hunt', 7),
(6, 'Doraemon: Nobita và chuyến phiêu lưu vào xứ quỷ', 'Fujiko F.Fujio', 10),
(9, 'Truc\'\'s Books', 'Minh Chực', 69);

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
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `contact` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `password`, `email`, `contact`) VALUES
(5, '1', '1', 'khang@gmail.com', '1'),
(6, '1', '1', 'khang@gmail.com', '1'),
(7, 'khang', '1', 'khang@gmail.com', '0123493456'),
(8, 'khang', '1', 'khang@gmail.com', '0123493456'),
(9, 'khang123', '1', 'khang2@gmail.com', '1234567879'),
(10, 'khang123', '1', 'khang2@gmail.com', '1234567879'),
(11, 'khang3', '1', 'tas@gmail.com', '1234567879'),
(12, 'khang3', '1', 'tas@gmail.com', '1234567879');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `book_details`
--
ALTER TABLE `book_details`
  ADD PRIMARY KEY (`book_id`);

--
-- Indexes for table `student_details`
--
ALTER TABLE `student_details`
  ADD PRIMARY KEY (`student_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `book_details`
--
ALTER TABLE `book_details`
  MODIFY `book_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `student_details`
--
ALTER TABLE `student_details`
  MODIFY `student_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
