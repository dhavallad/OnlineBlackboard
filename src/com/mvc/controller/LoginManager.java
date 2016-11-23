package com.mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.LoginDAO;
import com.mvc.pojo.LoginBean;
import com.mvc.pojo.RegistrationBean;

/**
 * Servlet implementation class LoginManager
 */
@WebServlet("/LoginManager")
public class LoginManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);

		String email = request.getParameter("username");
		String password = request.getParameter("password");

		System.out.println(email + "\\\\\\\\\\\\\\\\" + password);

		LoginBean loginUser = new LoginBean();
		loginUser.setEmail(email);
		loginUser.setPassword(password);

		LoginDAO logindao = new LoginDAO();
		RegistrationBean loggeduser = logindao.AuthUser(loginUser);
//		boolean userValidate = logindao.AuthUser(loginUser);

		if (loggeduser != null) {
			request.setAttribute("loggeduser", loggeduser);
			System.out.println("----------Login Sucucessfully");
//			response.sendRedirect("home.jsp");
			request.getRequestDispatcher("/home.jsp").forward(request, response);
		} else {
			System.out.println("----------Login Failed.");
			request.setAttribute("loginpageMessage", "Invalid user credentials.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
