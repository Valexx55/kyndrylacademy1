package edu.kyndryl.msalumnosprofe.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;

import edu.kyndryl.msalumnosprofe.model.Alumno;

@SpringBootTest(webEnvironment =  WebEnvironment.RANDOM_PORT)
class AlumnoControllerTest {
	
	@Autowired
	TestRestTemplate template;
	
	@LocalServerPort
	int puerto;
	
	static Logger log = LoggerFactory.getLogger(AlumnoControllerTest.class);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		log.debug ("BeforeAll");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		log.debug ("AfterAll");
	}

	@BeforeEach
	void setUp() throws Exception {
		log.debug ("BeforeEach");
	}

	@AfterEach
	void tearDown() throws Exception {
		log.debug ("AfterEach");
	}

	@Test
	final void testObtenerAlumnoTest() {
		
	 	Alumno alumnoTest =  template.getForObject("http://localhost:"+puerto+"/alumno/obtener-alumno-test", Alumno.class);
	 	assertEquals(alumnoTest.getNombre(), "Sergio");
	}

	@Test
	final void testObtenerAlumnoPorId() throws URISyntaxException {
		 //MyRequest body = ...
		 RequestEntity<Void> request = RequestEntity.get(new URI("http://localhost:"+puerto+"/alumno/2")).build();
		 ResponseEntity<Alumno> response = template.exchange(request, Alumno.class);
		 assertEquals(HttpStatus.OK, response.getStatusCode());
		 assertEquals(2l, response.getBody().getId());
	}
	
	
	//TODO TIEMPO PARA PRACTICAR ALGÚN CASO DE TEST
	//1 post correcto -201
	@Test
	final void insertarAlumnoTest201() throws URISyntaxException {
		 Alumno alumno = new Alumno(null, "Sergio", "Martínez", 55, "sergio@kyndryl.com", LocalDateTime.now());
		 RequestEntity<Alumno> request = RequestEntity.post(new URI("http://localhost:"+puerto+"/alumno")).accept(MediaType.APPLICATION_JSON).body(alumno);
		 ResponseEntity<Alumno> response = template.exchange(request, Alumno.class);
		 assertEquals(HttpStatus.CREATED, response.getStatusCode());
		 assertNotNull(response.getBody().getId());
		 assertNotNull(response.getBody().getCreadoEn());
		 log.debug("Alumno nuevo " + response.getBody().toString()); 
	}
	//1 post incorrecto - no supere la validación - 400
	@Test
	final void insertarAlumnoTest400() throws URISyntaxException {
		 Alumno alumno = new Alumno(null, "Se", "", 550, "sergiokyndryl.com", LocalDateTime.now());
		 RequestEntity<Alumno> request = RequestEntity.post(new URI("http://localhost:"+puerto+"/alumno")).accept(MediaType.APPLICATION_JSON).body(alumno);
		 ResponseEntity<Object> response = template.exchange(request, Object.class);
		 //TODO comprobar que tiene 4 items la lista de errores devuelta en el cuerpo
		 assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
		 //assertNotNull(response.getBody().getId());
		 //assertNotNull(response.getBody().getCreadoEn());
		 //log.debug("Alumno nuevo " + response.getBody().toString()); 
	}
	

}
