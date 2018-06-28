package com.sapient.studentproducer.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sapient.studentproducer.model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {
	public List<Student> findOneByStudentName(String studentName);
	public List<Student> findBySchoolName(String schoolName);
}
