package edu.kyndryl.mscursosprofe.service;

import java.util.Optional;

import edu.kyndryl.mscomunprofe.entity.Curso;

public interface CursoService {
	
	public Iterable<Curso> findAll ();
	
	public Optional<Curso> findById (Long id);
	
	public Curso save (Curso curso);
	
	public void deleteById (Long id);
	
	public Optional<Curso> update (Curso curso, Long id);

}
