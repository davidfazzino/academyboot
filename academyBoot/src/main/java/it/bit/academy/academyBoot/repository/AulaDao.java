package it.bit.academy.academyBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.bit.academy.academyBoot.model.Aula;
@Repository
public interface AulaDao  extends JpaRepository<Aula, Integer>{
	Aula findByNomeAula(String nomeAula);
}
