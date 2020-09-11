package dev.paie.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import dev.paie.entite.Grade;
import dev.paie.service.GradeService;

@RestController
@RequestMapping("grade")
public class GradeController {

	
	private GradeService gradeService ;

	public GradeController(GradeService gradeService) {
		super();
		this.gradeService = gradeService;
	}
	
	// Get/grade
		@GetMapping
	    public List<Grade> listerGrades( @RequestParam Integer start, @RequestParam Integer size) {
	        return gradeService.listerGrades(start, size);
	    }
}
