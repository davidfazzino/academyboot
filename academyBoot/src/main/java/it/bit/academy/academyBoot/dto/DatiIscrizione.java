package it.bit.academy.academyBoot.dto;

public class DatiIscrizione {
	private Integer iscrizioneId;
	private Integer valutazione;
	private Boolean ritirato;
	
	public Boolean getRitirato() {
		return ritirato;
	}
	public void setRitirato(Boolean ritirato) {
		this.ritirato = ritirato;
	}
	public Integer getIscrizioneId() {
		return iscrizioneId;
	}
	public void setIscrizioneId(Integer iscrizioneId) {
		this.iscrizioneId = iscrizioneId;
	}
	public Integer getValutazione() {
		return valutazione;
	}
	public void setValutazione(Integer valutazione) {
		this.valutazione = valutazione;
	}
	public DatiIscrizione(Integer iscrizioneId, Integer valutazione, Boolean ritirato) {
		
		this.iscrizioneId = iscrizioneId;
		this.valutazione = valutazione;
		this.ritirato=ritirato;
	}
	public DatiIscrizione() {
	
	}
	
}
