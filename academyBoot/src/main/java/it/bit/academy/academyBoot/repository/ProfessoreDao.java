package it.bit.academy.academyBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.bit.academy.academyBoot.model.Professor;
@Repository
public interface ProfessoreDao extends JpaRepository<Professor, Integer> {

}
