package ru.javamentor.EcoCRM;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.javamentor.EcoCRM.init.DataInitializer;
import javax.annotation.PostConstruct;


@SpringBootApplication
public class EcoCrmApplication implements WebMvcConfigurer {

	//@PostConstruct
	//@Bean(initMethod = "init")
	public DataInitializer init() {
		return new DataInitializer();
	}

	public static void main(String[] args) {
		SpringApplication.run(EcoCrmApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
}
