package com.mvc.controller;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.DiscussionDAO;
import com.mvc.pojo.QuestionBean;

/**
 * Servlet implementation class PostDiscussion
 */
@WebServlet("/PostDiscussion")
public class PostDiscussion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PostDiscussion() {
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
		System.out.println("zzzzzzzzzzzzz");
		request.getRequestDispatcher("/postdiscussion.jsp").forward(request, response);
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
		System.out.println(getClass());
		if (session != null) {
			String question = request.getParameter("dis_question");
			String userid = session.getAttribute("session_userid").toString();
			String courseid = session.getAttribute("session_courseid").toString();

			System.out.println("Userid" + userid + "Courseid" + courseid);

			QuestionBean postquestion = new QuestionBean();
			postquestion.setQuestion(question);
			postquestion.setUserid(userid);
			postquestion.setCourseid(courseid);

			DiscussionDAO discussiondao = new DiscussionDAO();
			boolean postQuestionFlag = discussiondao.PostQuestion(postquestion);

			if (postQuestionFlag) {

				System.out.println("Quesiton created successfully....." + session.getAttribute("session_courseid"));
				request.getSession().setAttribute("discussionlistmessage", "Question posted successfully.");
				response.sendRedirect("DiscussionBoard?courseid=" + courseid);
				// request.setAttribute("postquestionMessage", "Question has
				// been posted successfully.");
				// request.getRequestDispatcher("DiscussionBoard?courseid="+session.getAttribute("session_courseid")).forward(request,
				// response);
			} else // On Failure, display a meaningful message to the User.
			{
				System.out.println("Oops!! Something went wrong. COurse not created.");
				request.getSession().setAttribute("discussionlistmessage", "Oops!! Something went wrong. Question not posted.");
				response.sendRedirect("DiscussionBoard?courseid=" + courseid);
//				request.setAttribute("error", "Oops!! Something went wrong.");
//				request.getRequestDispatcher("/error.html").forward(request, response);
			}

		}

	}

}
