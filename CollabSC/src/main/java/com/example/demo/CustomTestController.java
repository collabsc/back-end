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
public class CustomTestController {

	private final CustomTestRepository repository;
	
	CustomTestController(CustomTestRepository repository){
		this.repository = repository;
	}
	
//	@GetMapping("/users")
//	List<User> all(){
//		Iterable<User> it = repository.findAll();
//		List<User> users = new ArrayList<User>();
//		it.forEach(users::add);
//		System.out.println("runnnn");
//		return users;
//	}
	
	@RequestMapping(value = "/test" , method=RequestMethod.POST)
	CustomTest newUser(@RequestBody CustomTest newTest) {
		System.out.println(newTest);
		return repository.save(newTest);
	}
	
//	@ExceptionHandler(HttpMessageNotReadableException.class)
//	public void handleMissingParams(HttpMessageNotReadableException ex) {
//		
//	    String name = ex.getLocalizedMessage();
//	    System.out.println(name + " parameter is missing");
//	    // Actual exception handling
//	}
//	
	
	
}
