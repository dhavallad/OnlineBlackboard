package com.mvc.pojo;

public class LoginBean {
	private String email;
	private String password;
	private String loginusr_firstname;
	private String loginusr_lastname;
	private String loginusr_userid;
	
	
	public String getEmail() {
		return email;
	}
	public String getLoginusr_firstname() {
		return loginusr_firstname;
	}
	public void setLoginusr_firstname(String loginusr_firstname) {
		this.loginusr_firstname = loginusr_firstname;
	}
	public String getLoginusr_lastname() {
		return loginusr_lastname;
	}
	public void setLoginusr_lastname(String loginusr_lastname) {
		this.loginusr_lastname = loginusr_lastname;
	}
	public String getLoginusr_userid() {
		return loginusr_userid;
	}
	public void setLoginusr_userid(String loginusr_userid) {
		this.loginusr_userid = loginusr_userid;
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
}
