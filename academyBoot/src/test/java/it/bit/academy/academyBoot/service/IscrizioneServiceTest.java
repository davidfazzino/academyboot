package it.bit.academy.academyBoot.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import it.bit.academy.academyBoot.exceptions.IscrizioneNotFoundException;
import it.bit.academy.academyBoot.model.Course;
import it.bit.academy.academyBoot.model.Iscrizione;
import it.bit.academy.academyBoot.model.Student;

@SpringBootTest
@Transactional
public class IscrizioneServiceTest {
	@Autowired
	private IscrizioneService iscrizioneService;
	
	
	@Autowired
	private EntityManager entityManager;
	private int id1;
	private int studentid;
	private int corsoid;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		
	}

	@BeforeEach
	void setUp() throws Exception {
		Student s= new Student("Nome1","Cognome1","123456789",LocalDate.now(),"indirizzoTesting","@hotmail","333322222","laurea",true);
		Course c= new Course("programmazione","python",33,"qwer",3,LocalDate.now(),4);
		Iscrizione i =new Iscrizione(s,c,LocalDate.now());
		entityManager.persist(c);
		corsoid=c.getId();
		entityManager.persist(s);
		studentid=s.getId();
		entityManager.persist(i);
		id1=i.getId();
		
	}

	@AfterEach
	void tearDown() throws Exception {
		
		
	}

	@Test
	void testRemoveByCorsoAndStudente() {
		try {
			
			iscrizioneService.removeByCorsoAndStudente(studentid, corsoid);
			assertThrows(IscrizioneNotFoundException.class,()-> iscrizioneService.findById(id1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
