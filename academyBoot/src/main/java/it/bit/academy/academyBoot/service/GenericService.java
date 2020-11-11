package it.bit.academy.academyBoot.service;

import java.util.List;
import java.util.Optional;

import it.bit.academy.academyBoot.exceptions.DataException;
import it.bit.academy.academyBoot.exceptions.StudentNotFoundException;
import it.bit.academy.academyBoot.model.Student;

public interface GenericService<T> {
	List<T> findAll();
	T findById(int id) throws Exception;
	T add(T t)throws Exception;
	void remove(int id) throws Exception;
	void update(T t);
	
}
