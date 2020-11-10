package it.bit.academy.academyBoot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.bit.academy.academyBoot.exceptions.DataException;
import it.bit.academy.academyBoot.model.Student;
import it.bit.academy.academyBoot.repository.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

	private StudentDao studentDao;
	
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
	public Student findById(int id) throws DataException {
		Optional<Student> st = studentDao.findById(id);
		if(st.isPresent()) {
			return st.get();
		}else {
			throw new DataException("Studente con id " + id + "non trovato!");
		}
		
	}

	@Override
	@Transactional
	public Student add(Student t) {
		return studentDao.save(t);
	}

	@Override
	@Transactional
	public Student remove(int id) throws DataException {
		Optional<Student> st = studentDao.findById(id);
		if(st.isPresent()) {
			studentDao.delete(st.get());
			return st.get();
		}else {
			throw new DataException("Non puoi eliminare lo studente con id " + id + ". Non trovato sul DB!");
		}
	}

	@Override
	@Transactional
	public void update(Student t) {
		studentDao.save(t);
	}
	
	@Override
	@Transactional
	public List<Student> findByNameLike(String partialName){
		return studentDao.findByNameLike(partialName);
	}

	@Override
	public List<Student> findByCourse(int courseId) {
		return studentDao.findByCourse(courseId);
	}

}
