package it.bit.academy.academyBoot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.bit.academy.academyBoot.dto.CourseDto;
import it.bit.academy.academyBoot.service.CorsoService;

@RestController
@RequestMapping("/api/corso")
@CrossOrigin
public class CorsoController {
	
	private CorsoService corsoService;
	
	@Autowired
	public CorsoController(CorsoService cs) {
		this.corsoService=cs;
	}
	
	@GetMapping
	public ResponseEntity<List<CourseDto>> findAll(){
		List<CourseDto> corsi = corsoService.findAll().stream()
				.map(CourseDto::new).collect(Collectors.toList());
		if(corsi.isEmpty()) {
			return new ResponseEntity<List<CourseDto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CourseDto>>(corsi, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CourseDto> findById(@PathVariable("id") int id) {
		CourseDto c = null;
		try {
			c = new CourseDto(corsoService.findById(id));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Corso non trovato!");
		}
		return new ResponseEntity<CourseDto>(c, HttpStatus.OK);
	}
	
	@PostMapping()
	public void add(@RequestBody CourseDto cd) {
		
		try {
		
			corsoService.add(cd);
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Dati errati.");
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable("id") int id) {
		
		
			try {
				corsoService.remove(id);
			} catch (Exception e) {
				e.printStackTrace();
				throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Dati errati.");
				
			}
		
	}
	

}
