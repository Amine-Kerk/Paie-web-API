package dev.paie.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import dev.paie.entite.ProfilRemuneration;
import dev.paie.service.ProfilRemunerationService;

@RestController
@RequestMapping("profils")
public class ProfilRemunerationController {

	private ProfilRemunerationService pService;

	public ProfilRemunerationController(ProfilRemunerationService pService) {
		this.pService = pService;
	}

	@GetMapping
	public ResponseEntity<?> getAllProfils() {

		List<ProfilRemuneration> listeP = pService.listerProfils();

		if (!listeP.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).header("message", "Profils trouvés").body(listeP);

		} else { // listeE.isEmpty = true
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucun Profil enregistré en BDD ");
		}

	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getProfilById(@PathVariable int id) {

		Optional<ProfilRemuneration> optionalProfilRemuneration = pService.getProfilById(id);

		if (optionalProfilRemuneration.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optionalProfilRemuneration.get());

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L’ID fourni ne correspond à aucun profil de rémuneration.");
		}
	}
	
	
	
}

