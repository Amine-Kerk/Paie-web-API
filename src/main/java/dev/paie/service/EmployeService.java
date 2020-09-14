package dev.paie.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import dev.paie.DTO.EmployeRequestDto;
import dev.paie.entite.Employe;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.EmployeRepository;

@Service
public class EmployeService {
	private EmployeRepository employeRepository ;
    private EntrepriseService entrepriseService ;
    private GradeService gradeService;
    private ProfilRemunerationService profilService;


	public EmployeService(EmployeRepository employeRepository, EntrepriseService entrepriseService,
			GradeService gradeService, ProfilRemunerationService profilRenumService) {
		super();
		this.employeRepository = employeRepository;
		this.entrepriseService = entrepriseService;
		this.gradeService = gradeService;
		this.profilService = profilRenumService;
	}


@Transactional
	public Employe ajouterEmploye(EmployeRequestDto employeDto) {
	
		Entreprise entreprise = entrepriseService.findById(employeDto.getEntrepriseId()).get();
		ProfilRemuneration profilRemuneration=profilService.findById(employeDto.getProfilRemunerationId()).get();
		Grade grade =gradeService.findById(employeDto.getGradeId()).get();

		
	Employe nouveauEmploye = new Employe(employeDto.getMatricule(),entreprise,profilRemuneration,grade);

		return employeRepository.save(nouveauEmploye);
	}





}
