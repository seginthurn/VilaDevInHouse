package br.com.inthurn.VilaDevInHouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class VilaDevInHouseApplication {

	public static void main(String[] args) {
		SpringApplication.run(VilaDevInHouseApplication.class, args);
	}

}
