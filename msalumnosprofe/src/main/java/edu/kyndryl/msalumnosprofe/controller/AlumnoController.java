package edu.kyndryl.msalumnosprofe.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.kyndryl.msalumnosprofe.client.ClienteFeignCurso;
import edu.kyndryl.msalumnosprofe.model.FraseChiquito;
import edu.kyndryl.msalumnosprofe.service.AlumnoService;
import edu.kyndryl.mscomunprofe.entity.Alumno;
import edu.kyndryl.mscomunprofe.entity.Curso;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;

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

	@Autowired //inyección de dependencias
	AlumnoService alumnoService;
	
	@Value("${instancia}")//obtiene el valor de las properties
	String nombre;
	
	@Autowired
	Environment environment;
	
	@Autowired
	ClienteFeignCurso clienteFeignCurso;
	
	Logger log = LoggerFactory.getLogger(AlumnoController.class);
	
	
	 // si viene una petición GET con esta url /alumno/obtener-alumno-test,
	@GetMapping("/obtener-alumno-test")											// ejecute este método
	public Alumno obtenerAlumnoTest() {
		Alumno alumno = null;

		// Long id, String nombre, String apellido, int edad, String email,
		// LocalDateTime creadoEn
		//alumno.getEmail();//provocamos un nullpointer exception
		log.debug ("en obtenerAlumnoTest ");
		alumno = new Alumno(1l, "Sergio", "Martínez", 55, "sergio@kyndryl.com", LocalDateTime.now());
		log.debug ("sal obtenerAlumnoTest " + alumno);
		//alumno.getNombre().charAt(6);
		
		
		return alumno;
	}

	@GetMapping
	@Operation(description = "Esta operación recupera el listado de alumnos total en base datos")
	public ResponseEntity<Iterable<Alumno>> obtenerAlumnos() {
		ResponseEntity<Iterable<Alumno>> httpRespuesta = null;
			
			log.debug("Atentido por instacia " + this.nombre + " en el puerto " + environment.getProperty("local.server.port"));
			Iterable<Alumno> listalumnos = this.alumnoService.consultarTodos();
			httpRespuesta = ResponseEntity.ok(listalumnos);

		return httpRespuesta;
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Alumno> obtenerAlumnoPorId(@PathVariable Long id) {
		ResponseEntity<Alumno> httpRespuesta = null;
		
		Optional<Alumno> oa = this.alumnoService.consulta(id);
		if (oa.isPresent())
		{
			Alumno alumnoleido = oa.get();
			httpRespuesta = ResponseEntity.ok(alumnoleido);
		} else {
			httpRespuesta = ResponseEntity.noContent().build();
		}

		return httpRespuesta;
	}
	
	
	@PostMapping
	public ResponseEntity<?> insertarAlumno(@Valid @RequestBody Alumno alumno, BindingResult br) {
		ResponseEntity<?> httpRespuesta = null;
		
			if (br.hasErrors())
			{
				List<ObjectError> lista_errores = br.getAllErrors();
				httpRespuesta = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(lista_errores);
			} else {
				Alumno alumnonuevo = this.alumnoService.alta(alumno);
				httpRespuesta = ResponseEntity.status(HttpStatus.CREATED).body(alumnonuevo);
			}
		
			
		
		return httpRespuesta;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> borrarAlumnoPorId(@PathVariable Long id) {
		ResponseEntity<Void> httpRespuesta = null;
		
			this.alumnoService.bajaPorId(id);
			httpRespuesta = ResponseEntity.ok().build();

		return httpRespuesta;
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Alumno> modificarAlumnoPorId(@PathVariable Long id, @RequestBody Alumno alumno) {
		ResponseEntity<Alumno> httpRespuesta = null;
		
		Optional<Alumno> oa = this.alumnoService.modificar(alumno, id);
		if (oa.isPresent())
		{
			Alumno alumnoModificado = oa.get();
			httpRespuesta = ResponseEntity.ok(alumnoModificado);
		} else {
			httpRespuesta = ResponseEntity.notFound().build();
		}

		return httpRespuesta;
	}
	
	 //@GetMapping("/consultar-alumnos-rango-edad/{ini}/{max}")
	@GetMapping("/consultar-alumnos-rango-edad")
		public ResponseEntity<Iterable<Alumno>> obtenerAlumnoEntrreEdad(
				@RequestParam(name = "edadmin", required = true) int ini,
				@RequestParam(name = "edadmax", required = true) int max)
				/*@PathVariable int ini,@PathVariable int max)*/ {
			
		ResponseEntity<Iterable<Alumno>> httpRespuesta = null;
			
			Iterable<Alumno> listalumnos = this.alumnoService.consultarAlumnosEntreEdad(ini,max);
			
			httpRespuesta = ResponseEntity.ok(listalumnos);

		return httpRespuesta;
		//https://www.google.com/search?client=ubuntu-sn&channel=fs&q=real+madrid
			
		}
	
	
	@GetMapping("/obtener-frase-chiquito")
	public ResponseEntity<FraseChiquito> obtenerFraseChiquito() {
		ResponseEntity<FraseChiquito> httpRespuesta = null;
		
		Optional<FraseChiquito> oa = this.alumnoService.obtenerFraseChiquitoAleatoria();
		if (oa.isPresent())
		{
			FraseChiquito fraseChiquito = oa.get();
			log.debug("FRASE recuperada = " + fraseChiquito.toString());
			httpRespuesta = ResponseEntity.ok(fraseChiquito);
		} else {
			httpRespuesta = ResponseEntity.noContent().build();
		}

		return httpRespuesta;
	}
	
	
	@GetMapping("/obtener-curso-alumno-via-feign/{idalumno}")
	public ResponseEntity<Curso> obtenerCursoAlumno (@PathVariable Long idalumno)
	{
		ResponseEntity<Curso> responseEntity = null;
		Optional<Curso> oc = null;
		
			 oc = this.clienteFeignCurso.obtenerCursoAlumnoViaFeign(idalumno);
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
