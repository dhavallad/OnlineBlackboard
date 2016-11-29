package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.AssignmentDAO;
import com.mvc.pojo.AssignmentBean;
import com.mvc.pojo.CourseBean;

/**
 * Servlet implementation class ViewAssignment
 * 
 */
@WebServlet({ "/ViewAssignment", "/ViewAssignment?assignmentid=" })
public class ViewAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ViewAssignment() {
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
		// System.out.println("Asdaskjdhaskd");
		String assignmentid = request.getParameter("assignmentid");
		System.out.println(assignmentid + getClass());
		AssignmentDAO dao = new AssignmentDAO();
		AssignmentBean assignment = dao.getAssignment(assignmentid);
		request.setAttribute("assignmentInfo", assignment);
		RequestDispatcher rd = request.getRequestDispatcher("assignmentinfo.jsp");
		rd.forward(request, response);
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
