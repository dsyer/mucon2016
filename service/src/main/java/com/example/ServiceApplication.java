package com.example;

import java.util.Collections;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@ConfigurationProperties("app")
public class ServiceApplication {

	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@RequestMapping("/greeting")
	public Map<String, String> greeting() {
		return Collections.singletonMap("value", this.message);
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}

}
