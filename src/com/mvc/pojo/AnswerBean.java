package com.mvc.pojo;

import java.util.Date;

public class AnswerBean {
	
	private String answerrid;
	private String answer;
	private String userid;
	private Date postdate;
	private String user_firstname;
	private String user_lastname;
	private String questionid;
	
	
	
	public String getQuestionid() {
		return questionid;
	}
	public void setQuestionid(String questionid) {
		this.questionid = questionid;
	}
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
	public String getAnswerrid() {
		return answerrid;
	}
	public void setAnswerrid(String answerrid) {
		this.answerrid = answerrid;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getPostdate() {
		return postdate;
	}
	public void setPostdate(Date postdate) {
		this.postdate = postdate;
	}
}
