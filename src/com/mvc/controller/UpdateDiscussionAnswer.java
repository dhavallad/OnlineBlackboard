package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.DiscussionDAO;

/**
 * Servlet implementation class UpdateDiscussionAnswer
 */
@WebServlet({ "/UpdateDiscussionAnswer", "/UpdateDiscussionAnswer?action=delete&answerid=" })
public class UpdateDiscussionAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateDiscussionAnswer() {
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
			System.out.println("Inside" + getClass());
			String id = request.getParameter("answerid");
			if (request.getParameter("action").equals("delete")) {
				boolean flag = deleteAnswer(id);
				if (flag) {
					request.getSession().setAttribute("questiondiscussionpagemessage", "Answer deleted successfully.");
					response.sendRedirect(
							"QuestionDiscussion?questionid=" + session.getAttribute("session_questionid"));
				} else {
					request.getSession().setAttribute("questiondiscussionpagemessage", "Oops!! Something went wrong.");
					response.sendRedirect(
							"QuestionDiscussion?questionid=" + session.getAttribute("session_questionid"));
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

	public boolean deleteAnswer(String answerid) {

		DiscussionDAO dao = new DiscussionDAO();
		boolean isDelete = dao.deleteDiscussionAnswer(answerid);
		if (isDelete) {
			System.out.println("Answer Deleted.");
			return true;
		}
		System.out.println("Ooops!! Answer not deleted.");
		return false;

	}
}
