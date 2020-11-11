package it.bit.academy.academyBoot.service;
import org.springframework.web.bind.annotation.RestController;

import it.bit.academy.academyBoot.dto.DataIscrizione;
import it.bit.academy.academyBoot.dto.IscrizioneDto;
import it.bit.academy.academyBoot.exceptions.CourseNotFoundException;
import it.bit.academy.academyBoot.exceptions.StudentNotFoundException;
import it.bit.academy.academyBoot.model.Iscrizione;


public interface IscrizioneService extends GenericService<Iscrizione>{
	
	void add(DataIscrizione dt) throws StudentNotFoundException, CourseNotFoundException;
	void removeByCorsoAndStudente(int idStudente,int idCorso) throws Exception;
	void updateValutazione(int id,int valutazione)throws Exception;
}
