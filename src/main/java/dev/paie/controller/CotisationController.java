package dev.paie.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import dev.paie.DTO.CotisationReponseDto;
import dev.paie.service.CotisationService;

public class CotisationController {
	private CotisationService cService;

	public CotisationController(CotisationService cService) {
		super();
		this.cService = cService;
	}

	@GetMapping("all")
	public ResponseEntity<?> getAllCotisations() {

		List <CotisationReponseDto> listeC = cService.listerCotisations();

		if (!listeC.isEmpty()) {
			return ResponseEntity.status(HttpStatus.OK).header("message", "Cotisations trouvées").body(listeC);

		} else { // listeE.isEmpty = true
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aucune cotisation enregistrée en BDD ");
		}

	}

}
