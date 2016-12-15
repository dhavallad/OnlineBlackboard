package com.mvc.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.RegistrationDAO;
import com.mvc.pojo.RegistrationBean;

/**
 * Servlet implementation class Registration
 */
@WebServlet("/Registration")
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Registration() {
		super();
		System.out.println("Inside Registration.");
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(getClass());
		request.getRequestDispatcher("/register.jsp").forward(request, response);

		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println(getClass());

		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String email = request.getParameter("email");
		String isStudent = request.getParameter("optionyes");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");

		String tempdob = request.getParameter("dob");

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date dob = null;

		try {
			dob = df.parse(tempdob);
			// System.out.println("After formatting"+dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		RegistrationBean registerBean = new RegistrationBean();
		registerBean.setFirstName(firstname);
		registerBean.setLastName(lastname);
		registerBean.setEmail(email);
		registerBean.setIsStudent(isStu(isStudent));
		registerBean.setPassword(password);
		registerBean.setPhoneno(phone);
		registerBean.setDob(dob);

		System.out.println("Inside RegManager..");
		System.out.println(firstname + " - " + lastname + " - " + email + " - " + isStudent + "||" + isStu(isStudent)
				+ " - " + dob + " - " + phone + " - " + password);

		RegistrationDAO registerDao = new RegistrationDAO();
		System.out.println(email);
		boolean isAvaliable = registerDao.isEmailAvaliable(email);
		System.out.println("isAvaliable" + isAvaliable);
		if (!isAvaliable) {
			System.out.println("inside isaval");
			request.setAttribute("error", "Email id already exists.");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		} else {
			boolean registerFlag = registerDao.registerUser(registerBean);
			if (registerFlag) {
				request.setAttribute("loginpageMessage", "Register Successfully. Please login.");
				System.out.println("inside registrflag true");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			} else {
				System.out.println("inside registrflag false");
				request.setAttribute("message", "Oops!! Something wrong.");
				request.getRequestDispatcher("/register.jsp").forward(request, response);
			}
		}
	}

	public Boolean isStu(String str) {
		if (str.equals("1"))
			return true;
		return false;

		// TODO Auto-generated constructor stub
	}

}
