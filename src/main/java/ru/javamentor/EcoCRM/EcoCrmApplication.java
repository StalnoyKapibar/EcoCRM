package ru.javamentor.EcoCRM;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ru.javamentor.EcoCRM.init.DataInitializer;


@SpringBootApplication
public class EcoCrmApplication {

//	@PostConstruct
//	@Bean(initMethod = "init")
	public DataInitializer init() {
		return new DataInitializer();
	}

	public static void main(String[] args) {
		SpringApplication.run(EcoCrmApplication.class, args);
	}

}
