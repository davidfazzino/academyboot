package it.bit.academy.academyBoot.dto;

import java.time.LocalDate;

import it.bit.academy.academyBoot.model.Iscrizione;

public class IscrizioneDto {

	private Integer id;
	private LocalDate data;
	private Integer valutazione;
	private Boolean ritirato;
	private Integer studentId;
	private Integer courseId ;
	
	public IscrizioneDto (Iscrizione i) {
		this.id = i.getId();
		this.data = i.getData();
		this.valutazione = i.getValutazione();
		this.ritirato = i.isRitirato();
		this.studentId = i.getStudent().getId();
		this.courseId = i.getCourse().getId();
	}

	public IscrizioneDto() {
		super();
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

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer student) {
		this.studentId = student;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer course) {
		this.courseId = course;
	}
	
}
