package dev.paie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import dev.paie.entite.Grade;

import dev.paie.repository.GradeRepository;

@Service
public class GradeService {

	private GradeRepository gradeRepository;

	public GradeService(GradeRepository gradeRepository) {
		super();
		this.gradeRepository = gradeRepository;
	}
	
	public Optional<Grade> findById (Integer id) {
		return gradeRepository.findById(id);
}
	
	
	
	public List<Grade> listerGrades(Integer numeroPage, Integer taille) {
	return gradeRepository.findAll(PageRequest.of(numeroPage, taille)).getContent();
  
}
	
	
}
