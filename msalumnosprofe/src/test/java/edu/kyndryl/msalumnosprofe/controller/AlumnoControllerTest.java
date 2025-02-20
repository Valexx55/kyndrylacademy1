package edu.kyndryl.msalumnosprofe.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

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
		//fail("Not yet implemented"); // TODO
	 	//Alumno alumnoTest =  template.getForObject("http://localhost:"+puerto+"/alumno/obtener-alumno-test", String.class);
	 	String alumnoTest =  template.getForObject("http://localhost:"+puerto+"/alumno/obtener-alumno-test", String.class);
	 	assertThat(alumnoTest.contains("nombre"));
	}

	@Test
	final void testObtenerAlumnoPorId() {
		fail("Not yet implemented"); // TODO
	}

}
