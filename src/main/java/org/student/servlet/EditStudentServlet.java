package org.student.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

public class EditStudentServlet extends HttpServlet {
	StudentService studentService = new StudentJdbcServiceImpl();
	//date format 
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=(String) request.getSession().getAttribute("user");
		if(user == null) {
			request.setAttribute("error", "session expired");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
		else 
		{
			
		}
		
		response.setContentType("text/html");
		String sid = request.getParameter("sid");
		StudentData student = studentService.getStudent(Integer.parseInt(sid));
		System.out.println("old Student record:" + student);
		System.out.println("student:" + student);
		request.setAttribute("student", student);
		RequestDispatcher rd = request.getRequestDispatcher("UpdateStudentData.jsp");
		rd.include(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String sid = request.getParameter("sid");
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String Gender = request.getParameter("gender");
		String Age = request.getParameter("age");
		String Email = request.getParameter("email");
		String Phone = request.getParameter("phone");
		String Address = request.getParameter("address");
		String DateOfJoin = request.getParameter("dateofjoin");

		StudentData Student = new StudentData();

		Student.setSid(Integer.valueOf(sid));
		Student.setFirstName(FirstName);
		Student.setLastName(LastName);
		Student.setGender(Gender);
		Student.setAge((Integer.valueOf(Age)));
		Student.setEmail(Email);
		Student.setPhone(Phone);
		Student.setAddress(Address);
		Student.setDateOfJoin(LocalDate.parse(DateOfJoin, dtf));

		try {
			StudentData updatedstudent = studentService.updatestudentRecord(Student);                
			System.out.println("updated Patient record: " + updatedstudent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		response.sendRedirect("GetStudentServlet");

//		RequestDispatcher rd = request.getRequestDispatcher("index.html");
//
//		rd.include(request, response);

	}

}
