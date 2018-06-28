package com.sapient.school.schoolservice.service;

import java.util.List;

import com.sapient.school.schoolservice.model.Student;

public interface SchoolService {
	//List<Student> getStudents( String schoolname) ;
	Student findStudentById(String studentId);
	//List<Student> getStudentsByName(String studentName);
	List<Student> findStudentsByName(String name);
	List<Student> findStudentsBySchoolName(String schoolName);
	List<Student> findAllStudents();
}

