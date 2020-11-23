package it.bit.academy.academyBoot.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.bit.academy.academyBoot.dto.StudentDto;
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
	public void update(Student t) throws StudentNotFoundException {
		Student s = studentDao.findById(t.getId())
				.orElseThrow(()->new StudentNotFoundException("Studente con id " + t.getId() + "non trovato!"));
		s.setNome(t.getNome());
		s.setCognome(t.getCognome());
		//s.setCodiceFiscale(t.getCodiceFiscale());
		s.setDataDiNascita(t.getDataDiNascita());
		s.setIndirizzo(t.getIndirizzo());
		s.setMail(t.getMail());
		s.setTelefono(t.getTelefono());
		s.setTitoloDiStudio(t.getTitoloDiStudio());
		s.setSesso(t.isSesso());
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
	@Override
	public Map<String, Object> findStudentsInPages(Integer pageN, Integer size, String sortBy) {
		Pageable pageable = PageRequest.of(pageN, size, Sort.by(sortBy));
		Page<Student> result = studentDao.findAll(pageable);
		Map<String, Object> response = new HashMap<>();
		List<StudentDto> students = result.getContent().stream().map(StudentDto::new).collect(Collectors.toList());
		response.put("students", students);
		response.put("currentPage", result.getNumber());
		response.put("totalItems", result.getTotalElements());
		response.put("totalPages", result.getTotalPages());
		return response;
	}

}
