-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-05-2021 a las 03:22:05
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
  `idCentro` int(11) NOT NULL,
  `motivo` varchar(50) NOT NULL,
  `horaTurno` time NOT NULL,
  `fecha` date NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`idCitas`, `idPersona`, `idCentro`, `motivo`, `horaTurno`, `fecha`, `estado`) VALUES
(1, 2, 1, 'Primera dosis', '10:40:00', '2021-05-29', 1),
(2, 4, 1, 'Primera dosis', '18:25:00', '2021-05-03', 1),
(3, 2, 1, 'Segunda dosis', '12:00:00', '2021-05-11', 1),
(4, 4, 1, 'segunda dosis', '11:00:00', '2021-04-16', 1);

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
(1, 'Obesidad'),
(2, 'Diabetes'),
(3, 'Hipertension'),
(4, 'Ninguna');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `idPersona` int(10) NOT NULL,
  `idPatologia` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `apellido` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `celular` int(10) NOT NULL,
  `localidad` varchar(30) NOT NULL,
  `ambitoLaboral` varchar(30) NOT NULL,
  `dni` int(10) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `direccion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `idPatologia`, `nombre`, `apellido`, `email`, `celular`, `localidad`, `ambitoLaboral`, `dni`, `fechaNacimiento`, `direccion`) VALUES
(2, 2, 'Maxi', 'Rodriguez', 'aaacnon', 265731872, 'Villa Mercedes', 'Salud', 34104821, '2012-05-11', 'ajaaoifjio'),
(4, 4, 'Alejandro', 'Flores', 'wewe', 23423, 'san luis', 'nose', 334245, '2011-05-11', 'rgtrttgr');

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

--
-- Volcado de datos para la tabla `registrovacunados`
--

INSERT INTO `registrovacunados` (`idRegistrados`, `vacuna`, `idCita`, `fechaAplicacion`) VALUES
(2, 3, 1, '2021-05-28'),
(4, 4, 2, '2021-05-25');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vacuna`
--

CREATE TABLE `vacuna` (
  `idVacuna` int(10) NOT NULL,
  `idLaboratorio` int(11) NOT NULL,
  `nroSerie` int(10) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `vacuna`
--

INSERT INTO `vacuna` (`idVacuna`, `idLaboratorio`, `nroSerie`, `estado`) VALUES
(3, 1, 120, 1),
(4, 1, 121, 1),
(6, 2, 124, 1),
(7, 2, 125, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `citas`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`idCitas`);

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
  ADD UNIQUE KEY `vacuna` (`vacuna`),
  ADD UNIQUE KEY `idCita` (`idCita`);

--
-- Indices de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD PRIMARY KEY (`idVacuna`),
  ADD UNIQUE KEY `nroSerie` (`nroSerie`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `citas`
--
ALTER TABLE `citas`
  MODIFY `idCitas` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

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
  MODIFY `idPatologia` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `registrovacunados`
--
ALTER TABLE `registrovacunados`
  MODIFY `idRegistrados` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  MODIFY `idVacuna` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `citas`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`idCentro`) REFERENCES `ctrovacunacion` (`idCtroVacunacion`),
  ADD CONSTRAINT `citas_ibfk_3` FOREIGN KEY (`idPersona`) REFERENCES `persona` (`idPersona`);

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`idPatologia`) REFERENCES `patologias` (`idPatologia`);

--
-- Filtros para la tabla `registrovacunados`
--
ALTER TABLE `registrovacunados`
  ADD CONSTRAINT `registrovacunados_ibfk_1` FOREIGN KEY (`vacuna`) REFERENCES `vacuna` (`idVacuna`),
  ADD CONSTRAINT `registrovacunados_ibfk_2` FOREIGN KEY (`idCita`) REFERENCES `citas` (`idCitas`);

--
-- Filtros para la tabla `vacuna`
--
ALTER TABLE `vacuna`
  ADD CONSTRAINT `vacuna_ibfk_1` FOREIGN KEY (`idLaboratorio`) REFERENCES `laboratorio` (`idLaboratorio`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
