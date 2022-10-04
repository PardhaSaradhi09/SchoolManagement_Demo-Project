package org.studentfee.service;

import java.util.List;
import java.util.Map;

import org.student.domain.StudentFee;

public interface StudentFeeService {

	public boolean addStudentFeeRecord(StudentFee StudentFeeRecord);

	public Map<Integer, StudentFee> getAllStudentFeeRecords();



}
