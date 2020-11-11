package it.bit.academy.academyBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.bit.academy.academyBoot.exceptions.DataException;
import it.bit.academy.academyBoot.exceptions.StudentNotFoundException;
import it.bit.academy.academyBoot.model.Student;
import it.bit.academy.academyBoot.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	protected StudentDao getStudentDao() {
		return studentDao;
	}
	@Autowired
	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}
	
	@Override
	@Transactional
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@Override
	@Transactional
	public Student findById(int id) throws StudentNotFoundException {
		Optional<Student> st = studentDao.findById(id);
		
		return st.orElseThrow(()->new StudentNotFoundException("Studente con id " + id + "non trovato!"));
		
	}

	@Override
	@Transactional
	public Student add(Student t) {
		return studentDao.save(t);
	}

	@Override
	@Transactional
	public void remove(int id) throws StudentNotFoundException {
		Optional<Student> st = studentDao.findById(id);
		Student s = st.orElseThrow(()->new StudentNotFoundException("Studente con id " + id + "non trovato!"));
		studentDao.delete(s);
		
	}

	@Override
	@Transactional
	public void update(Student t) {
		studentDao.save(t);
	}
	
	@Override
	@Transactional
	public List<Student> findByNameLike(String partialName){
		return studentDao.findByNomeContaining(partialName);
	}

	@Override
	public List<Student> findByCourse(int courseId) {
		return studentDao.findByCourse(courseId);
	}

	@Override
	public List<Student> findByCognomeLike(String partialSurname) {
		return studentDao.findByCognomeContaining(partialSurname);
	}

}
