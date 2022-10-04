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

public class GetStudentServlet extends HttpServlet {
	StudentService studentService = new StudentJdbcServiceImpl();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = (String) request.getSession().getAttribute("user");
		if (user == null) {
			request.setAttribute("error", "session expired");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		} else {
			response.setContentType("text/html");

			

			List<StudentData> studentList = studentService.getAllStudent();
			System.out.println("list size:" + studentList.size());
			request.setAttribute("studentList", studentList);
			RequestDispatcher rd = request.getRequestDispatcher("Showstudentdata.jsp");
			rd.include(request, response);
		}

	}

}
