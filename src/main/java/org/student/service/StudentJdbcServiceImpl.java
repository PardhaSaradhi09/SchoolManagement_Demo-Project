package org.student.service;

import java.util.ArrayList;
import java.util.List;

import org.student.domain.StudentData;
import org.student.utils.StudentServiceUtils;

public class StudentJdbcServiceImpl implements StudentService {
	List<StudentData> Studentlist = new ArrayList<StudentData>();
	StudentServiceUtils util = new StudentServiceUtils();

	@Override
	public StudentData getStudent(int sid) {
		return util.getRecordFromTable(sid);
		
	}

	@Override
	public Boolean addStudent(StudentData Student) {
		return util.insertRecord(Student);
		
	}

	@Override
	public List<StudentData> getAllStudent() {
		return util.getAllstudent();
		
	}

	@Override
	public Boolean deleteStudent(int sid) {
		return util.deletestudent(sid);
	}

	@Override
	public List<StudentData> topNStudent(int n) {
		return util.topNStudent(n);
		
	}

	@Override
	public List<StudentData> getAllStudentsByYear(int year) {
		return util.getAllStudentsByYear(year);
	}

	@Override
	public List<StudentData> sortByAge() {
		return util.sortByAge();
	}

	@Override
	public StudentData updatestudentRecord(StudentData Student) {
		return util.updatePatientRecord(Student);
	
	}

	

	
}
