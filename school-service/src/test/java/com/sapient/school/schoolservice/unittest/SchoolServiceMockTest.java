package com.sapient.school.schoolservice.unittest;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.sapient.school.schoolservice.SchoolServiceApplicationTests;
import com.sapient.school.schoolservice.model.Student;
import com.sapient.school.schoolservice.service.SchoolServiceImpl;

import junit.framework.Assert;

@RunWith(MockitoJUnitRunner.class)
public class SchoolServiceMockTest extends SchoolServiceApplicationTests {
	@InjectMocks
	@Spy
	SchoolServiceImpl schoolServiceImpl;
	@Mock
	RestTemplate restTemplate;

	//@SuppressWarnings({ "deprecation", "unchecked" })
	@SuppressWarnings({ "unchecked", "deprecation" })
	/*public void testGetStudents() throws Exception {
		String schoolName = "SBHS";
		Student student = new Student("002", "Dinesh", "12MCA07", "SBHS");
		List<Student> list = new ArrayList<Student>();
		list.add(student);
		ResponseEntity<List<Student>> myEntity = new ResponseEntity<List<Student>>(HttpStatus.ACCEPTED);
		myEntity = ResponseEntity.accepted().body(list);
		System.out.println("myEntity->" + myEntity);
		schoolServiceImpl.setRestTemplate(restTemplate);
		Mockito.when(restTemplate.exchange(
				Mockito.eq("http://student-service/students/getStudentDetailsForSchool/{schoolname}"),
				Mockito.any(HttpMethod.class), Mockito.any(HttpEntity.class),
				Mockito.any(ParameterizedTypeReference.class), Mockito.eq(schoolName))).thenReturn(myEntity);

		List<Student> studentList = schoolServiceImpl.getStudents(schoolName);
		System.out.println("studentList-->" + studentList);
		Assert.assertEquals(student, studentList.get(0));
	}*/	
	@Test
	public void testFindStudentById() {
		String studentId="002";
		Student student = new Student("002", "Dinesh", "12MCA07", "SBHS");
		ResponseEntity<Student> myEntity = new ResponseEntity<Student>(HttpStatus.ACCEPTED);
		myEntity = ResponseEntity.accepted().body(student);
		schoolServiceImpl.setRestTemplate(restTemplate);
		Mockito.when(restTemplate.exchange(
				Mockito.eq("http://student-service/student-api/v1/students/{studentId}"),
				Mockito.any(HttpMethod.class),Mockito.any(HttpEntity.class),Mockito.any(ParameterizedTypeReference.class),
				Mockito.eq(studentId)
				)).thenReturn(myEntity);
		Student stud=schoolServiceImpl.findStudentById(studentId);
		Assert.assertEquals(stud, student);
		
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Test
	public void testFindStudentsByName() {
		String studentName="Dinesh";
		Student student = new Student("002", "Dinesh", "12MCA07", "SBHS");
		List<Student> list = new ArrayList<Student>();
		list.add(student);
		ResponseEntity<List<Student>> myEntity = new ResponseEntity<List<Student>>(HttpStatus.ACCEPTED);
		myEntity = ResponseEntity.accepted().body(list);
		schoolServiceImpl.setRestTemplate(restTemplate);
		Mockito.when(restTemplate.exchange(
				Mockito.eq("http://student-service/student-api/v1/students?name={studentName}"),
				Mockito.any(HttpMethod.class),Mockito.any(HttpEntity.class),Mockito.any(ParameterizedTypeReference.class),
				Mockito.eq(studentName)
				)).thenReturn(myEntity);
		List<Student> studentList=schoolServiceImpl.findStudentsByName(studentName);
		Assert.assertEquals(list, studentList);
		
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Test
	public void testFindStudentsBySchoolName() {
		String schoolName="SBHS";
		Student student = new Student("002", "Dinesh", "12MCA07", "SBHS");
		List<Student> list = new ArrayList<Student>();
		list.add(student);
		ResponseEntity<List<Student>> myEntity = new ResponseEntity<List<Student>>(HttpStatus.ACCEPTED);
		myEntity = ResponseEntity.accepted().body(list);
		schoolServiceImpl.setRestTemplate(restTemplate);
		Mockito.when(restTemplate.exchange(
				Mockito.eq("http://student-service/student-api/v1/students?schoolname={schoolName}"),
				Mockito.any(HttpMethod.class),Mockito.any(HttpEntity.class),Mockito.any(ParameterizedTypeReference.class),
				Mockito.eq(schoolName)
				)).thenReturn(myEntity);
		List<Student> studentList=schoolServiceImpl.findStudentsBySchoolName(schoolName);
		Assert.assertEquals(list, studentList);
		
	}
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Test
	public void testFindAllStudents() {
		Student student = new Student("002", "Dinesh", "12MCA07", "SBHS");
		List<Student> list = new ArrayList<Student>();
		list.add(student);
		ResponseEntity<List<Student>> myEntity = new ResponseEntity<List<Student>>(HttpStatus.ACCEPTED);
		myEntity = ResponseEntity.accepted().body(list);
		schoolServiceImpl.setRestTemplate(restTemplate);
		Mockito.when(restTemplate.exchange(
				Mockito.eq("http://student-service/student-api/v1/students"),
				Mockito.any(HttpMethod.class),Mockito.any(HttpEntity.class),Mockito.any(ParameterizedTypeReference.class)
				)).thenReturn(myEntity);
		List<Student> studentList=schoolServiceImpl.findAllStudents();
		Assert.assertEquals(list, studentList);
		
	}
}
