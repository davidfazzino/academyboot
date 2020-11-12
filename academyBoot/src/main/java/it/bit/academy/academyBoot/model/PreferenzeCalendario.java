package it.bit.academy.academyBoot.model;

import java.time.DayOfWeek;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="preferenze_settimanali_modulo")
public class PreferenzeCalendario {
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_modulo")
	@JsonIgnore
	private Modulo modulo;
	//controllare db
	@Column(name="giorno")
	
	private DayOfWeek giorno;
	@Column(name="ora_inizio")
	private LocalTime oraInizio;
	@Column(name="ora_fine")
	private LocalTime oraFine;
	
	
	
	public PreferenzeCalendario() {

	}

	public PreferenzeCalendario(Modulo modulo, DayOfWeek giorno, LocalTime oraInizio, LocalTime oraFine) {
	
		this.modulo = modulo;
		this.giorno = giorno;
		this.oraInizio = oraInizio;
		this.oraFine = oraFine;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Modulo getModulo() {
		return modulo;
	}
	public void setModulo(Modulo modulo) {
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
