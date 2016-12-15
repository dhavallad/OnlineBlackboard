package com.mvc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mvc.dao.CourseDAO;
import com.mvc.pojo.CourseContentBean;

/**
 * Servlet implementation class FileUploadHandler
 */
@WebServlet("/FileUploadHandler")
@MultipartConfig
public class FileUploadHandler extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final String UPLOAD_DIRECTORY = "/Users/dhavallad/Documents/workspace/Lab/WebContent/uploads";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadHandler() {
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
		HttpSession session = request.getSession(false);
		if (session.getAttribute("session_userid") != null) {

			String courseid = session.getAttribute("session_courseid").toString();
			System.out.println("asdasds");
			String contentname = null;
			String desc = null;
			String filename = null;
			int i = 0;
			// process only if its multipart content
			if (ServletFileUpload.isMultipartContent(request)) {

				try {

					List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
					Iterator<FileItem> it = multiparts.iterator();
					// for (FileItem item : multiparts) {
					// if (!item.isFormField()) {
					// name = new File(item.getName()).getName();
					// item.write(new File(UPLOAD_DIRECTORY + File.separator +
					// name));
					// filepath = UPLOAD_DIRECTORY + File.separator + name;
					// }else{
					// contentname = item.getString();
					// desc = item.getString();
					//
					// }
					// }

					while (it.hasNext()) {
						FileItem fileItem = it.next();
						boolean isFormField = fileItem.isFormField();
						if (isFormField) {
							if (i == 0) {
								contentname = fileItem.getString();
								i++;
							} else {
								desc = fileItem.getString();
							}
							System.out.println("field---" + fileItem.getString());
						} else {
							String temp = new File(fileItem.getName()).getName();
							filename = temp.replaceAll("\\s+", "");
							fileItem.write(new File(UPLOAD_DIRECTORY + File.separator + filename));
							// filepath = UPLOAD_DIRECTORY + File.separator +
							// name;
						}
						// if (!item.isFormField()) {
						// name = new File(item.getName()).getName();
						// item.write(new File(UPLOAD_DIRECTORY + File.separator
						// +
						// name));
						// filepath = UPLOAD_DIRECTORY + File.separator + name;
						// }else{
						// contentname = item.getString();
						// desc = item.getString();
						//
						// }
					}

					// String contentname = request.getParameter("contentname");
					// String desc = request.getParameter("contentdesc");
					System.out.println("content name " + contentname + "content desc" + desc);
					CourseContentBean fileInfo = new CourseContentBean();

					fileInfo.setContentname(contentname);
					fileInfo.setContentdesc(desc);
					fileInfo.setContentpath(filename);
					fileInfo.setCourseid(courseid);

					CourseDAO coursedao = new CourseDAO();
					boolean isFileNameAvaliable = coursedao.isFileExists(contentname);
					
					
					
					if(isFileNameAvaliable){
						boolean isUploaded = coursedao.insertFilePath(fileInfo);
						if (isUploaded) {
							// request.setAttribute("contentpagemessage", "File:" +
							// filename + " uploaded successfully.");
							System.out.println("File:" + filename + " uploaded successfully.");
							request.getSession().setAttribute("contentpagemessage",
									"Content : " + contentname + " uploaded successfully.");
							response.sendRedirect("CourseContent?courseid=" + courseid);
							// request.getRequestDispatcher("CourseContent?courseid="+courseid).forward(request,
							// response);
						}
						
					} else {
						System.out.println("Errrroorrrrrrr" + getClass());
						request.getSession().setAttribute("contentpagemessage",
								"Sorry!!! Content : "+contentname+" already exists.");
						response.sendRedirect("CourseContent?courseid=" + courseid);

					}
					// File uploaded successfully
//					if (isUploaded) {
//						// request.setAttribute("contentpagemessage", "File:" +
//						// filename + " uploaded successfully.");
//						System.out.println("File:" + filename + " uploaded successfully.");
//						request.getSession().setAttribute("contentpagemessage",
//								"Content : " + contentname + " uploaded successfully.");
//						response.sendRedirect("CourseContent?courseid=" + courseid);
//						// request.getRequestDispatcher("CourseContent?courseid="+courseid).forward(request,
//						// response);
//					}

				} catch (Exception ex) {
					request.setAttribute("message", "File Upload Failed due to " + ex);
					System.out.println("failed to uplaod....." + ex.getMessage());
				}

			} else {
				request.setAttribute("message", "Sorry this Servlet only handles file upload request");
				System.out.println("Sorry this Servlet only handles file upload request");
			}
			// -------------------------------------------------------

			// request.getRequestDispatcher("/success.html").forward(request,
			// response);
		} else {
			System.out.println("Session not set.");
			request.setAttribute("loginpageMessage", "Please login first to access page.");
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
	}

}
