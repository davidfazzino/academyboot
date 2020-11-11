package it.bit.academy.academyBoot.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import it.bit.academy.academyBoot.model.Course;
import it.bit.academy.academyBoot.model.Iscrizione;

public class CourseDto {

	private int id;	
	private String nome;
	private String materia;
	private int maxIscritti;
	private String categoria;
	private LocalDate dataInizio;
	
	private int durataCorso;
	
	private int orarioMinimo;
	
	private String ente;
	
	private String azienda;
	
	private List<IscrizioneDto> listaIscrizione;

	public CourseDto(Course c) {
		this.id = c.getId();
		this.nome = c.getNome();
		this.materia = c.getMateria();
		this.maxIscritti = c.getMaxIscritti();
		this.categoria = c.getCategoria();
		this.dataInizio = c.getDataInizio();
		this.durataCorso = c.getDurataCorso();
		this.orarioMinimo = c.getOrarioMinimo();
		this.ente = c.getEnte();
		this.azienda = c.getAzienda();
		this.listaIscrizione = c.getListaIscrizione().stream().map(IscrizioneDto::new).collect(Collectors.toList());
	}
	public CourseDto() {
		
		}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getMateria() {
		return materia;
	}
	public void setMateria(String materia) {
		this.materia = materia;
	}
	public int getMaxIscritti() {
		return maxIscritti;
	}
	public void setMaxIscritti(int maxIscritti) {
		this.maxIscritti = maxIscritti;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public int getDurataCorso() {
		return durataCorso;
	}
	public void setDurataCorso(int durataCorso) {
		this.durataCorso = durataCorso;
	}
	public int getOrarioMinimo() {
		return orarioMinimo;
	}
	public void setOrarioMinimo(int orarioMinimo) {
		this.orarioMinimo = orarioMinimo;
	}
	public String getEnte() {
		return ente;
	}
	public void setEnte(String ente) {
		this.ente = ente;
	}
	public String getAzienda() {
		return azienda;
	}
	public void setAzienda(String azienda) {
		this.azienda = azienda;
	}
	public List<IscrizioneDto> getListaIscrizione() {
		return listaIscrizione;
	}
	public void setListaIscrizione(List<IscrizioneDto> listaIscrizione) {
		this.listaIscrizione = listaIscrizione;
	}
	
	
}
