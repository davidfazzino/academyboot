package it.bit.academy.academyBoot.service;

import java.util.List;

import it.bit.academy.academyBoot.model.Lezione;

public interface LezioneService extends GenericService<Lezione>{

	List<Lezione> findByAula(String nomeAula);
    
    List<Lezione> findByModulo(String modulo);
}
