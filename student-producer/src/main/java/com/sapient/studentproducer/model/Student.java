package com.sapient.studentproducer.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;

@Document(collection = "student")
public class Student {
	public Student(String studentId, String studentName, String studentRollNumber, String schoolName) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentRollNumber = studentRollNumber;
		this.schoolName = schoolName;
	}
	public Student(){
		
	}
	@Id
	private String studentId;
	private String studentName;
	private String studentRollNumber;
	private String schoolName;

	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentRollNumber() {
		return studentRollNumber;
	}

	public void setStudentRollNumber(String studentRollNumber) {
		this.studentRollNumber = studentRollNumber;
	}
	public String toString() {
		return "Id::"+studentId+"  Name::"+studentName+"  roll::"+studentRollNumber;
	}
}
