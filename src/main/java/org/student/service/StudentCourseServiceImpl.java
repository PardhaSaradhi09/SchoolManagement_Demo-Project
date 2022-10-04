package org.student.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import org.student.domain.StudentCourse;

public class StudentCourseServiceImpl implements StudentCourseService {
	Map<Integer, StudentCourse> studentcourseList = new HashMap<>();

	@Override
	public boolean addStudentCourse(StudentCourse StudentCourse) {
		
		studentcourseList.put(StudentCourse.getCourse_id(), StudentCourse);
		return true;
	}

	@Override
	public Map<Integer, StudentCourse> getAllStudentCourse() {
		
		return studentcourseList;
	}

	@Override
	public StudentCourse getStudentCourseByID(int course_id) {
		
		for (Integer key : studentcourseList.keySet()) {
			if (key == course_id) {
				return studentcourseList.get(key);
			}
		}
		return null;
	}

	@Override
	public List<StudentCourse> getStudentCourseBySID(int sid) {
		
		List<StudentCourse> patientList= new ArrayList<>();
		for(Entry<Integer, StudentCourse> entry: studentcourseList.entrySet()) {
			if(entry.getValue().getSid()==sid) {
				patientList.add(entry.getValue());
				
			}
		}
		return patientList;
	}

	@Override
	
	public StudentCourse updateStudentCourse(StudentCourse StudentCourse) {
		
		for(Entry<Integer, StudentCourse> entry: studentcourseList.entrySet() ) {
			if(entry.getValue().getCourse_id()==StudentCourse.getCourse_id()) {
				entry.getValue().setCourse_name(StudentCourse.getCourse_name());
				entry.getValue().setCourse_mentor(StudentCourse.getCourse_mentor());
				entry.getValue().setCourse_duration(StudentCourse.getCourse_duration());
				entry.getValue().setSid(StudentCourse.getSid());
				
				return entry.getValue();
			}
		}
		return null;
	}

	@Override
	public boolean deleteStudentcourse(int course_id) {
		studentcourseList.remove(course_id);
		return true;
		
	}
	}
	

