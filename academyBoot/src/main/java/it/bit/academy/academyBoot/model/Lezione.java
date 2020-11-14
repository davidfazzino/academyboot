package it.bit.academy.academyBoot.model;

import java.time.LocalDateTime;

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
@Table ( name = "lezione")
public class Lezione {
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name ="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_modulo")
	@JsonIgnore
	private Modulo modulo;
	
	@ManyToOne
	@JoinColumn(name="id_aula")
	@JsonIgnore
	private Aula aula;
	
	@Column(name="data_inizio")
	private LocalDateTime dataInizio;
	
	@Column(name="data_fine")
	private LocalDateTime dataFine;

	public Lezione() {
		
	}
	
	public Lezione(Integer id, Modulo modulo, LocalDateTime dataInizio, LocalDateTime dataFine, Aula aula) {
		this.id = id;
		this.modulo = modulo;
		this.aula = aula;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}
	
	public Lezione(Modulo modulo, LocalDateTime dataInizio, LocalDateTime dataFine, Aula aula) {
		this.modulo = modulo;
		this.aula = aula;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
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

	public void setIdModulo(Modulo modulo) {
		this.modulo = modulo;
	}



	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public void setModulo(Modulo modulo) {
		this.modulo = modulo;
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
