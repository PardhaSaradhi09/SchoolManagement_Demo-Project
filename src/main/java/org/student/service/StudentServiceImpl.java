package org.student.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.UnaryOperator;

import org.student.domain.StudentData;

public class StudentServiceImpl implements StudentService {
	List<StudentData> studentlist = new ArrayList<>();

	@Override
	public StudentData getStudent(int sid) {
		for (StudentData student : studentlist) {
			if (student.getSid() == sid) {
				return student;
			}
		}
		return null;
	}

	@Override
	public Boolean addStudent(StudentData Student) {
		studentlist.add(Student);

		return true;
	}

	@Override
	public List<StudentData> getAllStudent() {

		return studentlist;
	}

	@Override
	public Boolean deleteStudent(int sid) {
		studentlist.removeIf(student -> (student.getSid() == sid));
		return true;
	}

	@Override
	public List<StudentData> topNStudent(int n) {
		List<StudentData> studentTopList = new ArrayList<StudentData>();
		for (int i = 0; i < n; i++) {
			studentTopList.add(studentlist.get(i));

		}
		return studentTopList;

	}

	@Override
	public List<StudentData> getAllStudentsByYear(int year) {
		List<StudentData> studentListByYear = new ArrayList<StudentData>();
		for (int i = 0; i < studentlist.size(); i++) {
			if (studentlist.get(i).getDateOfJoin().getYear() == year) {
				studentListByYear.add(studentlist.get(i));
			}
		}
		return studentListByYear;

	}

	@Override
	public List<StudentData> sortByAge() {
		Collections.sort(studentlist, new Comparator<StudentData>() {

			public int compare(StudentData student1, StudentData student2) {

				if (student1.getAge() < student2.getAge())
					return 1;

				return -1;
			}
		});
		return studentlist;
	}

	@Override
	public StudentData updatestudentRecord(StudentData Student) {
		for (int i = 0; i < studentlist.size(); i++) {
			if (studentlist.get(i).getSid() == Student.getSid()) {
				studentlist.get(i).setFirstName(Student.getFirstName());
				studentlist.get(i).setLastName(Student.getLastName());
				studentlist.get(i).setGender(Student.getGender());
				studentlist.get(i).setAge(Student.getAge());
				studentlist.get(i).setEmail(Student.getEmail());
				studentlist.get(i).setPhone(Student.getPhone());
				studentlist.get(i).setAddress(Student.getAddress());
				studentlist.get(i).setDateOfJoin(Student.getDateOfJoin());

				return studentlist.get(i);
			}
		}
		return null;
	}

}
