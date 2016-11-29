package com.mvc.pojo;

import java.util.Date;

public class CourseBean {
	private String courseid;
	private String coursename;
	private String coursecode;
	private String coursedesc;
	private String maxstudent;
	private String instructorid;
	
	
	public String getInstructorid() {
		return instructorid;
	}
	public void setInstructorid(String instructorid) {
		this.instructorid = instructorid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	private Date startdate;
	private Date enddate;
	
	public String getMaxstudent() {
		return maxstudent;
	}
	public void setMaxstudent(String maxstudent) {
		this.maxstudent = maxstudent;
	}
	public String getCoursename() {
		return coursename;
	}
	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}
	public String getCoursedesc() {
		return coursedesc;
	}
	public void setCoursedesc(String coursedesc) {
		this.coursedesc = coursedesc;
	}
	public Date getStartdate() {
		return startdate;
	}
	public void setStartdate(Date startdate) {
		this.startdate = startdate;
	}
	public Date getEnddate() {
		return enddate;
	}
	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}
	public String getCoursecode() {
		return coursecode;
	}
	public void setCoursecode(String coursecode) {
		this.coursecode = coursecode;
	}
	
}
