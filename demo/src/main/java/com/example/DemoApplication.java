package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class DemoApplication {

	private RestTemplate template;

	@Autowired
	public DemoApplication(RestTemplateBuilder builder) {
		this.template = builder.build();
	}

	@RequestMapping("/greeting")
	public Message greeting() {
		return template.getForObject("http://localhost:9000/greeting", Message.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

class Message {
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
