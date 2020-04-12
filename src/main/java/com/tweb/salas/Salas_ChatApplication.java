package com.tweb.salas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.tweb.salas.servicio.FicherosServicio;

@SpringBootApplication
public class Salas_ChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(Salas_ChatApplication.class, args);
	}
	
	@Bean
	CommandLineRunner init(FicherosServicio ficherosService) {
		return (args) -> {
			ficherosService.deleteAll();
			ficherosService.init();
		};
	}
}