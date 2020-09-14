package dev.paie.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.DTO.RemunerationEmployeReponseDto;
import dev.paie.DTO.RemunerationEmployeRequestDto;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.service.RemunerationEmployeService;

@RestController
@RequestMapping("remunerations")
public class RemunerationEmployeController {

	private RemunerationEmployeService rService;

	public RemunerationEmployeController(RemunerationEmployeService rService) {
		this.rService = rService;
	}

	@PostMapping
	public ResponseEntity<?> creerRemuneration(@RequestBody RemunerationEmployeRequestDto request,
			BindingResult resValid) {

		if (!resValid.hasErrors()) {

			RemunerationEmploye newRemu = rService.creerRemunerationEmploye(request);

			RemunerationEmployeReponseDto reponse = new RemunerationEmployeReponseDto(newRemu);

			return ResponseEntity.ok(reponse);
		} else {
			return ResponseEntity.badRequest().body(" Tous les champs sont obligatoires !");
		}

	}

}
