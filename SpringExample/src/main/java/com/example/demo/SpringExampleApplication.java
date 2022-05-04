package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.constructorin.ConstructorInjectionExample;
import com.example.demo.di.UserExample;

@SpringBootApplication
public class SpringExampleApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringExampleApplication.class, args);

		UserExample userExample1 = context.getBean(UserExample.class);
		userExample1.helloUser();
		
		ConstructorInjectionExample constructorInjectionExample=context.getBean(ConstructorInjectionExample.class);
		

	}
}
