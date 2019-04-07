package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

	private final UserRestRepository repository;
	
	UserController(UserRestRepository repository){
		this.repository = repository;
	}
	
	@GetMapping("/users")
	List<User> all(){
		Iterable<User> it = repository.findAll();
		List<User> users = new ArrayList<User>();
		it.forEach(users::add);
		System.out.println("runnnn");
		return users;
	}
	
	@RequestMapping(value = "/users" , method=RequestMethod.POST)
	User newUser(@RequestBody User newUser) {
		System.out.println(newUser);
		return repository.save(newUser);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public void handleMissingParams(HttpMessageNotReadableException ex) {
		
	    String name = ex.getLocalizedMessage();
	    System.out.println(name + " parameter is missing");
	    // Actual exception handling
	}
	
	
	
}
