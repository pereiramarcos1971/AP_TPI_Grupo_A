DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `tecnico_con_mas_incidentes_resueltos_en_n_dias`(dias int)
BEGIN
SELECT CONCAT(a.apellido,  ', ',  a.nombre) as nombre
FROM
(
	SELECT t.id_tecnico, t.apellido, t.nombre,  COUNT(ia.id_incidente) as cant_incidentes
    FROM tecnicos t
    INNER JOIN incidentes_asignados ia ON t.id_tecnico = ia.id_tecnico
    WHERE ia.marca_resolucion = 1 and datediff(now(), ia.fecha_resolucion) <= dias
    GROUP BY t.id_tecnico, t.apellido, t.nombre ORDER BY COUNT(ia.id_incidente) DESC
    limit 1
 ) as a ;  


END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `tecnico_mas_incidentes_resueltos_de_un_servicio_en_n_dias`(descripcion_servicio varchar(255),  dias int)
BEGIN
SELECT CONCAT(a.apellido,  ', ',  a.nombre) as nombre
FROM
(
	SELECT t.id_tecnico, t.apellido, t.nombre,  COUNT(ia.id_incidente) as cant_incidentes
    FROM tecnicos t
    INNER JOIN incidentes_asignados ia ON t.id_tecnico = ia.id_tecnico
    INNER JOIN incidentes i ON ia.id_incidente = i.id_incidente
    INNER JOIN servicios s ON i.id_servicio = s.id_servicio
    WHERE ia.marca_resolucion = 1 and s.descripcion = descripcion_servicio
		and datediff(now(), ia.fecha_resolucion) <= dias
    GROUP BY t.id_tecnico, t.apellido, t.nombre ORDER BY COUNT(ia.id_incidente) DESC
    limit 1
 ) as a ;  



END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `tecnico_mas_rapido`()
BEGIN
SELECT CONCAT(a.apellido,  ', ',  a.nombre) as nombre
FROM
(
	SELECT t.id_tecnico, t.apellido, t.nombre, datediff(now(), ia.fecha_resolucion) as duracion
    FROM tecnicos t
    INNER JOIN incidentes_asignados ia ON t.id_tecnico = ia.id_tecnico
    WHERE ia.marca_resolucion = 1 
    ORDER BY datediff(now(), ia.fecha_resolucion) DESC
    limit 1
 ) as a ;  


END$$
DELIMITER ;
