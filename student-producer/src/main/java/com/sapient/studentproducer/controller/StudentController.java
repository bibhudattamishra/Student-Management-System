package com.sapient.studentproducer.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.studentproducer.model.Student;
import com.sapient.studentproducer.service.StudentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
//import com.wordnik.swagger.annotations.Api;
//import com.wordnik.swagger.annotations.ApiOperation;

@Api(basePath = "com/sapient/studentproducer/controller", value = "StudentController", description = "Controller for Student Service", produces = "application/json")
@RestController
@RequestMapping("/student-api/v1/students")

public class StudentController {

	@Autowired
	StudentService service;

	@RequestMapping(value = "/register", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Register Student", notes = "Registers a Student")

	public void registerStudent(@RequestBody Student student) {
		service.registerStudent(student);
	}

	@RequestMapping(value = "/{studentId}")
	@ApiOperation(value = "Find Student By Id", notes = "Accepts a studentId and returns student detail")
	public Optional<Student> findById(@PathVariable String studentId) {
		return service.fetchStudentById(studentId);
	}

/*	@GetMapping
	@ApiOperation(value = "Find Students By Name", notes = "${StudentController.findByName.notes}")
	public List<Student> findByName(@RequestParam("name") Optional<String> studentName) {
		System.out.println("Here");
		return service.fetchStudentsByName(studentName);

	}*/

	/*
	 * @GetMapping(value = "/getStudentDetailsForSchool/{schoolName}")
	 * 
	 * @ApiOperation(value = "Find Students By School Name", notes
	 * ="${StudentController.findBySchoolName.notes}") public List<Student>
	 * findBySchoolName(@PathVariable String schoolName) { return
	 * service.findStudentsBySchoolName(schoolName); }
	 */

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "Update Student", notes = "Accepts student details and updates the same")
	public void update(@RequestBody Student student) {
		service.updateStudent(student);
	}

	@RequestMapping(value = "/{studentId}", method = RequestMethod.DELETE)
	@ApiOperation(value = "Delete Student", notes = "Accepts a studentId and removes the student")
	public void delete(@PathVariable String studentId) {
		service.removeStudent(studentId);
	}

	@GetMapping
	@ApiOperation(value = "Find Students By Name /School Name /All Students", notes = "Accepts a student name/school name or nothing and returns corresponding/all student(s) details")
	public List<Student> findByNameSchoolName(@RequestParam Map<String, String> requestParams) {
		//System.out.println("********inside findBySchoolName2 student*******");
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

}
