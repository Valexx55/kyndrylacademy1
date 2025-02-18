package edu.kyndryl.msalumnosprofe.repository;

import org.springframework.data.repository.CrudRepository;

import edu.kyndryl.msalumnosprofe.model.Alumno;

/**
 * aquí accederemos a la base de datos
 */

public interface AlumnoRepository extends CrudRepository<Alumno, Long> {

}
