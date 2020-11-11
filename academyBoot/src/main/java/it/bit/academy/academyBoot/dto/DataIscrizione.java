package it.bit.academy.academyBoot.dto;

public class DataIscrizione {
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
	public DataIscrizione(int idCorso, int idStudente) {
		this.idCorso = idCorso;
		this.idStudente = idStudente;
	}
	public DataIscrizione() {
	
	}
	
}
