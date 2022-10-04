package org.student.domain;

import java.time.LocalDate;
import java.util.Date;

public class StudentData {
	private int sid;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private String email;
	private String phone;
	private String address;
	private LocalDate dateOfJoin;

	public StudentData(int sid, String firstName, String lastName, String gender, int age, String email, String phone,
			String address, LocalDate dateOfJoin) {
		super();
		this.sid = sid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.dateOfJoin = dateOfJoin;
	}

	public StudentData() {
		// TODO Auto-generated constructor stub
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getDateOfJoin() {
		return dateOfJoin;
	}

	public void setDateOfJoin(LocalDate dateOfJoin) {
		this.dateOfJoin = dateOfJoin;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", age=" + age + ", email=" + email + ", phone=" + phone + ", address=" + address + ", dateOfJoin="
				+ dateOfJoin + "]";
	}

}
