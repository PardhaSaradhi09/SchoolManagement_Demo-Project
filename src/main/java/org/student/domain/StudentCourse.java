package org.student.domain;

import java.sql.Date;

public class StudentCourse {
	private int course_id;
	private String course_name;
	private String course_mentor;
	private int course_duration;
	private int sid;
	
	public StudentCourse(int course_id, String course_name, String course_mentor, int course_duration, int sid) {
		super();
		this.course_id = course_id;
		this.course_name = course_name;
		this.course_mentor = course_mentor;
		this.course_duration = course_duration;
		this.sid = sid;
	}

	

	public StudentCourse() {
		// TODO Auto-generated constructor stub
	}

	public int getCourse_id() {
		return course_id;
	}

	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_mentor() {
		return course_mentor;
	}

	public void setCourse_mentor(String course_mentor) {
		this.course_mentor = course_mentor;
	}

	public int getCourse_duration() {
		return course_duration;
	}

	public void setCourse_duration(int course_duration) {
		this.course_duration = course_duration;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Override
	public String toString() {
		return "StudentFee [course_id=" + course_id + ", course_name=" + course_name + ", course_mentor="
				+ course_mentor + ", course_duration=" + course_duration + ", sid=" + sid + "]";
	}
	
	
	
	
	}
