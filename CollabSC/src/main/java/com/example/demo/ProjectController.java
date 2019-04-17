package com.example.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
	
	@GetMapping("/projects/user/{userid}")
	List<Project> getProjectByUserId(@PathVariable("userid") Integer userId) {
		if (!repository.findProjectByUserId(userId).isEmpty())
			return repository.findProjectByUserId(userId);
		else
			throw new ResponseStatusException(HttpStatus.NOT_FOUND , "project with userId " 
					+ userId + " does not exist");
	}
	
	@RequestMapping (value = "/projects" , method=RequestMethod.POST)
	Project newProject(@RequestBody Project newProject){
		return repository.save(newProject);
	}
	
	@DeleteMapping(value = "/projects/{id}")
	void deleteProject(@PathVariable Long id) {
		repository.deleteById(id);
	}
	
	@RequestMapping (value = "/addUser" , method=RequestMethod.POST)
	void addUser(@RequestBody HashMap<Long , Long> map) {
		Iterable<Project> iter = repository.findAll();
		List<Project> projects = new ArrayList<Project>();
		iter.forEach(projects::add);
		
		Iterator<Long> itr = map.keySet().iterator();
		List<Long> keys = new ArrayList<Long>();
		while (itr.hasNext()) {
			Long key = itr.next();
			keys.add(key);
		}
		
		for (int i = 0 ; i < keys.size() ; i++) {
			for (int j = 0 ; j < projects.size() ; j++) {
				if (projects.get(i).getId() == keys.get(i)) {
					projects.get(i).addAppliedId(map.get(keys.get(i)));
				}
			}
		}
	}

}

	
