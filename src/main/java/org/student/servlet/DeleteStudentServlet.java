package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.student.domain.StudentData;
import org.student.service.StudentJdbcServiceImpl;
import org.student.service.StudentService;

public class DeleteStudentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=(String) request.getSession().getAttribute("user");
		if(user == null) {
			request.setAttribute("error", "session expired");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
		StudentJdbcServiceImpl ser1 = new StudentJdbcServiceImpl();
		response.setContentType("text/html");
		String sid = request.getParameter("sid");
		ser1.deleteStudent(Integer.parseInt(sid));
		System.out.println("Deleted Student record with " + sid +  "student ID");
		RequestDispatcher rd = request.getRequestDispatcher("GetStudentServlet");
		rd.include(request, response);
	}

}
