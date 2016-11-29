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

import com.mvc.pojo.CourseBean;
import com.mvc.pojo.CourseContentBean;
import com.mvc.pojo.RegistrationBean;
import com.mvc.util.DBConnection;

public class CourseDAO {

	Statement s = null;

	public boolean CreateCourse(CourseBean course) {

		String coursename = course.getCoursename();
		String coursecode = course.getCoursecode();
		String coursedesc = course.getCoursedesc();
		String maxstudent = course.getMaxstudent();
		String instructorid = course.getInstructorid();
		Date tempstartdate = course.getStartdate();
		Date tempenddate = course.getEnddate();

		String startdate = new SimpleDateFormat("yyyy-MM-dd").format(tempstartdate);
		String enddate = new SimpleDateFormat("yyyy-MM-dd").format(tempenddate);

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {

			con = DBConnection.getConnection();
			String query = "insert into tblCourse(coursename,coursedesc,max_student,startdate,enddate,coursecode,instructorid) values (?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, coursename);
			preparedStatement.setString(2, coursedesc);
			preparedStatement.setString(3, maxstudent);
			preparedStatement.setString(4, startdate);
			preparedStatement.setString(5, enddate);
			preparedStatement.setString(6, coursecode);
			preparedStatement.setString(7, instructorid);

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
				// System.out.println(rs.getString("course/name"));
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

	public ArrayList<CourseBean> getInstructorCourse(String instructorid) {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConnection();
			ArrayList<CourseBean> courseTeaches = new ArrayList<CourseBean>();
			String query = "select * from tblCourse where instructorid = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, instructorid);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				// System.out.println(rs.getString("course/name"));
				CourseBean cm = new CourseBean();
				cm.setCourseid(rs.getString("courseid"));
				cm.setCoursename(rs.getString("coursename"));
				cm.setCoursedesc(rs.getString("coursedesc"));
				cm.setCoursecode(rs.getString("coursecode"));
				// cm.setMaxstudent(rs.getString("max_student"));
				// cm.setStartdate(rs.getDate("startdate"));
				// cm.setEnddate(rs.getDate("enddate"));
				courseTeaches.add(cm);

			}
			return courseTeaches;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public CourseBean getSingleCourse(String courseid) {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConnection();
			CourseBean courseinfo = new CourseBean();
			String query = "select * from tblCourse where courseid = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, courseid);
			ResultSet rs = preparedStatement.executeQuery();

			if (rs.next()) {
				// System.out.println(rs.getString("course/name"));
				courseinfo.setCourseid(rs.getString("courseid"));
				System.out.println(rs.getString("coursename"));
				courseinfo.setCoursename(rs.getString("coursename"));
				courseinfo.setCoursedesc(rs.getString("coursedesc"));
				courseinfo.setCoursecode(rs.getString("coursecode"));
				courseinfo.setMaxstudent(rs.getString("max_student"));
				courseinfo.setStartdate(rs.getDate("startdate"));
				courseinfo.setEnddate(rs.getDate("enddate"));
				courseinfo.setInstructorid(rs.getString("instructorid"));
			}

			return courseinfo;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean insertFilePath(CourseContentBean file) {

		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		String postdate = dateFormat.format(date);
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {

			con = DBConnection.getConnection();
			String query = "insert into tblCourseContent(contentname,contentdetail,contentfilename,uploadate,courseid) values (?,?,?,?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, file.getContentname());
			preparedStatement.setString(2, file.getContentdesc());
			preparedStatement.setString(3, file.getContentpath());
			preparedStatement.setString(4, postdate);
			preparedStatement.setString(5, file.getCourseid());

			int i = preparedStatement.executeUpdate();

			if (i != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean isCourseCreated(String coursecode) {
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConnection();
			String query = "select * from tblCourse where coursecode = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, coursecode);
			ResultSet rs = preparedStatement.executeQuery();
			RegistrationBean user = new RegistrationBean();
			if (rs.next()) {
				System.out.println("Course already exits" + getClass());
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ArrayList<CourseContentBean> getCourseContentList(String courseid) {
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConnection();
			ArrayList<CourseContentBean> contentList = new ArrayList<CourseContentBean>();
			String query = "select * from tblCourseContent where courseid = ? ORDER BY uploadate DESC ,contentid DESC";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, courseid);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				// System.out.println(rs.getString("course/name"));
				CourseContentBean cm = new CourseContentBean();
				cm.setContentid(rs.getString("contentid"));
				cm.setContentname(rs.getString("contentname"));
				cm.setContentdesc(rs.getString("contentdetail"));
				cm.setContentpath(rs.getString("contentfilename"));
				cm.setPostdate(rs.getDate("uploadate"));
				
				contentList.add(cm);

			}
			return contentList;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
	
	public CourseContentBean getContent(String contentid) {
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConnection();
			String query = "select * from tblCourseContent where contentid = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, contentid);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				// System.out.println(rs.getString("course/name"));
				CourseContentBean cm = new CourseContentBean();
//				cm.setContentid(rs.getString("contentid"));
				cm.setContentname(rs.getString("contentname"));
				cm.setContentdesc(rs.getString("contentdetail"));
				cm.setContentpath(rs.getString("contentfilename"));
				cm.setPostdate(rs.getDate("uploadate"));
				return cm;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}
	
	
	public boolean deleteContent(String id) {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConnection();
			String query = "DELETE FROM tblCourseContent WHERE contentid= ?";
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

	// public ResultSet selectcourse() throws SQLException {
	// System.out.println("ini");
	// String query = "select * from tblCourse";
	// return s.executeQuery(query);
	// }

}
