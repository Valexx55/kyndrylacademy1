package edu.kyndryl.msalumnosprofe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient//activamos el cliente de Eureka
public class MsalumnosprofeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsalumnosprofeApplication.class, args);
	}

}
