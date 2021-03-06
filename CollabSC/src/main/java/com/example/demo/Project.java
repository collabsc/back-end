package com.example.demo;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String projectname;
	private Integer userid;
	private String projectdetails;
	private String applicationdeadline;
	private Integer numapplications;
	
	@ElementCollection(targetClass=Integer.class)
	private List<Long> appliedids;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public String getProjectdetails() {
		return projectdetails;
	}
	public void setProjectdetails(String projectdetails) {
		this.projectdetails = projectdetails;
	}
	public String getApplicationdeadline() {
		return applicationdeadline;
	}
	public void setApplicationdeadline(String applicationdeadline) {
		this.applicationdeadline = applicationdeadline;
	}
	public Integer getNumapplications() {
		return numapplications;
	}
	public void setNumapplications(Integer numapplications) {
		this.numapplications = numapplications;
	}
	public List<Long> getAppliedIds(){
		return appliedids;
	}
	public void setAppliedIds(List<Long> appliedids) {
		this.appliedids = appliedids;
	}
	public void addAppliedId(Long id) {
		appliedids.add(id);
	}
		
}
