package edu.kyndryl.msalumnosprofe.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * es una especie de sumidero de excepciones
 * listener global de mi app
 */
@RestControllerAdvice(basePackages = {"edu.kyndryl.msalumnosprofe"})
public class GestionExcepciones {
	
	Logger log = LoggerFactory.getLogger(GestionExcepciones.class);
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> gestionNullPointerException (NullPointerException npex)
	{
		ResponseEntity<String> respuesta = null;
		
			log.error(npex.getMessage(), npex);
			respuesta = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(npex.getMessage());
		
		return respuesta;
	}
	
	
	@ExceptionHandler(Throwable.class)
	public ResponseEntity<String> gestionOtraException (Throwable exception)
	{
		ResponseEntity<String> respuesta = null;
		
			log.error(exception.getMessage(), exception);
			respuesta = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
		
		return respuesta;
	}

}
