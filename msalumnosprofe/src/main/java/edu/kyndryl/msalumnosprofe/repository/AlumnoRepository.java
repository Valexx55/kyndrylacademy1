package edu.kyndryl.msalumnosprofe.repository;

import org.springframework.data.repository.CrudRepository;

import edu.kyndryl.mscomunprofe.entity.Alumno;

/**
 * aquí accederemos a la base de datos
 */

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {
	
	
	 Iterable<Alumno> findByEdadBetween (int edadmin, int edadmax);

}
