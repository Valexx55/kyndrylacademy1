package edu.kyndryl.mscursosprofe.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kyndryl.mscomunprofe.entity.Alumno;
import edu.kyndryl.mscomunprofe.entity.Curso;
import edu.kyndryl.mscursosprofe.service.CursoService;

@RestController
@RequestMapping("/curso")
public class CursoController {
	
	@Autowired
	CursoService cursoService;
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> bajaPorId (@PathVariable Long id)
	{
		ResponseEntity<Void> responseEntity = null;
		
			 this.cursoService.deleteById(id);
			 responseEntity = ResponseEntity.ok().build();
			 
		
		return responseEntity;
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Curso> consultaPorId (@PathVariable Long id)
	{
		ResponseEntity<Curso> responseEntity = null;
		Optional<Curso> oc = null;
		
			 oc = this.cursoService.findById(id);
			 if (oc.isPresent())
			 {
				 Curso curso = oc.get();
				 responseEntity = ResponseEntity.ok(curso);
			 } else {
				 responseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			 }
		
		return responseEntity;
		
	}
	
	@GetMapping
	public ResponseEntity<Iterable<Curso>> consultarTodos ()
	{
		ResponseEntity<Iterable<Curso>> responseEntity = null;
		Iterable<Curso> listacursos = null;
		
			listacursos = this.cursoService.findAll();
			responseEntity = ResponseEntity.ok(listacursos);
			 
		
		return responseEntity;
		
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Curso> modificarPorId (@RequestBody Curso curso, @PathVariable Long id)
	{
		ResponseEntity<Curso> responseEntity = null;
		Optional<Curso> oc = null;
		
			 oc = this.cursoService.update(curso, id);
			 if (oc.isPresent())
			 {
				 Curso cursoModificado = oc.get();
				 responseEntity = ResponseEntity.ok(cursoModificado);
			 } else {
				 responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			 }
		
		return responseEntity;
		
	}
	
	
	
	@PostMapping
	public ResponseEntity<Curso> altaCurso (@RequestBody Curso curso)
	{
		ResponseEntity<Curso> responseEntity = null;
		Curso cursonuevo = null;
		
			cursonuevo = this.cursoService.save(curso);
			responseEntity = ResponseEntity.status(HttpStatus.CREATED).body(cursonuevo);
			
		
		return responseEntity;
		
	}
	
	
	@PutMapping("/asignar-alumnos/{idcurso}")
	public ResponseEntity<Curso> asignarAlumnosCurso (@RequestBody List<Alumno> alumnos, @PathVariable Long idcurso)
	{
		ResponseEntity<Curso> responseEntity = null;
		Optional<Curso> oc = null;
		
			 oc = this.cursoService.matricularAlumnos(alumnos, idcurso);
			 if (oc.isPresent())
			 {
				 Curso cursoModificado = oc.get();
				 responseEntity = ResponseEntity.ok(cursoModificado);
			 } else {
				 responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			 }
		
		return responseEntity;
		
	}
	
	@PutMapping("/borrar-alumno/{idcurso}")
	public ResponseEntity<Curso> borrarAlumnoCurso (@RequestBody Alumno alumno, @PathVariable Long idcurso)
	{
		ResponseEntity<Curso> responseEntity = null;
		Optional<Curso> oc = null;
		
			 oc = this.cursoService.desmatricularAlumno(alumno, idcurso);
			 if (oc.isPresent())
			 {
				 Curso cursoModificado = oc.get();
				 responseEntity = ResponseEntity.ok(cursoModificado);
			 } else {
				 responseEntity = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			 }
		
		return responseEntity;
		
	}
	
	
	@GetMapping("/obtener-curso-alumno/{idalumno}")
	public ResponseEntity<Curso> obtenerCursoAlumno (@PathVariable Long idalumno)
	{
		ResponseEntity<Curso> responseEntity = null;
		Optional<Curso> oc = null;
		
			 oc = this.cursoService.obtenerCursoAlumno(idalumno);
			 if (oc.isPresent())
			 {
				 Curso cursoAlumno = oc.get();
				 responseEntity = ResponseEntity.ok(cursoAlumno);
			 } else {
				 responseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			 }
		
		return responseEntity;
	}
	
	
	
	
	

}
