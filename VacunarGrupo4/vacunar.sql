-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-06-2021 a las 04:01:33
-- Versión del servidor: 10.4.18-MariaDB
-- Versión de PHP: 8.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vacunar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `citas`
--

CREATE TABLE `citas` (
  `idCitas` int(10) NOT NULL,
  `idPersona` int(11) NOT NULL,
  `idCentro` int(11) NOT NULL DEFAULT 1,
  `motivo` varchar(50) NOT NULL,
  `horaTurno` time NOT NULL,
  `fecha` date NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ctrovacunacion`
--

CREATE TABLE `ctrovacunacion` (
  `idCtroVacunacion` int(10) NOT NULL,
  `localidad` varchar(30) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `direccion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `ctrovacunacion`
--

INSERT INTO `ctrovacunacion` (`idCtroVacunacion`, `localidad`, `nombre`, `direccion`) VALUES
(1, 'Villa Mercedes', 'Policlinico vm', 'peron 343');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `laboratorio`
--

CREATE TABLE `laboratorio` (
  `idLaboratorio` int(10) NOT NULL,
  `paisOrigen` varchar(30) NOT NULL,
  `nombreComercial` varchar(30) NOT NULL,
  `direccion` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `laboratorio`
--

INSERT INTO `laboratorio` (`idLaboratorio`, `paisOrigen`, `nombreComercial`, `direccion`) VALUES
(1, 'Alemania', 'Pfizer', 'lalala'),
(2, 'Inglaterra', 'Oxford', 'lelele');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patologias`
--

CREATE TABLE `patologias` (
  `idPatologia` int(10) NOT NULL,
  `nombre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `patologias`
--

INSERT INTO `patologias` (`idPatologia`, `nombre`) VALUES
(1, 'Ninguna'),
(2, 'Obesidad'),
(3, 'Hipertension'),
(4, 'Diabetes'),
(5, 'Respiratoria'),
(6, 'Cardiaca');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idPersona` int(10) NOT NULL,
  `idPatologia` int(11) DEFAULT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `peso` double DEFAULT NULL,
  `altura` int(11) DEFAULT NULL,
  `email` varchar(30) NOT NULL,
  `celular` int(10) NOT NULL,
  `localidad` varchar(30) NOT NULL,
  `ambitoLaboral` varchar(30) DEFAULT NULL,
  `dni` int(10) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `direccion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `idPatologia`, `nombre`, `apellido`, `peso`, `altura`, `email`, `celular`, `localidad`, `ambitoLaboral`, `dni`, `fechaNacimiento`, `direccion`) VALUES
(11, 1, 'Mayra', 'Ramos', NULL, NULL, 'lopez@hotmail.com', 26631592, 'La Toma', 'Salud', 34104821, '1978-03-16', 'Mitre 2360'),
(12, 1, 'Florencia', 'Monti', 55.4, 166, 'vjjask@hotmail.com', 233425, 'Merlo', 'Industria', 42234534, '1986-05-15', 'Guayaquil 160'),
(13, 1, 'Carlos', 'Gutierrez', 87.7, 175, 'afasafs', 12415, 'Villa Mercedes', 'Fabrica', 64623, '1977-04-13', 'gwgwegwg'),
(14, 3, 'Eusebia', 'Aguilera', 90, 159, 'gvgg', 35131, 'Quines', 'Jubilada', 1124515, '1951-06-18', 'aaffwawf');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrovacunados`
--

CREATE TABLE `registrovacunados` (
  `idRegistrados` int(11) NOT NULL,
  `vacuna` int(11) NOT NULL,
  `idCita` int(11) NOT NULL,
  `fechaAplicacion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

CREATE TABLE `vacuna` (
  `idVacuna` int(10) NOT NULL,
  `laboratorio` int(11) NOT NULL,
  `nroSerie` int(10) NOT NULL,
  `estado` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vacuna`
--

INSERT INTO `vacuna` (`idVacuna`, `laboratorio`, `nroSerie`, `estado`) VALUES
(129, 1, 8490000, 1),
(130, 1, 8490001, 1),
(131, 1, 8490002, 1),
(132, 1, 8490003, 1),
(133, 1, 8490004, 1),
(134, 1, 8490005, 1),
(135, 1, 8490006, 0),
(136, 1, 8490007, 1),
(137, 1, 8490008, 1),
(138, 1, 8490009, 1),
(139, 1, 8490010, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`idCitas`),
  ADD KEY `idCentro` (`idCentro`),
  ADD KEY `idPersona` (`idPersona`);

--
-- Indices de la tabla `ctrovacunacion`
--
ALTER TABLE `ctrovacunacion`
  ADD PRIMARY KEY (`idCtroVacunacion`);

--
-- Indices de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  ADD PRIMARY KEY (`idLaboratorio`);

--
-- Indices de la tabla `patologias`
--
ALTER TABLE `patologias`
  ADD PRIMARY KEY (`idPatologia`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idPersona`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `registrovacunados`
--
ALTER TABLE `registrovacunados`
  ADD PRIMARY KEY (`idRegistrados`),
  ADD UNIQUE KEY `idCita` (`idCita`),
  ADD UNIQUE KEY `vacuna` (`vacuna`);

--
-- Indices de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD PRIMARY KEY (`idVacuna`),
  ADD UNIQUE KEY `nroSerie` (`nroSerie`),
  ADD KEY `laboratorio` (`laboratorio`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `idCitas` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=84;

--
-- AUTO_INCREMENT de la tabla `ctrovacunacion`
--
ALTER TABLE `ctrovacunacion`
  MODIFY `idCtroVacunacion` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  MODIFY `idLaboratorio` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `patologias`
--
ALTER TABLE `patologias`
  MODIFY `idPatologia` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `registrovacunados`
--
ALTER TABLE `registrovacunados`
  MODIFY `idRegistrados` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  MODIFY `idVacuna` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=144;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`idCentro`) REFERENCES `ctrovacunacion` (`idCtroVacunacion`),
  ADD CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`idPatologia`) REFERENCES `patologias` (`idPatologia`);

--
-- Filtros para la tabla `registrovacunados`
--
ALTER TABLE `registrovacunados`
  ADD CONSTRAINT `registrovacunados_ibfk_1` FOREIGN KEY (`vacuna`) REFERENCES `vacuna` (`nroSerie`),
  ADD CONSTRAINT `registrovacunados_ibfk_2` FOREIGN KEY (`idCita`) REFERENCES `citas` (`idCitas`);

--
-- Filtros para la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD CONSTRAINT `vacuna_ibfk_1` FOREIGN KEY (`laboratorio`) REFERENCES `laboratorio` (`idLaboratorio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
