package dev.paie.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.DTO.CotisationReponseDto;
import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;
@Service
public class CotisationService {
	private CotisationRepository repoCotisation;

	public CotisationService(CotisationRepository repoCotisation) {
		this.repoCotisation = repoCotisation;
	}

	public List<CotisationReponseDto> listerCotisations() {

		List<CotisationReponseDto> listDto = new ArrayList();

		List<Cotisation> listeCotisations = repoCotisation.findAll();

		for (Cotisation cotisation : listeCotisations) {
			listDto.add(new CotisationReponseDto(cotisation));
		}

		return listDto;
	}

}
