package edu.kyndryl.msalumnosprofe.client;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.kyndryl.mscomunprofe.entity.Curso;

//aquí se cocina la comunicación entre el ms de alumnos y cursos
//se hace por configuración

//TODO Voluntario: consumir el listado de cursos, desde el microsericio de alumnos


@FeignClient(name = "mscursosprofe") //indico el nombre del ms que voy a consumir
public interface ClienteFeignCurso {
	
	@GetMapping("/curso/obtener-curso-alumno/{idalumno}")
	public Optional<Curso> obtenerCursoAlumnoViaFeign (@PathVariable Long idalumno);

}
