package it.bit.academy.academyBoot.dto;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.bit.academy.academyBoot.model.Modulo;
import it.bit.academy.academyBoot.model.PreferenzeCalendario;

public class PreferenzeCalendarioDto {
	
	private Integer id;
	
	private Integer modulo;
	
	private DayOfWeek giorno;
	
	private LocalTime oraInizio;
	
	private LocalTime oraFine;

	public PreferenzeCalendarioDto(PreferenzeCalendario pc) {
		this.modulo = pc.getModulo().getId();
		this.giorno = pc.getGiorno();
		this.oraInizio = pc.getOraInizio();
		this.oraFine = pc.getOraFine();
	}

	public PreferenzeCalendarioDto() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getModulo() {
		return modulo;
	}

	public void setModulo(Integer modulo) {
		this.modulo = modulo;
	}

	public DayOfWeek getGiorno() {
		return giorno;
	}

	public void setGiorno(DayOfWeek giorno) {
		this.giorno = giorno;
	}

	public LocalTime getOraInizio() {
		return oraInizio;
	}

	public void setOraInizio(LocalTime oraInizio) {
		this.oraInizio = oraInizio;
	}

	public LocalTime getOraFine() {
		return oraFine;
	}

	public void setOraFine(LocalTime oraFine) {
		this.oraFine = oraFine;
	}
	
	
	
	
}
