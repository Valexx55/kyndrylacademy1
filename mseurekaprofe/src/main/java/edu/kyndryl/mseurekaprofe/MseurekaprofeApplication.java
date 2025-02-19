package edu.kyndryl.mseurekaprofe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer //activamos la lirería eureka
public class MseurekaprofeApplication {
	/**
	 * 
	 * PASOS PARA CONFIGURAR EUREKA
	 * 
	 * 1) CREAMOS EL PROYECTO CON LA DEPEDENCIA DE EUREKA SERVER
	 * 2) ACTIVARTLO con @EnableEurekaServer
	 * 3) ADD DEPENDENCIA JAXB GLASSFISH
	 * 4) ADD PROPERTIES
	 * 
	 */

	public static void main(String[] args) {
		SpringApplication.run(MseurekaprofeApplication.class, args);
	}

}
