package com.sapient.school.schoolservice.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.school.schoolservice.model.Student;
import com.sapient.school.schoolservice.service.SchoolService;

@RestController
@RequestMapping("/school-api/v1/schools")
public class SchoolController {

	@Autowired
	SchoolService service;

/*	@RequestMapping(value = "/{schoolname}")
	public List<Student> getStudents(@PathVariable String schoolname) {
		System.out.println("Getting School details for " + schoolname);
		return service.getStudents(schoolname);
	}*/
	/*@RequestMapping(value = "/{schoolname}")
	public List<Student> getStudents(@PathVariable String schoolname) {
		System.out.println("Getting School details for " + schoolname);
		return service.getStudents(schoolname);
	}
	

	@RequestMapping(value = "/students/{/studentId}")
	public Student getStudentById(@PathVariable String studentId) {
		System.out.println("Getting Student details for " + studentId);
		return service.getStudentById(studentId);
	}*/

	@RequestMapping(value = "/students/{studentId}")
	public Student getStudentsById(@PathVariable String studentId) {
		System.out.println("Getting Student details for " + studentId);
		return service.findStudentById(studentId);
	}
	@RequestMapping(value = "/students",method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> findNameSchoolNameStudents(@RequestParam Map<String, String> requestParams) {
		System.out.println("inside findNameSchoolNameStudents");
		String name = requestParams.get("name");
		String schoolName = requestParams.get("schoolname");
		if (!(name == "" || null == name)) {
			return service.findStudentsByName(name);
		} else if (!(schoolName == "" || null == schoolName)) {
			return service.findStudentsBySchoolName(schoolName);
		} else if (requestParams.size() == 0) {
			return service.findAllStudents();
		}
		return null;

	}
	/*@GetMapping
	public void test() {
		System.out.println("******************Hello*****************");
	}*/

}
