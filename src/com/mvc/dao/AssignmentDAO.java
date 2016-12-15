package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mvc.pojo.AssignmentBean;
import com.mvc.pojo.CourseBean;
import com.mvc.util.DBConnection;

public class AssignmentDAO {

	// public static void main(String[] args) {
	//
	//
	// }

	public boolean isAssigmentExists(String name) {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {

			con = DBConnection.getConnection();
			String query = "select * from tblAssignment where assignmentname = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);

			ResultSet rs = preparedStatement.executeQuery();
			if (rs.next()) {
				System.out.println("Assignment already exits" + getClass());
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
	
	
	
	public boolean createAssignment(AssignmentBean assignment) {

		String name = assignment.getName();
		String stdesc = assignment.getDesc();
		String question1 = assignment.getQuestion1();
		String q1o1 = assignment.getQ1_option1();
		String q1o2 = assignment.getQ1_option2();
		String q1o3 = assignment.getQ1_option3();
		String q1o4 = assignment.getQ1_option4();
		String question2 = assignment.getQuestion2();
		String q2o1 = assignment.getQ2_option1();
		String q2o2 = assignment.getQ2_option2();
		String q2o3 = assignment.getQ2_option3();
		String q2o4 = assignment.getQ2_option4();
		String courseid = assignment.getOfcourseid();

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String posteddate = dateFormat.format(date);

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {

			con = DBConnection.getConnection();
			String query = "insert into tblAssignment(assignmentname,assignmentdesc,question1,1option1,1option2,1option3,1option4,question2,2option1,2option2,2option3,2option4,ofcourseid,postdate) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, name);
			preparedStatement.setString(2, stdesc);
			preparedStatement.setString(3, question1);
			preparedStatement.setString(4, q1o1);
			preparedStatement.setString(5, q1o2);
			preparedStatement.setString(6, q1o3);
			preparedStatement.setString(7, q1o4);
			preparedStatement.setString(8, question2);
			preparedStatement.setString(9, q2o1);
			preparedStatement.setString(10, q2o2);
			preparedStatement.setString(11, q2o3);
			preparedStatement.setString(12, q2o4);
			preparedStatement.setString(13, courseid);
			preparedStatement.setString(14, posteddate);
			//

			int i = preparedStatement.executeUpdate();

			if (i != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean deleteAssignment(String id) {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConnection();
			String query = "DELETE FROM tblAssignment WHERE assignmentid= ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, id);
			int flag = preparedStatement.executeUpdate();

			if (flag != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList<AssignmentBean> getAssignmentList(String courseid) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = DBConnection.getConnection();
			ArrayList<AssignmentBean> assignmentList = new ArrayList<AssignmentBean>();
			String query = "SELECT * FROM tblAssignment where ofcourseid = ? ORDER BY postdate DESC";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, courseid);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				// System.out.println(rs.getString("course/name"));
				AssignmentBean assignment = new AssignmentBean();
				assignment.setAssignmentid(rs.getString("assignmentid"));
				assignment.setName(rs.getString("assignmentname"));
				assignment.setDesc(rs.getString("assignmentdesc"));
				assignment.setPostdate(rs.getDate("postdate"));
				assignmentList.add(assignment);
			}
			return assignmentList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public AssignmentBean getAssignment(String assignmentid) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = DBConnection.getConnection();
			AssignmentBean assignment = new AssignmentBean();
			String query = "SELECT * FROM tblAssignment where assignmentid = ?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, assignmentid);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				// System.out.println(rs.getString("course/name"));
				assignment.setAssignmentid(rs.getString("assignmentid"));
				assignment.setName(rs.getString("assignmentname"));
				assignment.setDesc(rs.getString("assignmentdesc"));
				assignment.setQuestion1(rs.getString("question1"));
				assignment.setQ1_option1(rs.getString("1option1"));
				assignment.setQ1_option2(rs.getString("1option2"));
				assignment.setQ1_option3(rs.getString("1option3"));
				assignment.setQ1_option4(rs.getString("1option4"));
				assignment.setQuestion2(rs.getString("question2"));
				assignment.setQ2_option1(rs.getString("2option1"));
				assignment.setQ2_option2(rs.getString("2option2"));
				assignment.setQ2_option3(rs.getString("2option3"));
				assignment.setQ2_option4(rs.getString("2option4"));
				assignment.setPostdate(rs.getDate("postdate"));

			}
			return assignment;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
