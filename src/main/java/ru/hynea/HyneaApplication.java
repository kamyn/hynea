package ru.hynea;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "ru.hynea.model")
public class HyneaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HyneaApplication.class, args);
	}

}
