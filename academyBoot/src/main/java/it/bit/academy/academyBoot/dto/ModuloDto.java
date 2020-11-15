package it.bit.academy.academyBoot.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import it.bit.academy.academyBoot.model.Modulo;

public class ModuloDto {
	private Integer id;
	private Integer idCourse;
	private Integer idProfessor;
	private String nome;
	private String descrizione;
	private int numeroOre;
	private LocalDate dataDesiderata;
	private Integer aulaPreferita;
	private List<PreferenzeCalendarioDto> listaPreferenze;
	
	public ModuloDto() {
		
	}

	public ModuloDto(Modulo m) {
		this.id = m.getId();
		this.idCourse = m.getCorso().getId();
		this.idProfessor = null; //sistemare appena gestiamo i professori
		this.nome = m.getNome();
		this.descrizione = m.getDescrizione();
		this.numeroOre = m.getNumeroOre();
		this.dataDesiderata = m.getDataDesiderata();
		this.aulaPreferita = m.getAulaPreferita().getId();
		this.listaPreferenze = m.getListaPreferenzaCalendario().stream().map(PreferenzeCalendarioDto::new).collect(Collectors.toList());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdCourse() {
		return idCourse;
	}

	public void setIdCourse(Integer idCourse) {
		this.idCourse = idCourse;
	}

	public Integer getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(Integer idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroOre() {
		return numeroOre;
	}

	public void setNumeroOre(int numeroOre) {
		this.numeroOre = numeroOre;
	}

	public Integer getAulaPreferita() {
		return aulaPreferita;
	}

	public void setAulaPreferita(Integer aulaPreferita) {
		this.aulaPreferita = aulaPreferita;
	}

	public List<PreferenzeCalendarioDto> getListaPreferenze() {
		return listaPreferenze;
	}

	public void setListaPreferenze(List<PreferenzeCalendarioDto> listaPreferenze) {
		this.listaPreferenze = listaPreferenze;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public LocalDate getDataDesiderata() {
		return dataDesiderata;
	}

	public void setDataDesiderata(LocalDate dataDesiderata) {
		this.dataDesiderata = dataDesiderata;
	}
	
	
}
