package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fname;
	private String lname;
	private String email;
	private String password;
	private Integer classstanding;
	private String major;
	private String phonenumber;
	private String resumeurl;
	
	public User(String fname , String lname , String email, String password, Integer classstanding , String major , String phonenumber , String resumeurl) {
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.classstanding = classstanding;
        this.major = major;
        this.phonenumber = phonenumber;
        this.resumeurl = resumeurl;
    }
	
	public User() {}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getclassstanding() {
		return classstanding;
	}
	public void setclassstanding(Integer classstanding) {
		this.classstanding = classstanding;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getphonenumber() {
		return phonenumber;
	}
	public void setphonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getResumeurl() {
		return resumeurl;
	}
	public void setResumeurl(String resumeurl) {
		this.resumeurl = resumeurl;
	}


	
	

}
