package org.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.service.StudentCourseService;
import org.student.utils.StudentCourseUtils;

public class DeleteStudentCourseServlet extends HttpServlet{
	StudentCourseService stuadd = new StudentCourseUtils();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=(String) request.getSession().getAttribute("user");
		if(user == null) {
			request.setAttribute("error", "session expired");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
		else {
			response.setContentType("text/html");
			String course_id = request.getParameter("course_id");
			stuadd.deleteStudentcourse(Integer.parseInt(course_id));
			System.out.println("From Servlet Deleted student course with " + course_id + "Course ID");
			RequestDispatcher rd = request.getRequestDispatcher("GetStudentCourseServlet");
			rd.include(request, response);
	}
	}
}
