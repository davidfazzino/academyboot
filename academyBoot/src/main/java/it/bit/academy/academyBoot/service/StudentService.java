package it.bit.academy.academyBoot.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import it.bit.academy.academyBoot.model.Student;

public interface StudentService extends GenericService<Student> {

	List<Student> findByNameLike(String partialName);
	
	List<Student> findByCourse(@Param("course") int courseId);
}
