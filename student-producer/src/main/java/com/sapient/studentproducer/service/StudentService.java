package com.sapient.studentproducer.service;

import java.util.List;
import java.util.Optional;

import com.sapient.studentproducer.model.Student;

public interface StudentService {

	void registerStudent(Student student);

	Optional<Student> fetchStudentById(String studentId);

	List<Student> fetchStudentsByName(Optional<String> studentName);

	List<Student> findStudentsBySchoolName(String schoolName);

	void updateStudent(Student student);

	void removeStudent(String studentId);
	
	
	List<Student> findStudentsByName(String name);
	
	List<Student> findStudentsBySchoolName2(String schoolName);
	
	List<Student> findAllStudents();

}