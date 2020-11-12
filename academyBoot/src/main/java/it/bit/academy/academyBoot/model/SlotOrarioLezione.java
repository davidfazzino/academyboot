package it.bit.academy.academyBoot.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class SlotOrarioLezione {
	private LocalTime oraInizio;
	private LocalTime oraFine;
	private DayOfWeek giorno;
	
	public SlotOrarioLezione(PreferenzeCalendario p) {
		this.oraInizio=p.getOraInizio();
		this.oraFine=p.getOraFine();
		this.giorno=p.getGiorno();
		

	}
	
	
	public SlotOrarioLezione(LocalTime oraInizio, LocalTime oraFine) {
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
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


	public DayOfWeek getGiorno() {
		return giorno;
	}


	public void setGiorno(DayOfWeek giorno) {
		this.giorno = giorno;
	}


	
	

}
