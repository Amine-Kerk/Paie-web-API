package dev.paie.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import dev.paie.entite.BulletinSalaire;

public class BulletinSalaireReponseDto extends BulletinSalaireRequestDto {

	private int id;
	private LocalDateTime dateCreation;
	private String matricule;
	private BigDecimal salaireBase;
	private BigDecimal salaireBrut;
	private BigDecimal totalRetenueSalariale;
	private BigDecimal netImposable;
	private BigDecimal netAPayer;

	public BulletinSalaireReponseDto(BulletinSalaire bulletin) {
		this.id = bulletin.getId();
		this.setIdRemuEmploye(bulletin.getRemunerationEmploye().getId());
		this.setIdPeriode(bulletin.getPeriode().getId());
		this.setPrimeExceptionelle(bulletin.getPrimeExceptionnelle());

		this.matricule = bulletin.getRemunerationEmploye().getMatricule();
	//	this.dateCreation = bulletin.getDateCreation();
		this.salaireBase = bulletin.getRemunerationEmploye().getGrade().getNbHeuresBase()
				.multiply(bulletin.getRemunerationEmploye().getGrade().getTauxBase());
		this.salaireBrut = this.salaireBase.add(bulletin.getPrimeExceptionnelle());

		this.totalRetenueSalariale = this.salaireBrut.multiply(new BigDecimal(0.3)); // 0.3 = Valeur "magique" via
																						// addition des taux salariaux
																						// obsrvés en BDD
		this.netImposable = this.salaireBrut.subtract(this.totalRetenueSalariale);

		BigDecimal cotisationImposable = this.salaireBrut.multiply(new BigDecimal(0.03)); // 0.003 = valeur magique
																							// observée via aditions des
																							// taux salariés observés en
																							// BDD
		this.netAPayer = this.netImposable.subtract(cotisationImposable);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public BigDecimal getSalaireBase() {
		return salaireBase;
	}

	public void setSalaireBase(BigDecimal salaireBase) {
		this.salaireBase = salaireBase;
	}

	public BigDecimal getSalaireBrut() {
		return salaireBrut;
	}

	public void setSalaireBrut(BigDecimal salaireBrut) {
		this.salaireBrut = salaireBrut;
	}

	public BigDecimal getTotalRetenueSalariale() {
		return totalRetenueSalariale;
	}

	public void setTotalRetenueSalariale(BigDecimal totalRetenueSalariale) {
		this.totalRetenueSalariale = totalRetenueSalariale;
	}

	public BigDecimal getNetImposable() {
		return netImposable;
	}

	public void setNetImposable(BigDecimal netImposable) {
		this.netImposable = netImposable;
	}

	public BigDecimal getNetAPayer() {
		return netAPayer;
	}

	public void setNetAPayer(BigDecimal netAPayer) {
		this.netAPayer = netAPayer;
	}

}
