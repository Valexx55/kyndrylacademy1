package edu.kyndryl.msalumnosprofe.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

import edu.kyndryl.msalumnosprofe.model.Alumno;

@SpringBootTest(webEnvironment =  WebEnvironment.RANDOM_PORT)
class AlumnoControllerTest {
	
	@Autowired
	TestRestTemplate template;
	
	@LocalServerPort
	int puerto;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
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

}
