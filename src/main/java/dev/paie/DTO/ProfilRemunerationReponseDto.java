package dev.paie.DTO;

import java.util.ArrayList;
import java.util.List;

import dev.paie.entite.Avantage;
import dev.paie.entite.Cotisation;
import dev.paie.entite.ProfilRemuneration;

public class ProfilRemunerationReponseDto extends ProfilRemunerationRequestDto {

	private int id;

	public ProfilRemunerationReponseDto(ProfilRemuneration profilRemu) {
		this.id = profilRemu.getId();
		this.setCode(profilRemu.getCode());

		List<Integer> listIdCotisations = new ArrayList<>();
		for (Cotisation c : profilRemu.getCotisations()) {
			listIdCotisations.add(c.getId());
		}

		List<Integer> listIdAvantages = new ArrayList<>();
		for ( Avantage a : profilRemu.getAvantages()) {
			listIdAvantages.add(a.getId());
		}
		this.setIdAvantages(listIdAvantages);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
