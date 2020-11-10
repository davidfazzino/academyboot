package it.bit.academy.academyBoot.service;

import java.util.List;
import java.util.Optional;

import it.bit.academy.academyBoot.exceptions.DataException;
import it.bit.academy.academyBoot.model.Student;

public interface GenericService<T> {
	List<T> findAll();
	Student findById(int id) throws DataException;
	T add(T t);
	T remove(int id) throws DataException;
	void update(T t);
	
}
