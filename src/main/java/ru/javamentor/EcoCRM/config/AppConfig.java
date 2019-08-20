package ru.javamentor.EcoCRM.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

//todo reduce class
@Configuration
@PropertySource({"classpath:config/datasource.properties",
                 "classpath:config/jpa.properties",
                 "classpath:config/mail.properties"})
public class AppConfig {

}
