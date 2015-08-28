-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.6.26-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.2.0.4947
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Volcando estructura de base de datos para tfg
DROP DATABASE IF EXISTS `tfg`;
CREATE DATABASE IF NOT EXISTS `tfg` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `tfg`;


-- Volcando estructura para tabla tfg.client
DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` longtext,
  `name` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tfg.client: ~5 rows (aproximadamente)
DELETE FROM `client`;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` (`id`, `description`, `name`) VALUES
	(1, 'asdas', 'hola'),
	(2, 'asdas', 'hola'),
	(3, 'asdas', 'hola'),
	(4, 'asdas', 'hola'),
	(6, 'asdas', 'hola');
/*!40000 ALTER TABLE `client` ENABLE KEYS */;


-- Volcando estructura para tabla tfg.count
DROP TABLE IF EXISTS `count`;
CREATE TABLE IF NOT EXISTS `count` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `date` datetime DEFAULT NULL,
  `value` double DEFAULT NULL,
  `device_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_rqmykm4txlxeoxgl3bu4quy6f` (`device_id`),
  CONSTRAINT `FK_rqmykm4txlxeoxgl3bu4quy6f` FOREIGN KEY (`device_id`) REFERENCES `device` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tfg.count: ~90 rows (aproximadamente)
DELETE FROM `count`;
/*!40000 ALTER TABLE `count` DISABLE KEYS */;
INSERT INTO `count` (`id`, `date`, `value`, `device_id`) VALUES
	(1, '2015-08-20 18:35:00', 1, 1),
	(2, '2015-08-20 18:35:00', 1, 1),
	(3, '2015-08-20 18:35:00', -1, 1),
	(4, '2015-08-20 18:35:00', 1, 1),
	(5, '2015-08-20 18:35:00', 1, 1),
	(6, '2015-08-20 18:35:00', 1, 1),
	(7, '2015-08-20 18:35:00', 1, 1),
	(8, '2015-08-12 19:10:00', 1, 1),
	(10, '2015-08-11 18:35:00', 25, 2),
	(11, '2015-08-11 18:40:00', 25, 2),
	(12, '2015-08-11 18:45:00', 26, 2),
	(13, '2015-08-11 18:50:00', 26, 2),
	(14, '2015-08-11 18:55:00', 26, 2),
	(15, '2015-08-11 19:00:00', 27, 2),
	(16, '2015-08-11 19:05:00', 27, 2),
	(17, '2015-08-11 19:10:00', 27, 2),
	(18, '2015-08-11 18:35:00', 12, 3),
	(19, '2015-08-11 18:40:00', 12, 3),
	(20, '2015-08-11 18:45:00', 13, 3),
	(21, '2015-08-11 18:50:00', 13, 3),
	(22, '2015-08-11 18:55:00', 9, 3),
	(23, '2015-08-11 19:00:00', 9, 3),
	(24, '2015-08-11 19:05:00', 7, 3),
	(25, '2015-08-11 19:10:00', 8, 3),
	(27, '2015-08-25 19:19:56', 1, 1),
	(28, '2015-08-25 20:20:58', -1, 1),
	(29, '2015-08-25 20:22:04', -1, 1),
	(30, '2015-08-25 20:26:17', -1, 1),
	(31, '2015-08-25 20:27:30', -1, 1),
	(32, '2015-08-25 20:29:19', 1, 1),
	(33, '2015-08-25 20:33:16', -1, 1),
	(34, '2015-08-25 20:33:24', 1, 1),
	(35, '2015-08-25 20:33:24', -1, 1),
	(36, '2015-08-25 20:33:27', 1, 1),
	(37, '2015-08-25 20:33:47', -1, 1),
	(38, '2015-08-25 20:34:57', 1, 1),
	(39, '2015-08-26 15:49:11', 1, 1),
	(40, '2015-08-26 15:49:19', -1, 1),
	(41, '2015-08-26 15:49:23', 1, 1),
	(42, '2015-08-26 15:49:26', -1, 1),
	(43, '2015-08-26 15:49:28', 1, 1),
	(44, '2015-08-26 15:49:32', -1, 1),
	(45, '2015-08-26 15:50:28', 1, 1),
	(46, '2015-08-26 15:50:31', -1, 1),
	(47, '2015-08-26 17:38:38', -1, 1),
	(48, '2015-08-26 17:38:48', 1, 1),
	(49, '2015-08-26 17:38:49', -1, 1),
	(50, '2015-08-26 17:38:51', 1, 1),
	(51, '2015-08-26 17:38:52', -1, 1),
	(52, '2015-08-26 17:38:54', 1, 1),
	(53, '2015-08-26 17:38:55', -1, 1),
	(54, '2015-08-26 17:45:26', 1, 1),
	(55, '2015-08-26 17:45:34', -1, 1),
	(56, '2015-08-26 17:54:48', 1, 1),
	(57, '2015-08-26 18:37:18', 26.8, 2),
	(58, '2015-08-26 18:37:28', 26.8, 2),
	(59, '2015-08-26 18:37:38', 26.8, 2),
	(60, '2015-08-26 18:37:48', 26.8, 2),
	(61, '2015-08-26 18:37:58', 26.8, 2),
	(62, '2015-08-26 18:38:08', 26.8, 2),
	(63, '2015-08-26 18:38:18', 26.7, 2),
	(64, '2015-08-26 18:38:28', 26.7, 2),
	(65, '2015-08-26 18:38:31', 2.3, 2),
	(66, '2015-08-26 18:38:39', 26.7, 2),
	(67, '2015-08-26 18:38:49', 26.7, 2),
	(68, '2015-08-26 18:38:59', 26.7, 2),
	(69, '2015-08-26 18:39:09', 26.7, 2),
	(70, '2015-08-26 18:39:19', 26.7, 2),
	(71, '2015-08-26 18:39:29', 26.7, 2),
	(72, '2015-08-26 18:39:39', 26.6, 2),
	(73, '2015-08-26 18:39:42', 1, 1),
	(74, '2015-08-26 18:39:49', 26.7, 2),
	(75, '2015-08-26 18:39:59', 26.6, 2),
	(76, '2015-08-26 18:40:09', 26.6, 2),
	(77, '2015-08-26 18:40:40', 2.3, 3),
	(78, '2015-08-26 18:43:32', 1, 1),
	(79, '2015-08-26 18:43:36', -1, 1),
	(80, '2015-08-26 18:44:13', 26.6, 2),
	(81, '2015-08-26 18:44:13', 38.2, 3),
	(82, '2015-08-26 18:45:13', 26.5, 2),
	(83, '2015-08-26 18:45:13', 38.1, 3),
	(84, '2015-08-26 18:46:13', 26.5, 2),
	(85, '2015-08-26 18:46:13', 38, 3),
	(86, '2015-08-26 18:47:13', 26.4, 2),
	(87, '2015-08-26 18:47:13', 38, 3),
	(88, '2015-08-26 18:47:27', 1, 1),
	(89, '2015-08-26 18:48:13', 26.3, 2),
	(90, '2015-08-26 18:48:13', 38.1, 3),
	(91, '2015-08-26 18:49:13', 26.3, 2),
	(92, '2015-08-26 18:49:13', 38.2, 3);
/*!40000 ALTER TABLE `count` ENABLE KEYS */;


-- Volcando estructura para tabla tfg.device
DROP TABLE IF EXISTS `device`;
CREATE TABLE IF NOT EXISTS `device` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `group_devices` varchar(20) DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  `type_device` int(11) DEFAULT NULL,
  `location_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_kgi604mek64pt4vd1w01qw7rx` (`location_id`),
  CONSTRAINT `FK_kgi604mek64pt4vd1w01qw7rx` FOREIGN KEY (`location_id`) REFERENCES `location` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tfg.device: ~4 rows (aproximadamente)
DELETE FROM `device`;
/*!40000 ALTER TABLE `device` DISABLE KEYS */;
INSERT INTO `device` (`id`, `group_devices`, `name`, `type_device`, `location_id`) VALUES
	(1, '', 'Dinamic Area', 0, 1),
	(2, '', 'Dinamic Area', 1, 1),
	(3, '', 'Dinamic Area', 2, 1),
	(4, '', 'ETSII', 0, 2);
/*!40000 ALTER TABLE `device` ENABLE KEYS */;


-- Volcando estructura para tabla tfg.location
DROP TABLE IF EXISTS `location`;
CREATE TABLE IF NOT EXISTS `location` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` longtext,
  `city` varchar(15) DEFAULT NULL,
  `description` longtext,
  `is_public` bit(1) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `max_capacity` int(11) DEFAULT NULL,
  `name` varchar(15) DEFAULT NULL,
  `client_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_r4pg3lefasmk07kd3bqnfyybj` (`client_id`),
  CONSTRAINT `FK_r4pg3lefasmk07kd3bqnfyybj` FOREIGN KEY (`client_id`) REFERENCES `client` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla tfg.location: ~2 rows (aproximadamente)
DELETE FROM `location`;
/*!40000 ALTER TABLE `location` DISABLE KEYS */;
INSERT INTO `location` (`id`, `address`, `city`, `description`, `is_public`, `latitude`, `longitude`, `max_capacity`, `name`, `client_id`) VALUES
	(1, 'Av. San Francisco Javier, 9 Edificio SEVILLA-2, Planta 11, Módulo 28', 'Sevilla', 'Dispositivo que se encuentra en la empresa Dinamic Area. Consta de sesnor de temperatura, sensor de humedad y contador de aforo.', b'1', 37.380268, -5.973494, 20, 'Dinamic area', 1),
	(2, 'Avenida Reina Mercedes s/n', 'Sevilla', 'Contador de aforo situado en la bibloteca de la ETSII (Escuela Ténica Superior de Ingeniería Informática).', b'1', 37.358381, -5.9880085, 200, 'Biblio ETSII', 1);
/*!40000 ALTER TABLE `location` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
