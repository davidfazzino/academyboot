package it.bit.academy.academyBoot.model;
import java.time.LocalDate;
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
@Table ( name = "insegnante" )
public class Professor {
	
	@Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    @Column( name ="id")
	private int id; 
	
	@Column( name ="nome")
	private String nome; 
	
	@Column( name ="cognome")
	private String cognome; 
	
	@Column( name ="codiceFiscale")
	private String codiceFiscale;
	
	@Column( name ="dataDiNascita")
	private LocalDate dataDiNascita;
	
	@Column( name ="email")
	private String email; 
	
	@Column( name ="indirizzo")
	private String indirizzo;
	
	@Column( name ="telefono")
	private String telefono; 
	
	@Column( name ="costoOrario")
	private int costoOrario; 
	
	@Column( name ="partitaIva")
	private String partitaIva;
	
	@Column( name ="titoloDiStudio")
	private String titoloDiStudio;
	
	@OneToMany(mappedBy = "professor",fetch = FetchType.EAGER,cascade=CascadeType.REMOVE)
	private List<Modulo>listaModulo;
	public Professor() {
		
	}
	public Professor(int id, String nome, String cognome, String codiceFiscale, LocalDate dataDiNascita, String email,
			String indirizzo, String telefono, int costoOrario, String partitaIva, String titoloDiStudio) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.codiceFiscale = codiceFiscale;
		this.dataDiNascita = dataDiNascita;
		this.email = email;
		this.indirizzo = indirizzo;
		this.telefono = telefono;
		this.costoOrario = costoOrario;
		this.partitaIva = partitaIva;
		this.titoloDiStudio = titoloDiStudio;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getCostoOrario() {
		return costoOrario;
	}

	public void setCostoOrario(int costoOrario) {
		this.costoOrario = costoOrario;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getTitoloDiStudio() {
		return titoloDiStudio;
	}

	public void setTitoloDiStudio(String titoloDiStudio) {
		this.titoloDiStudio = titoloDiStudio;
	}

	@Override
	public String toString() {
		return "Professor [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", codiceFiscale=" + codiceFiscale
				+ ", dataDiNascita=" + dataDiNascita + ", email=" + email + ", indirizzo=" + indirizzo + ", telefono="
				+ telefono + ", costoOrario=" + costoOrario + ", partitaIva=" + partitaIva + ", titoloDiStudio="
				+ titoloDiStudio + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceFiscale == null) ? 0 : codiceFiscale.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + costoOrario;
		result = prime * result + ((dataDiNascita == null) ? 0 : dataDiNascita.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((indirizzo == null) ? 0 : indirizzo.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((partitaIva == null) ? 0 : partitaIva.hashCode());
		result = prime * result + ((telefono == null) ? 0 : telefono.hashCode());
		result = prime * result + ((titoloDiStudio == null) ? 0 : titoloDiStudio.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Professor))
			return false;
		Professor other = (Professor) obj;
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
		if (costoOrario != other.costoOrario)
			return false;
		if (dataDiNascita == null) {
			if (other.dataDiNascita != null)
				return false;
		} else if (!dataDiNascita.equals(other.dataDiNascita))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (indirizzo == null) {
			if (other.indirizzo != null)
				return false;
		} else if (!indirizzo.equals(other.indirizzo))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (partitaIva == null) {
			if (other.partitaIva != null)
				return false;
		} else if (!partitaIva.equals(other.partitaIva))
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
