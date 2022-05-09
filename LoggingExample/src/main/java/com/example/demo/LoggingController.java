package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

	Logger logger = LoggerFactory.getLogger(LoggingController.class);

	@GetMapping("/logging")
	public String sampleLoggingExample() {
		logger.debug("this is Debug logger level");
		logger.info("this is Info logger level");
		logger.error("this is Error logger level");
		logger.trace("this is Trace logger level");
		logger.warn("this is Warn logger level");
		return "This is sample example for springboot logging";
	}

}
