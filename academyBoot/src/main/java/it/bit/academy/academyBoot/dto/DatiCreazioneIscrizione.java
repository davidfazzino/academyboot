package it.bit.academy.academyBoot.dto;

public class DatiCreazioneIscrizione {
	private int idCorso;
	private int idStudente;
	public int getIdCorso() {
		return idCorso;
	}
	public void setIdCorso(int idCorso) {
		this.idCorso = idCorso;
	}
	public int getIdStudente() {
		return idStudente;
	}
	public void setIdStudente(int idStudente) {
		this.idStudente = idStudente;
	}
	public DatiCreazioneIscrizione(int idCorso, int idStudente) {
		this.idCorso = idCorso;
		this.idStudente = idStudente;
	}
	public DatiCreazioneIscrizione() {
	
	}
	
}
