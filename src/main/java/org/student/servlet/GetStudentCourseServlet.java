package org.student.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.domain.StudentCourse;
import org.student.service.StudentCourseService;
import org.student.utils.StudentCourseUtils;

public class GetStudentCourseServlet extends HttpServlet {
	StudentCourseService stuadd = new StudentCourseUtils();
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=(String) request.getSession().getAttribute("user");
		if(user == null) {
			
			request.setAttribute("error", "session expired");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}else {
			response.setContentType("text/html");
			Map<Integer, StudentCourse> studentcourseList = stuadd.getAllStudentCourse();
			System.out.println("list size:" + studentcourseList.size());
			request.setAttribute("studentcourseList", studentcourseList);
			RequestDispatcher rd = request.getRequestDispatcher("ShowStudentCourse.jsp");
			rd.include(request, response);
		
		}
	}
}
