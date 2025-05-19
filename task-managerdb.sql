-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2025 at 09:27 PM
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
-- Database: `task-managerdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `logs`
--

CREATE TABLE `logs` (
  `log_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `action` varchar(255) DEFAULT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `logs`
--

INSERT INTO `logs` (`log_id`, `user_id`, `action`, `timestamp`) VALUES
(1, 1003, 'Deleted user with ID 1004', '2025-04-20 11:31:19'),
(2, 1003, 'Navigated to update user form for user ID: 1008', '2025-05-05 07:30:11'),
(3, 1003, 'Logged in successfully', '2025-05-05 07:35:45'),
(4, 1003, 'Logged in successfully', '2025-05-05 07:43:25'),
(5, 1003, 'Logged in successfully', '2025-05-05 07:47:19'),
(6, 1003, 'Logged in successfully', '2025-05-05 07:51:46'),
(7, 1003, 'Logged in successfully', '2025-05-05 07:54:47'),
(8, 0, 'Navigated to add user form.', '2025-05-05 09:53:42'),
(9, 0, 'Navigated to add user form.', '2025-05-05 09:54:58'),
(10, 0, 'Navigated to add user form.', '2025-05-05 09:57:17'),
(11, 0, 'Navigated to add user form.', '2025-05-05 09:59:49'),
(12, 1011, 'Logged in successfully', '2025-05-19 18:35:11'),
(13, 1011, 'Logged in successfully', '2025-05-19 18:36:48'),
(14, 1011, 'Navigated to add project form.', '2025-05-19 18:36:54'),
(15, 1011, 'Logged in successfully', '2025-05-19 18:45:44'),
(16, 1011, 'Navigated to add project form.', '2025-05-19 18:45:48'),
(17, 1011, 'Logged in successfully', '2025-05-19 18:47:43'),
(18, 1011, 'Navigated to add project form.', '2025-05-19 18:47:47'),
(19, 1011, 'Logged in successfully', '2025-05-19 18:49:37'),
(20, 1011, 'Navigated to add project form.', '2025-05-19 18:49:39'),
(21, 1011, 'Navigated to add project form.', '2025-05-19 18:50:08'),
(22, 1011, 'Logged in successfully', '2025-05-19 19:06:12'),
(23, 1011, 'Navigated to add project form.', '2025-05-19 19:06:18'),
(24, 1011, 'Logged in successfully', '2025-05-19 19:08:24'),
(25, 1011, 'Navigated to add project form.', '2025-05-19 19:08:28'),
(26, 1011, 'Logged in successfully', '2025-05-19 19:10:41'),
(27, 1011, 'Navigated to add project form.', '2025-05-19 19:10:45'),
(28, 1011, 'Logged in successfully', '2025-05-19 19:13:29'),
(29, 1011, 'Navigated to add project form.', '2025-05-19 19:13:31'),
(30, 1011, 'Logged in successfully', '2025-05-19 19:22:31'),
(31, 1011, 'Logged in successfully', '2025-05-19 19:26:14'),
(32, 1011, 'Deleted project with ID 1003', '2025-05-19 19:26:23');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_projects`
--

CREATE TABLE `tbl_projects` (
  `p_id` int(11) NOT NULL,
  `project_name` varchar(255) NOT NULL,
  `due_date` date DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `t_id` int(11) DEFAULT NULL,
  `u_id` int(11) DEFAULT NULL,
  `description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `tbl_task`
--

CREATE TABLE `tbl_task` (
  `t_id` int(11) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text DEFAULT NULL,
  `status` varchar(50) DEFAULT 'pending',
  `due_date` date DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_task`
--

INSERT INTO `tbl_task` (`t_id`, `title`, `description`, `status`, `due_date`, `created_at`) VALUES
(2000, 'test', 'test', 'pending', '2003-08-03', '2025-05-05 09:17:58'),
(2001, 'ivanbayot', 'sigbinayot', 'Pending', '2008-07-03', '2025-05-05 09:55:12'),
(2002, 'ivan sig binayet', 'maby goloid', 'Pending', '2002-03-14', '2025-05-05 09:57:38'),
(2003, 'ivansclarckbaynason', 'baynas', 'Pending', '2001-12-03', '2025-05-05 10:00:26');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(20) NOT NULL,
  `u_name` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_pass` varchar(255) DEFAULT NULL,
  `u_lname` varchar(50) DEFAULT NULL,
  `u_status` varchar(50) DEFAULT NULL,
  `u_type` varchar(50) DEFAULT NULL,
  `u_image` varchar(1000) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_name`, `u_email`, `u_username`, `u_pass`, `u_lname`, `u_status`, `u_type`, `u_image`) VALUES
(1002, 'ivans', 'ivansclarksbaynas@gmail.com', 'ivanclarkson', 'QaKSyc6Tkh1DPeMkSrGxLKOI5j+rXqDK/S43SUD0HVM=', 'clarks', 'Active', 'User', ''),
(1003, 'miketest', 'lisondra@gmail.com', 'michaelgwapo', 'NLY0xQfINeha/bSRYa6VabQKLIDJFc5FL+7Fq3HGnYU=', 'mikechel', 'Active', 'Admin', ''),
(1005, 'ivanclarck', 'clarck@gmail.com', 'clarckson', 'uWOSFgzfZFwIQGL1X2G076FzcZLGUbJY2FeCel1j1nM=', 'clarck', 'Active', 'User', ''),
(1006, 'ivans', 'ivans@gmail.com', 'ivans', 'uWOSFgzfZFwIQGL1X2G076FzcZLGUbJY2FeCel1j1nM=', 'ivans', 'Active', 'Admin', ''),
(1007, 'maby talks', 'mabytalks@gmail.com', 'mabysworld', '', 'brrrrr', 'Active', 'User', 'src/userImages/download (6).jpg'),
(1008, 'michael', 'bust@gmail.com', 'bustylatina', '', 'bust', 'Active', 'User', 'src/userImages/Michael.jpg'),
(1009, 'mabyjay', 'adamtourtosa@gmail.com', 'mabyjay', '8FQAMd/7BLuDTOLhuxlEmXR6mg6R0lIdlSkOzkMPbro=', 'jay', 'Pending', 'User', 'src/userImages/3d5b807f9a6e468745b4eca84d418695.jpg'),
(1010, 'mabyguillermers', 'eheydumpacc@gmail.com', 'eheydump', 'E9JJ8stBJ7QM+nV4ZoUCeHk/gU3tPFh/5YieiJp6n2w=', 'autahays', 'Pending', 'User', 'src/userImages/50579b87f1507f2f2c38f30296e5e02f.jpg'),
(1011, 'adamtest', 'adamtest@gmail.com', 'adamtest', 'mRvNksDJwm8vQV8S/snULfxxSaR2vY165CGAk8wieas=', 'colins', 'Active', 'Admin', 'src/userImages/470057912_1259910005236733_1832370240850830970_n.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `logs`
--
ALTER TABLE `logs`
  ADD PRIMARY KEY (`log_id`);

--
-- Indexes for table `tbl_projects`
--
ALTER TABLE `tbl_projects`
  ADD PRIMARY KEY (`p_id`),
  ADD KEY `t_id` (`t_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `tbl_task`
--
ALTER TABLE `tbl_task`
  ADD PRIMARY KEY (`t_id`);

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `logs`
--
ALTER TABLE `logs`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `tbl_projects`
--
ALTER TABLE `tbl_projects`
  MODIFY `p_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1004;

--
-- AUTO_INCREMENT for table `tbl_task`
--
ALTER TABLE `tbl_task`
  MODIFY `t_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2004;

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1012;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `tbl_projects`
--
ALTER TABLE `tbl_projects`
  ADD CONSTRAINT `tbl_projects_ibfk_1` FOREIGN KEY (`t_id`) REFERENCES `tbl_task` (`t_id`) ON DELETE SET NULL,
  ADD CONSTRAINT `tbl_projects_ibfk_2` FOREIGN KEY (`u_id`) REFERENCES `tbl_user` (`u_id`) ON DELETE SET NULL;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
