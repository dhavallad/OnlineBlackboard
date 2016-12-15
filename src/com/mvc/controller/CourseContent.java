package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.CourseDAO;
import com.mvc.dao.RegistrationDAO;
import com.mvc.pojo.CourseBean;
import com.mvc.pojo.CourseContentBean;
import com.mvc.pojo.RegistrationBean;

/**
 * Servlet implementation class CourseContent
 */
@WebServlet({ "/CourseContent", "/CourseContent?courseid=" })
public class CourseContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseContent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String courseid = request.getParameter("courseid");
		HttpSession session = request.getSession();
		if (session.getAttribute("session_userid") != null) {
			ArrayList<CourseContentBean> contentList = new ArrayList<CourseContentBean>();
			CourseDAO coursedao = new CourseDAO();
			contentList = coursedao.getCourseContentList(courseid);

			request.setAttribute("contentlist", contentList);
			RequestDispatcher rd = request.getRequestDispatcher("coursecontent.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("Session not set.");
			request.setAttribute("loginpageMessage", "Please login first to access page.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
