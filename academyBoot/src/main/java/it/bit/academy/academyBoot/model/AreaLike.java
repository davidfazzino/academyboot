package it.bit.academy.academyBoot.model;

public class AreaLike {
	private String nome; 
	private String descrizione; 
	private String categoria; 
	private boolean certificata;
	
	public AreaLike(String nome, String descrizione, String categoria, boolean certificata) {
		this.nome = nome;
		this.descrizione = descrizione;
		this.categoria = categoria;
		this.certificata = certificata;
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isCertificata() {
		return certificata;
	}

	public void setCertificata(boolean certificata) {
		this.certificata = certificata;
	}

	@Override
	public String toString() {
		return "Area [nome=" + nome + ", descrizione=" + descrizione + ", categoria=" + categoria + ", certificata="
				+ certificata + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((categoria == null) ? 0 : categoria.hashCode());
		result = prime * result + (certificata ? 1231 : 1237);
		result = prime * result + ((descrizione == null) ? 0 : descrizione.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof AreaLike))
			return false;
		AreaLike other = (AreaLike) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		if (certificata != other.certificata)
			return false;
		if (descrizione == null) {
			if (other.descrizione != null)
				return false;
		} else if (!descrizione.equals(other.descrizione))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	} 
	
	
	
	
}
