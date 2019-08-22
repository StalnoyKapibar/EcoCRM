package ru.javamentor.EcoCRM.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//todo reduce class
@Configuration
@PropertySource({"classpath:properties/datasource.properties",
                 "classpath:properties/jpa.properties",
                 "classpath:properties/mail.properties",
                "classpath:properties/application.properties"})
public class AppConfig {

}
