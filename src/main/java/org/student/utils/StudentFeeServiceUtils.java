package org.student.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.student.domain.StudentFee;
import org.studentfee.service.StudentFeeService;
import org.student.utils.StudentServiceUtils;

public class StudentFeeServiceUtils implements StudentFeeService {

	StudentServiceUtils utils = new StudentServiceUtils();
	Connection connection;
	Statement stmt;
	PreparedStatement pst;
	ResultSet rs;

	@Override
	public boolean addStudentFeeRecord(StudentFee StudentFeeRecord) {
		if (connection == null) {
			try {
				pst = utils.getConnection().prepareStatement("insert into studentfee values(?,?,?,?,?,?)");
				pst.setInt(1, StudentFeeRecord.getBillID());
				pst.setString(2, StudentFeeRecord.getCourseName());
				pst.setString(3, StudentFeeRecord.getSemesterType());
				pst.setInt(4, StudentFeeRecord.getCourseAmount());
				pst.setString(5, StudentFeeRecord.getPaymentType());
				pst.setInt(6, StudentFeeRecord.getSid());

				pst.execute();

			} catch (SQLException e) {

				e.printStackTrace();
			} finally {
				utils.closeConnection();
			}
		}
		return true;
	}

	@Override
	public Map<Integer, StudentFee> getAllStudentFeeRecords() {
		Map<Integer, StudentFee> studentfeeRecordList = new HashMap<>();

		try {

			stmt = utils.getConnection().createStatement();
			rs = stmt.executeQuery("select * from studentfee");
			while (rs.next()) {

				StudentFee newRecord = new StudentFee(rs.getInt("billID"), rs.getString("coursename"),
						rs.getString("semesterType"), rs.getInt("courseAmount"), rs.getString("paymentType"),
						rs.getInt("sid"));
				studentfeeRecordList.put(rs.getInt("billID"), newRecord);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			utils.closeConnection();
		}
		return studentfeeRecordList;
	}

}
