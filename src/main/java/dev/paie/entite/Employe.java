package dev.paie.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Employe {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String matricule;

	@ManyToOne
	private Entreprise entreprise;
	
	@ManyToOne
	private ProfilRemuneration profilRenumeration;
	
	@ManyToOne
	private Grade grade;
	
	
	
	
	

	public Employe(String matricule, Entreprise entreprise, ProfilRemuneration profilRenumeration,
			Grade grade) {
		super();
		this.matricule = matricule;
		this.entreprise = entreprise;
		this.profilRenumeration = profilRenumeration;
		this.grade = grade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public ProfilRemuneration getProfilRenumeration() {
		return profilRenumeration;
	}

	public void setProfilRenumeration(ProfilRemuneration profilRenumeration) {
		this.profilRenumeration = profilRenumeration;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
	
	
	
}
