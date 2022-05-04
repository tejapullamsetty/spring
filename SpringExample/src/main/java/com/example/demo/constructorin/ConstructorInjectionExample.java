package com.example.demo.constructorin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConstructorInjectionExample {
	
	HandlerExample handlerExample;

	@Autowired
	ConstructorInjectionExample(HandlerExample handlerExample){
		System.out.println("*********This is constructor example********");
		this.handlerExample=handlerExample;
	}
}
