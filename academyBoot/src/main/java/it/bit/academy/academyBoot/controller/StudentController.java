package it.bit.academy.academyBoot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.bit.academy.academyBoot.dto.StudentDto;
import it.bit.academy.academyBoot.exceptions.DataException;
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
	
	@GetMapping("/student/{id}")
	public StudentDto findById(@PathVariable("id") int id) {
		StudentDto st = null;
		try {
			st = new StudentDto(service.findById(id));
		} catch (DataException e) {
			System.out.println(e.getMessage());
		}
		return st;
	}
	
	@PostMapping(value = "/student/insert")
	public StudentDto addStudent(@RequestBody StudentDto student) {
		Student s = initStudent(student);
		Student sd = service.add(s);
		return new StudentDto(sd);
	}
	
	private Student initStudent(StudentDto s) {
		return new Student(s.getId(), s.getNome(), s.getCognome(), s.getCodiceFiscale(), s.getDataDiNascita(),
				s.getIndirizzo(), s.getMail(),s.getTelefono(), s.getTitoloDiStudio(), s.isSesso());
	}
	
	@DeleteMapping(value = "/student/delete/{id}")
	public StudentDto deleteStudent(@PathVariable("id") int id) throws DataException {
		return new StudentDto(service.remove(id));
	}
	
	@PostMapping(value = "/student/update")
	public void updateStudent(@RequestBody StudentDto student) {
		service.update(initStudent(student));
	}
	
	@GetMapping(value = "/students/{partialName}")
	public List<StudentDto> findByNameLike(@PathVariable("partialName") String partialName){
		return service.findByNameLike(partialName).stream().map(StudentDto::new).collect(Collectors.toList());
	}
	
	//http://localhost:8080/api/students?id=2
	@GetMapping(value = "/students")
	public List<StudentDto> findByCourse(@RequestParam("id") int id){
		return service.findByCourse(id).stream().map(StudentDto::new).collect(Collectors.toList());
	}
	
}
