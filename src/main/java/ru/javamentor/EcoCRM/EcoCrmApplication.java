package ru.javamentor.EcoCRM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ru.javamentor.EcoCRM.controller.rest.EncodingRestController;
import ru.javamentor.EcoCRM.dao.TokenDao;
import ru.javamentor.EcoCRM.init.DataInitializer;
import ru.javamentor.EcoCRM.model.Token;
import ru.javamentor.EcoCRM.service.TokenService;
import ru.javamentor.EcoCRM.service.TokenServiceImpl;

import javax.annotation.PostConstruct;
import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;


@EnableScheduling
@SpringBootApplication
@PropertySource({"classpath:properties/datasource.properties",
		"classpath:properties/jpa.properties",
		"classpath:properties/mail.properties",
		"classpath:properties/token.properties",
		"classpath:properties/application.properties"})
public class EcoCrmApplication implements WebMvcConfigurer {

//	@PostConstruct
//	@Bean(initMethod = "init")
	public DataInitializer init() {
		return new DataInitializer();
	}

	public static void main(String[] args) throws IOException {
		/*
		File file = new File("src\\main\\resources\\properties\\text");
		BufferedReader br = new BufferedReader(new FileReader(file));
		String text = br.readLine();
		System.out.println(text);
		Map<Character, Float> crypted = EcoCrmApplication.decodeText(text);
		for (Map.Entry<Character, Float> entry : crypted.entrySet()) {
			System.out.print(entry.getKey() + " : " + (float)entry.getValue()/(float)text.length() + " Кол-во инфы: ");
			System.out.println((float)entry.getValue()/(float)text.length()*32);
		}
		*/





		SpringApplication.run(EcoCrmApplication.class, args);

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}

	public static Map<Character, Float> decodeText(String text){

		Map<Character, Integer> preResult = EncodingRestController.analyze(text).entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		Map<Character, Float> result = new HashMap<>();
		for (Map.Entry<Character, Integer> entry : preResult.entrySet()) {
			result.put(entry.getKey(),(float)entry.getValue()/(float)text.length());
		}
		//сортировка с относительными частотами
		Map<Character,Float> relativeResult = result.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
						(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		return relativeResult;


	}
}
