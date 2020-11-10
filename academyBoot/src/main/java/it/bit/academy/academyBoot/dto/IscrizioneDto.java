package it.bit.academy.academyBoot.dto;

import java.time.LocalDate;

import it.bit.academy.academyBoot.model.Iscrizione;

public class IscrizioneDto {

	private Integer id;
	private LocalDate data;
	private Integer valutazione;
	private Boolean ritirato;
	private Integer student;
	private Integer course ;
	
	public IscrizioneDto (Iscrizione i) {
		this.id = i.getId();
		this.data = i.getData();
		this.valutazione = i.getValutazione();
		this.ritirato = i.isRitirato();
		this.student = i.getStudent().getId();
		this.course = i.getCourse().getId();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Integer getValutazione() {
		return valutazione;
	}

	public void setValutazione(Integer valutazione) {
		this.valutazione = valutazione;
	}

	public Boolean getRitirato() {
		return ritirato;
	}

	public void setRitirato(Boolean ritirato) {
		this.ritirato = ritirato;
	}

	public Integer getStudent() {
		return student;
	}

	public void setStudent(Integer student) {
		this.student = student;
	}

	public Integer getCourse() {
		return course;
	}

	public void setCourse(Integer course) {
		this.course = course;
	}
	
}
