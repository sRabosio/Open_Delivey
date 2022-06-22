package it.opendelivey.demo;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class OpenDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(OpenDeliveryApplication.class, args);
	}

}
