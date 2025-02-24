package edu.kyndryl.mscursosprofe.service;

import java.util.List;
import java.util.Optional;

import edu.kyndryl.mscomunprofe.entity.Alumno;
import edu.kyndryl.mscomunprofe.entity.Curso;

public interface CursoService {
	
	public Iterable<Curso> findAll ();
	
	public Optional<Curso> findById (Long id);
	
	public Curso save (Curso curso);
	
	public void deleteById (Long id);
	
	public Optional<Curso> update (Curso curso, Long id);
	
	public Optional<Curso> matricularAlumnos (List<Alumno> lAlumnos, Long id);
	
	public Optional<Curso> desmatricularAlumno (Alumno alumno, Long id);
	
	public Optional<Curso> obtenerCursoAlumno (Long idalumno);

}
