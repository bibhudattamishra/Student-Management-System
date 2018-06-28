package com.sapient.school.schoolservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.school.schoolservice.model.Student;

@Service
public class SchoolServiceImpl implements SchoolService {
	@Autowired
	RestTemplate restTemplate;

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/*
	 * public List<Student> getStudents(String schoolname) { List<Student>
	 * studentList = new ArrayList<Student>();
	 * ParameterizedTypeReference<List<Student>> typeRef = new
	 * ParameterizedTypeReference<List<Student>>() { };
	 * ResponseEntity<List<Student>> responseEntity = restTemplate.exchange(
	 * "http://student-service/students/getStudentDetailsForSchool/{schoolname}",
	 * HttpMethod.GET, new HttpEntity<>(studentList), typeRef, schoolname); return
	 * responseEntity.getBody(); }
	 */
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public Student findStudentById(String studentId) {
		ParameterizedTypeReference<Student> typeRef = new ParameterizedTypeReference<Student>() {
		};
		Student student = new Student();
		ResponseEntity<Student> responseEntity = restTemplate.exchange(
				"http://student-service/student-api/v1/students/{studentId}", HttpMethod.GET, new HttpEntity<>(student),
				typeRef, studentId);
		return responseEntity.getBody();
	}
	/*
	 * @Override public List<Student> getStudentsByName(Optional<String>
	 * studentName) { List<Student> studentList = new ArrayList<Student>();
	 * ParameterizedTypeReference<List<Student>> typeRef = new
	 * ParameterizedTypeReference<List<Student>>() { }; if
	 * (!studentName.isPresent()) { ResponseEntity<List<Student>> responseEntity =
	 * restTemplate.exchange(
	 * "http://student-service/students/getStudentDetailsForSchool/{schoolname}",
	 * HttpMethod.GET, new HttpEntity<>(studentList), typeRef, studentName); } else
	 * { ResponseEntity<List<Student>> responseEntity = restTemplate.exchange(
	 * "http://student-service/students/getStudentDetailsForSchool/{schoolname}",
	 * HttpMethod.GET, new HttpEntity<>(studentList), typeRef, schoolname); } return
	 * responseEntity.getBody();
	 * 
	 * }
	 */

	@Override
	public List<Student> findStudentsByName(String studentName) {
		System.out.println("inside findStudentsByName");
		List<Student> studentList = new ArrayList<Student>();
		ParameterizedTypeReference<List<Student>> typeRef = new ParameterizedTypeReference<List<Student>>() {
		};

		ResponseEntity<List<Student>> responseEntity = restTemplate.exchange(
				"http://student-service/student-api/v1/students?name={studentName}", HttpMethod.GET,
				new HttpEntity<>(studentList), typeRef, studentName);

		return responseEntity.getBody();
	}

	@Override
	public List<Student> findStudentsBySchoolName(String schoolName) {
		System.out.println("inside findStudentsBySchoolName");
		List<Student> studentList = new ArrayList<Student>();
		ParameterizedTypeReference<List<Student>> typeRef = new ParameterizedTypeReference<List<Student>>() {
		};

		ResponseEntity<List<Student>> responseEntity = restTemplate.exchange(
				"http://student-service/student-api/v1/students?schoolname={schoolName}", HttpMethod.GET,
				new HttpEntity<>(studentList), typeRef, schoolName);

		return responseEntity.getBody();
	}

	@Override
	public List<Student> findAllStudents() {
		System.out.println("inside findAllStudents");
		List<Student> studentList = new ArrayList<Student>();
		ParameterizedTypeReference<List<Student>> typeRef = new ParameterizedTypeReference<List<Student>>() {
		};
		System.out.println("Before calling");
		ResponseEntity<List<Student>> responseEntity = restTemplate.exchange(
				"http://student-service/student-api/v1/students", HttpMethod.GET, new HttpEntity<>(studentList),
				typeRef);

		System.out.println("responseEntity--->" + responseEntity);
		return responseEntity.getBody();
	}

	/*
	 * @Override public List<Student> getStudents(String schoolname) { // TODO
	 * Auto-generated method stub return null; }
	 * 
	 * @Override public List<Student> getStudentsByName(String studentName) { //
	 * TODO Auto-generated method stub return null; }
	 */
}
