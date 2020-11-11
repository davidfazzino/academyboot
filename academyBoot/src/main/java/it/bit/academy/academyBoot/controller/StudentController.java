package it.bit.academy.academyBoot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.bit.academy.academyBoot.dto.StudentDto;
import it.bit.academy.academyBoot.exceptions.DataException;
import it.bit.academy.academyBoot.exceptions.StudentNotFoundException;
import it.bit.academy.academyBoot.model.Student;
import it.bit.academy.academyBoot.service.GenericService;
import it.bit.academy.academyBoot.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	private StudentService service;

	@Autowired
	public StudentController(StudentService service) {
		this.service = service;
	}
	
	@GetMapping(value = "/students", produces = "application/json")
	public List<StudentDto> findAll(){
		return service.findAll().stream().map(StudentDto::new).collect(Collectors.toList());
	}
	
	@GetMapping("/students/{id}")
	public StudentDto findById(@PathVariable("id") int id)throws Exception {
		StudentDto st = null;
		try {
			st = new StudentDto(service.findById(id));
		} catch (StudentNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"lo studente non esiste");
		}
		return st;
	}
	
	
	@PostMapping(value = "/students")
	public StudentDto addStudent(@RequestBody StudentDto student) throws Exception {
		Student s = initStudent(student);
		Student sd = service.add(s);
		return new StudentDto(sd);
	}
	
	private Student initStudent(StudentDto s) {
		return new Student(s.getId(), s.getNome(), s.getCognome(), s.getCodiceFiscale(), s.getDataDiNascita(),
				s.getIndirizzo(), s.getMail(),s.getTelefono(), s.getTitoloDiStudio(), s.isSesso());
	}
	
	@DeleteMapping(value = "/students/{id}")
	public void deleteStudent(@PathVariable("id") int id) throws Exception{
		try {
			service.remove(id);
		} catch (StudentNotFoundException e) {
			
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"lo studente non esiste");
		}
	}
	
	@PutMapping(value = "/students")
	public void updateStudent(@RequestBody StudentDto student) {
		service.update(initStudent(student));
	}
	
	
	@GetMapping(value = "/courses/{id}/students")
	public List<StudentDto> findByCourse(@PathVariable("id") int id){
		return service.findByCourse(id).stream().map(StudentDto::new).collect(Collectors.toList());
	}
	
	//http://localhost:8080/api/studentsbysurname?surname=an
	@GetMapping(value = "/studentsbysurname")
	public List<StudentDto> findByCognomeLike(@RequestParam("surname")String partialSurname){
		return service.findByCognomeLike(partialSurname).stream().map(StudentDto::new).collect(Collectors.toList());
		
	}
	
	@GetMapping(value = "/studentsbyname")
	public List<StudentDto> findByNomeLike(@RequestParam("name")String partialName){
		return service.findByNameLike(partialName).stream().map(StudentDto::new).collect(Collectors.toList());
		
	}
	
	
}
