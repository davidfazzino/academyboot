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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table ( name = "studente" )
public class Student {
	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name ="id")
	private int id;
	
	@Column ( name = "nome")
	private String nome;
	
	@Column ( name = "cognome")
	private String cognome;
	
	@Column ( name = "codiceFiscale")
	private String codiceFiscale;
	
	@Column ( name = "dataDiNascita")
	private LocalDate dataDiNascita;
	
	@Column ( name = "indirizzo")
	private String indirizzo;
	
	@Column ( name= "mail")
	private String mail;
	
	@Column ( name= "telefono")
	private String telefono;
	
	@Column ( name = "titoloDiStudio")
	private String titoloDiStudio;
	
	@Column ( name ="sesso")
	private boolean sesso;
	
	@OneToMany(mappedBy="student", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Iscrizione> listaIscrizione;
	
	public List<Iscrizione> getListaIscrizione() {
		return listaIscrizione;
	}

	public void setListaIscrizione(List<Iscrizione> listaIscrizione) {
		this.listaIscrizione = listaIscrizione;
	}

	public Student() {
		
	}
	
	public Student( String nome, String cognome, String codiceFiscale, LocalDate dataDiNascita, String indirizzo,
			String mail, String telefono, String titoloDiStudio, boolean sesso) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataDiNascita = dataDiNascita;
		this.indirizzo = indirizzo;
		this.mail = mail;
		this.telefono = telefono;
		this.titoloDiStudio = titoloDiStudio;
		this.sesso = sesso;
	}
	
	

	public Student(int id, String nome, String cognome, String codiceFiscale, LocalDate dataDiNascita, String indirizzo,
			String mail, String telefono, String titoloDiStudio, boolean sesso) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataDiNascita = dataDiNascita;
		this.indirizzo = indirizzo;
		this.mail = mail;
		this.telefono = telefono;
		this.titoloDiStudio = titoloDiStudio;
		this.sesso = sesso;
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

	@Override
	public String toString() {
		return "Student [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale
				+ ", dataDiNascita=" + dataDiNascita + ", indirizzo=" + indirizzo + ", mail=" + mail + ", telefono="
				+ telefono + ", titoloDiStudio=" + titoloDiStudio + ", sesso=" + sesso + "]";
	}
	
	public void addNewIscrizione(Iscrizione i) {
		if(listaIscrizione== null) {
			listaIscrizione=new ArrayList();
		}
		listaIscrizione.add(i);
		
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((dataDiNascita == null) ? 0 : dataDiNascita.hashCode());
		result = prime * result + id;
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (sesso ? 1231 : 1237);
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((titoloDiStudio == null) ? 0 : titoloDiStudio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Student))
			return false;
		Student other = (Student) obj;
		if (codiceFiscale == null) {
			if (other.codiceFiscale != null)
				return false;
		} else if (!codiceFiscale.equals(other.codiceFiscale))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (dataDiNascita == null) {
			if (other.dataDiNascita != null)
				return false;
		} else if (!dataDiNascita.equals(other.dataDiNascita))
			return false;
		if (id != other.id)
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (sesso != other.sesso)
			return false;
		if (telefono == null) {
			if (other.telefono != null)
				return false;
		} else if (!telefono.equals(other.telefono))
			return false;
		if (titoloDiStudio == null) {
			if (other.titoloDiStudio != null)
				return false;
		} else if (!titoloDiStudio.equals(other.titoloDiStudio))
			return false;
		return true;
	} 
	
	
	
	
	
	
	

}
