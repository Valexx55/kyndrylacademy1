package edu.kyndryl.msalumnosprofe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient//activamos el cliente de Eureka
@EntityScan({"edu.kyndryl.mscomunprofe"})
@EnableFeignClients//activar los clientes feign (com entre ms de la misma nube)
public class MsalumnosprofeApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsalumnosprofeApplication.class, args);
	}

}
