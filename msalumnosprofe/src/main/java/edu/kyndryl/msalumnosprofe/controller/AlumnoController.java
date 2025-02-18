package edu.kyndryl.msalumnosprofe.controller;

import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.kyndryl.msalumnosprofe.model.Alumno;

/**
 * esta clase, recibe las peticiones http y las contesta expone el api pública
 * los métodos / operaciones que tiene nuestro microservicio
 * 
 * ALTA BAJA MODIFICACIÓN CONSULTA
 * 
 * DE ALUMNOS
 * 
 * REST
 */

@RestController // esta clase, recibe y contesta HTTPS con Formato JSON
@RequestMapping("/alumno") //todo lo que sea /alumno, es para esta clase 
public class AlumnoController {

	@GetMapping("/obtener-alumno-test") // si viene una petición GET con esta url /alumno/obtener-alumno-test,
												// ejecute este método
	public Alumno obtenerAlumnoTest() {
		Alumno alumno = null;

		// Long id, String nombre, String apellido, int edad, String email,
		// LocalDateTime creadoEn
		alumno = new Alumno(1l, "Sergio", "Martínez", 55, "sergio@kyndryl.com", LocalDateTime.now());

		return alumno;
	}

	@GetMapping
	public ResponseEntity<Iterable<Alumno>> obtenerAlumnos() {
		ResponseEntity<Iterable<Alumno>> httpRespuesta = null;

		return httpRespuesta;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable Long id) {
		ResponseEntity<Alumno> httpRespuesta = null;

		return httpRespuesta;
	}
	
	
	@PostMapping
	public ResponseEntity<Alumno> insertarAlumno(@RequestBody Alumno alumno) {
		ResponseEntity<Alumno> httpRespuesta = null;

		return httpRespuesta;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarAlumnoPorId(@PathVariable Long id) {
		ResponseEntity<Void> httpRespuesta = null;

		return httpRespuesta;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Alumno> modificarAlumnoPorId(@PathVariable Long id, @RequestBody Alumno alumno) {
		ResponseEntity<Alumno> httpRespuesta = null;

		return httpRespuesta;
	}
	

}
