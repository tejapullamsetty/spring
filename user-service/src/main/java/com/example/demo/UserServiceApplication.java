package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.OrderDTO;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@SpringBootApplication
@RestController
@RequestMapping("/user-service")
public class UserServiceApplication {

	@Autowired
	@Lazy
	private RestTemplate restTemplate;

	private static final String BASEURL = "http://localhost:8080/orders";

	private static final String USER_SERVICE = "userService";

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@GetMapping("/displayOrders")
	@CircuitBreaker(name = "USER_SERVICE", fallbackMethod = "getAllAvailableProducts")
	public List<OrderDTO> displayOrders(@RequestParam("category") String category) {

		// http://localhost:8080/orders/electronics
		String url = category == null ? BASEURL : BASEURL + "/" + category;

		return restTemplate.getForObject(url, ArrayList.class);
	}

	public List<OrderDTO> getAllAvailableProducts(Exception e) {
		return Stream.of(new OrderDTO(1, "TV", "Electronics", "black", 500000),
				new OrderDTO(2, "Mobile", "Electronics", "black", 500000),
				new OrderDTO(3, "Fan", "Electronics", "white", 500000),
				new OrderDTO(4, "T-Shirts", "Clothing", "brown", 500000),
				new OrderDTO(5, "Tickets", "Movie", "white", 500000)).collect(Collectors.toList());
	}

}
