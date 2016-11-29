package com.mvc.dao;

import java.nio.file.attribute.UserPrincipalLookupService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mvc.pojo.RegistrationBean;
import com.mvc.util.DBConnection;

public class RegistrationDAO {
	
	public static void main(String[] args) {
		System.out.println(new RegistrationDAO().isEmailAvaliable("dd@albany.edu"));
	}

	public boolean registerUser(RegistrationBean registerUser) {
		String firstname = registerUser.getFirstName();
		String lastname = registerUser.getLastName();
		String email = registerUser.getEmail();
		Boolean isStudent = registerUser.getIsStudent();
		String password = registerUser.getPassword();
		String phone = registerUser.getPhoneno();
		Date dob = registerUser.getDob();

		String format_dob = new SimpleDateFormat("yyyy-MM-dd").format(dob);
		// System.out.println("Inside RegDAO.."+new
		// SimpleDateFormat("yyyy-MM-dd").format(dob));
		System.out.println(firstname + " - " + lastname + " - " + email + " - " + password + " - " + format_dob + " - "
				+ phone + " - " + isStudent);

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {

			con = DBConnection.getConnection();
			String query = "insert into tblUsers(firstname,lastname,email,password,dob,phoneno,isStudent) values (?,?,?,?,?,?,?)";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, firstname);
			preparedStatement.setString(2, lastname);
			preparedStatement.setString(3, email);
			preparedStatement.setString(4, password);
			preparedStatement.setString(5, format_dob);
			preparedStatement.setString(6, phone);
			preparedStatement.setInt(7, student_boolToInt(isStudent));

			int i = preparedStatement.executeUpdate();

			if (i != 0)
				return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public boolean isEmailAvaliable(String email) {
		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {
			con = DBConnection.getConnection();
			String query = "select * from tblUsers where email = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, email);
			ResultSet rs = preparedStatement.executeQuery();
			RegistrationBean user = new RegistrationBean();
			if (rs.next()) {
				System.out.println("email already exits"+getClass());
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public RegistrationBean getUserInfo(String userid) {

		Connection con = null;
		PreparedStatement preparedStatement = null;

		try {

			con = DBConnection.getConnection();
			String query = "select * from tblUsers where userid = ?";
			preparedStatement = con.prepareStatement(query);
			preparedStatement.setString(1, userid);
			ResultSet rs = preparedStatement.executeQuery();
			RegistrationBean user = new RegistrationBean();
			if (rs.next()) {
				// System.out.println(rs.getString("course/name"));
				user.setFirstName(rs.getString("firstname"));
				user.setLastName(rs.getString("lastname"));
				user.setPhoneno(rs.getString("phoneno"));
				user.setEmail(rs.getString("email"));
				user.setDob(rs.getDate("dob"));
			}

			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public int student_boolToInt(Boolean bool) {
		if (bool)
			return 1;
		return 0;

		// TODO Auto-generated constructor stub
	}
}
