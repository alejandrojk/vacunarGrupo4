-- phpMyAdmin SQL Dump
-- version 5.1.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-06-2021 a las 21:21:05
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

--
-- Volcado de datos para la tabla `citas`
--

INSERT INTO `citas` (`idCitas`, `idPersona`, `idCentro`, `motivo`, `horaTurno`, `fecha`, `estado`) VALUES
(84, 13, 1, 'Primera Dosis', '11:14:50', '2021-06-25', 0),
(86, 13, 1, 'Segunda Dosis', '11:11:00', '2021-06-12', 1),
(87, 14, 2, 'Primera Dosis', '15:23:40', '2021-08-06', 0);

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
(1, 'Villa Mercedes', 'Policlinico vm', 'peron 343'),
(2, 'Villa Mercedes', 'La Pedrera', 'Ruta interfabricas');

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
(2, 'Inglaterra', 'Oxford', 'lelele'),
(4, 'EEUU', 'Moderna', 'Cambridge');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `localidades`
--

CREATE TABLE `localidades` (
  `id` int(11) NOT NULL,
  `localidad` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `localidades`
--

INSERT INTO `localidades` (`id`, `localidad`) VALUES
(1752, 'Alto Pelado'),
(1753, 'Alto Pencoso'),
(1754, 'Anchorena'),
(1755, 'Arizona'),
(1756, 'Bagual'),
(1757, 'Balde'),
(1758, 'Batavia'),
(1759, 'Beazley'),
(1760, 'Buena Esperanza'),
(1761, 'Candelaria'),
(1762, 'Capital'),
(1763, 'Carolina'),
(1764, 'Carpintería'),
(1765, 'Concarán'),
(1766, 'Cortaderas'),
(1767, 'El Morro'),
(1768, 'El Trapiche'),
(1769, 'El Volcán'),
(1770, 'Fortín El Patria'),
(1771, 'Fortuna'),
(1772, 'Fraga'),
(1773, 'Juan Jorba'),
(1774, 'Juan Llerena'),
(1775, 'Juana Koslay'),
(1776, 'Justo Daract'),
(1777, 'La Calera'),
(1778, 'La Florida'),
(1779, 'La Punilla'),
(1780, 'La Toma'),
(1781, 'Lafinur'),
(1782, 'Las Aguadas'),
(1783, 'Las Chacras'),
(1784, 'Las Lagunas'),
(1785, 'Las Vertientes'),
(1786, 'Lavaisse'),
(1787, 'Leandro N. Alem'),
(1788, 'Los Molles'),
(1789, 'Luján'),
(1790, 'Mercedes'),
(1791, 'Merlo'),
(1792, 'Naschel'),
(1793, 'Navia'),
(1794, 'Nogolí'),
(1795, 'Nueva Galia'),
(1796, 'Papagayos'),
(1797, 'Paso Grande'),
(1798, 'Potrero de Los Funes'),
(1799, 'Quines'),
(1800, 'Renca'),
(1801, 'Saladillo'),
(1802, 'San Francisco'),
(1803, 'San Gerónimo'),
(1804, 'San Martín'),
(1805, 'San Pablo'),
(1806, 'Santa Rosa de Conlara'),
(1807, 'Talita'),
(1808, 'Tilisarao'),
(1809, 'Unión'),
(1810, 'Villa de La Quebrada'),
(1811, 'Villa de Praga'),
(1812, 'Villa del Carmen'),
(1813, 'Villa Gral. Roca'),
(1814, 'Villa Larca'),
(1815, 'Villa Mercedes'),
(1816, 'Zanjitas'),
(2383, 'Alto Pelado'),
(2384, 'Alto Pencoso'),
(2385, 'Anchorena'),
(2386, 'Arizona'),
(2387, 'Bagual'),
(2388, 'Balde'),
(2389, 'Batavia'),
(2390, 'Beazley'),
(2391, 'Buena Esperanza'),
(2392, 'Candelaria'),
(2393, 'Capital'),
(2394, 'Carolina'),
(2395, 'Carpintería'),
(2396, 'Concarán'),
(2397, 'Cortaderas'),
(2398, 'El Morro'),
(2399, 'El Trapiche'),
(2400, 'El Volcán'),
(2401, 'Fortín El Patria'),
(2402, 'Fortuna'),
(2403, 'Fraga'),
(2404, 'Juan Jorba'),
(2405, 'Juan Llerena'),
(2406, 'Juana Koslay'),
(2407, 'Justo Daract'),
(2408, 'La Calera'),
(2409, 'La Florida'),
(2410, 'La Punilla'),
(2411, 'La Toma'),
(2412, 'Lafinur'),
(2413, 'Las Aguadas'),
(2414, 'Las Chacras'),
(2415, 'Las Lagunas'),
(2416, 'Las Vertientes'),
(2417, 'Lavaisse'),
(2418, 'Leandro N. Alem'),
(2419, 'Los Molles'),
(2420, 'Luján'),
(2421, 'Mercedes'),
(2422, 'Merlo'),
(2423, 'Naschel'),
(2424, 'Navia'),
(2425, 'Nogolí'),
(2426, 'Nueva Galia'),
(2427, 'Papagayos'),
(2428, 'Paso Grande'),
(2429, 'Potrero de Los Funes'),
(2430, 'Quines'),
(2431, 'Renca'),
(2432, 'Saladillo'),
(2433, 'San Francisco'),
(2434, 'San Gerónimo'),
(2435, 'San Martín'),
(2436, 'San Pablo'),
(2437, 'Santa Rosa de Conlara'),
(2438, 'Talita'),
(2439, 'Tilisarao'),
(2440, 'Unión'),
(2441, 'Villa de La Quebrada'),
(2442, 'Villa de Praga'),
(2443, 'Villa del Carmen'),
(2444, 'Villa Gral. Roca'),
(2445, 'Villa Larca'),
(2446, 'Villa Mercedes'),
(2447, 'Zanjitas');

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
  `fechaNacimiento` date DEFAULT NULL,
  `direccion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`idPersona`, `idPatologia`, `nombre`, `apellido`, `peso`, `altura`, `email`, `celular`, `localidad`, `ambitoLaboral`, `dni`, `fechaNacimiento`, `direccion`) VALUES
(11, 1, 'Mayra', 'Ramos', 60, 165, 'lopez@hotmail.com', 26631592, 'La Toma', 'Salud', 34104821, '1978-03-16', 'Mitre 2360'),
(12, 1, 'Florencia', 'Monti', 55.4, 166, 'vjjask@hotmail.com', 233425, 'Merlo', 'Industria', 42234534, '1986-05-15', 'Guayaquil 160'),
(13, 1, 'Carlos', 'Gutierrez', 87.7, 175, 'afasafs', 12415, 'Villa Mercedes', 'Fabrica', 64623, '1977-04-13', 'gwgwegwg'),
(14, 3, 'Eusebia', 'Aguilera', 90, 159, 'gvgg', 35131, 'Quines', 'Jubilada', 1124515, '1951-06-18', 'aaffwawf'),
(21, 1, 'Mariana', 'Lopez', 51, 158, 'mariana@hotmail.com', 465849, 'Zanjitas', 'salud', 45115848, '2001-05-13', 'Pringles 1148');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `registrovacunados`
--

CREATE TABLE `registrovacunados` (
  `idRegistrados` int(11) NOT NULL,
  `vacuna` int(11) NOT NULL,
  `idCita` int(11) NOT NULL,
  `dosis` varchar(40) NOT NULL,
  `fechaAplicacion` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `registrovacunados`
--

INSERT INTO `registrovacunados` (`idRegistrados`, `vacuna`, `idCita`, `dosis`, `fechaAplicacion`) VALUES
(22, 8490001, 84, 'Primera Dosis', '2021-06-25'),
(23, 440005460, 87, 'Primera Dosis', '2021-08-06');

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
(130, 1, 8490001, 0),
(131, 1, 8490002, 1),
(132, 1, 8490003, 1),
(133, 1, 8490004, 1),
(134, 1, 8490005, 1),
(135, 1, 8490006, 0),
(136, 1, 8490007, 1),
(137, 1, 8490008, 1),
(138, 1, 8490009, 1),
(139, 1, 8490010, 1),
(144, 4, 440005460, 0),
(145, 4, 440005461, 1),
(146, 4, 440005462, 1),
(147, 4, 440005463, 1),
(148, 4, 440005464, 1),
(149, 4, 440005465, 1),
(150, 4, 440005466, 1),
(151, 4, 440005467, 1),
(152, 4, 440005468, 1),
(153, 4, 440005469, 1);

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
-- Indices de la tabla `localidades`
--
ALTER TABLE `localidades`
  ADD PRIMARY KEY (`id`);

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
  ADD UNIQUE KEY `dni` (`dni`),
  ADD KEY `persona_ibfk_1` (`idPatologia`);

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
  MODIFY `idCitas` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=92;

--
-- AUTO_INCREMENT de la tabla `ctrovacunacion`
--
ALTER TABLE `ctrovacunacion`
  MODIFY `idCtroVacunacion` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT de la tabla `laboratorio`
--
ALTER TABLE `laboratorio`
  MODIFY `idLaboratorio` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `localidades`
--
ALTER TABLE `localidades`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2448;

--
-- AUTO_INCREMENT de la tabla `patologias`
--
ALTER TABLE `patologias`
  MODIFY `idPatologia` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `persona`
--
ALTER TABLE `persona`
  MODIFY `idPersona` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT de la tabla `registrovacunados`
--
ALTER TABLE `registrovacunados`
  MODIFY `idRegistrados` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT de la tabla `vacuna`
--
ALTER TABLE `vacuna`
  MODIFY `idVacuna` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=184;

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
