package dev.paie.DTO;

import java.math.BigDecimal;

public class GradeReponseDto {

	private String libelle;

	private BigDecimal salaireAnnuel;

	public GradeReponseDto(String libelle, BigDecimal salaireAnnuel) {
		this.libelle = libelle;
		this.salaireAnnuel = salaireAnnuel;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public BigDecimal getSalaireAnnuel() {
		return salaireAnnuel;
	}

	public void setSalaireAnnuel(BigDecimal salaireAnnuel) {
		this.salaireAnnuel = salaireAnnuel;
	}
}
