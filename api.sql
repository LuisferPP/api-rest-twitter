-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 25-05-2021 a las 16:01:29
-- Versión del servidor: 5.7.31
-- Versión de PHP: 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `api`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tweet`
--

DROP TABLE IF EXISTS `tweet`;
CREATE TABLE IF NOT EXISTS `tweet` (
  `usuario` varchar(100) COLLATE utf8_spanish_ci NOT NULL,
  `texto` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `localizacion` varchar(300) COLLATE utf8_spanish_ci NOT NULL,
  `validacion` tinyint(1) NOT NULL,
  `id` int(11) NOT NULL,
  `idioma` varchar(50) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `tweet`
--

INSERT INTO `tweet` (`usuario`, `texto`, `localizacion`, `validacion`, `id`, `idioma`) VALUES
('lf', 'hola', 'gggggg', 1, 1, '');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
