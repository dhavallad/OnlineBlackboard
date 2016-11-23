package com.mvc.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.DiscussionDAO;
import com.mvc.pojo.QuestionBean;

/**
 * Servlet implementation class PostQuestionServlet
 */
@WebServlet("/PostQuestionServlet")
public class PostQuestionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostQuestionServlet() {
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
		String question = request.getParameter("dis_question");
		Date postdate = new Date();
		String userid = "2";
		String courseid = "1";

		QuestionBean postquestion = new QuestionBean();
		postquestion.setQuestion(question);
		postquestion.setPostdate(postdate);
		postquestion.setUserid(userid);
		postquestion.setCourseid(courseid);

		DiscussionDAO discussiondao = new DiscussionDAO();
		boolean postQuestionFlag = discussiondao.PostQuestion(postquestion);

		if (postQuestionFlag) {
			request.setAttribute("postquestionMessage", "Question has been posted successfully.");
			System.out.println("Quesiton created successfully.....");
			request.getRequestDispatcher("/success.html").forward(request, response);
		} else // On Failure, display a meaningful message to the User.
		{
			System.out.println("Oops!! Something went wrong. COurse not created.");
			request.setAttribute("error", "Oops!! Something went wrong.");
			request.getRequestDispatcher("/error.html").forward(request, response);
		}

	}

}
