package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mvc.pojo.RegistrationBean;
import com.mvc.util.DBConnection;
public class RegistrationDAO {
	public int registerUser(RegistrationBean registerUser) {
		String firstname = registerUser.getFirstName();
		String lastname = registerUser.getLastName();
		String email = registerUser.getEmail();
		Boolean isStudent = registerUser.getIsStudent();
		String password = registerUser.getPassword();
		String phone = registerUser.getPhoneno();
		Date dob = registerUser.getDob();
		
		String format_dob = new SimpleDateFormat("yyyy-MM-dd").format(dob);
//		System.out.println("Inside RegDAO.."+new SimpleDateFormat("yyyy-MM-dd").format(dob));
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
				return 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
		
		
		
	}


	public int student_boolToInt(Boolean bool) {
		if(bool)
			return 1;
		return 0;
		
		// TODO Auto-generated constructor stub
	}
}
