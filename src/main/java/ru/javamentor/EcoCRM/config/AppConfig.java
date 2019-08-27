package ru.javamentor.EcoCRM.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

//todo reduce class
@Configuration
@PropertySource({"classpath:properties/datasource.properties",
                 "classpath:properties/jpa.properties",
                 "classpath:properties/mail.properties",
                "classpath:properties/token.properties",
                "classpath:properties/application.properties"})
public class AppConfig {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        PropertySourcesPlaceholderConfigurer c = new PropertySourcesPlaceholderConfigurer();
        c.setLocation(new ClassPathResource("properties/application.properties"));
        return c;
    }
}
