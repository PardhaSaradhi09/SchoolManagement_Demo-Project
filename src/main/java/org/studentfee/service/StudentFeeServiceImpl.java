package org.studentfee.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.student.domain.StudentFee;

public class StudentFeeServiceImpl implements StudentFeeService {
	Map<Integer, StudentFee> StudentFeeList = new HashMap<>();

	@Override
	public boolean addStudentFeeRecord(StudentFee StudentFeeRecord) {
		StudentFeeList.put(StudentFeeRecord.getBillID(), StudentFeeRecord);
		return true;

	}

	@Override
	public Map<Integer, StudentFee> getAllStudentFeeRecords() {

		return StudentFeeList;
	}

	

}
