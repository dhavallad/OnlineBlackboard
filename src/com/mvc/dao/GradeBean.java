package com.mvc.dao;

import java.util.ArrayList;

public class GradeBean {
	private String user_firstname;
	private String user_lastname;
	private String assignmentid;
	private String grade;
	private ArrayList assingmentid;

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

	public String getAssignmentid() {
		return assignmentid;
	}

	public void setAssignmentid(String assignmentid) {
		this.assignmentid = assignmentid;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
