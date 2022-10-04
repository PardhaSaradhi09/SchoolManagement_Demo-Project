
package org.student.utils;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.student.domain.StudentData;

public class StudentServiceUtils {

	Connection connection;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/school", "root", "1234");
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return connection;
	}

	public void closeConnection() {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	public Boolean insertRecord(StudentData student) {

		
			try {

				pst = getConnection().prepareStatement("insert into student values(?,?,?,?,?,?,?,?,?)");
				pst.setInt(1, student.getSid());
				pst.setString(2, student.getFirstName());
				pst.setString(3, student.getLastName());
				pst.setString(4, student.getGender());
				pst.setInt(5, student.getAge());
				pst.setString(6, student.getEmail());
				pst.setString(7, student.getPhone());
				pst.setString(8, student.getAddress());
				pst.setDate(9, Date.valueOf(student.getDateOfJoin()));

				pst.execute();
				System.out.println("From database " + student.getSid() + "is inserted into the student");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return true;
		}
	


	
	public List<StudentData> getAllstudent() {

		List<StudentData> studentlist = new ArrayList<StudentData>();
		try {

			stmt = getConnection().createStatement();
			rs = stmt.executeQuery("select * from student");
			while (rs.next()) {
				java.sql.Date sqlDate = rs.getDate("dateOfJoin");

				LocalDate dateOfJoin = sqlDate.toLocalDate();

				studentlist.add(new StudentData(rs.getInt(1), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("gender"), rs.getInt("age"), rs.getString("email"), rs.getString("phone"),
						rs.getString("address"), dateOfJoin));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return studentlist;

	}

	public Boolean deletestudent(int sid) {

		if (connection == null) {
			try {
				pst = getConnection().prepareStatement("delete from student where sid = ?");
				pst.setInt(1, sid);
				pst.execute();

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}

		return true;
	}

	public List<StudentData> topNStudent(int n) {
		List<StudentData> topTatientList = new ArrayList<StudentData>();

		try {
			pst = getConnection().prepareStatement("SELECT * FROM student");

			pst.setMaxRows(n);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				java.sql.Date dateOfJoin = rs.getDate("dateOfJoin");

				topTatientList.add(new StudentData(rs.getInt(1), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("gender"), rs.getInt("age"), rs.getString("email"), rs.getString("phone"),
						rs.getString("address"), dateOfJoin.toLocalDate()));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return topTatientList;
	}

	public List<StudentData> getAllStudentsByYear(int year) {
		List<StudentData> studentListByYear = new ArrayList<StudentData>();

		try {
			pst = getConnection().prepareStatement("select * from student where YEAR(dateofjoin)=?;");
			pst.setInt(1, year);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				java.sql.Date sqlDate = rs.getDate("dateOfJoin");
				LocalDate dateOfJoin = sqlDate.toLocalDate();
				studentListByYear.add(new StudentData(rs.getInt(1), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("gender"), rs.getInt("age"), rs.getString("email"), rs.getString("phone"),
						rs.getString("address"), dateOfJoin));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return studentListByYear;
	}

	public List<StudentData> sortByAge() {

		List<StudentData> studentListByAge = new ArrayList<StudentData>();

		try {
			pst = getConnection().prepareStatement("SELECT * FROM student ORDER BY age Desc");

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				java.sql.Date sqlDate = rs.getDate("dateOfJoin");
				LocalDate dateOfJoin = sqlDate.toLocalDate();

				studentListByAge.add(new StudentData(rs.getInt(1), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("gender"), rs.getInt("age"), rs.getString("email"), rs.getString("phone"),
						rs.getString("address"), dateOfJoin));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return studentListByAge;

	}

	public StudentData getRecordFromTable(int pid) {
		StudentData student = new StudentData();

		try {
			pst = getConnection().prepareStatement("select * from student where sid = ?");
			pst.setInt(1, pid);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				java.sql.Date sqlDate = rs.getDate("dateOfJoin");
				LocalDate dateOfJoin = sqlDate.toLocalDate();
				student.setSid(rs.getInt("sid"));
				student.setFirstName(rs.getString("firstName"));
				student.setLastName(rs.getString("lastName"));
				student.setGender((rs.getString("gender")));
				student.setAge(rs.getInt("age"));
				student.setEmail(rs.getString("email"));
				student.setPhone(rs.getString("phone"));
				student.setAddress(rs.getString("address"));
				student.setDateOfJoin(dateOfJoin);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			closeConnection();
		}

		return student;
	}

	public StudentData updatePatientRecord(StudentData Student) {
		// TODO Auto-generated method stub
		PreparedStatement pst1;

		try {
//          udapate query
			pst = getConnection().prepareStatement(
					"update student set firstName=?,lastName=?,gender=?,age=?,email=?,phone=?,address=?,dateOfJoin=? where sid=?;");/*
																																	 * we
																																	 * passing
																																	 * the
																																	 * SQL
																																	 * query
																																	 * in
																																	 * the
																																	 * prepStatment.
																																	 */

			pst.setString(1, Student.getFirstName());
			pst.setString(2, Student.getLastName());
			pst.setString(3, Student.getGender());
			pst.setInt(4, Student.getAge());
			pst.setString(5, Student.getEmail());
			pst.setString(6, Student.getPhone());
			pst.setString(7, Student.getAddress());
			pst.setDate(8, Date.valueOf(Student.getDateOfJoin()));
			pst.setInt(9, Student.getSid());
			pst.execute();
//         get updated query

			pst1 = getConnection().prepareStatement(
					"select * from student where sid = ?");/*
															 * we passing the SQL query in the prepStatment.
															 */
			pst1.setInt(1, Student.getSid());
			ResultSet rs = pst1.executeQuery();

			while (rs.next()) {

				java.sql.Date sqlDate = rs.getDate("dateOfJoin");
				LocalDate dateOfJoin = sqlDate.toLocalDate();

				Student = (new StudentData(rs.getInt(1), rs.getString("firstName"), rs.getString("lastName"),
						rs.getString("gender"), rs.getByte("age"), rs.getString("email"), rs.getString("phone"),
						rs.getString("address"), dateOfJoin));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		return Student;

	}

}
