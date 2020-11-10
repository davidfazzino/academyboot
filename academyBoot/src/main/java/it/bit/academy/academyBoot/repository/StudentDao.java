package it.bit.academy.academyBoot.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import it.bit.academy.academyBoot.model.Student;

@Repository
public interface StudentDao extends JpaRepository<Student, Integer>{

	@Query("SELECT s FROM Student s WHERE s.nome LIKE %?1%")
	List<Student> findByNameLike(String partialName);
	
	@Query("SELECT s FROM Student s WHERE s.cognome LIKE %?1%")
	List<Student> findByCognomeLike(String partialSurname);
	
	@Query("SELECT s FROM Student s JOIN s.listaIscrizione l WHERE l.course.id = :course")
	List<Student> findByCourse(@Param("course") int courseId);
	
}
