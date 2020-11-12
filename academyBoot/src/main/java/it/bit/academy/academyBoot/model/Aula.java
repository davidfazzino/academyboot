package it.bit.academy.academyBoot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table ( name = "aula")
public class Aula {
	
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name ="id")
	private Integer id;
	
	@Column(name="nome_aula")
	private String nomeAula;
	
	@Column(name="capienza_max")
	private Integer capienzaMax;
	
	@Column(name="computer_max")
	private Integer computerMax;
	
	@Column(name="proiettore")
	private Boolean proiettore;
	
	@Column(name="piattaforma")
	private String piattaforma;

	public Aula() {
		
	}
	
	public Aula(Integer id, String nomeAula, Integer capienzaMax, Integer computerMax, Boolean proiettore,
			String piattaforma) {
		this.id = id;
		this.nomeAula = nomeAula;
		this.capienzaMax = capienzaMax;
		this.computerMax = computerMax;
		this.proiettore = proiettore;
		this.piattaforma = piattaforma;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeAula() {
		return nomeAula;
	}

	public void setNomeAula(String nomeAula) {
		this.nomeAula = nomeAula;
	}

	public Integer getCapienzaMax() {
		return capienzaMax;
	}

	public void setCapienzaMax(Integer capienzaMax) {
		this.capienzaMax = capienzaMax;
	}

	public Integer getComputerMax() {
		return computerMax;
	}

	public void setComputerMax(Integer computerMax) {
		this.computerMax = computerMax;
	}

	public Boolean getProiettore() {
		return proiettore;
	}

	public void setProiettore(Boolean proiettore) {
		this.proiettore = proiettore;
	}

	public String getPiattaforma() {
		return piattaforma;
	}

	public void setPiattaforma(String piattaforma) {
		this.piattaforma = piattaforma;
	}

	
	
	
	
	
}
