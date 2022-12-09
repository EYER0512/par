package com.ayllusinchi.upeu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2   
@Configuration
public class Proyecto2Application {

	public static void main(String[] args) {
		SpringApplication.run(Proyecto2Application.class, args);
	}
        
        @Bean 
        public Docket productApi(){
            return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.ayllusinchi.upeu")).build();
           
        }

}
