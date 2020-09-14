package dev.paie.DTO;

public class EmployeRequestDto {
	private String matricule;
	private Integer entrepriseId;
	private Integer profilRemunerationId;
	private Integer gradeId ;


	public String getMatricule() {
		return matricule;
	}
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public Integer getEntrepriseId() {
		return entrepriseId;
	}
	public void setEntrepriseId(Integer entrepriseId) {
		this.entrepriseId = entrepriseId;
	}
	public Integer getProfilRemunerationId() {
		return profilRemunerationId;
	}
	public void setProfilRemunerationId(Integer profilRemunerationId) {
		this.profilRemunerationId = profilRemunerationId;
	}
	public Integer getGradeId() {
		return gradeId;
	}
	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}
}
