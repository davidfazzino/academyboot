package it.bit.academy.academyBoot.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import it.bit.academy.academyBoot.model.Student;
@SpringBootTest
@Transactional
public class StudentServiceTest {
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private EntityManager entityManager;
	private int id1;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		
	}

	@BeforeEach
	public void setUp() throws Exception {//prima di ogni metodo di test
		Student s= new Student("Nome1","Cognome1","123456789",LocalDate.now(),"indirizzoTesting","@hotmail","333322222","laurea",true);
		
		//s=studentService.add(s);
		entityManager.persist(s);
		id1=s.getId();
		

		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	
	//@Test
	void testServiceHasRepository() {
		assertTrue(studentService.getClass()==StudentServiceImpl.class);
		StudentServiceImpl ssi=(StudentServiceImpl)studentService;
		assertNotNull(ssi.getStudentDao());
		
		
	}
	
	@Test
	void testFindById() {
		
		try {
			Student s=studentService.findById(id1);
			assertNotNull(s);
			assertEquals("123456789", s.getCodiceFiscale());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	void testFindByCognomeLike() {
		try {
			List<Student> studentiLista=studentService.findByCognomeLike("cognome1");
			
			assertNotNull(studentiLista.stream().filter(s->s.getCodiceFiscale().equals("123456789")).findFirst());
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

}
