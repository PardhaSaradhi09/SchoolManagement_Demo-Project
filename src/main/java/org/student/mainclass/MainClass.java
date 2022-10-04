package org.student.mainclass;

import java.time.LocalDate;
import java.util.Date;

import org.student.domain.StudentData;
import org.student.domain.StudentCourse;
import org.student.service.StudentJdbcServiceImpl;
import org.student.service.StudentService;
import org.student.service.StudentServiceImpl;



public class MainClass {

	public static void main(String[] args) {

		StudentData s1 = new StudentData(1, "raju", "rao", "male", 10, "raju@gmail.com", "8908969210", "rourkela",
				LocalDate.of(2021, 02, 12));
		StudentData s2 = new StudentData(2, "puja", "kumari", "female", 11, "puja@gmail.com", "7978658997", "raipur",
				LocalDate.of(2020, 01, 19));
		StudentData s3 = new StudentData(3, "ajay", "kumar", "male", 15, "ajay@gmail.com", "7978658997", "cuttack",
				LocalDate.of(2022, 02, 22));
		StudentData s4 = new StudentData(4, "mallica", "sahoo", "female", 12, "mallica@gmail.com", "7978658997", "puri",
				LocalDate.of(2023, 04, 28));
		StudentData s5 = new StudentData(5, "sanjay", "rana", "male", 14, "sanjay@gmail.com", "7978658997", "agra",
				LocalDate.of(2025, 03, 11));

		StudentService stud = new StudentServiceImpl();

		stud.addStudent(s1);
		stud.addStudent(s2);
		stud.addStudent(s3);
		stud.addStudent(s4);
		
		
		System.out.println(s5);
		
		
		StudentCourse c1 = new StudentCourse(1, "java", "sunil", 2, 20);
//		stud.addStudent(s5);
		
		//System.out.println(stud.addStudent(s1));
		// System.out.println(stud.getStudent(1));
//	    System.out.println(stud.getAllStudent());
//	    System.out.println(stud.deleteStudent(1));
		// System.out.println(stud.topNStudent(1));
		// System.out.println(stud.getAllStudentsByYear(2025));
		// System.out.println(stud.sortByAge());

		//StudentService db = new StudentJdbcServiceImpl();

		 //System.out.println(db.addStudent(s1));
		// System.out.println(db.getAllStudent());
		// System.out.println(db.deleteStudent(1));
		// System.out.println(db.topNStudent(2));
		// System.out.println(db.getAllStudentsByYear(2023));
		// System.out.println(db.sortByAge());
		//System.out.println(db.getStudent(3));
		
		
		
//		StudentFee sf1 = new StudentFee(1, "hindi", "1", 1000, "card", 1);
//		
//		StudentFeeServiceUtils fee1 = new StudentFeeServiceUtils();
//		//fee1.addStudentFeeRecord(sf1);
//		//System.out.println();
//		fee1.getAllStudentFeeRecords();
//		
		
		
		
		
		
		
		
		

	}

}
