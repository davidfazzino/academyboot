package it.bit.academy.academyBoot.service;

import it.bit.academy.academyBoot.dto.CourseDto;
import it.bit.academy.academyBoot.exceptions.CourseNotFoundException;
import it.bit.academy.academyBoot.model.Course;

public interface CorsoService extends GenericService<Course> {

	Course add(CourseDto t) throws CourseNotFoundException;

}
