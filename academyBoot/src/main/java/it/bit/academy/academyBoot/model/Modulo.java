package it.bit.academy.academyBoot.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table ( name = "modulo")
public class Modulo {
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name ="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id_corso")
	@JsonIgnore
	private Course course;
	
	@ManyToOne
	@JoinColumn(name="id_Insegnante")
	@JsonIgnore
	private Professor professor;
	
	@Column(name="nome")
	private String nome;
	
	@Column (name="descrizione")
	private String descrizione;
	
	@Column(name="numero_ore")
	private Integer numeroOre;
	
	@Column(name="data_desiderata")
	private LocalDate dataDesiderata;
	
	@ManyToOne
	@JoinColumn(name="aula_preferita_id")
	private Aula aulaPreferita;
	
	@OneToMany(mappedBy = "modulo",fetch = FetchType.LAZY,cascade= CascadeType.REMOVE)
	private List<Lezione> listaLezione=new ArrayList<Lezione>();
	@OneToMany(mappedBy = "modulo",fetch = FetchType.LAZY,cascade= {CascadeType.REMOVE,CascadeType.PERSIST})
	private List<PreferenzeCalendario> listaPreferenzaCalendario=new ArrayList<PreferenzeCalendario>();
	

	public List<PreferenzeCalendario> getListaPreferenzaCalendario() {
		return listaPreferenzaCalendario;
	}
	public void setListaPreferenzaCalendario(List<PreferenzeCalendario> listaPreferenzaCalendario) {
		this.listaPreferenzaCalendario = listaPreferenzaCalendario;
	}
	public Modulo() {
	
	}
	public Modulo(Integer id, Course corso, Professor professor, String nome, String descrizione,
			Integer numeroOre, LocalDate data, Aula aulaPreferita) {
		this.id = id;
		this.course = corso;
		this.professor = professor;
		this.nome = nome;
		this.descrizione = descrizione;
		this.numeroOre = numeroOre;
		this.dataDesiderata = data;
		this.aulaPreferita = aulaPreferita;
	}
	
	public Modulo(Course corso, Professor professor, String nome, String descrizione,
			Integer numeroOre, LocalDate data, Aula aulaPreferita) {
		this.course = corso;
		this.professor = professor;
		this.nome = nome;
		this.descrizione = descrizione;
		this.numeroOre = numeroOre;
		this.dataDesiderata = data;
		this.aulaPreferita = aulaPreferita;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Course getCorso() {
		return course;
	}
	public void setCourse(Course c) {
		this.course = c;
	}
	public Professor getInsegnante() {
		return professor;
	}
	public void setInsegnante(Professor professor) {
		this.professor = professor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public Integer getNumeroOre() {
		return numeroOre;
	}
	public void setNumeroOre(Integer numeroOre) {
		this.numeroOre = numeroOre;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Lezione> getListaLezione() {
		return listaLezione;
	}
	public void setListaLezione(List<Lezione> listaLezione) {
		this.listaLezione = listaLezione;
	}
	public Course getCourse() {
		return course;
	}

	
	public Aula getAulaPreferita() {
		return aulaPreferita;
	}
	public void setAulaPreferita(Aula aulaPreferita) {
		this.aulaPreferita = aulaPreferita;
	}
	public void addNewLezione(Lezione l) {
		
		listaLezione.add(l);
		
	}
	public LocalDate getDataDesiderata() {
		return dataDesiderata;
	}
	public void setDataDesiderata(LocalDate dataDesiderata) {
		this.dataDesiderata = dataDesiderata;
	}
	
	
}
