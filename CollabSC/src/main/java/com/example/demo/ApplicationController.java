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
import org.springframework.web.server.ResponseStatusException;

public class ApplicationController {
	
	private final ApplicationRestRepository repository;
	
	ApplicationController(ApplicationRestRepository repository){
		this.repository = repository;
	}
	
	@GetMapping("/applications")
	List<Application> all(){
		Iterable<Application> it = repository.findAll();
		List<Application> applications = new ArrayList<Application>();
		it.forEach(applications::add);
		return applications;		
	}
	
	@GetMapping("/applications/{userid}")
	List<Application> getApplication(@PathVariable("userid") Integer userid) {
		if (!repository.findApplicationByUserId(userid).isEmpty())
			return repository.findApplicationByUserId(userid);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND , "applications with id " + 
					userid + " do not exist");
	}
	
	@RequestMapping (value = "/applications" , method=RequestMethod.POST)
	Application newApplication (@RequestBody Application newApplication) {
		return repository.save(newApplication);
	}
	
	
	@DeleteMapping(value = "/applications")
	void deleteApplication(@PathVariable Long applicationid) {
		repository.deleteById(applicationid);
	}

}
