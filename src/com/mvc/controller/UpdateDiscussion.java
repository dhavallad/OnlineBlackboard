package com.mvc.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mvc.dao.CourseDAO;
import com.mvc.dao.DiscussionDAO;

/**
 * Servlet implementation class UpdateDiscussion
 */
@WebServlet({"/UpdateDiscussion","/UpdateDiscussion?discussionid="})
public class UpdateDiscussion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateDiscussion() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		if (session.getAttribute("session_userid") != null) {
			System.out.println("Inside"+getClass());
			String id = request.getParameter("discussionid");
			if (request.getParameter("action").equals("delete")) {
				boolean flag = deleteDiscussion(id);
				if (flag) {
//					request.setAttribute("errormess", "Content Deleted Successfully.");
//					request.getRequestDispatcher("Assignments?courseid=" + session.getAttribute("session_courseid")).forward(request, response);
					request.getSession().setAttribute("discussionlistmessage", "Discussion Deleted Successfully.");
					response.sendRedirect("DiscussionBoard?courseid="+session.getAttribute("session_courseid"));
				}
			}
		}else{
			request.setAttribute("loginpageMessage", "Please login first to access page.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	public boolean deleteDiscussion(String discussionid) {

		DiscussionDAO dao = new DiscussionDAO();
		boolean isDelete = dao.deleteDiscussion(discussionid);
		if (isDelete) {
			System.out.println("Discussion Deleted.");
			return true;
		}
		System.out.println("Ooops!! Discussion not deleted.");
		return false;

	}

}
