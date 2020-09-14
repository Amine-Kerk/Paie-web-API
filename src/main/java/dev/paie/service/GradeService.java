package dev.paie.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.DTO.GradeReponseDto;
import dev.paie.entite.Grade;

import dev.paie.repository.GradeRepository;

@Service
public class GradeService {

	private static final String NB_MOIS_ANNEE = "12";

	private GradeRepository repoGrade;

	public GradeService(GradeRepository repoGrade) {
		this.repoGrade = repoGrade;
	}

	public List<GradeReponseDto> listerGrades() {

		List<GradeReponseDto> listeDto = new ArrayList<>();

		List<Grade> listeGrade = repoGrade.findAll();

		for (Grade grade : listeGrade) {
			BigDecimal salaireAnnuel = grade.getNbHeuresBase().multiply(grade.getTauxBase()).multiply(new BigDecimal(NB_MOIS_ANNEE));
			listeDto.add(new GradeReponseDto(grade.getCode(), salaireAnnuel));
		}
		return listeDto;
	}
	
	
	public Optional<Grade> findById (Integer id) {
		return repoGrade.findById(id);
}

	
	
}
