package it.bit.academy.academyBoot.service;

import org.springframework.data.jpa.repository.JpaRepository;

import it.bit.academy.academyBoot.model.Modulo;


public interface ModuloService extends JpaRepository<Modulo, Integer> {

}
