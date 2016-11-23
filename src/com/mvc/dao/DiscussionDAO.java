package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mvc.pojo.QuestionBean;
import com.mvc.util.DBConnection;

public class DiscussionDAO {
	
	Statement s = null;

	public boolean PostQuestion(QuestionBean question) {

		String question1 = question.getQuestion();
		String userid = question.getUserid();
		String courseid = question.getCourseid();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String postdate = dateFormat.format(date);

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConnection();
			String query = "insert into tblDiscussionQue(question,postdate,courseid,userid) values (?,?,?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, question1);
			preparedStatement.setString(2, postdate);
			preparedStatement.setString(3, userid);
			preparedStatement.setString(4, courseid);
			int flag = preparedStatement.executeUpdate();

			if (flag != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	public ArrayList LoadQuestions() {
		Connection conn = null;
		try {
			conn = DBConnection.getConnection();
			s = conn.createStatement();
			ArrayList<QuestionBean> questionsArray = new ArrayList<QuestionBean>();
			String query = "select * from tblDiscussionQue,tblUsers where tblDiscussionQue.userid = tblUsers.userid";
			ResultSet rs = s.executeQuery(query);

			while (rs.next()) {
				QuestionBean cm = new QuestionBean();
				cm.setQuesitonid(rs.getString("questionid"));
				cm.setQuestion(rs.getString("question"));
				cm.setPostdate(rs.getDate("postdate"));
				cm.setCourseid(rs.getString("courseid"));
				cm.setUser_firstname(rs.getString("tblUsers.firstname"));
				cm.setUser_lastname(rs.getString("tblUsers.lastname"));
				questionsArray.add(cm);
			}
			return questionsArray;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public boolean deleteQuestion(String questionid) {
		
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConnection();
			String query = "DELETE FROM tblDiscussionQue WHERE questionid= ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, questionid);
			
			int flag = preparedStatement.executeUpdate();

			if (flag != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}


}
