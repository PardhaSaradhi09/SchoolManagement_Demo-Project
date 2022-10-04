package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.school.validation.ValidationUtil;
import org.student.domain.StudentData;
import org.student.service.StudentJdbcServiceImpl;
import org.student.service.StudentService;
import org.student.service.UserServiceImpl;
import org.student.service.UserService;



public class AddStudentServlet extends HttpServlet {
	StudentData student = new StudentData();
	StudentService stuadd = new StudentJdbcServiceImpl();
	UserService UserService = new  UserServiceImpl();
	
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String user=(String) request.getSession().getAttribute("user");
		if(user == null) {
			
			request.setAttribute("error", "session expired");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
			
		}

		response.setContentType("text/html");
		
		
		
		PrintWriter out = response.getWriter(); 
		String sid = request.getParameter("sid");
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String dateofjoin = request.getParameter("dateofjoin");

		//StudentData student = new StudentData();

		//student.setSid(Integer.valueOf(sid));
		student.setFirstName(FirstName);
		student.setLastName(LastName);
		student.setGender(gender);
		if (age != null && age.trim().length() > 0) 
		{
	    student.setAge((Integer.valueOf(age)));
		}
		student.setEmail(email);
		student.setPhone(phone);
		student.setAddress(address);
		try {
		student.setDateOfJoin(LocalDate.parse(dateofjoin, dtf));
		}catch(Exception e)
		{
			
		}
		String error = ValidationUtil.validate(request);
		
		if (error != null && error.trim().length() > 0) 
		 {
			request.setAttribute("student", student);
			request.setAttribute("emptyFliedError", error);
			RequestDispatcher rd = request.getRequestDispatcher("Addstudent.jsp");
			rd.include(request, response);
		 } else 
			{
		
	   //System.out.println(student);
		try {
			stuadd.addStudent(student);	
			System.out.println("Added student data ");
			response.sendRedirect("GetStudentServlet");
        } catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(student);
		

		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			response.setContentType("text/html");

			StudentData student = new StudentData();
		
			request.setAttribute("student", student);
			RequestDispatcher rd = request.getRequestDispatcher("Addstudent.jsp");
			rd.include(request, response);
			
	}

}
