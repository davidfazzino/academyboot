package it.bit.academy.academyBoot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import it.bit.academy.academyBoot.dto.CourseDto;
import it.bit.academy.academyBoot.model.Course;
import it.bit.academy.academyBoot.service.CorsoService;

@RestController
@RequestMapping("/api/corso")
public class CorsoController {
	private CorsoService corsoService;
	@Autowired
	public CorsoController(CorsoService cs) {
		this.corsoService=cs;
	}
	
	@PostMapping()
	public void add(@RequestBody CourseDto i) {
		
		try {
		
			corsoService.add(initCourse(i));
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Dati errati.");
		}
	}
	private Course initCourse(CourseDto dt) {
		return new Course(dt.getNome(), dt.getMateria(), dt.getMaxIscritti(), dt.getCategoria(), dt.getDurataCorso(), dt.getDataInizio(), dt.getOrarioMinimo());
		
		
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
