-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-02-2017 a las 22:24:47
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `facturacioninterfaces`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--
create database facturacioninterfaces;
use facturacioninterfaces;

CREATE TABLE `articulo` (
  `id_articulo` int(11) NOT NULL,
  `descripcion` varchar(30) NOT NULL,
  `precio_venta` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `cod_tipo_articulo` int(11) NOT NULL,
  `cod_proveedor` varchar(20) NOT NULL,
  `fecha_ingreso` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `articulo`
--

INSERT INTO `articulo` (`id_articulo`, `descripcion`, `precio_venta`, `stock`, `cod_tipo_articulo`, `cod_proveedor`, `fecha_ingreso`) VALUES
(1, 'Bota Larga', 100000, 20, 19, '00003-A', '2012-11-03'),
(2, 'Bota corta', 70000, 55, 19, '00003-A', '2012-10-11'),
(3, 'Botin ', 150000, 18, 19, '00003-A', '2012-09-01'),
(4, 'Tenis ', 120000, 5, 20, '00002-2', '2012-10-02'),
(5, 'Zandalias', 50000, 59, 21, '00001-1', '2012-11-01'),
(7, 'Camisas', 50000, 12, 22, '00003-A', '2012-10-20'),
(9, 'Chaquetas sudadera', 60000, 20, 23, '00002-2', '2012-10-23'),
(10, 'Pantalon sudadera', 60000, 17, 23, '00002-2', '2012-10-23'),
(11, 'Sudadera completa', 100000, 20, 23, '00002-2', '2012-10-23');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

CREATE TABLE `ciudad` (
  `Codigo_ciudad` int(11) NOT NULL,
  `Nombre_ciudad` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `ciudad`
--

INSERT INTO `ciudad` (`Codigo_ciudad`, `Nombre_ciudad`) VALUES
(1, 'QUITO'),
(2, 'GUAYAQUIL'),
(3, 'CUENCA'),
(4, 'LOJA'),
(5, 'AMBATO'),
(6, 'RIOBAMBA'),
(7, 'CAYAMBE'),
(8, 'MANTA'),
(9, 'IBARRA'),
(10, 'LATACUNGA'),
(11, 'TULCAN'),
(12, 'OTAVALO'),
(13, 'ATUNTAQUI'),
(14, 'SAN GABRIEL'),
(15, 'PUERTO QUITO'),
(16, 'ZARUMA'),
(17, 'PORTOVIEJO'),
(18, 'LOS BANCOS'),
(19, 'ESMERALDAS'),
(20, 'OLMEDO');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `Documento` varchar(15) NOT NULL,
  `cod_tipo_documento` int(11) NOT NULL,
  `Nombres` varchar(30) NOT NULL,
  `Apellidos` varchar(30) NOT NULL,
  `Direccion` varchar(20) DEFAULT NULL,
  `cod_ciudad` int(11) NOT NULL,
  `Telefono` varchar(20) DEFAULT NULL,
  `Contrasenia` varchar(20) DEFAULT NULL,
  `Administrador` tinyint(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`Documento`, `cod_tipo_documento`, `Nombres`, `Apellidos`, `Direccion`, `cod_ciudad`, `Telefono`, `Contrasenia`, `Administrador`) VALUES
('0001', 1, 'Camilo', 'Lopez', 'Calle 23 N 12-43', 2, '8239578', '', 0),
('0002', 2, 'Maria', 'Arango', 'Carrera 5 N 23-12', 1, '8253478', '', 0),
('0003', 1, 'Andres', 'Florez', 'Carrera 23 N 12A 34', 4, '3127654323', '', 0),
('0004', 1, 'Carlos', 'Marin', 'Calle 3 N 98_21', 10, '8345623', '', 0),
('0005', 1, 'Elvira', 'Orozco', 'Centro', 15, '3219843543', '', 0),
('0006', 1, 'Kevin', 'Ayala', 'Carrera 23 N 4B 23', 1, '8354624', '', 0),
('0008', 2, 'Marcela', 'Gomez', 'Centro', 6, NULL, '', 0),
('0009', 1, 'Andres', 'Orozco', 'Calle 34 N 89 00', 1, '8219876', '', 0),
('0010', 1, 'Marlon', 'Diaz', 'Carrera 23 N 78-00', 9, '3219870987', '', 0),
('0011', 1, 'Daniela', 'Ceron', 'Centro', 1, '8236543', '', 0),
('0012', 2, 'Camilo', 'Orozco', 'Calle 21 N 23-98', 10, '3119874534', '', 0),
('0013', 1, 'Daniela', 'Ramos', 'Centro', 2, '3217653400', '', 0),
('0014', 2, 'Camilo', 'Samboni', 'Carrera 23 N45A 12', 6, '8204587', '', 0),
('0015', 1, 'Alexander', 'Romero', 'Calle 34 N 23 B 12', 2, '8340976', '', 0),
('0016', 1, 'Sebastian', 'Naranjo', 'Carrera 23 N 2 A 1', 1, '8320912', '', 0),
('0017', 2, 'Sandra', 'Castillo', 'Centro', 3, '3218769988', '', 0),
('0018', 1, 'Nicolas', 'Ospina', 'Calle 23- N 76', 1, '8230954', '', 0),
('0019', 1, 'Santiago', 'Sanchez', 'Carrera 23 N 12-23', 1, '8236521', '', 0),
('0020', 1, 'Aleja', 'Dorado', 'Calle 34 N 23 B 4', 2, '8453234', '', 0),
('0021', 2, 'andrea', 'Ruiz', 'Centro', 1, '3238765456', '', 0),
('0022', 1, 'Andres', 'Perdomo', 'Centro', 3, '8456342', '', 0),
('0023', 1, 'Dolly', 'Joaqui', 'Calle 3 N 34-12', 1, '8230943', '', 0),
('0024', 2, 'Kevin', 'Rivera', 'Centro', 1, '8342309', '', 0),
('0025', 1, 'Camila', 'Maya', 'Carrera 23 n 65-4', 1, '3150987866', '', 0),
('0026', 1, 'Camilo', 'Coral', 'Centro', 1, NULL, '', 0),
('0027', 2, 'Carlos', 'Paz', 'Centro', 1, NULL, '', 0),
('0028', 1, 'Cristian', 'Paz', 'Calle 34 N b34', 1, '3219870045', '', 0),
('0029', 1, 'Daniela', 'Solarte', 'Centro', 1, '8345623', '', 0),
('0030', 1, 'Diana', 'Aponte', 'Centro', 15, '8234522', '', 0),
('0400779286', 1, 'Aída ', 'Cárdenas', 'Ulloa y Selva ALegre', 1, '2904187', '', 0),
('0400779287', 1, 'Randy', 'Granda', 'Ulloa', 1, '2904187', 'lala123_', 0),
('1000982882', 1, 'Luis', 'Orquera', 'Isla Marchena', 1, '2438011', 'Miguel-1', 0),
('1032', 2, 'andres', 'juan', 'calle 34-23', 2, '326589', '', 0),
('12', 1, 'kerly andrea', 'samboni bolaños', 'los cimuneros', 1, '3113882177', '', 0),
('120', 1, 'andres', 'sanchez', 'carere 12-45', 2, '8202565', '', 0),
('123', 2, 'carlos', 'andres', 'calle 23.5', 2, '235645', '', 0),
('125', 2, 'andres', 'sanchez', 'calle 23', 2, '12545', '', 0),
('1707392252', 1, 'Randy ', 'Granda', 'Ulloa', 1, '2904187', 'lala123', 0),
('1717216616', 1, 'Jaime Gustavo', 'Yerovi Usiña', 'san carlos', 1, '2535917', 'Jaime-123', 0),
('1718927716', 1, 'Aída Alexandra', 'Granda Cárdenas', 'Ulloa y Selva Alegre', 1, '0999601084', 'Lala123', 0),
('1725453102', 1, 'Daniel Alexander', 'Beltran', 'La forestal', 1, '0981097376', 'david', 1),
('1720524204', 1, 'Daniel Alexander', 'Beltran Venegas', 'La Forestal', 1, '0995076835', '1234', 1),
('4115', 2, 'hhhhhhhh', 'hhhhhhhhhh', 'hhhhhhhhhhh', 1, 'hhhhhhhhh', '', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalle_factura`
--

CREATE TABLE `detalle_factura` (
  `cod_factura` varchar(20) NOT NULL,
  `cod_articulo` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `total` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `detalle_factura`
--

INSERT INTO `detalle_factura` (`cod_factura`, `cod_articulo`, `cantidad`, `total`) VALUES
('FACT-9910966', 3, 1, '150000'),
('FACT-9910966', 4, 2, '240000'),
('FACT-9910966', 5, 1, '47500'),
('FACT-998769', 4, 3, '360000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `devolucion`
--

CREATE TABLE `devolucion` (
  `cod_detallefactura` varchar(20) NOT NULL,
  `cod_detallearticulo` int(11) NOT NULL,
  `Motivo` varchar(15) NOT NULL,
  `Fecha_devolucion` varchar(10) NOT NULL,
  `cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `devolucion`
--

INSERT INTO `devolucion` (`cod_detallefactura`, `cod_detallearticulo`, `Motivo`, `Fecha_devolucion`, `cantidad`) VALUES
('FACT-9910966', 3, 'pequeño', '22/1/2013', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `Nnm_factura` varchar(20) NOT NULL,
  `cod_cliente` varchar(15) NOT NULL,
  `Nombre_empleado` varchar(30) NOT NULL,
  `Fecha_facturacion` date NOT NULL,
  `cod_formapago` int(11) NOT NULL,
  `total_factura` decimal(10,0) DEFAULT NULL,
  `IVA` decimal(10,0) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`Nnm_factura`, `cod_cliente`, `Nombre_empleado`, `Fecha_facturacion`, `cod_formapago`, `total_factura`, `IVA`) VALUES
('11111111111111111', '0001', 'david', '2017-02-13', 1, '200', '90'),
('33-33-333333333', '1725453102', 'Estilos', '2017-02-13', 1, '160', '23'),
('44-44-444444444', '1725453102', 'Sports', '2017-02-13', 1, '108', '23'),
('FACT-6676810', '1718927716', 'Estilos', '2016-01-01', 1, NULL, NULL),
('FACT-679688', '1718927716', 'Estilos', '2016-01-01', 1, '0', '0'),
('FACT-69910910', '1718927716', 'Fashion', '2016-01-01', 1, NULL, NULL),
('FACT-986889', '1718927716', 'Estilos', '2016-01-01', 3, NULL, NULL),
('FACT-9910966', '125', 'jose', '2016-01-01', 1, '437500', '70000'),
('FACT-998769', '1718927716', 'Estilos', '2016-01-01', 1, '360000', '57600');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `facturapersonal`
--

CREATE TABLE `facturapersonal` (
  `Nnm_factura` varchar(20) NOT NULL,
  `cod_cliente` varchar(15) NOT NULL,
  `Nombre_empleado` varchar(30) NOT NULL,
  `Fecha_facturacion` date NOT NULL,
  `cod_formapago` int(11) NOT NULL,
  `total_factura` double NOT NULL,
  `IVA` double NOT NULL,
  `alimentacion` double NOT NULL DEFAULT '0',
  `salud` double NOT NULL DEFAULT '0',
  `educacion` double NOT NULL DEFAULT '0',
  `vestimenta` double NOT NULL DEFAULT '0',
  `vivienda` double NOT NULL DEFAULT '0',
  `otros` double NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `facturapersonal`
--

INSERT INTO `facturapersonal` (`Nnm_factura`, `cod_cliente`, `Nombre_empleado`, `Fecha_facturacion`, `cod_formapago`, `total_factura`, `IVA`, `alimentacion`, `salud`, `educacion`, `vestimenta`, `vivienda`, `otros`) VALUES
('11-11-111111111', '1725453102', 'Bellas', '2017-02-13', 1, 127, 45, 49, 0, 26, 26, 26, 0),
('44-44-444444444', '1725453102', 'Fashion', '2017-03-14', 1, 272, 56, 34, 34, 0, 34, 170, 0),
('33-33-333333333', '1725453102', 'jeans&&jeans', '2017-09-14', 1, 136, 35, 34, 68, 0, 34, 0, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `forma_de_pago`
--

CREATE TABLE `forma_de_pago` (
  `id_formapago` int(11) NOT NULL,
  `Descripcion_formapago` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `forma_de_pago`
--

INSERT INTO `forma_de_pago` (`id_formapago`, `Descripcion_formapago`) VALUES
(1, 'EFECTIVO'),
(2, 'BONO'),
(3, 'TARJETA DE CREDITO'),
(4, 'CHEQUE');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gasto_negocio`
--

CREATE TABLE `gasto_negocio` (
  `id_gasto_negocio` int(11) NOT NULL,
  `codigo_cliente` varchar(15) NOT NULL,
  `tipo_gasto` int(11) NOT NULL,
  `cantidad` decimal(10,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `gasto_negocio`
--

INSERT INTO `gasto_negocio` (`id_gasto_negocio`, `codigo_cliente`, `tipo_gasto`, `cantidad`) VALUES
(1, '1725453102', 1, '5.050'),
(2, '1718927716', 1, '8.650');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gasto_personal`
--

CREATE TABLE `gasto_personal` (
  `id_gasto` int(11) NOT NULL,
  `codigo_cliente` varchar(15) NOT NULL,
  `anio` int(11) NOT NULL,
  `alimentacion` decimal(10,3) NOT NULL,
  `vestimenta` decimal(10,3) NOT NULL,
  `salud` decimal(10,3) NOT NULL,
  `educacion` decimal(10,3) NOT NULL,
  `vivienda` decimal(10,3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `gasto_personal`
--

INSERT INTO `gasto_personal` (`id_gasto`, `codigo_cliente`, `anio`, `alimentacion`, `vestimenta`, `salud`, `educacion`, `vivienda`) VALUES
(1, '1718927716', 2016, '0.000', '0.000', '0.000', '0.000', '0.000'),
(2, '1725453102', 2017, '1219.000', '529.000', '493.000', '1062.000', '516.000');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `No_documento` varchar(20) NOT NULL,
  `cod_tipo_documento` int(11) NOT NULL,
  `Nombre` varchar(20) NOT NULL,
  `Apellido` varchar(20) NOT NULL,
  `Nombre_comercial` varchar(20) NOT NULL,
  `direccion` varchar(20) DEFAULT NULL,
  `cod_ciudad` int(11) NOT NULL,
  `Telefono` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`No_documento`, `cod_tipo_documento`, `Nombre`, `Apellido`, `Nombre_comercial`, `direccion`, `cod_ciudad`, `Telefono`) VALUES
('00001-1', 4, 'Carlos', 'Maya', 'Estilos', 'Calle 12-12', 1, NULL),
('00002-2', 4, 'Marino', 'Burbano', 'Sports', 'Centro', 2, NULL),
('00003-A', 7, 'Paola', 'Sanchez', 'Fashion', 'Veraneras', 3, NULL),
('00004-4', 4, 'Camilo', 'Muñoz', 'Jeans&Jackets', 'Centro', 2, NULL),
('00005-F', 7, 'Marlon', 'Brandom', 'Bellas', 'Calle 34 B 12', 1, NULL),
('00006-6', 1, 'Carlos', 'sanchez diaz', 'jeans&&jeans', 'calle 45 N 23-23', 1, '8213423');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_articulo`
--

CREATE TABLE `tipo_articulo` (
  `id_tipoarticulo` int(11) NOT NULL,
  `descripcion_articulo` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_articulo`
--

INSERT INTO `tipo_articulo` (`id_tipoarticulo`, `descripcion_articulo`) VALUES
(19, 'alimentacion'),
(20, 'vestimenta'),
(21, 'salud'),
(22, 'educacion'),
(23, 'vivienda');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_de_documento`
--

CREATE TABLE `tipo_de_documento` (
  `id_tipo_documento` int(11) NOT NULL,
  `Descripcion` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_de_documento`
--

INSERT INTO `tipo_de_documento` (`id_tipo_documento`, `Descripcion`) VALUES
(1, 'CC'),
(2, 'TI'),
(3, 'RC'),
(4, 'NIT'),
(5, 'PASAPORTE'),
(6, 'CE'),
(7, 'RUT');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_gasto_negocio`
--

CREATE TABLE `tipo_gasto_negocio` (
  `id_tipo_gasto_negocio` int(11) NOT NULL,
  `descripcion_tipo_gasto_negocio` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_gasto_negocio`
--

INSERT INTO `tipo_gasto_negocio` (`id_tipo_gasto_negocio`, `descripcion_tipo_gasto_negocio`) VALUES
(1, 'Sueldo'),
(2, 'Viaticos');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_gasto_personal`
--

CREATE TABLE `tipo_gasto_personal` (
  `id_tipo_gasto` int(11) NOT NULL,
  `tipo_gasto` varchar(50) NOT NULL,
  `limite_gasto` decimal(10,3) NOT NULL,
  `Anio` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `tipo_gasto_personal`
--

INSERT INTO `tipo_gasto_personal` (`id_tipo_gasto`, `tipo_gasto`, `limite_gasto`, `Anio`) VALUES
(1, 'Alimentación', '3630.000', 2017),
(2, 'Vestimenta', '3630.000', 2017),
(3, 'Salud', '14521.000', 2017),
(4, 'Educacion', '3800.250', 2017),
(5, 'vivienda', '1300.000', 2017);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD PRIMARY KEY (`id_articulo`),
  ADD KEY `ref_tipo_articulo_idx` (`cod_tipo_articulo`),
  ADD KEY `ref_prov_art_idx` (`cod_proveedor`);

--
-- Indices de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  ADD PRIMARY KEY (`Codigo_ciudad`);

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`Documento`),
  ADD KEY `cod_tipodocumento_idx` (`cod_tipo_documento`),
  ADD KEY `ref_ciudad_idx` (`cod_ciudad`);

--
-- Indices de la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  ADD PRIMARY KEY (`cod_factura`,`cod_articulo`),
  ADD KEY `ref_facturacion_idx` (`cod_factura`),
  ADD KEY `ref_ar_fact_idx` (`cod_articulo`);

--
-- Indices de la tabla `devolucion`
--
ALTER TABLE `devolucion`
  ADD PRIMARY KEY (`cod_detallefactura`,`cod_detallearticulo`),
  ADD KEY `ref_detallefactu_idx` (`cod_detallefactura`),
  ADD KEY `ref_deta_art_idx` (`cod_detallearticulo`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`Nnm_factura`),
  ADD KEY `ref_cli_idx` (`cod_cliente`),
  ADD KEY `ref_formapago_idx` (`cod_formapago`);

--
-- Indices de la tabla `forma_de_pago`
--
ALTER TABLE `forma_de_pago`
  ADD PRIMARY KEY (`id_formapago`);

--
-- Indices de la tabla `gasto_negocio`
--
ALTER TABLE `gasto_negocio`
  ADD PRIMARY KEY (`id_gasto_negocio`);

--
-- Indices de la tabla `gasto_personal`
--
ALTER TABLE `gasto_personal`
  ADD PRIMARY KEY (`id_gasto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`No_documento`),
  ADD KEY `ref_prov_ciudad_idx` (`cod_ciudad`),
  ADD KEY `proveedor_ibfk_1` (`cod_tipo_documento`);

--
-- Indices de la tabla `tipo_articulo`
--
ALTER TABLE `tipo_articulo`
  ADD PRIMARY KEY (`id_tipoarticulo`);

--
-- Indices de la tabla `tipo_de_documento`
--
ALTER TABLE `tipo_de_documento`
  ADD PRIMARY KEY (`id_tipo_documento`);

--
-- Indices de la tabla `tipo_gasto_negocio`
--
ALTER TABLE `tipo_gasto_negocio`
  ADD PRIMARY KEY (`id_tipo_gasto_negocio`);

--
-- Indices de la tabla `tipo_gasto_personal`
--
ALTER TABLE `tipo_gasto_personal`
  ADD PRIMARY KEY (`id_tipo_gasto`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `articulo`
--
ALTER TABLE `articulo`
  MODIFY `id_articulo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT de la tabla `ciudad`
--
ALTER TABLE `ciudad`
  MODIFY `Codigo_ciudad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
--
-- AUTO_INCREMENT de la tabla `forma_de_pago`
--
ALTER TABLE `forma_de_pago`
  MODIFY `id_formapago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT de la tabla `gasto_negocio`
--
ALTER TABLE `gasto_negocio`
  MODIFY `id_gasto_negocio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `gasto_personal`
--
ALTER TABLE `gasto_personal`
  MODIFY `id_gasto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `tipo_articulo`
--
ALTER TABLE `tipo_articulo`
  MODIFY `id_tipoarticulo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT de la tabla `tipo_de_documento`
--
ALTER TABLE `tipo_de_documento`
  MODIFY `id_tipo_documento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT de la tabla `tipo_gasto_negocio`
--
ALTER TABLE `tipo_gasto_negocio`
  MODIFY `id_tipo_gasto_negocio` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `tipo_gasto_personal`
--
ALTER TABLE `tipo_gasto_personal`
  MODIFY `id_tipo_gasto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `articulo`
--
ALTER TABLE `articulo`
  ADD CONSTRAINT `ref_prov_art` FOREIGN KEY (`cod_proveedor`) REFERENCES `proveedor` (`No_documento`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ref_tipo_articulo` FOREIGN KEY (`cod_tipo_articulo`) REFERENCES `tipo_articulo` (`id_tipoarticulo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `ref_ciudad` FOREIGN KEY (`cod_ciudad`) REFERENCES `ciudad` (`Codigo_ciudad`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ref_tipo_doc` FOREIGN KEY (`cod_tipo_documento`) REFERENCES `tipo_de_documento` (`id_tipo_documento`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `detalle_factura`
--
ALTER TABLE `detalle_factura`
  ADD CONSTRAINT `ref_ar_fact` FOREIGN KEY (`cod_articulo`) REFERENCES `articulo` (`id_articulo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ref_facturacion` FOREIGN KEY (`cod_factura`) REFERENCES `factura` (`Nnm_factura`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `devolucion`
--
ALTER TABLE `devolucion`
  ADD CONSTRAINT `ref_deta_art` FOREIGN KEY (`cod_detallearticulo`) REFERENCES `detalle_factura` (`cod_articulo`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ref_detallefactu` FOREIGN KEY (`cod_detallefactura`) REFERENCES `detalle_factura` (`cod_factura`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `ref_cli` FOREIGN KEY (`cod_cliente`) REFERENCES `cliente` (`Documento`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ref_formapago` FOREIGN KEY (`cod_formapago`) REFERENCES `forma_de_pago` (`id_formapago`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD CONSTRAINT `proveedor_ibfk_1` FOREIGN KEY (`cod_tipo_documento`) REFERENCES `tipo_de_documento` (`id_tipo_documento`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ref_prov_ciudad` FOREIGN KEY (`cod_ciudad`) REFERENCES `ciudad` (`Codigo_ciudad`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
