package dev.paie.DTO;

import java.math.BigDecimal;

import com.sun.istack.NotNull;

public class AvantageRequestDto {
	
	@NotNull
	private String code;

	@NotNull
	private String nom;

	@NotNull
	private BigDecimal montant;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getMontant() {
		return montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

}
