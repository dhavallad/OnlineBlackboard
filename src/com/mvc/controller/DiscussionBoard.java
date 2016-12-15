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

import com.mvc.dao.AssignmentDAO;
import com.mvc.dao.DiscussionDAO;
import com.mvc.pojo.AssignmentBean;
import com.mvc.pojo.QuestionBean;

/**
 * Servlet implementation class DiscussionBoard
 */
@WebServlet({ "/DiscussionBoard", "/DiscussionBoard?courseid=" })
public class DiscussionBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DiscussionBoard() {
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
			String courseid = request.getParameter("courseid");
			System.out.println(request.getParameter("courseid") + getClass());

			ArrayList<QuestionBean> questionList = new ArrayList<QuestionBean>();
			DiscussionDAO discussiondao = new DiscussionDAO();

			questionList = discussiondao.LoadQuestions(courseid);
			request.setAttribute("questionList", questionList);
			RequestDispatcher rd = request.getRequestDispatcher("discussionlist.jsp");
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
