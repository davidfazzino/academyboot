package it.bit.academy.academyBoot.dto;

import it.bit.academy.academyBoot.model.Modulo;

public class ModuloDto {
	private Integer id;
	private Integer idCourse;
	private Integer idProfessor;
	private String nome;
	private int numeroOre;
	private String aulaPreferita;
	
	public ModuloDto() {
		
	}

	public ModuloDto(Modulo m) {
		this.id = m.getId();
		this.idCourse = m.getCorso().getId();
		this.idProfessor = m.getProfessor().getId();
		this.nome = m.getNome();
		this.numeroOre = m.getNumeroOre();
		this.aulaPreferita = m.getAulaPreferita().getNomeAula();
	}
	

}
