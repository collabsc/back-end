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
	
	@RequestMapping(value = "/applications" , method=RequestMethod.POST)
	Application newApplication(@RequestBody Application newApplication) {
		return repository.save(newApplication);
	}
	
	@GetMapping(value = "/applications/userid/{userid}")
	List<Application> findApplicationByUserId(@PathVariable Integer userid){
		if (!repository.findApplicationByUserId(userid).isEmpty())
			return repository.findApplicationByUserId(userid);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND , "application with userid "
					+ userid + " does not exist");
	}
	
	@DeleteMapping (value = "/applications/appid")
	void delteApplication(Long userid) {
		repository.deleteById(userid);
	}
}
