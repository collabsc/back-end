package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ProjectController {

	private final ProjectRestRepository repository;
	
	ProjectController(ProjectRestRepository repository){
		this.repository = repository;
	}
	
	@GetMapping("/projects")
	List<Project> all(){
		Iterable<Project> it = repository.findAll();
		List<Project> projects = new ArrayList<Project>();
		it.forEach(projects::add);
		return projects;
	}
	
	@GetMapping("/projects/{projectid}")
	Project getProjectById(@PathVariable Long projectid) {
		return repository.findById(projectid).orElseThrow(() -> new ResponseStatusException(
				HttpStatus.NOT_FOUND , "project with id " + projectid + " does not exist"));
	}
	
	@GetMapping("projects/user/{userid}")
	List<Project> getProjectByUserId(@PathVariable("userid") Integer userId) {
		//List<Project> projects = new ArrayList<Project>();
		if (!repository.findProjectByUserId(userId).isEmpty())
			return repository.findProjectByUserId(userId);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND , "project with userId " 
					+ userId + " does not exist");

	}

	
}

	
