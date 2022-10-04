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
import org.student.service.StudentCourseService;
import org.student.service.StudentJdbcServiceImpl;
import org.student.service.StudentService;
import org.student.service.UserServiceImpl;
import org.student.utils.StudentCourseUtils;
import org.student.service.UserService;
import org.student.domain.StudentCourse;

public class AddCourseServlet extends HttpServlet {
	StudentCourse StudentCourse = new StudentCourse();
	StudentCourseService stuadd = new StudentCourseUtils();
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
		String sid = request.getParameter("sid");
		String course_name = request.getParameter("course_name");
		String course_mentor = request.getParameter("course_mentor");
		String course_duration = request.getParameter("course_duration");
		
		
		System.out.println(sid);
		StudentCourse.setSid(Integer.valueOf(sid));
		StudentCourse.setCourse_name(course_name);
		StudentCourse.setCourse_mentor(course_mentor);
		if (course_duration != null && course_duration.trim().length() > 0) {
			StudentCourse.setCourse_duration(Integer.valueOf(course_duration));
		}
		
		String error = ValidationUtil.CourseFormValidate(request);
		
		if (error != null && error.trim().length() > 0) 
		 {
			request.setAttribute("student", StudentCourse);
			request.setAttribute("emptyFliedError", error);
			RequestDispatcher rd = request.getRequestDispatcher("AddCourse.jsp");
			rd.include(request, response);
		 } else 
			{
		
	   //System.out.println(student);
		try {
			stuadd.addStudentCourse(StudentCourse);	
			System.out.println("Added studentcourse data ");
			response.sendRedirect("GetStudentCourseServlet");
        } catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(stuadd);
		

		}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
			response.setContentType("text/html");

			StudentCourse StudentCourse = new StudentCourse();
			String sid = request.getParameter("sid");
			System.out.println(sid);
			StudentCourse.setSid(Integer.valueOf(sid));
			request.setAttribute("student", StudentCourse );
			RequestDispatcher rd = request.getRequestDispatcher("AddCourse.jsp");
			rd.include(request, response);
			
	}

}
