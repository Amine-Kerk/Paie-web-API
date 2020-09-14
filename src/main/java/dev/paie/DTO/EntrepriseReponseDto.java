package dev.paie.DTO;

public class EntrepriseReponseDto {

	private String siret;
	private String denomination;

	public EntrepriseReponseDto() {
	}

	public EntrepriseReponseDto(String siret, String denomination) {
		this.siret = siret;
		this.denomination = denomination;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}
}

