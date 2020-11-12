package it.bit.academy.academyBoot.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table ( name = "lezione")
public class Lezione {
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name ="id")
	private Integer id;
	
	@ManyToOne
	@JoinTable(name="id")
	private Modulo modulo;
	
	@Column(name="id_aula")
	private int idAula;
	
	@Column(name="data_inizio")
	private LocalDateTime dataInizio;
	
	@Column(name="data_fine")
	private LocalDateTime dataFine;

	public Lezione() {
		
	}
	
	public Lezione(Integer id, Modulo modulo, int idAula, LocalDateTime dataInizio, LocalDateTime dataFine) {
		super();
		this.id = id;
		this.modulo = modulo;
		this.idAula = idAula;
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

	public int getIdAula() {
		return idAula;
	}

	public void setIdAula(int idAula) {
		this.idAula = idAula;
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
