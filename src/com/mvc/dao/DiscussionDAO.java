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

import com.mvc.pojo.AnswerBean;
import com.mvc.pojo.QuestionBean;
import com.mvc.util.DBConnection;

public class DiscussionDAO {

	// public static void main(String argc[]) {
	// // new DiscussionDAO().getQuestion("3");
	// // new DiscussionDAO().deleteQuestion("7");
	//// new DiscussionDAO().getAnswers("3");
	// }

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
			preparedStatement.setString(3, courseid);
			preparedStatement.setString(4, userid);

			int flag = preparedStatement.executeUpdate();

			if (flag != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean PostAnswer(AnswerBean answer) {

		System.out.println(getClass());
		String ans = answer.getAnswer();
		String userid = answer.getUserid();
		String courseid = answer.getQuestionid();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String postdate = dateFormat.format(date);

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConnection();
			String query = "insert into tblDiscussionAnswer(replyanswer,postdate,userid,questionid) values (?,?,?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, ans);
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

	public ArrayList LoadQuestions(String courseid) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = DBConnection.getConnection();
			s = conn.createStatement();
			ArrayList<QuestionBean> questionsArray = new ArrayList<QuestionBean>();
			String query = "select * from tblDiscussionQue,tblUsers where tblDiscussionQue.userid = tblUsers.userid and TermProject.tblDiscussionQue.courseid = ? ORDER BY tblDiscussionQue.postdate DESC, tblDiscussionQue.questionid DESC";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, courseid);
			ResultSet rs = preparedStatement.executeQuery();

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

	public QuestionBean getQuestionInfo(String questionid) {
		Connection conn = null;
		System.out.println(questionid);
		QuestionBean cm = new QuestionBean();
		PreparedStatement preparedStatement = null;
		try {
			conn = DBConnection.getConnection();
			s = conn.createStatement();
			String query = "select * from tblDiscussionQue,tblUsers where tblDiscussionQue.userid = tblUsers.userid and tblDiscussionQue.questionid = ?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(questionid));
			System.out.println(preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				cm.setQuesitonid(rs.getString("questionid"));
				cm.setQuestion(rs.getString("question"));
				cm.setPostdate(rs.getDate("postdate"));
				cm.setUser_firstname(rs.getString("firstname"));
				cm.setUser_lastname(rs.getString("lastname"));
				// System.out.println(rs.getString("question"));
			}
			return cm;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<AnswerBean> getAnswers(String questionid) {
		Connection conn = null;
		System.out.println(questionid);
		ArrayList<AnswerBean> answersArray = new ArrayList<AnswerBean>();
		PreparedStatement preparedStatement = null;
		try {
			conn = DBConnection.getConnection();
			s = conn.createStatement();
			String query = "select * from tblDiscussionAnswer,tblUsers where tblDiscussionAnswer.questionid = ? and tblDiscussionAnswer.userid = tblUsers.userid ORDER BY tblDiscussionAnswer.postdate DESC, tblDiscussionAnswer.id DESC";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(questionid));
			System.out.println(preparedStatement.toString());
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				AnswerBean answer = new AnswerBean();
				answer.setAnswerrid(rs.getString("id"));
				answer.setAnswer(rs.getString("replyanswer"));
				System.out.println(rs.getString("replyanswer"));
				answer.setUserid(rs.getString("userid"));
				answer.setPostdate(rs.getDate("postdate"));
				answer.setUser_firstname(rs.getString("firstname"));
				answer.setUser_lastname(rs.getString("lastname"));
				answersArray.add(answer);
			}
			return answersArray;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean deleteDiscussion(String id) {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConnection();
			String query = "DELETE FROM tblDiscussionQue WHERE questionid= ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, id);
			int flag = preparedStatement.executeUpdate();
			
			String query1 = "DELETE FROM tblDiscussionAnswer WHERE questionid= ?";
			preparedStatement = con.prepareStatement(query1);
			preparedStatement.setString(1, id);
			int flag1 = preparedStatement.executeUpdate();

			if (flag != 0 && flag1 != 0){
				System.out.println("Deleted inside both flag");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}
	
	
	public boolean deleteDiscussionAnswer(String id) {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConnection();
			String query = "DELETE FROM tblDiscussionAnswer WHERE id= ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, id);
			int flag = preparedStatement.executeUpdate();
	
			if (flag != 0){
				System.out.println("Deleted inside both flag");
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

}
