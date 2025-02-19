package edu.kyndryl.msgatewayprofe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsgatewayprofeApplication {
	
	/**
	 * PARA CONFIGURAR EL GATEWAY
	 * 
	 * 1) Nuevo proyecto Spring starter Gateway y Eureka
	 * 2) Activamos  @EnableDiscoveryClient
	 * 3) Configuramos YML
	 * 
	 * 
	 */

	public static void main(String[] args) {
		SpringApplication.run(MsgatewayprofeApplication.class, args);
	}

}
