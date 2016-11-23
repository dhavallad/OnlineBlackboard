package com.mvc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mvc.pojo.LoginBean;
import com.mvc.pojo.RegistrationBean;
import com.mvc.util.DBConnection;

public class LoginDAO {

	public RegistrationBean AuthUser(LoginBean loginUser) {
		Connection con = null;
		con = DBConnection.getConnection();

		String email = loginUser.getEmail();
		String password = loginUser.getPassword();
		String userNameDB = "";
		String passwordDB = "";
		try {
			Statement statement = con.createStatement(); 
			ResultSet resultSet = statement.executeQuery("select * from tblUsers"); 

			while (resultSet.next()) 
			{
				userNameDB = resultSet.getString("email");
				passwordDB = resultSet.getString("password");
				if (email.equals(userNameDB) && password.equals(passwordDB)) {
					RegistrationBean loginuser = new RegistrationBean();
					loginuser.setFirstName(resultSet.getString("firstname"));
					loginuser.setLastName(resultSet.getString("lastname"));
					loginuser.setUserid(resultSet.getString("userid"));
					return loginuser; 
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
