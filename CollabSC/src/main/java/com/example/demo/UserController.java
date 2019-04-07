package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

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
		return users;
	}
	
	@GetMapping("users/{id}")
	User getUser(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
				  HttpStatus.NOT_FOUND, "user with id " + id + " does not exist"));
		
	}
	
	@RequestMapping(value = "/users" , method=RequestMethod.POST)
	User newUser(@RequestBody User newUser) {
		return repository.save(newUser);
	}
	
	@DeleteMapping(value = "/users/{id}")
	void deleteUser(@PathVariable Long id){
		repository.deleteById(id);
	}
	
}
