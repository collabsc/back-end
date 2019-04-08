package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ApplicationRestRepository extends CrudRepository<Application , Long> {
	@Query("FROM Application a WHERE a.userid = :userid")
	List<Application> findApplicationByUserId(@Param("userid") Integer id);
}
