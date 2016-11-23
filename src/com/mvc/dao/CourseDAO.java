package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import com.mvc.pojo.CourseBean;
import com.mvc.util.DBConnection;

public class CourseDAO {

	Statement s = null;

	public boolean CreateCourse(CourseBean course) {

		String coursename = course.getCoursename();
		String coursedesc = course.getCoursedesc();
		String maxstudent = course.getMaxstudent();
		Date tempstartdate = course.getStartdate();
		Date tempenddate = course.getEnddate();

		String startdate = new SimpleDateFormat("yyyy-MM-dd").format(tempstartdate);
		String enddate = new SimpleDateFormat("yyyy-MM-dd").format(tempenddate);

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {

			con = DBConnection.getConnection();
			String query = "insert into tblCourse(coursename,coursedesc,max_student,startdate,enddate) values (?,?,?,?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, coursename);
			preparedStatement.setString(2, coursedesc);
			preparedStatement.setString(3, maxstudent);
			preparedStatement.setString(4, startdate);
			preparedStatement.setString(5, enddate);

			int i = preparedStatement.executeUpdate();

			if (i != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public ArrayList<CourseBean> CourseStudentHasTaken(String studentid) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = DBConnection.getConnection();

			s = conn.createStatement();
			ArrayList<CourseBean> enrolledcourse = new ArrayList<CourseBean>();
			String query = "SELECT * FROM tblStudentTakes,tblUsers,tblCourse where tblUsers.userid = tblStudentTakes.studentid and tblStudentTakes.courseid = tblCourse.courseid and TermProject.tblStudentTakes.studentid = ?";
			preparedStatement = conn.prepareStatement(query);
			preparedStatement.setString(1, studentid);
			ResultSet rs = preparedStatement.executeQuery();
			
			while (rs.next()) {
//				System.out.println(rs.getString("course/name"));
				 CourseBean cm = new CourseBean();
				 cm.setCoursename(rs.getString("coursename"));
				 cm.setCoursedesc(rs.getString("coursedesc"));
				// cm.setMaxstudent(rs.getString("max_student"));
				// cm.setStartdate(rs.getDate("startdate"));
				// cm.setEnddate(rs.getDate("enddate"));
				 enrolledcourse.add(cm);

			}
			return enrolledcourse;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public ArrayList<CourseBean> ViewCourse() {
		Connection conn = null;

		try {
			conn = DBConnection.getConnection();
			s = conn.createStatement();
			ArrayList<CourseBean> viewcourse = new ArrayList<CourseBean>();
			String query = "select * from tblCourse";
			ResultSet rs = s.executeQuery(query);
			// System.out.println(rs.getRow());
			while (rs.next()) {
				CourseBean cm = new CourseBean();
				cm.setCoursename(rs.getString("coursename"));
				cm.setCoursedesc(rs.getString("coursedesc"));
				cm.setMaxstudent(rs.getString("max_student"));
				cm.setStartdate(rs.getDate("startdate"));
				cm.setEnddate(rs.getDate("enddate"));
				viewcourse.add(cm);

			}
			return viewcourse;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	// public ResultSet selectcourse() throws SQLException {
	// System.out.println("ini");
	// String query = "select * from tblCourse";
	// return s.executeQuery(query);
	// }

}
