package com.cui.csci2110.lab4;


public class Student {
	private int studentID;
	private String firstName;
	private String lastName;
	private String email;
	private String major;
	private String faculty;
	public Student(int studentID, String firstName, String lastName,String email, String major, String faculty) {
		this.studentID = studentID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.major = major;
		this.faculty = faculty;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getFaculty() {
		return faculty;
	}
	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}
	@Override
	public String toString() {
		return  studentID + " " + firstName + " " + lastName + " " + email + " "+ major + " " + faculty;
	}
	
	
}
