package dev.paie.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.DTO.RemunerationEmployeReponseDto;
import dev.paie.DTO.RemunerationEmployeRequestDto;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.service.RemunerationEmployeService;

@RestController
@RequestMapping("employes")
public class RemunerationEmployeController {

	private RemunerationEmployeService rService;

	public RemunerationEmployeController(RemunerationEmployeService rService) {
		this.rService = rService;
	}
	
	//get list tous les employes 
	@GetMapping
	public ResponseEntity<?> getAllRemuEmploye() {
			return ResponseEntity.status(HttpStatus.OK).body(rService.listerRemuEmploye());
	}
	
	//get employés par /ID
	@GetMapping("{id}")
	public ResponseEntity<?> getRemuEmployeById(@PathVariable int id) {
		
		Optional<RemunerationEmploye> optionalRemuEmploye = rService.getRemuEmployeById(id);

		if (optionalRemuEmploye.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optionalRemuEmploye.get());

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L’ID fourni ne correspond à aucun employé.");
		}
	}
		
    
	@PostMapping
	public ResponseEntity<?> ajouterEmploye(@RequestBody RemunerationEmployeRequestDto dto,
			BindingResult resValid) {

		if (!resValid.hasErrors()) {

			RemunerationEmploye newRemu = rService.ajouterEmploye(dto.getMatricule(), dto.getIdEntreprise(), dto.getIdProfilRemu(), dto.getIdGrade());

			RemunerationEmployeReponseDto reponse = new RemunerationEmployeReponseDto(newRemu);

			return ResponseEntity.ok(reponse);
		} else {
			return ResponseEntity.badRequest().body(" Tous les champs sont obligatoires !");
		}

	}

}
