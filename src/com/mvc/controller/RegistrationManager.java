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

import com.mvc.dao.RegistrationDAO;
import com.mvc.pojo.RegistrationBean;

/**
 * Servlet implementation class RegistrationManager
 */
@WebServlet("/RegistrationManager")
public class RegistrationManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RegistrationManager() {
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
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/register.jsp").forward(request, response);
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
//			System.out.println("After formatting"+dob);
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
		System.out.println(firstname + " - " + lastname + " - " + email + " - " + isStudent + "||"+isStu(isStudent)+ " - " + dob
				+ " - " + phone + " - " + password);

		RegistrationDAO registerDao = new RegistrationDAO();
		System.out.println(email);
		boolean isAvaliable = registerDao.isEmailAvaliable(email);
		System.out.println("isAvaliable"+isAvaliable);
		if(!isAvaliable){
			request.setAttribute("loginpageMessage","Email id already exists.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		
				// } catch (ClassNotFoundException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		
		
	}
	public Boolean isStu(String str) {
		if(str.equals("1"))
			return true;
		return false;
		
		// TODO Auto-generated constructor stub
	}

}
