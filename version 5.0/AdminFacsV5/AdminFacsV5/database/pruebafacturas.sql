-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-02-2017 a las 22:25:01
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pruebafacturas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle`
--
create database pruebafacturas
use pruebafacturas
CREATE TABLE `detalle` (
  `codigoPrincipal` text NOT NULL,
  `descripcion` text NOT NULL,
  `cantidad` text NOT NULL,
  `precioUnitario` text NOT NULL,
  `precioTotalSinImpuesto` text NOT NULL,
  `ID_Detalle` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detalle`
--

INSERT INTO `detalle` (`codigoPrincipal`, `descripcion`, `cantidad`, `precioUnitario`, `precioTotalSinImpuesto`, `ID_Detalle`) VALUES
('750954604508', 'PACK COLGATE CEPILLO 360COLGATE TOTAL', '1.0000', '4.7281', '4.73', 373),
('770203191887', 'CAREFREE ORIGINAL', '1.0000', '6.8070', '6.81', 374),
('786102290072', 'INDAVES HUEVO MEDIANO', '1.0000', '4.8000', '4.80', 375),
('000000268516', 'MANZANA ROJA GRANEL A.', '0.6800', '3.2647', '2.22', 376),
('000000262925', 'PIMIENTO AMARILLO GRANEL', '0.4900', '2.7959', '1.37', 377),
('000000260594', 'PIMIENTO ROJO GRANEL', '0.5350', '4.1682', '2.23', 378),
('000000260647', 'TOMATE RINON GRANEL', '1.1900', '0.8992', '1.07', 379),
('201503880000', 'H. ACELGA AKI', '1.0000', '0.5500', '0.55', 380),
('786100021464', 'HORTILISTO MIX MEGA CEBOLLAS', '1.0000', '1.6200', '1.62', 381),
('786104251248', 'VAINITA 350GR A', '1.0000', '0.4500', '0.37', 382),
('786105820961', 'GRAN VAN DUSH DULCE. ESPUMANTE', '2.0000', '5.2719', '9.78', 383),
('786104861008', 'GIRASOL  .', '1.0000', '3.1100', '3.11', 384),
('000000261217', 'A-V.SALON MITAD C/GRASA RES.', '1.0000', '9.9700', '9.97', 385),
('201503870000', 'H. CULANTRO AKI', '1.0000', '0.5200', '0.52', 386),
('786101820060', 'PASTA TOMATE ECONOPACK', '2.0000', '0.6140', '1.23', 387),
('009038800255', 'REAL SIX PACK ACEITE.', '1.0000', '7.9400', '7.94', 388),
('770201088079', 'PROMO AXION LIMON', '1.0000', '2.1579', '2.16', 389),
('786104251543', 'BROCOLI FLORETEADO', '1.0000', '0.6300', '0.63', 390),
('786103640001', 'SG INAQUINUA', '1.0000', '2.9800', '2.77', 391),
('786103191067', 'SG PRADERA MAIZ PARA TOSTAR', '1.0000', '2.3300', '2.33', 392),
('786100650334', 'SIBERIA FRESCO QUESO', '1.0000', '5.6300', '5.63', 393),
('786102022395', 'VELAS VOTIVAS', '1.0000', '1.6140', '1.61', 394),
('786101540032', 'SG MASCORONA MAIZ', '1.0000', '2.5200', '2.52', 395),
('786104252963', 'ZANAHORIA AMARILLA AKI.', '1.0000', '0.2300', '0.23', 396),
('786210091055', 'DELIVALLE YUCA VACIO', '1.0000', '1.8100', '1.81', 397),
('000000269073', 'A-S.MOLIDA TIPO I 14-15% RES..', '1.0000', '1.4900', '1.49', 398),
('000000260072', 'A-S.MOLIDA TIPO I SUPER ESP 3-4% RES.', '1.0000', '3.2500', '3.25', 399),
('000000262925', 'PIMIENTO AMARILLO GRANEL', '0.4150', '2.7952', '1.16', 400),
('000000261212', 'PLATANO MADURO GRANEL A', '1.0150', '0.4532', '0.46', 401),
('786104251248', 'VAINITA 350GR A', '1.0000', '0.4500', '0.39', 402),
('000000268334', 'A-S.MOLIDA TIPO II ESP CERDO.', '1.0000', '2.2000', '2.20', 403),
('000000260647', 'TOMATE RINON GRANEL', '0.9900', '0.9293', '0.92', 404),
('786100311200', 'FAMILIA PH MEGAROLLO X18 GRATIS 2 ROLLOS', '1.0000', '11.1404', '11.14', 405),
('786104253104', 'AK.LECHUGA CRESPA', '1.0000', '0.5900', '0.59', 406),
('000000268516', 'MANZANA ROJA GRANEL A.', '0.8000', '2.3250', '1.86', 407),
('786105590092', 'NUTRI LECHE SEMIDES UHT TETRA SQUARE', '2.0000', '1.2700', '2.29', 408),
('000000265021', 'PIMIENTO AKI EMPACADO', '1.0000', '0.2500', '0.25', 409),
('786104251161', 'AK.HUEVOS EXT.GRANDE', '1.0000', '5.1100', '5.11', 410),
('786104861008', 'GIRASOL  .', '1.0000', '3.1100', '3.11', 411),
('786104250541', 'AK.LENTEJA', '1.0000', '1.3100', '1.31', 412),
('786103190018', 'PRADERA FREJOL NEGRO', '1.0000', '1.3100', '1.31', 413),
('786104600187', 'BONANZA ALMENDRAS', '1.0000', '6.0900', '6.09', 414),
('786101540022', 'MASCORONA FREJOL R BOLON', '1.0000', '2.6900', '2.69', 415),
('009038800255', 'REAL SIX PACK ACEITE.', '1.0000', '7.9400', '7.94', 416),
('786105760061', 'FLEXIPLAST FUNDA SUPER ECONOMICA', '1.0000', '1.3947', '1.40', 417),
('786104250771', 'AK SAL REFINADA', '1.0000', '0.6400', '0.64', 418),
('786100650334', 'SIBERIA FRESCO QUESO', '1.0000', '5.6300', '5.63', 419),
('009038800155', 'REAL TUNTUN AC OLIVA', '1.0000', '2.6200', '2.62', 420),
('786211229010', 'CLOROX CLORO LIQ.PUREZA CITRICA', '1.0000', '2.3246', '2.33', 421),
('786100134072', 'DEJA CON SUAVIZANTE', '1.0000', '5.0263', '3.16', 422),
('000000261207', 'PECHUGA UNIDAD', '2.0000', '4.0950', '8.19', 423),
('786104252963', 'ZANAHORIA AMARILLA AKI.', '1.0000', '0.2300', '0.23', 424),
('786210091055', 'DELIVALLE YUCA VACIO', '1.0000', '1.8100', '1.81', 425),
('000000269073', 'A-S.MOLIDA TIPO I 14-15% RES..', '1.0000', '1.4900', '1.49', 426),
('000000260072', 'A-S.MOLIDA TIPO I SUPER ESP 3-4% RES.', '1.0000', '3.2500', '3.25', 427),
('000000262925', 'PIMIENTO AMARILLO GRANEL', '0.4150', '2.7952', '1.16', 428),
('000000261212', 'PLATANO MADURO GRANEL A', '1.0150', '0.4532', '0.46', 429),
('786104251248', 'VAINITA 350GR A', '1.0000', '0.4500', '0.39', 430),
('000000268334', 'A-S.MOLIDA TIPO II ESP CERDO.', '1.0000', '2.2000', '2.20', 431),
('000000260647', 'TOMATE RINON GRANEL', '0.9900', '0.9293', '0.92', 432),
('786100311200', 'FAMILIA PH MEGAROLLO X18 GRATIS 2 ROLLOS', '1.0000', '11.1404', '11.14', 433),
('786104253104', 'AK.LECHUGA CRESPA', '1.0000', '0.5900', '0.59', 434),
('000000268516', 'MANZANA ROJA GRANEL A.', '0.8000', '2.3250', '1.86', 435),
('786105590092', 'NUTRI LECHE SEMIDES UHT TETRA SQUARE', '2.0000', '1.2700', '2.29', 436),
('000000265021', 'PIMIENTO AKI EMPACADO', '1.0000', '0.2500', '0.25', 437),
('786104251161', 'AK.HUEVOS EXT.GRANDE', '1.0000', '5.1100', '5.11', 438),
('786104861008', 'GIRASOL  .', '1.0000', '3.1100', '3.11', 439),
('786104250541', 'AK.LENTEJA', '1.0000', '1.3100', '1.31', 440),
('786103190018', 'PRADERA FREJOL NEGRO', '1.0000', '1.3100', '1.31', 441),
('786104600187', 'BONANZA ALMENDRAS', '1.0000', '6.0900', '6.09', 442),
('786101540022', 'MASCORONA FREJOL R BOLON', '1.0000', '2.6900', '2.69', 443),
('009038800255', 'REAL SIX PACK ACEITE.', '1.0000', '7.9400', '7.94', 444),
('786105760061', 'FLEXIPLAST FUNDA SUPER ECONOMICA', '1.0000', '1.3947', '1.40', 445),
('786104250771', 'AK SAL REFINADA', '1.0000', '0.6400', '0.64', 446),
('786100650334', 'SIBERIA FRESCO QUESO', '1.0000', '5.6300', '5.63', 447),
('009038800155', 'REAL TUNTUN AC OLIVA', '1.0000', '2.6200', '2.62', 448),
('786211229010', 'CLOROX CLORO LIQ.PUREZA CITRICA', '1.0000', '2.3246', '2.33', 449),
('786100134072', 'DEJA CON SUAVIZANTE', '1.0000', '5.0263', '3.16', 450),
('000000261207', 'PECHUGA UNIDAD', '2.0000', '4.0950', '8.19', 451),
('786104252963', 'ZANAHORIA AMARILLA AKI.', '1.0000', '0.2300', '0.23', 452),
('786210091055', 'DELIVALLE YUCA VACIO', '1.0000', '1.8100', '1.81', 453),
('000000269073', 'A-S.MOLIDA TIPO I 14-15% RES..', '1.0000', '1.4900', '1.49', 454),
('000000260072', 'A-S.MOLIDA TIPO I SUPER ESP 3-4% RES.', '1.0000', '3.2500', '3.25', 455),
('000000262925', 'PIMIENTO AMARILLO GRANEL', '0.4150', '2.7952', '1.16', 456),
('000000261212', 'PLATANO MADURO GRANEL A', '1.0150', '0.4532', '0.46', 457),
('786104251248', 'VAINITA 350GR A', '1.0000', '0.4500', '0.39', 458),
('000000268334', 'A-S.MOLIDA TIPO II ESP CERDO.', '1.0000', '2.2000', '2.20', 459),
('000000260647', 'TOMATE RINON GRANEL', '0.9900', '0.9293', '0.92', 460),
('786100311200', 'FAMILIA PH MEGAROLLO X18 GRATIS 2 ROLLOS', '1.0000', '11.1404', '11.14', 461),
('786104253104', 'AK.LECHUGA CRESPA', '1.0000', '0.5900', '0.59', 462),
('000000268516', 'MANZANA ROJA GRANEL A.', '0.8000', '2.3250', '1.86', 463),
('786105590092', 'NUTRI LECHE SEMIDES UHT TETRA SQUARE', '2.0000', '1.2700', '2.29', 464),
('000000265021', 'PIMIENTO AKI EMPACADO', '1.0000', '0.2500', '0.25', 465),
('786104251161', 'AK.HUEVOS EXT.GRANDE', '1.0000', '5.1100', '5.11', 466),
('786104861008', 'GIRASOL  .', '1.0000', '3.1100', '3.11', 467),
('786104250541', 'AK.LENTEJA', '1.0000', '1.3100', '1.31', 468),
('786103190018', 'PRADERA FREJOL NEGRO', '1.0000', '1.3100', '1.31', 469),
('786104600187', 'BONANZA ALMENDRAS', '1.0000', '6.0900', '6.09', 470),
('786101540022', 'MASCORONA FREJOL R BOLON', '1.0000', '2.6900', '2.69', 471),
('009038800255', 'REAL SIX PACK ACEITE.', '1.0000', '7.9400', '7.94', 472),
('786105760061', 'FLEXIPLAST FUNDA SUPER ECONOMICA', '1.0000', '1.3947', '1.40', 473),
('786104250771', 'AK SAL REFINADA', '1.0000', '0.6400', '0.64', 474),
('786100650334', 'SIBERIA FRESCO QUESO', '1.0000', '5.6300', '5.63', 475),
('009038800155', 'REAL TUNTUN AC OLIVA', '1.0000', '2.6200', '2.62', 476),
('786211229010', 'CLOROX CLORO LIQ.PUREZA CITRICA', '1.0000', '2.3246', '2.33', 477),
('786100134072', 'DEJA CON SUAVIZANTE', '1.0000', '5.0263', '3.16', 478),
('000000261207', 'PECHUGA UNIDAD', '2.0000', '4.0950', '8.19', 479);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `impuesto`
--

CREATE TABLE `impuesto` (
  `valor` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `impuesto`
--

INSERT INTO `impuesto` (`valor`) VALUES
(1),
(1),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(1),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(2),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(2),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(2),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0),
(0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `infoadicional`
--

CREATE TABLE `infoadicional` (
  `campoAdicional` text,
  `direccionComprador` text,
  `correoComprador` text NOT NULL,
  `ID_InfoAdicional` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `infoadicional`
--

INSERT INTO `infoadicional` (`campoAdicional`, `direccionComprador`, `correoComprador`, `ID_InfoAdicional`) VALUES
('61.54', NULL, '', 20),
('61.54', NULL, '', 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `infofactura`
--

CREATE TABLE `infofactura` (
  `dirEstablecimiento` text NOT NULL,
  `contribuyenteEspecial` int(3) NOT NULL,
  `obligadoContabilidad` text NOT NULL,
  `tipoIdentificacionComprador` text NOT NULL,
  `razonSocialComprador` text NOT NULL,
  `identificacionComprador` text NOT NULL,
  `totalSinImpuestos` text NOT NULL,
  `totalDescuento` text NOT NULL,
  `ID_InfoFactura` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `infofactura`
--

INSERT INTO `infofactura` (`dirEstablecimiento`, `contribuyenteEspecial`, `obligadoContabilidad`, `tipoIdentificacionComprador`, `razonSocialComprador`, `identificacionComprador`, `totalSinImpuestos`, `totalDescuento`, `ID_InfoFactura`) VALUES
('Av. Mariano Acosta     y   Fray Vacas Galindo', 5368, 'SI', '05', 'ORQUERA ANDRADE LUIS MIGUEL                                .', '1000982882', '79.57', '2.18', 20),
('Av. Mariano Acosta     y   Fray Vacas Galindo', 5368, 'SI', '05', 'ORQUERA ANDRADE LUIS MIGUEL                                .', '1000982882', '79.57', '2.18', 21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `infotributaria`
--

CREATE TABLE `infotributaria` (
  `ambiente` int(2) NOT NULL,
  `tipoEmision` int(2) NOT NULL,
  `razonSocial` text NOT NULL,
  `nombreComercial` text NOT NULL,
  `ruc` text NOT NULL,
  `claveAcceso` text NOT NULL,
  `codDoc` int(2) NOT NULL,
  `estab` int(3) NOT NULL,
  `ptoEmi` int(3) NOT NULL,
  `secuencial` text NOT NULL,
  `dirMatriz` text NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `infotributaria`
--

INSERT INTO `infotributaria` (`ambiente`, `tipoEmision`, `razonSocial`, `nombreComercial`, `ruc`, `claveAcceso`, `codDoc`, `estab`, `ptoEmi`, `secuencial`, `dirMatriz`, `id`) VALUES
(2, 1, 'CORPORACION FAVORITA C.A.', 'CORPORACION FAVORITA C.A.', '1790016919001', '1311201601179001691900121271060000421730552017815', 1, 127, 106, '000042173', 'AV. GENERAL ENRIQUEZ VIA COTOGCHOA', 39),
(2, 1, 'CORPORACION FAVORITA C.A.', 'CORPORACION FAVORITA C.A.', '1790016919001', '1311201601179001691900121271060000421730552017815', 1, 127, 106, '000042173', 'AV. GENERAL ENRIQUEZ VIA COTOGCHOA', 40);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `detalle`
--
ALTER TABLE `detalle`
  ADD PRIMARY KEY (`ID_Detalle`);

--
-- Indices de la tabla `infoadicional`
--
ALTER TABLE `infoadicional`
  ADD PRIMARY KEY (`ID_InfoAdicional`);

--
-- Indices de la tabla `infofactura`
--
ALTER TABLE `infofactura`
  ADD PRIMARY KEY (`ID_InfoFactura`);

--
-- Indices de la tabla `infotributaria`
--
ALTER TABLE `infotributaria`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `detalle`
--
ALTER TABLE `detalle`
  MODIFY `ID_Detalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=480;
--
-- AUTO_INCREMENT de la tabla `infoadicional`
--
ALTER TABLE `infoadicional`
  MODIFY `ID_InfoAdicional` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT de la tabla `infofactura`
--
ALTER TABLE `infofactura`
  MODIFY `ID_InfoFactura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;
--
-- AUTO_INCREMENT de la tabla `infotributaria`
--
ALTER TABLE `infotributaria`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
