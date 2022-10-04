package org.student.service;

import java.util.List;
import java.util.Map;

import org.student.domain.StudentCourse;
import org.student.domain.StudentData;

public interface StudentCourseService {
	
	public boolean addStudentCourse(StudentCourse StudentCourse);

	public Map<Integer, StudentCourse> getAllStudentCourse();

	public StudentCourse getStudentCourseByID(int course_id);

	public List<StudentCourse> getStudentCourseBySID(int sid);

	public StudentCourse updateStudentCourse(StudentCourse StudentCourse);
	
	public boolean deleteStudentcourse(int course_id);


}
