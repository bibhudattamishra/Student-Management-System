package com.sapient.studentproducer.unittest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.studentproducer.model.Student;
import com.sapient.studentproducer.repository.StudentRepository;
import com.sapient.studentproducer.service.StudentService;

import static org.mockito.Mockito.when;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceMockSpringContextTest {
	@MockBean
	StudentRepository studentRepositoryMock;

	@Autowired
	StudentService studentServiceImpl;

	@Test
	public void testFetchStudentsByName(String name) {
		Optional<String> optional = Optional.of(name);
		List<Student> studentList = new ArrayList<Student>() {
			private static final long serialVersionUID = 1L;
			{
				add(new Student("001", "Raju", "08MCA07", "SBHS"));
				add(new Student("012", "Raju", "09MBA07", "RSH"));
			}
		};
		when(studentRepositoryMock.findOneByStudentName(name)).thenReturn(studentList);
		assertEquals(studentList, studentServiceImpl.fetchStudentsByName(optional));
	}

}
