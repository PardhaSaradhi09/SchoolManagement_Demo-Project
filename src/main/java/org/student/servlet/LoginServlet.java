package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.student.service.UserService;
import org.student.service.UserServiceImpl;

public class LoginServlet extends HttpServlet {
	UserService us = new UserServiceImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String user = request.getParameter("username");
		String pass = request.getParameter("password");
		System.out.println(String.format("username:%s,password:%s", user, pass));

		// todo validate cridentals

		if(us.isValid(user, pass)) {
			System.out.println("user Valid");
			request.getSession().setAttribute("user", user);
			RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");

			rd.include(request, response);
		} else {
			System.out.println("user not Valid");
			request.setAttribute("error", "Wrong username and password");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);

		}
		//out.close();
	}
}