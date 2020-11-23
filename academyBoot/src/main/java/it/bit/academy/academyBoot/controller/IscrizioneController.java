package it.bit.academy.academyBoot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
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

import it.bit.academy.academyBoot.dto.DatiCreazioneIscrizione;
import it.bit.academy.academyBoot.dto.DatiIscrizione;
import it.bit.academy.academyBoot.dto.IscrizioneDto;
import it.bit.academy.academyBoot.model.Iscrizione;
import it.bit.academy.academyBoot.service.IscrizioneService;

@RestController
@RequestMapping("/api/iscrizione")
@CrossOrigin
public class IscrizioneController {
	private IscrizioneService iscrizioneService ;

	@Autowired
	public IscrizioneController(IscrizioneService iscrizione) {
		this.iscrizioneService = iscrizione;
	}
	
	@PostMapping()
	public void add(@RequestBody DatiCreazioneIscrizione i) {
		
		try {
			iscrizioneService.add(i);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Impossibile iscrivere");
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") int id) {
		
		try {
			 iscrizioneService.remove(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Iscrizione non trovata");
		}
	}
	
	
	@GetMapping()
	public List<IscrizioneDto> findAll() {
		
		return iscrizioneService.findAll().stream().map(IscrizioneDto::new).collect(Collectors.toList());
		
	}
	
	@DeleteMapping(value = "/{idStudente}/{idCorso}")
	public void removeByCorsoAndStudente(@PathVariable("idStudente")int idStudente,@PathVariable("idCorso")int idCorso) {
		try {
			 iscrizioneService.removeByCorsoAndStudente(idStudente,idCorso);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Iscrizione non trovata");
		}	
	}
	
	
	//http://localhost:8080/api/iscrizione
	@PatchMapping()
	public void updateValutazione( @RequestBody DatiIscrizione ds) {
		try {
			iscrizioneService.patchValutazione(ds.getIscrizioneId(), ds.getValutazione(),ds.getRitirato());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Id non trovato");
		}
	}
	
	
	
	
}
