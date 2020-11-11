package it.bit.academy.academyBoot.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import it.bit.academy.academyBoot.model.Student;

public class StudentDto {

	private int id;
	private String nome;
	private String cognome;
	private String codiceFiscale;
	private LocalDate dataDiNascita;
	private String indirizzo;
	private String mail;
	private String telefono;
	private String titoloDiStudio;
	private boolean sesso;
	private List<IscrizioneDto> listaIscrizione;
	
	public StudentDto (Student s) {
		this.id = s.getId();
		this.nome = s.getNome();
		this.cognome = s.getCognome();
		this.codiceFiscale = s.getCodiceFiscale();
		this.dataDiNascita = s.getDataDiNascita();
		this.indirizzo = s.getIndirizzo();
		this.mail = s.getMail();
		this.telefono = s.getTelefono();
		this.titoloDiStudio = s.getTitoloDiStudio();
		this.sesso = s.isSesso();
		this.listaIscrizione = s.getListaIscrizione().stream().map(IscrizioneDto::new).collect(Collectors.toList());
	}

	public StudentDto() {
		
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

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public LocalDate getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(LocalDate dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTitoloDiStudio() {
		return titoloDiStudio;
	}

	public void setTitoloDiStudio(String titoloDiStudio) {
		this.titoloDiStudio = titoloDiStudio;
	}

	public boolean isSesso() {
		return sesso;
	}

	public void setSesso(boolean sesso) {
		this.sesso = sesso;
	}

	public List<IscrizioneDto> getListaIscrizione() {
		return listaIscrizione;
	}

	public void setListaIscrizione(List<IscrizioneDto> listaIscrizione) {
		this.listaIscrizione = listaIscrizione;
	}
	
	
}
