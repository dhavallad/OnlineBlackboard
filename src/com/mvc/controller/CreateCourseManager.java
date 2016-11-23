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

import com.mvc.dao.CourseDAO;
import com.mvc.pojo.CourseBean;

/**
 * Servlet implementation class CreateCourseManager
 */
@WebServlet("/CreateCourseManager")
public class CreateCourseManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateCourseManager() {
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
		String coursename = request.getParameter("coursename");
		String coursedesc = request.getParameter("coursedesc");
		String maxstudent = request.getParameter("maxseats");
		String tempstartdate = request.getParameter("coursestart");
		String tempenddate = request.getParameter("courseend");

		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		Date startdate = null;
		Date enddate = null;

		try {
			startdate = df.parse(tempstartdate);
			enddate = df.parse(tempenddate);
			// System.out.println("After formatting"+dob);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		CourseBean course = new CourseBean();
		course.setCoursename(coursename);
		course.setCoursedesc(coursedesc);
		course.setMaxstudent(maxstudent);
		course.setStartdate(startdate);
		course.setEnddate(enddate);

		CourseDAO coursedao = new CourseDAO();
		boolean createCourseFlag = coursedao.CreateCourse(course);
		if (createCourseFlag) {
			request.setAttribute("loginpageMessage", "Course Created successfully.");
			System.out.println("Course Created successfully.....");
			request.getRequestDispatcher("/success.html").forward(request, response);
		} else // On Failure, display a meaningful message to the User.
		{
			System.out.println("Oops!! Something went wrong. COurse not created.");
			request.setAttribute("error", "Oops!! Something went wrong.");
			request.getRequestDispatcher("/error.html").forward(request, response);
		}

	}

}
