package org.school.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;

public class ValidationUtil {
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static String validate(HttpServletRequest request) {
		String FirstName = request.getParameter("FirstName");
		String LastName = request.getParameter("LastName");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String dateofjoin = request.getParameter("dateofjoin");
		String error = "";
		if (FirstName == null || FirstName.trim().length() == 0) {
			error = "First name should not be empty";
		} else if (LastName == null || LastName.trim().length() == 0) {
			error = "Last name should not be empty";
		} else if (gender == null || gender.trim().length() == 0) {
			error = "gender should not be empty";
		} else if (age == null || age.trim().length() == 0) {
			error = "age should not be empty";
		} else if (email == null || email.trim().length() == 0) {
			error = "email should not be empty";
		} else if (phone == null || phone.trim().length() == 0) {
			error = "phone should not be empty";
		} else if (address == null || address.trim().length() == 0) {

			error = "address should not be empty";
		} else if (dateofjoin == null || dateofjoin.trim().length() == 0) {
			error = "dateofjoin should not be empty";
		}

		if (dateofjoin != null && dateofjoin.trim().length() > 0) {
			try {
				LocalDate.parse(dateofjoin, dtf);
			} catch (Exception e) {
				error = String.format("invalid dateofjoin.error:%s", e.getMessage());

			}

		}

		return error;
	}

	public static String CourseFormValidate(HttpServletRequest request) {
		String course_name = request.getParameter("course_name");
		String course_mentor = request.getParameter("course_mentor");
		String course_duration = request.getParameter("course_duration");

		String error = "";

		if (course_name == null || course_name.trim().length() == 0) {
			error = "coursename  should not be empty";
		} else if (course_mentor == null || course_mentor.trim().length() == 0) {
			error = "coursementor should be empty";
		} else if (course_duration == null || course_duration.trim().length() == 0) {
			error = "courseduration should not be empty";

		}

		return error;

	}

}
