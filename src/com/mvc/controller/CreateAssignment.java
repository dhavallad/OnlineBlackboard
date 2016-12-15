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
 * Servlet implementation class CreateAssignment
 */
@WebServlet("/CreateAssignment")
public class CreateAssignment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreateAssignment() {
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
		HttpSession session = request.getSession();
		if (session.getAttribute("session_userid") != null) {
			request.getRequestDispatcher("/createasignmentquestion.jsp").forward(request, response);
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
		// doGet(request, response);
		HttpSession session = request.getSession();
		if (session.getAttribute("session_userid") != null) {
			String assignmentname = request.getParameter("assignmentname");
			String courseid = session.getAttribute("session_courseid").toString();

			String assignmentdesc = request.getParameter("assignmentdesc");
			String question1 = request.getParameter("question1");
			String q1option1 = request.getParameter("1option1");
			String q1option2 = request.getParameter("1option2");
			String q1option3 = request.getParameter("1option3");
			String q1option4 = request.getParameter("1option4");
			String question2 = request.getParameter("question2");
			String q2option1 = request.getParameter("2option1");
			String q2option2 = request.getParameter("2option2");
			String q2option3 = request.getParameter("2option3");
			String q2option4 = request.getParameter("2option4");

			AssignmentBean assignment = new AssignmentBean();
			assignment.setName(assignmentname);
			assignment.setDesc(assignmentdesc);
			assignment.setQuestion1(question1);
			assignment.setQ1_option1(q1option1);
			assignment.setQ1_option2(q1option2);
			assignment.setQ1_option3(q1option3);
			assignment.setQ1_option4(q1option4);
			assignment.setQuestion2(question2);
			assignment.setQ2_option1(q2option1);
			assignment.setQ2_option2(q2option2);
			assignment.setQ2_option3(q2option3);
			assignment.setQ2_option4(q2option4);
			assignment.setOfcourseid(courseid);

			AssignmentDAO assignmentdao = new AssignmentDAO();

			boolean isAssigmentNameAvaliable = assignmentdao.isAssigmentExists(assignmentname);

			if (isAssigmentNameAvaliable) {
				boolean createAssignmentFlag = assignmentdao.createAssignment(assignment);

				if (createAssignmentFlag) {
					System.out.println("Assignemnt Created successfully..." + getClass());
					request.getSession().setAttribute("assignmentlistmessage", "Assignment Created Successfully.");
					response.sendRedirect("Assignments?courseid=" + courseid);
				} else {
					System.out.println("Oops!! Something went wrong. Assignemnt not created." + getClass());
					request.getSession().setAttribute("assignmentlistmessage",
							"Oops!! Something went wrong. Assignment not created.");
					response.sendRedirect("Assignments?courseid=" + courseid);
				}

			} else {
				System.out.println("Assignemnt already exists..." + getClass());
				request.getSession().setAttribute("assignmentlistmessage", "Sorry!!! Assignment already exists.");
				response.sendRedirect("Assignments?courseid=" + courseid);
			}

		} else {
			System.out.println("Session not set.");
			request.setAttribute("loginpageMessage", "Please login first to access page.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);

		}
	}

}
