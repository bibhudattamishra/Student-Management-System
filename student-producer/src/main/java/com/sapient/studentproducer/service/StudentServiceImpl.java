package com.sapient.studentproducer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.studentproducer.model.Student;
import com.sapient.studentproducer.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository studentRepository;

	/* (non-Javadoc)
	 * @see com.sapient.studentproducer.service.StudentService#registerStudent(com.sapient.studentproducer.model.Student)
	 */
	@Override
	public void registerStudent(Student student) {
		studentRepository.save(student);
	}
	
	/* (non-Javadoc)
	 * @see com.sapient.studentproducer.service.StudentService#fetchStudentById(java.lang.String)
	 */
	@Override
	public Optional<Student> fetchStudentById(String studentId) {
		return studentRepository.findById(studentId);
	}
	
	/* (non-Javadoc)
	 * @see com.sapient.studentproducer.service.StudentService#fetchStudentsByName(java.util.Optional)
	 */
	@Override
	public List<Student> fetchStudentsByName(Optional<String> studentName) {
		System.out.println("Here");
		if (!studentName.isPresent()) {
			//System.out.println("Here i am::"+studentRepository.findAll());
			return studentRepository.findAll();
		} else {
			//System.out.println("Here i am again::"+studentName.get());
			return studentRepository.findOneByStudentName(studentName.get());
		}

	}
	
	
	/* (non-Javadoc)
	 * @see com.sapient.studentproducer.service.StudentService#findStudentsBySchoolName(java.lang.String)
	 */
	@Override
	public List<Student> findStudentsBySchoolName(String schoolName) {
		return studentRepository.findBySchoolName(schoolName);
	}

	
	/* (non-Javadoc)
	 * @see com.sapient.studentproducer.service.StudentService#updateStudent(com.sapient.studentproducer.model.Student)
	 */
	@Override
	public void updateStudent(Student student) {
		studentRepository.save(student);
	}

	
	/* (non-Javadoc)
	 * @see com.sapient.studentproducer.service.StudentService#removeStudent(java.lang.String)
	 */
	@Override
	public void removeStudent(String studentId) {
		studentRepository.deleteById(studentId);
	}

	@Override
	public List<Student> findStudentsBySchoolName2(String schoolName) {
		// TODO Auto-generated method stub
		return studentRepository.findBySchoolName(schoolName);
	}

	@Override
	public List<Student> findStudentsByName(String name) {
		// TODO Auto-generated method stub
		return studentRepository.findOneByStudentName(name);
	}

	@Override
	public List<Student> findAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
}
