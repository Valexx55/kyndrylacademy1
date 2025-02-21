package edu.kyndryl.msalumnosprofe.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@SpringBootTest
@AutoConfigureMockMvc // simulamos el servidor
class AlumnoControllerTest2 {
	
	/**
	 *  La idea es testear una api REST de forma «interna» sin tener que desplegar la aplicación en un servidor, 
	 *  pero también de forma realista efectuando las llamadas a la misma tal y como lo harían los consumidores del servicio.
	 */
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	ObjectMapper om;//es para serializar a JSON el alumno
	
	
	//TEST POST CORRECTO
	@Test
	public void insertarAlumnoTest() throws Exception {
	
		
		ObjectNode objectNode = om.createObjectNode();//nuestro alumno
		objectNode.put("nombre" , "Nacho");
		objectNode.put("apellido" , "Moreno");
		objectNode.put("email" , "nacho@rm.es");
		objectNode.put("edad" , 15);
		
		// serializar este alumno
		String alumno_json = objectNode.toString();

		mockMvc.perform(post("/alumno").contentType(MediaType.APPLICATION_JSON).content(alumno_json))
				.andExpect(status().isCreated()).andExpect(content().contentType("application/json"));

	}
	
	
	@Test
	public void insertarAlumnoEmailIncorrectoTest() throws Exception {
	
		
		ObjectNode objectNode = om.createObjectNode();//nuestro alumno
		objectNode.put("nombre" , "Nacho");
		objectNode.put("apellido" , "Moreno");
		objectNode.put("email" , "nachorm.es");
		objectNode.put("edad" , 15);
		
		// serializar este alumno
		String alumno_json = objectNode.toString();

		mockMvc.perform(post("/alumno").contentType(MediaType.APPLICATION_JSON).content(alumno_json))
				.andExpect(status().is4xxClientError());//.andExpect(content().contentType("application/json"));

	}
	

}
