package com.mvc.pojo;

import java.util.Date;

public class QuestionBean {
	private String quesitonid;
	private String question;
	private String userid;
	private Date postdate;
	private String courseid;
	private String user_firstname;
	private String user_lastname;
	
	public String getUser_firstname() {
		return user_firstname;
	}
	public void setUser_firstname(String user_firstname) {
		this.user_firstname = user_firstname;
	}
	public String getUser_lastname() {
		return user_lastname;
	}
	public void setUser_lastname(String user_lastname) {
		this.user_lastname = user_lastname;
	}
	public String getQuestion() {
		return question;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	public String getQuesitonid() {
		return quesitonid;
	}
	public void setQuesitonid(String quesitonid) {
		this.quesitonid = quesitonid;
	}
		
	
	
}
