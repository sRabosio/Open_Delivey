package it.opendelivey.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class OpenDeliveryApplication {

	//TODO: usare il create-drop per testare le query
	//TODO: aggiungere il framework per gestire il database

	public static void main(String[] args) {
		SpringApplication.run(OpenDeliveryApplication.class, args);
	}

}
