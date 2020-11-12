package it.bit.academy.academyBoot.model;

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

@Entity
@Table ( name = "modulo")
public class Modulo {
	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name ="id")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Course course;
	
	@ManyToOne
	@JoinColumn(name="id")
	private Professor professor;
	
	@Column(name="nome")
	private String nome;
	
	@Column (name="descrizione")
	private String descrizione;
	
	@Column(name="numero_ore")
	private int numeroOre;

	@OneToMany(mappedBy = "modulo",fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
	private List<Lezione> listaLezione=new ArrayList<Lezione>();
	
	
	public Modulo() {
	
	}
	public Modulo(Integer id, Course corso, Professor professor, String nome, String descrizione, int numeroOre) {
		super();
		this.id = id;
		this.course = corso;
		this.professor = professor;
		this.nome = nome;
		this.descrizione = descrizione;
		this.numeroOre = numeroOre;
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
	public int getNumeroOre() {
		return numeroOre;
	}
	public void setNumeroOre(int numeroOre) {
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
	
	public void addNewLezione(Lezione l) {
		
		listaLezione.add(l);
		
	}
	
}
