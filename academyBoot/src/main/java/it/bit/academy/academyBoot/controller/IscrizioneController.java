package it.bit.academy.academyBoot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.bit.academy.academyBoot.dto.DataIscrizione;
import it.bit.academy.academyBoot.dto.IscrizioneDto;
import it.bit.academy.academyBoot.model.Iscrizione;
import it.bit.academy.academyBoot.service.IscrizioneService;

@RestController
@RequestMapping("/api")
public class IscrizioneController {
	private IscrizioneService iscrizioneService ;

	@Autowired
	public IscrizioneController(IscrizioneService iscrizione) {
	
		this.iscrizioneService = iscrizione;
	}
	
	@PostMapping("/iscrizione")
	public void add(@RequestBody DataIscrizione i) {
		
		try {
			
			iscrizioneService.add(i);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Dati errati.");
		}
	}
	
	@DeleteMapping(value = "/iscrizione/{id}")
	public void delete(@PathVariable("id") int id) {
		
		try {
			 iscrizioneService.remove(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Iscrizione non trovata");
		}
	}
	
	
	@GetMapping(value="/iscrizione")
	public List<IscrizioneDto> findAll() {
		
		return iscrizioneService.findAll().stream().map(IscrizioneDto::new).collect(Collectors.toList());
		
	}
	
	@DeleteMapping(value = "/iscrizione/{idStudente}/{idCorso}")
	public void removeByCorsoAndStudente(@PathVariable("idStudente")int idStudente,@PathVariable("idCorso")int idCorso) {
		try {
			 iscrizioneService.removeByCorsoAndStudente(idStudente,idCorso);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Iscrizione non trovata");
		}	
	}
	
	
	//http://localhost:8080/api/valutazione/8?val=30
	@PatchMapping(value="/valutazione/{id}")
	public void updateValutazione(@PathVariable("id")int id, @RequestParam("val")int valutazione) {
		try {
			iscrizioneService.updateValutazione(id, valutazione);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Id non trovato");
		}
	}
	
}
