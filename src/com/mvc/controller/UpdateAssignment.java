package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.AssignmentDAO;
import com.mvc.pojo.AssignmentBean;

/**
 * Servlet implementation class UpdateAssignment
 */
@WebServlet({ "/UpdateAssignment", "/UpdateAssignment?action=delete&assignmentid=" })
public class UpdateAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateAssignment() {
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
		if (session.getAttribute("session_userid") != null) {
			System.out.println("upadteassib");
			String id = request.getParameter("assignmentid");
			if (request.getParameter("action").equals("delete")) {
				boolean flag = deleteAssignment(id);
				if (flag) {
					// request.setAttribute("errormess", "Assignment Deleted
					// Successfully.");
					// request.getRequestDispatcher("Assignments?courseid="+session.getAttribute("session_courseid")).forward(request,
					// response);
					request.getSession().setAttribute("assignmentlistmessage", "Assignment Deleted Successfully.");
					response.sendRedirect("Assignments?courseid=" + session.getAttribute("session_courseid"));
					// response.sendRedirect("Assignments?courseid="+session.getAttribute("session_courseid"));
				}
			}
		} else {
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

	public boolean deleteAssignment(String assignmentid) {

		AssignmentDAO dao = new AssignmentDAO();
		boolean isDelete = dao.deleteAssignment(assignmentid);
		if (isDelete) {
			System.out.println("Delete Successfully.");
			return true;
		}
		return false;

	}

}
