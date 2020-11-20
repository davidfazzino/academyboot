package it.bit.academy.academyBoot.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.bit.academy.academyBoot.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{

	Page<Student> findAll(Pageable pageable);
	
	List<Student> findByNomeContaining(String partialName);
	
	List<Student> findByCognomeContaining(String partialSurname);
	
	@Query("SELECT s FROM Student s JOIN s.listaIscrizione l WHERE l.course.id = :course")
	List<Student> findByCourse(@Param("course") int courseId);
	
}
