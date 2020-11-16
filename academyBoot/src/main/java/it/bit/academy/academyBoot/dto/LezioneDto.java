package it.bit.academy.academyBoot.dto;

import java.time.LocalDateTime;

import it.bit.academy.academyBoot.model.Lezione;

public class LezioneDto {

	private Integer id;
	private Integer moduloId;
	private Integer aulaId;
	private LocalDateTime dataInizio;
	private LocalDateTime dataFine;
	
	public LezioneDto() {}
	
	public LezioneDto(Lezione l) {
		this.id = l.getId();
		this.moduloId = l.getModulo().getId();
		this.aulaId = l.getAula().getId();
		this.dataInizio = l.getDataInizio();
		this.dataFine = l.getDataFine();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getModuloId() {
		return moduloId;
	}

	public void setModuloId(Integer moduloId) {
		this.moduloId = moduloId;
	}

	public Integer getAulaId() {
		return aulaId;
	}

	public void setAulaId(Integer aulaId) {
		this.aulaId = aulaId;
	}

	public LocalDateTime getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(LocalDateTime dataInizio) {
		this.dataInizio = dataInizio;
	}

	public LocalDateTime getDataFine() {
		return dataFine;
	}

	public void setDataFine(LocalDateTime dataFine) {
		this.dataFine = dataFine;
	}
	
}
