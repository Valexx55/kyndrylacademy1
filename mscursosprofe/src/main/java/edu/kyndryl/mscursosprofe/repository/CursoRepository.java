package edu.kyndryl.mscursosprofe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.kyndryl.mscomunprofe.entity.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {
	//Query NATIVA : Opción que me da Spring pasa usar "consultas
	//de toda la vida"
	
	
	@Query(value = "select * from cursos where id = "
			+ "(select curso_id from cursos_alumnos where alumnos_id = ?1)", nativeQuery = true)
	public Optional<Curso> obtenerCursoAlumno (Long idalumno);
	

}
