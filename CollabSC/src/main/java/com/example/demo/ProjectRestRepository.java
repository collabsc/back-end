package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProjectRestRepository extends CrudRepository<Project , Long> {
	@Query("FROM Project p WHERE p.userid = :userid")
	List<Project> findProjectByUserId(@Param("userid") Integer id);
}

