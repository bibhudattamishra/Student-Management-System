package com.sapient.studentproducer.unittest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sapient.studentproducer.StudentApplicationTests;
import com.sapient.studentproducer.model.Student;
import com.sapient.studentproducer.repository.StudentRepository;
import com.sapient.studentproducer.service.StudentServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class StudentServiceMockTest extends StudentApplicationTests{
	@Mock
	StudentRepository studentRepositoryMock;
	@InjectMocks
	StudentServiceImpl studentServiceImpl;
	
	@Test
	public void testFetchStudentsByName() {
		Optional<String> optional = Optional.of("Raju");
		List<Student> studentList = new ArrayList<Student>() {
			private static final long serialVersionUID = 1L;
			{
				add(new Student("001", "Raju", "08MCA07", "SBHS"));
				add(new Student("012", "Raju", "09MBA07", "RSH"));
			}
		};
		when(studentRepositoryMock.findOneByStudentName("Raju")).thenReturn(studentList);
		assertEquals(studentList, studentServiceImpl.fetchStudentsByName(optional));
	}
}
