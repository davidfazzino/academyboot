package it.bit.academy.academyBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.bit.academy.academyBoot.model.Course;
import it.bit.academy.academyBoot.model.Iscrizione;

public interface CourseDao extends JpaRepository<Course, Integer>{

}
