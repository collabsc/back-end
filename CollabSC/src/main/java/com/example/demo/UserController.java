package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
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
		//return null;
		return users;
	}
	
	@GetMapping("users/{id}")
	User getUser(@PathVariable Long id) {
		return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
				  HttpStatus.NOT_FOUND, "user with id " + id + " does not exist"));
		
	}
	
//	@RequestMapping(value = "/users" , method=RequestMethod.POST)
//	User newUser(@RequestBody User newUser) {
//		return repository.save(newUser);
//	}
	
	@RequestMapping(value = "/register" , method=RequestMethod.POST)
	HashMap<String , Boolean> newUser(@RequestBody User newUser) {
		boolean emailMatch = false;
		Iterable<User> it = repository.findAll();
		List<User> users = new ArrayList<User>();
		it.forEach(users::add);
		for (User u : users) {
			if (u.getEmail().equals(newUser.getEmail())) 
				emailMatch = true;
		}
		HashMap<String, Boolean> hm = new LinkedHashMap<String , Boolean>();
		if (!emailMatch) {
			repository.save(newUser);
			hm.put("success", new Boolean(true));
		}
		else
			hm.put("success", new Boolean(false));
		return hm;
	}
	
	@RequestMapping(value = "/login" , method=RequestMethod.POST)
	HashMap<String , Long> loginUser(@RequestBody HashMap<String , String> payload){
		String email = payload.get("email");
		String password = payload.get("password");
		Iterable<User> it = repository.findAll();
		List<User> users = new ArrayList<User>();
		it.forEach(users::add);
		HashMap<String, Long> hm = new LinkedHashMap<String , Long>();

		for (User u : users) {
			if (u.getEmail().equals(email) && u.getPassword().equals(password)) {
				hm.put("userId" , u.getId());
				return hm;
			}
		}
		return hm;

	}
	
	
	@DeleteMapping(value = "/users/{id}")
	void deleteUser(@PathVariable Long id){
		repository.deleteById(id);
	}
	
}
