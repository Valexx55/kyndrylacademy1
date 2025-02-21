package edu.kyndryl.mscursosprofe.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.kyndryl.mscursosprofe.model.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {

}
