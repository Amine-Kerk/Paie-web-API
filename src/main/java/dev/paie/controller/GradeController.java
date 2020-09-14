package dev.paie.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

	@GetMapping
	public ResponseEntity<?> getAllGrades() {
			return ResponseEntity.status(HttpStatus.OK).body(gService.listerGrades());
	}

}

