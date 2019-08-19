package ru.javamentor.EcoCRM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import ru.javamentor.EcoCRM.init.DataInitializer;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class EcoCrmApplication implements WebMvcConfigurer {

//	@PostConstruct
//	@Bean(initMethod = "init")
	public DataInitializer init() {
		return new DataInitializer();
	}

//	@Bean
//	public ViewResolver viewResolver() {
//		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
//		templateResolver.setTemplateMode("XHTML");
//		templateResolver.setPrefix("templates/");
//		templateResolver.setSuffix(".html");
//
//		SpringTemplateEngine engine = new SpringTemplateEngine();
//		engine.setTemplateResolver(templateResolver);
//
//		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//		viewResolver.setTemplateEngine(engine);
//		return viewResolver;
//	}

	public static void main(String[] args) {
		SpringApplication.run(EcoCrmApplication.class, args);
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/static/js");
	}
}
