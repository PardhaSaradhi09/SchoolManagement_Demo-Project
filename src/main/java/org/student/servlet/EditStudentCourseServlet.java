package org.student.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.school.validation.ValidationUtil;
import org.student.domain.StudentCourse;
import org.student.service.StudentCourseService;
import org.student.utils.StudentCourseUtils;

public class EditStudentCourseServlet extends HttpServlet {
	StudentCourseService stuadd = new StudentCourseUtils();
	StudentCourse StudentCourse = new StudentCourse();
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
			StudentCourse StudentCourse = stuadd.getStudentCourseByID(Integer.valueOf(course_id));
			System.out.println("old doctor record:" + StudentCourse);
			request.setAttribute("StudentCourse", StudentCourse);
			RequestDispatcher rd = request.getRequestDispatcher("EditStudentCourse.jsp");
			rd.include(request, response);
		}
		
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user=(String) request.getSession().getAttribute("user");
		if(user == null) {
			request.setAttribute("error", "session expired");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.include(request, response);
		}
		else {
			response.setContentType("text/html");
			String sid = request.getParameter("sid");
			String course_id = request.getParameter("course_id");
			String course_name = request.getParameter("course_name");
			String course_mentor = request.getParameter("course_mentor");
			String course_duration = request.getParameter("course_duration");
			
			
		
			StudentCourse.setSid(Integer.valueOf(sid));
			StudentCourse.setCourse_id(Integer.valueOf(course_id));
			StudentCourse.setCourse_name(course_name);
			StudentCourse.setCourse_mentor(course_mentor);
			if (course_duration != null && course_duration.trim().length() > 0) {
				StudentCourse.setCourse_duration(Integer.valueOf(course_duration));
			}
			String error = ValidationUtil.CourseFormValidate(request);
			if (error != null && error.trim().length() > 0) {
				request.setAttribute("StudentCourse", StudentCourse);
				request.setAttribute("emptyFieldError", error);
				RequestDispatcher rd = request.getRequestDispatcher("UpdateStudentData.jsp");

				rd.include(request, response);
				
			} else {
				try {
				
					StudentCourse updatedDoctorData = stuadd.updateStudentCourse(StudentCourse);
					System.out.println("updated  record: " + updatedDoctorData);
					response.sendRedirect("GetStudentCourseServlet");
				}catch(Exception e) {
					e.printStackTrace();
				}
	}
	}
}
}
