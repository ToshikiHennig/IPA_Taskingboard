-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 10. Nov 2017 um 16:35
-- Server-Version: 10.1.21-MariaDB
-- PHP-Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `db_task`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `task`
--

CREATE TABLE `task` (
  `id` int(11) NOT NULL,
  `description` text COLLATE utf8_bin,
  `done` bit(1) NOT NULL,
  `title` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `assignee` varchar(31) COLLATE utf8_bin NOT NULL,
  `creator` varchar(31) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Daten für Tabelle `task`
--

INSERT INTO `task` (`id`, `description`, `done`, `title`, `assignee`, `creator`) VALUES
(1, 'asdsadsad', b'1', 'ewrewrew', 'Test-User', 'Toshiki'),
(2, 'Test 1', b'1', 'Titel', 'Toshiki', 'Toshiki'),
(3, 'sadsadad', b'0', 'Dasasad', 'Test-User', 'Toshiki'),
(4, 'Anderer Test', b'0', 'Zu viele Titel', 'Toshiki', 'Toshiki'),
(5, 'dsfdsf', b'1', 'dsfdsfds', 'Test-User', 'Toshiki'),
(6, 'Neuer Task', b'1', 'Begrenzung auf 45 Zeichen', 'Toshiki', 'Toshiki'),
(7, 'Neuer Task', b'1', 'Hier ist ein Titel', 'Toshiki', 'Toshiki'),
(8, 'Ein weiterer Task', b'1', 'Nochmals ein Titel', 'Toshiki', 'Toshiki'),
(9, 'Cooler Task', b'1', 'Coller Titel', 'Toshiki', 'Toshiki'),
(10, 'Das Hühnchen ist lecker', b'1', 'Hühnchen', 'Toshiki', 'Toshiki'),
(11, 'sadsadsad', b'0', 'Testtitel', 'Test-User', 'Toshiki'),
(12, 'Wie viele Tasks habe ich erstellt?', b'1', 'Titel schreiben ist anstrengend', 'Toshiki', 'Toshiki'),
(13, 'Das sind zu viele Tasks', b'1', 'dfdsfds', 'Toshiki', 'Toshiki'),
(14, 'sadsadsad', b'1', 'Titel', 'Test-User', 'Toshiki'),
(15, 'Das ist ein Task für Toshiki, ich hoffe der Text ist nicht zu lange', b'0', 'Task für Toshiki', 'Toshiki', 'Test-User'),
(20, 'aaaaaaaaaaaaaaaaaaaaaaaaaaaasssssssssssssssssssssssssssssssssssssssssssssvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvllllllllllllllllllllllllllsssssssssssssssqqqqqqqqqqqqqooooooooooooyyyyyyy999$$$$$$$$$$$$$$$$$$$$$$$saaaaaw213 fdsfsdfsdf', b'0', 'Das ist ein Titel', 'Toshiki', 'Toshiki'),
(23, 'Das ist ein Test für den Testfall Nr. 3', b'0', 'Testfall Nr. 3', 'Toshiki', 'Toshiki'),
(24, 'sdds fdfgdfgdfggfdgdf', b'0', 'Titel dsfdsfdsf fffffffffffffffffffffffffffff', 'Toshiki', 'Toshiki');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `user`
--

CREATE TABLE `user` (
  `username` varchar(31) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Daten für Tabelle `user`
--

INSERT INTO `user` (`username`) VALUES
('Test-User'),
('Toshiki'),
('bla');

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKeosvxgtnuynoegjnx2eo9eqpy` (`assignee`),
  ADD KEY `FK1k8s0uxkyspus7k0v5xo56hwv` (`creator`);

--
-- Indizes für die Tabelle `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT für exportierte Tabellen
--

--
-- AUTO_INCREMENT für Tabelle `task`
--
ALTER TABLE `task`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- Constraints der exportierten Tabellen
--

--
-- Constraints der Tabelle `task`
--
ALTER TABLE `task`
  ADD CONSTRAINT `FK1k8s0uxkyspus7k0v5xo56hwv` FOREIGN KEY (`creator`) REFERENCES `user` (`username`),
  ADD CONSTRAINT `FKeosvxgtnuynoegjnx2eo9eqpy` FOREIGN KEY (`assignee`) REFERENCES `user` (`username`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
