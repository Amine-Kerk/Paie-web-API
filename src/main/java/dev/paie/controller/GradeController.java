package dev.paie.controller;


import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import dev.paie.entite.Grade;
import dev.paie.service.GradeService;

@RestController
@RequestMapping("grades")
public class GradeController {

	private GradeService gService;

	public GradeController(GradeService gService) {
		this.gService = gService;
	}

	//get all grades
	@GetMapping
	public ResponseEntity<?> getAllGrades() {
			return ResponseEntity.status(HttpStatus.OK).body(gService.listerGrades());
	}
	
	
	//get grade by id
	@GetMapping("{id}")
	public ResponseEntity<?> getGradeById(@PathVariable int id) {
		
		Optional<Grade> optionalGrade = gService.getGradeById(id);

		if (optionalGrade.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optionalGrade.get());

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L’ID fourni ne correspond à aucun Grade.");
		}
	}
		
	}



