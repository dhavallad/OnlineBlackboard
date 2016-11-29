package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.AssignmentDAO;
import com.mvc.dao.CourseDAO;

/**
 * Servlet implementation class UpdateCourseContent
 */
@WebServlet({"/UpdateCourseContent","/UpdateCourseContent?contentid="})
public class UpdateCourseContent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateCourseContent() {
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
		// response.getWriter().append("Served at:
		// ").append(request.getContextPath());
		HttpSession session = request.getSession();
		if (session != null) {
			System.out.println("upadteassib");
			String id = request.getParameter("contenid");
			if (request.getParameter("action").equals("delete")) {
				boolean flag = deleteContent(id);
				if (flag) {
//					request.setAttribute("errormess", "Content Deleted Successfully.");
//					request.getRequestDispatcher("Assignments?courseid=" + session.getAttribute("session_courseid")).forward(request, response);
					request.getSession().setAttribute("contentpagemessage", "Content Deleted Successfully.");
					response.sendRedirect("CourseContent?courseid="+session.getAttribute("session_courseid"));
				}
			}
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
	
	
	public boolean deleteContent(String assignmentid) {

		CourseDAO dao = new CourseDAO();
		boolean isDelete = dao.deleteContent(assignmentid);
		if (isDelete) {
			System.out.println("Content Delete Successfully.");
			return true;
		}
		return false;

	}


}
