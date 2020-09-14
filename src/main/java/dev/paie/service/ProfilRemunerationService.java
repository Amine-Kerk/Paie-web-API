package dev.paie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import dev.paie.DTO.ProfilRemunerationReponseDto;
import dev.paie.DTO.ProfilRemunerationRequestDto;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.ProfilRemunerationRepository;


@Service
public class ProfilRemunerationService {

	private ProfilRemunerationRepository repoProfilRemu;

	public ProfilRemunerationService(ProfilRemunerationRepository repoProfilRemu) {
		this.repoProfilRemu = repoProfilRemu;
	}

	public List<ProfilRemunerationRequestDto> listerProfils() {

		List<ProfilRemunerationRequestDto> listDto = new ArrayList();

		List<ProfilRemuneration> listProfils = repoProfilRemu.findAll();

		for (ProfilRemuneration profil : listProfils) {
			listDto.add(new ProfilRemunerationReponseDto(profil));
		}
		return listDto;
	}
	
	public Optional<ProfilRemuneration> findById (Integer id) {
		return repoProfilRemu.findById(id);


	}
	
	
}
