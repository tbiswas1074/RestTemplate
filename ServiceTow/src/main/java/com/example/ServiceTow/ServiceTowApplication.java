package com.example.ServiceTow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class ServiceTowApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceTowApplication.class, args);
	}


	@GetMapping("/inventory")
	public String serviceTow() {
		return "Hello from Inventory! I have Iphone available.";
	}

}
