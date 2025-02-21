package edu.kyndryl.msalumnosprofe.service;

import java.util.Optional;

import edu.kyndryl.msalumnosprofe.model.FraseChiquito;
import edu.kyndryl.mscomunprofe.entity.Alumno;

/**
 * aquí se describe la funcionalidad de negocio
 * 
 */


public interface AlumnoService {
	
	Alumno alta (Alumno alumno);
	void bajaPorId (Long id);
	Optional<Alumno> modificar (Alumno alumno, Long id);
	Optional<Alumno> consulta (Long id);
	Iterable<Alumno> consultarTodos ();
	Iterable<Alumno>consultarAlumnosEntreEdad(int edadmin, int edadmax);
	Optional<FraseChiquito> obtenerFraseChiquitoAleatoria();
	
	

}
