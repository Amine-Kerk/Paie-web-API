package dev.paie.DTO;

import dev.paie.entite.Cotisation;

public class CotisationReponseDto extends CotisationRequestDto {

	private int id;

	public CotisationReponseDto(Cotisation cotisation) {

		this.id = cotisation.getId();
		this.setCode(cotisation.getCode());
		this.setLibelle(cotisation.getLibelle());
		this.setTauxPatronal(cotisation.getTauxPatronal());
		this.setTauxSalarial(cotisation.getTauxSalarial());
		this.setImposable(cotisation.getImposable());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
