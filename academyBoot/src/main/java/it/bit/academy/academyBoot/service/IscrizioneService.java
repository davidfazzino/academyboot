package it.bit.academy.academyBoot.service;
import org.springframework.web.bind.annotation.RestController;

import it.bit.academy.academyBoot.dto.DatiCreazioneIscrizione;
import it.bit.academy.academyBoot.dto.IscrizioneDto;
import it.bit.academy.academyBoot.exceptions.CourseNotFoundException;
import it.bit.academy.academyBoot.exceptions.IscrizioneNotFoundException;
import it.bit.academy.academyBoot.exceptions.StudentNotFoundException;
import it.bit.academy.academyBoot.model.Iscrizione;


public interface IscrizioneService extends GenericService<Iscrizione>{
	
	void add(DatiCreazioneIscrizione dt) throws StudentNotFoundException, CourseNotFoundException;
	void removeByCorsoAndStudente(int idStudente,int idCorso) throws IscrizioneNotFoundException;
	void patchValutazione(int id,Integer valutazione, Boolean ritirato)throws IscrizioneNotFoundException;
}
