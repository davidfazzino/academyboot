package it.bit.academy.academyBoot.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bit.academy.academyBoot.dto.LezioneDto;
import it.bit.academy.academyBoot.service.LezioneService;

@RestController
@RequestMapping("/api/lessons")
public class LezioneController {

	private LezioneService lezioneService;
	
	public LezioneController(LezioneService lezioneService) {
		this.lezioneService = lezioneService;
	}
	
	@GetMapping("")
	public ResponseEntity<List<LezioneDto>> findAll(){
		List<LezioneDto> lessons = lezioneService.findAll().stream().map(LezioneDto::new).collect(Collectors.toList());
		if(lessons.isEmpty()) {
			return new ResponseEntity<List<LezioneDto>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LezioneDto>>(lessons, HttpStatus.OK);
	}
}
