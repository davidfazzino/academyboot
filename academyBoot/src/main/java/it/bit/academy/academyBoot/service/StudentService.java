package it.bit.academy.academyBoot.service;

import java.util.List;
import java.util.Map;
import it.bit.academy.academyBoot.model.Student;

public interface StudentService extends GenericService<Student> {

	Map<String, Object> findStudentsInPages(Integer pageN, Integer size, String sortBy);
	List<Student> findByNameLike(String partialName);
	List<Student> findByCourse(int courseId);
	List<Student> findByCognomeLike(String partialSurname);
}
