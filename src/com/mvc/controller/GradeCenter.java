package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.AssignmentDAO;
import com.mvc.pojo.AssignmentBean;

/**
 * Servlet implementation class GradeCenter
 */
@WebServlet({"/GradeCenter","/GradeCenter?courseid="})
public class GradeCenter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GradeCenter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String courseid = request.getParameter("courseid");
		AssignmentDAO assignmentdao = new AssignmentDAO();
		ArrayList<AssignmentBean> assignmentlist = assignmentdao.getAssignmentList(courseid);
		System.out.println(assignmentlist.toString());	
//		ArrayList<E	
		request.getRequestDispatcher("/gradecenter.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
