package com.example.demo;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Application {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long applicationid;
	
	private Integer projectid;
	private Integer userid;
	@ElementCollection(targetClass=String.class)
	private List<String> applicationquestions;
	private String timestamp;
	
	public Long getApplicationid() {
		return applicationid;
	}
	
	public void setApplicationid(Long applicationid) {
		this.applicationid = applicationid;
	}
	public Integer getProjectid() {
		return projectid;
	}
	public void setProjectid(Integer projectid) {
		this.projectid = projectid;
	}
	public Integer getUserid() {
		return userid;
	}
	public void setUserid(Integer userid) {
		this.userid = userid;
	}
	public List<String> getApplicationquestions() {
		return applicationquestions;
	}
	public void setApplicationquestions(List<String> applicationquestions) {
		this.applicationquestions = applicationquestions;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
