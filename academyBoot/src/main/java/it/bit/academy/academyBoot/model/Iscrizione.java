package it.bit.academy.academyBoot.model;
import java.time.LocalDate;

import javax.persistence.CascadeType;
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
@Table ( name = "iscrizione")
public class Iscrizione {

	@Id 
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	@Column( name ="id")
	private Integer id;
	
	@Column(name="data")
	private LocalDate data;
	
	@Column(name="valutazione")
	private Integer valutazione;
	
	@Column(name="ritirato")
	private Boolean ritirato;
	
	@ManyToOne
	@JoinColumn(name="id_studente")
	@JsonIgnore
	private Student student;

	@ManyToOne
	@JoinColumn(name="id_corso")
	@JsonIgnore
	private Course course ;
	
	public Iscrizione() {
		
	}
	
	
	public Iscrizione( Student student, Course course,LocalDate data) {
		
		this.data = data;
		this.student = student;
		this.course = course;
	}


	public Iscrizione(Integer id, LocalDate data, Integer valutazione, Boolean ritirato, Student student,
			Course course) {
		super();
		this.id = id;
		this.data = data;
		this.valutazione = valutazione;
		this.ritirato = ritirato;
		this.student = student;
		this.course = course;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public Integer getValutazione() {
		return valutazione;
	}

	public void setValutazione(Integer valutazione) {
		this.valutazione = valutazione;
	}

	public Boolean isRitirato() {
		return ritirato;
	}

	public void setRitirato(boolean ritirato) {
		this.ritirato = ritirato;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Iscrizione{" +
				"id=" + id +
				", data=" + data +
				", valutazione=" + valutazione +
				", ritirato=" + ritirato +
				", student=" + student +
				", course=" + course +
				'}';
	}
}
