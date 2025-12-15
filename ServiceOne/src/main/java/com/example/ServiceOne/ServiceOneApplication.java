package com.example.ServiceOne;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
@RestController
public class ServiceOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceOneApplication.class, args);
	}

	@Autowired
	private RestTemplate restTemplate;


//	public String serviceOne() {
//		String response = restTemplate.getForObject("http://localhost:8081/inventory", String.class);
//		return "Hello from Service One! \n" + response;
//	}

	@GetMapping("/user")
	public String serviceOne() {
		ResponseEntity<String> response = restTemplate.exchange(
				"http://localhost:8081/inventory",
				HttpMethod.GET,
				null,
				String.class
		);

		if (response.getStatusCode().is2xxSuccessful()) {
			return response.getBody();
		} else if (response.getStatusCode().is5xxServerError()) {
			return "Request failed with status code: " + response.getStatusCode();
		}
		else return "Unexpected error occurred.";
	}
}
