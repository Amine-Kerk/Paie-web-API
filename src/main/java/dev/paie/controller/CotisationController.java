package dev.paie.controller;


import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


import dev.paie.entite.Cotisation;
import dev.paie.service.CotisationService;

public class CotisationController {
	private CotisationService cService;

	public CotisationController(CotisationService cService) {
		super();
		this.cService = cService;
	}

	@GetMapping
	public ResponseEntity<?> getAllCotisations() {

		Optional<Cotisation> listeC = cService.getCotisationImposable(true);

		if (!listeC.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).header("message", "Cotisations trouvées").body(listeC);

		} else { // listeE.isEmpty = true
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucune cotisation enregistrée en BDD ");
		}

	}

}
