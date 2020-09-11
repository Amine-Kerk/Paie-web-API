package dev.paie.service;




import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import dev.paie.DTO.EmployeRequestDto;
import dev.paie.entite.Employe;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.EmployeRepository;
import dev.paie.repository.EntrepriseRepository;

@Service
public class EmployeService {

	private EmployeRepository employeRepository ;
    private EntrepriseService entrepriseService ;
    private GradeService gradeService;
    private ProfilService profilService;
  
    
    
	
	
	
	public EmployeService(EmployeRepository employeRepository, EntrepriseService entrepriseService,
			GradeService gradeService, ProfilService profilService) {
		super();
		this.employeRepository = employeRepository;
		this.entrepriseService = entrepriseService;
		this.gradeService = gradeService;
		this.profilService = profilService;
	}

	



@Transactional
	public Employe ajouterEmploye(EmployeRequestDto employeRequest) {
		
		
		Entreprise entreprise = entrepriseService.findById(employeRequest.getEntrepriseId()).get();
		ProfilRemuneration profilRemuneration=profilService.findById(employeRequest.getProfilRemunerationId()).get();
		Grade grade =gradeService.findById(employeRequest.getGradeId()).get();
		
	Employe nouveauEmploye = new Employe(employeRequest.getMatricule(),entreprise,profilRemuneration,grade);
		
		return employeRepository.save(nouveauEmploye);
	}
	
}
