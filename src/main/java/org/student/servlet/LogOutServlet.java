package org.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogOutServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Successfully loggedout");
		request.getSession().invalidate();
		request.setAttribute("logOutError", "Successfully loggedout");
		RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
		rd.include(request, response);
	}
}
