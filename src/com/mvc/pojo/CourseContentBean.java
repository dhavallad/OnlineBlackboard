package com.mvc.pojo;

import java.util.Date;

public class CourseContentBean {
	private String contentid;
	private String contentname;
	private String contentdesc;
	private String contentpath;
	private Date postdate;
	private String courseid;
	
	
	
	
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	public String getContentid() {
		return contentid;
	}
	public void setContentid(String contentid) {
		this.contentid = contentid;
	}
	public String getContentname() {
		return contentname;
	}
	public void setContentname(String contentname) {
		this.contentname = contentname;
	}
	public String getContentdesc() {
		return contentdesc;
	}
	public void setContentdesc(String contentdesc) {
		this.contentdesc = contentdesc;
	}
	public String getContentpath() {
		return contentpath;
	}
	public void setContentpath(String contentpath) {
		this.contentpath = contentpath;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
	
}
