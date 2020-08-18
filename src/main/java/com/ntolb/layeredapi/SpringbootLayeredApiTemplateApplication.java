package com.ntolb.layeredapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ntolb.layeredapi.data.UserRepository;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class SpringbootLayeredApiTemplateApplication {
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		repository.save
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLayeredApiTemplateApplication.class, args);
	}

}
