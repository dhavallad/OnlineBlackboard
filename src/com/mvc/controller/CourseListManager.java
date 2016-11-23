package com.mvc.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.dao.CourseDAO;
import com.mvc.pojo.CourseBean;

/**
 * Servlet implementation class CourseListManager
 */
@WebServlet("/CourseListManager")
public class CourseListManager extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CourseListManager() {
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
		System.out.println("Asdasdasd");
		try {
			ArrayList<CourseBean> viewcourse = new ArrayList<CourseBean>();
			System.out.println("Asdasdasd1");
			CourseDAO coursedao = new CourseDAO();
			System.out.println("Asdasdasd2");
			viewcourse = coursedao.ViewCourse();
			System.out.println("Asdasdasd3");
			for (int i = 0; i < viewcourse.size(); i++) {
				System.out.println("Servlet--"+viewcourse.get(i).getCoursename());

			}

			request.setAttribute("course", viewcourse);
			RequestDispatcher rd = request.getRequestDispatcher("courselist.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
