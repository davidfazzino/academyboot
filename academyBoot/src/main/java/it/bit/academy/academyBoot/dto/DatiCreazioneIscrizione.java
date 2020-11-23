package it.bit.academy.academyBoot.dto;

public class DatiCreazioneIscrizione {
	private Integer idCorso;
	private Integer idStudente;
	
	public Integer getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(Integer idCorso) {
		this.idCorso = idCorso;
	}
	public Integer getIdStudente() {
		return idStudente;
	}
	public void setIdStudente(Integer idStudente) {
		this.idStudente = idStudente;
	}
	public DatiCreazioneIscrizione(Integer idCorso, Integer idStudente) {
		this.idCorso = idCorso;
		this.idStudente = idStudente;
	}
	public DatiCreazioneIscrizione() {
	
	}
	
}
