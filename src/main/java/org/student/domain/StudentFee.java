package org.student.domain;

import java.sql.Date;

public class StudentFee {
	private int billID;
	private String courseName;
	private String semesterType;
	private int courseAmount;
	private String paymentType;
	private int sid;
	
	public StudentFee(int billID, String courseName, String semesterType, int courseAmount, String paymentType,
			int sid) {
		super();
		this.billID = billID;
		this.courseName = courseName;
		this.semesterType = semesterType;
		this.courseAmount = courseAmount;
		this.paymentType = paymentType;
		this.sid = sid;
	}
	public int getBillID() {
		return billID;
	}
	public void setBillID(int billID) {
		this.billID = billID;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getSemesterType() {
		return semesterType;
	}
	public void setSemesterType(String semesterType) {
		this.semesterType = semesterType;
	}
	public int getCourseAmount() {
		return courseAmount;
	}
	public void setCourseAmount(int courseAmount) {
		this.courseAmount = courseAmount;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	@Override
	public String toString() {
		return "StudentFee [billID=" + billID + ", courseName=" + courseName + ", semesterType=" + semesterType
				+ ", courseAmount=" + courseAmount + ", paymentType=" + paymentType + ", sid=" + sid + "]";
	}

	

}
