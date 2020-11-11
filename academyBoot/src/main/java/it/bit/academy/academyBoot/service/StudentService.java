package it.bit.academy.academyBoot.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import it.bit.academy.academyBoot.model.Student;
import it.bit.academy.academyBoot.repository.StudentDao;

public interface StudentService extends GenericService<Student> {

	List<Student> findByNameLike(String partialName);
	List<Student> findByCourse(int courseId);
	List<Student> findByCognomeLike(String partialSurname);
}
