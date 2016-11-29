package com.mvc.controller;

import java.io.IOException;

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
import com.mvc.pojo.RegistrationBean;

/**
 * Servlet implementation class ViewCourse
 */
@WebServlet({"/Course","/Course?courseid="})
public class Course extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Course() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		if(session!=null){
			String courseid = request.getParameter("courseid");
			CourseDAO coursedao = new CourseDAO();
			CourseBean courseInfo = coursedao.getSingleCourse(courseid);
			session.setAttribute("session_courseid",courseid);
			session.setAttribute("session_coursename",courseInfo.getCoursename());
			
			RegistrationDAO regdao = new RegistrationDAO();
			RegistrationBean user = regdao.getUserInfo(courseInfo.getInstructorid());
			
			System.out.println(courseInfo.getCoursename());
			request.setAttribute("courseInfo", courseInfo);
			request.setAttribute("instructorInfo", user);
//			System.out.println(courseInfo.getCoursename());
			RequestDispatcher rd = request.getRequestDispatcher("courseinfo.jsp");
			rd.forward(request, response);	
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
