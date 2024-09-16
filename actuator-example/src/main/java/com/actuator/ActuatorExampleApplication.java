package com.actuator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.annotation.Annotation;

@SpringBootApplication
public class ActuatorExampleApplication {

	public static void main(String[] args) {

		SpringApplication.run(ActuatorExampleApplication.class, args);



		Demo d=new Demo();
		Class c = d.getClass();

		MyAnno annotation =(MyAnno) c.getAnnotation(MyAnno.class);



	}

}
