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

import com.mvc.dao.CourseDAO;
import com.mvc.pojo.CourseContentBean;

/**
 * Servlet implementation class ViewContent
 */
@WebServlet({"/ViewContent","/ViewContent?contentid="})
public class ViewContent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewContent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String contentid = request.getParameter("contentid");
		HttpSession session = request.getSession();
		if(session!=null){
			CourseDAO coursedao = new CourseDAO();
			CourseContentBean contentInfo = coursedao.getContent(contentid);
			
			request.setAttribute("contentinfo", contentInfo);
			RequestDispatcher rd = request.getRequestDispatcher("viewcoursecontent.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
