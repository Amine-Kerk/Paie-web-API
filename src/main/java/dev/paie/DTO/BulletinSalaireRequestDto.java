package dev.paie.DTO;

import java.math.BigDecimal;

import com.sun.istack.NotNull;

public class BulletinSalaireRequestDto {
	@NotNull
	private int idRemuEmploye;

	@NotNull
	private int idPeriode;

	@NotNull
	private BigDecimal primeExceptionelle;

	public int getIdRemuEmploye() {
		return idRemuEmploye;
	}

	public void setIdRemuEmploye(int idRemuEmploye) {
		this.idRemuEmploye = idRemuEmploye;
	}

	public int getIdPeriode() {
		return idPeriode;
	}

	public void setIdPeriode(int idPeriode) {
		this.idPeriode = idPeriode;
	}

	public BigDecimal getPrimeExceptionelle() {
		return primeExceptionelle;
	}

	public void setPrimeExceptionelle(BigDecimal primeExceptionelle) {
		this.primeExceptionelle = primeExceptionelle;
	}

}
