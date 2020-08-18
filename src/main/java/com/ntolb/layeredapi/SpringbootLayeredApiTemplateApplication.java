package com.ntolb.layeredapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ntolb.layeredapi.data.UserRepository;
import com.ntolb.layeredapi.model.User;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*")
public class SpringbootLayeredApiTemplateApplication {
	
	@Autowired
	private UserRepository repository;
	
	@PostMapping("/register")
	public String register(@RequestBody User user) {
		repository.save(user);
		return "Hello, "+ user.getUsername() + ", your registration was completed successfully!";
	}
	
	@GetMapping("/getAllUsers")
	public List<User> findAllUsers() {
		return (List<User>) repository.findAll();
	}
	
	@GetMapping("/getUser/{email}")
	public List<User> findUser(@PathVariable String email) {
		return repository.findAllByEmail(email);
		
	}
	
	@DeleteMapping("/cancel/{id}")
	public List<User> findUser(@PathVariable Integer id) {
		repository.deleteById(id);
		return repository.findAll();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringbootLayeredApiTemplateApplication.class, args);
	}

}
