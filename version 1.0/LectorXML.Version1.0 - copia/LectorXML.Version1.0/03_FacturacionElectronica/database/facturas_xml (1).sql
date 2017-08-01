-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 04-06-2017 a las 03:39:34
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `facturas_xml`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `idCliente` int(11) NOT NULL AUTO_INCREMENT,
  `ciRucCli` varchar(13) NOT NULL,
  `nombresCli` varchar(50) NOT NULL,
  PRIMARY KEY (`idCliente`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=14 ;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`idCliente`, `ciRucCli`, `nombresCli`) VALUES
(7, '1720192523', 'DE LOS PALOTES PERICO'),
(10, '1720197876', 'EL PERICO DE LOS PALOTES'),
(11, '1720197876', 'EL PERICO DE LOS PALOTES');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

DROP TABLE IF EXISTS `factura`;
CREATE TABLE IF NOT EXISTS `factura` (
  `idFactura` int(11) NOT NULL AUTO_INCREMENT,
  `codigo` varchar(50) NOT NULL,
  `fecha` varchar(15) NOT NULL,
  `tipoGasto` varchar(15) NOT NULL,
  `totalSinIva` varchar(10) NOT NULL,
  `iva` varchar(10) NOT NULL,
  `totalConIva` varchar(10) NOT NULL,
  `clienteFact` int(11) NOT NULL,
  PRIMARY KEY (`idFactura`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`idFactura`, `codigo`, `fecha`, `tipoGasto`, `totalSinIva`, `iva`, `totalConIva`, `clienteFact`) VALUES
(5, 'OF-1234', '22-03-2014', 'salud', '10', '12', '11.2', 7),
(6, 'OF-1234', '22-03-2014', 'salud', '10', '12', '11.2', 8),
(7, 'osf-9876', '11-07-2017', 'Vivienda', '200', '28', '228', 9);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
CREATE TABLE IF NOT EXISTS `proveedor` (
  `idProveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) NOT NULL,
  `ruc` varchar(13) NOT NULL,
  `direccion` varchar(500) NOT NULL,
  `ciudad` varchar(100) NOT NULL,
  `facturaPrive` int(11) NOT NULL,
  PRIMARY KEY (`idProveedor`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `nombres`, `ruc`, `direccion`, `ciudad`, `facturaPrive`) VALUES
(6, 'ALARCON FUENTES JOSE DANIEL', '1720896753001', 'Las casas 023-15 y el maestro', 'Quito', 5),
(7, 'ALARCON FUENTES JOSE DANIEL', '1720896753001', 'Las casas 023-15 y el maestro', 'Quito', 6),
(8, 'Beltran Venegas Daniel Alexander', '1720524204001', 'Av. ceballos y altamirano', 'Ambato', 7);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
