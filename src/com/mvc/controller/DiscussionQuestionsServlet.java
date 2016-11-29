package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.DiscussionDAO;
import com.mvc.pojo.QuestionBean;

import jdk.nashorn.internal.ir.RuntimeNode.Request;
import oracle.jrockit.jfr.events.RequestableEventEnvironment;

/**
 * Servlet implementation class DiscussionQuestionsServlet
 */
@WebServlet({"/DiscussionQuestionsServlet","/DiscussionQuestions?discussionid="})
public class DiscussionQuestionsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DiscussionQuestionsServlet() {
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
		String discussionid = request.getParameter("discussionid");
		System.out.println(discussionid);
		
		
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//		System.out.println(request.getParameter("id"));
//		
//		DiscussionDAO discussiondao = new DiscussionDAO();
//		boolean isDeleted = discussiondao.deleteQuestion(request.getParameter("id"));
//		if(isDeleted){
//			System.out.println("deleted");
//		}
//		else{
//			System.out.println("not deleted");
//		}
//		response.sendRedirect("discussion.jsp");
////		RequestDispatcher rd = request.getRequestDispatcher("discussion.jsp");
//		rd.forward(request, response);
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
		System.out.println("Asdasdasd");
		try {
			ArrayList<QuestionBean> viewcourse = new ArrayList<QuestionBean>();
			DiscussionDAO discussiondao = new DiscussionDAO();

//			viewcourse = discussiondao.LoadQuestions();
			// for (int i = 0; i < viewcourse.size(); i++) {
			// System.out.println("Servlet--"+viewcourse.get(i).getCoursename());
			//
			// }
			request.setAttribute("questions", viewcourse);
			RequestDispatcher rd = request.getRequestDispatcher("discussion.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
