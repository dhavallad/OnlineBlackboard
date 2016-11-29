package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.DiscussionDAO;
import com.mvc.pojo.AnswerBean;

/**
 * Servlet implementation class PostDiscussionAnswer
 */
@WebServlet("/PostDiscussionAnswer")
public class PostDiscussionAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostDiscussionAnswer() {
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		System.out.println(getClass());
		HttpSession session = request.getSession();
		if (session != null) {
			String answerdesc = request.getParameter("textareaanswer");
			String userid = session.getAttribute("session_userid").toString();
			String questionid = session.getAttribute("session_questionid").toString();
			System.out.println("Answer"+answerdesc+"Userid"+userid+"Questionid"+questionid);

			AnswerBean answer = new AnswerBean();
			answer.setAnswer(answerdesc);
			answer.setQuestionid(questionid);
			answer.setUserid(userid);

			DiscussionDAO dao = new DiscussionDAO();
			boolean isAnswerPosted = dao.PostAnswer(answer);
			
			if(isAnswerPosted){
//				request.setAttribute("m", "Oops!! Something went wrong.");
				System.out.println("Answer posted"+getClass());
				request.getSession().setAttribute("questiondiscussionpagemessage", "Answer posted successfully.");
				response.sendRedirect("QuestionDiscussion?questionid="+questionid);
//				request.getRequestDispatcher("QuestionDiscussion?questionid="+questionid).forward(request, response);
			}else{
				System.out.println("Oopsss!!!!!! Answer not posted"+getClass());
				response.sendRedirect("QuestionDiscussion?questionid="+questionid);
//				request.getRequestDispatcher("QuestionDiscussion?questionid="+questionid).forward(request, response);
			}
		}

	}

}
