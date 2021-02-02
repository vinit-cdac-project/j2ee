package com.app.registration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
	
@Id
private int id;
private String emailId;
private String user_name;
private String password;

public User() {
	
}


public User(int id, String emailid, String user_name, String password) {
	super();
	this.id = id;
	this.emailId = emailid;
	this.user_name = user_name;
	this.password = password;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}
public String getEmailid() {
	return emailId;
}
public void setEmailid(String emailid) {
	this.emailId = emailid;
}
public String getUser_name() {
	return user_name;
}
public void setUserName(String user_name) {
	this.user_name = user_name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
