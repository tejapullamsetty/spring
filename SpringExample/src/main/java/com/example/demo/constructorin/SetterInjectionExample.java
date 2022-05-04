package com.example.demo.constructorin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SetterInjectionExample {

	private HandlerExample handlerExample;

	public HandlerExample getHandlerExample() {
		return handlerExample;
	}

	@Autowired
	public void setHandlerExample(HandlerExample handlerExample) {
		System.out.println("***********setter method is initilizing***********");
		this.handlerExample = handlerExample;
		System.out.println("***********setter method is initilized successfully***********");
	}
	
	
}
