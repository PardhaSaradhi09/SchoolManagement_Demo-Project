package org.student.service;

import java.util.List;


import org.student.domain.StudentData;

public interface StudentService {
	// This method will retrieve the student record by student id(sid).
	public StudentData getStudent(int sid);

	// Use this method to add student record into the school database.
	public Boolean addStudent(StudentData Student);

	// This method will retrieve all students records from school database.
	public List<StudentData> getAllStudent();

	// Use this method to delete student record from school database.
	public Boolean deleteStudent(int sid);

	// Use this method to retrieve n student records from database.
	public List<StudentData> topNStudent(int n);

	// This method will retrieve the all student record by student year of
	// join(year).
	public List<StudentData> getAllStudentsByYear(int year);

	// This method will sort the student records table by the student age.
	public List<StudentData> sortByAge();
	
	//Use this method to updatestudentRecord  by Student id.
	public StudentData updatestudentRecord(StudentData Student);
	


}
