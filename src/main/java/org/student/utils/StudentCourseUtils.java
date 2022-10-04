package org.student.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.student.domain.StudentCourse;
import org.student.service.StudentCourseService;

public class StudentCourseUtils implements StudentCourseService {
	StudentServiceUtils utils = new StudentServiceUtils();
	Connection connection;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;
	StudentCourse studentcourse = new StudentCourse();

	@Override

	public boolean addStudentCourse(StudentCourse StudentCourse) {
		try {

			pst = utils.getConnection().prepareStatement("insert into  student_course (course_name, course_mentor, course_duration, sid) values(?,?,?,?)");
			//pst.setInt(1, StudentCourse.getCourse_id());
			pst.setString(1, StudentCourse.getCourse_name());
			pst.setString(2, StudentCourse.getCourse_mentor());
			pst.setInt(3, StudentCourse.getCourse_duration());
			pst.setInt(4, StudentCourse.getSid());
			pst.execute();
			System.out.println("From database " + StudentCourse.getCourse_id() + "is inserted into the student");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public Map<Integer, StudentCourse> getAllStudentCourse() {
		Map<Integer, StudentCourse> studentcourseList = new HashMap<>();

		try {

			stmt = utils.getConnection().createStatement();
			rs = stmt.executeQuery("select * from student_course");
			System.out.println("Get all studentcourse records is executed successfully");
			while (rs.next()) {

				StudentCourse newRecord = new StudentCourse(rs.getInt("course_id"), rs.getString("course_name"),
						rs.getString("course_mentor"), rs.getInt("course_duration"), rs.getInt("sid"));
				studentcourseList.put(rs.getInt("course_id"), newRecord);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}
//		finally {
//			utils.closeConnection();
//		}
		return studentcourseList;
	}

	@Override
	public StudentCourse getStudentCourseByID(int course_id) {
		try {
			pst = utils.getConnection().prepareStatement("select * from  student_course where Course_id = ?");
			pst.setInt(1, course_id);
			ResultSet rs = pst.executeQuery();

			System.out.println("Get studentcourse by course_id is working.....");
			while (rs.next()) {
				studentcourse.setCourse_id(rs.getInt("course_id"));
				studentcourse.setCourse_name(rs.getString("Course_name"));
				studentcourse.setCourse_mentor(rs.getString("Course_mentor"));
				studentcourse.setCourse_duration(rs.getInt("Course_duration"));
				studentcourse.setSid(rs.getInt("sid"));

				return studentcourse;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<StudentCourse> getStudentCourseBySID(int sid) {
		List<StudentCourse> courseListBysid = new ArrayList<>();
		StudentCourse courseRecord = new StudentCourse();
		try {
			pst = utils.getConnection().prepareStatement(
					"select * from student_course where sid = ?");/*
																	 * we passing the SQL query in the prepStatment.
																	 */
			pst.setInt(1, sid);
			ResultSet rs = pst.executeQuery();// We are executing the query by using executeQurey
			// to go the next iteration we need rs.next() method
			System.out.println("Get student_course by sid is working.....");
			while (rs.next()) {

				courseRecord.setCourse_id(rs.getInt("course_id"));
				courseRecord.setCourse_name(rs.getString("Course_name"));
				courseRecord.setCourse_mentor(rs.getString("Course_mentor"));
				courseRecord.setCourse_duration(rs.getInt("Course_duration"));
				courseRecord.setSid(rs.getInt("sid"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} 

		return courseListBysid;
	}

	@Override
	public StudentCourse updateStudentCourse(StudentCourse StudentCourse) {
		try {
			pst = utils.getConnection().prepareStatement(
					" update student_course set Course_name=?,Course_mentor=?,Course_duration=?,sid=? where Course_id=?");
			
			pst.setString(1, StudentCourse.getCourse_name());
			pst.setString(2, StudentCourse.getCourse_mentor());
			pst.setInt(3, StudentCourse.getCourse_duration());
			pst.setInt(4, StudentCourse.getSid());
			pst.setInt(5, StudentCourse.getCourse_id());
		    pst.execute();
			System.out.println("From database update student_course record is executed successfully ");

			pst = utils.getConnection().prepareStatement(
					"select * from student_course where Course_id = ?");/*
																	 * we passing the SQL query in the prepStatment.
																	 */
			pst.setInt(1, StudentCourse.getCourse_id());
			ResultSet rs = pst.executeQuery();// We are executing the query by using executeQurey
			// to go the next iteration we need rs.next() method
			System.out.println("Get student_course by course_id is working.....");
			while (rs.next()) {
				StudentCourse.setCourse_id(rs.getInt("course_id"));
				StudentCourse.setCourse_name(rs.getString("Course_name"));
				StudentCourse.setCourse_mentor(rs.getString("Course_mentor"));
				StudentCourse.setCourse_duration(rs.getInt("Course_duration"));
				StudentCourse.setSid(rs.getInt("sid"));
			

				return StudentCourse;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deleteStudentcourse(int course_id) {
		try {
			pst = utils.getConnection().prepareStatement(
					"delete from student_course where course_id = ?");/*
																 * we passing the SQL query in the prepStatment.
																 */
			pst.setInt(1, course_id);
			pst.executeUpdate();// We are executing the query by using executeQurey
			System.out.println("From database deleted student record with" + " " + course_id + " " + "Course ID");
			return true;

		} catch (SQLException e) {

			e.printStackTrace();
		} 
		return false;
		
	}

	}


