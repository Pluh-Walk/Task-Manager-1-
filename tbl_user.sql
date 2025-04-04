-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 19, 2025 at 03:55 PM
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
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `u_id` int(20) NOT NULL,
  `u_name` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `u_pass` varchar(150) NOT NULL,
  `u_lname` varchar(50) DEFAULT NULL,
  `u_status` varchar(50) DEFAULT NULL,
  `u_type` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_user`
--

INSERT INTO `tbl_user` (`u_id`, `u_name`, `u_email`, `u_username`, `u_pass`, `u_lname`, `u_status`, `u_type`) VALUES
(2, '1asfasfsa', 'asfoasjfsopafjposa@gmail.com', 'jagosajosga123', '[C@22159c1a', 'asfasfasai', 'Pending', 'User'),
(3, 'asgasfasfas', 'ehey123@yahoo.com', 'adamtest', '12341234', 'asgasfasfaga', 'Active', 'User'),
(6, 'asfasfsa', 'asojfsasgas@gmail.com', '', '12345678', 'asgasfas', 'Active', 'Admin'),
(7, 'Renz', 'RenzCaballeroz', 'RenzXVivian', '12345678', 'Caballeroz', 'Active', 'Easter Egg'),
(8, 'ivan', 'ivanclark@gmail.com', 'ivanclarkson', '12341234', 'clark baynas', 'Active', 'User'),
(9, 'ivanclarkson', 'ivanclarkbaynas@gmail.com', 'ehey', 'ehey1234', 'baynas', 'Pending', 'User'),
(10, 'adam', 'adamcolina@gmail.co', 'adamadmin', '0921354688', 'colina', 'Active', 'Admin'),
(11, 'ehey', 'ehey@scc.edu.ph', 'eheyers', 'ehey1234', 'ehey', 'Active', 'User'),
(12, 'ivan clark', 'ivanclarksonbaynason@gmail.com', 'eheymabsworld12', 'oUjLXbBaTMBpu6iHGzdcKXQJfqEp+q7RGW0oLb94oXE=', 'baynas', 'Pending', 'Admin'),
(13, 'Maby gabriel', 'mabysworld12@gmail.com', 'mabymegoo', 'doEp15TVeGrnheJlnEPu2s2LLKk7LD0tQObrm0JOC1U=', 'Guillemememer', 'Active', 'Admin'),
(14, 'Mike', 'mike@scc.edu.ph', 'Mikegwapo', 'eLniYKmc1pb5H39fmxgzr9NlOs0dBlQYCGRuY+4evmA=', 'mike', 'Active', 'Admin'),
(15, 'Mike', 'mikeuser@scc.edu.ph', 'mikeuser', 'PV3S6q1ooi1os51utHa3W6a83ZagDCfn3BDQo/7Lfmk=', 'mike', 'Active', 'User');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbl_user`
--
ALTER TABLE `tbl_user`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbl_user`
--
ALTER TABLE `tbl_user`
  MODIFY `u_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
