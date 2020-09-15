package dev.paie.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.RemunerationEmployeRepository;


@Service
public class RemunerationEmployeService {
	
	private RemunerationEmployeRepository repoRemuEmp;
	private EntrepriseService entrepriseService;
	private ProfilRemunerationService profilRemunerationService;
	private GradeService gradeService;
	
	
	public RemunerationEmployeService(RemunerationEmployeRepository repoRemuEmp, EntrepriseService entrepriseService,
			ProfilRemunerationService profilRemunerationService, GradeService gradeService) {
		super();
		this.repoRemuEmp = repoRemuEmp;
		this.entrepriseService = entrepriseService;
		this.profilRemunerationService = profilRemunerationService;
		this.gradeService = gradeService;
	}


	@Transactional
	public RemunerationEmploye ajouterEmploye(String matricule, int idEntreprise, int idProfilRemu, int idGrade) {
		List<String> messagesErreurs = new ArrayList<>();
		
		Optional<Entreprise> optEntreprise = entrepriseService.recupererEntreprise(idEntreprise);
		if (!optEntreprise.isPresent()) {
			messagesErreurs.add("L'id " + idEntreprise + " ne correspond à aucune entreprise.");
		}
		
		Optional<ProfilRemuneration> optProfilRemuneration = profilRemunerationService.getProfilById(idProfilRemu);
		if (!optProfilRemuneration.isPresent()) {
			messagesErreurs.add("L'id " + idProfilRemu + " ne correspond à aucun profil de remunération.");
		}
		
		Optional<Grade> optGrade = gradeService.getGradeById(idGrade);
		if (!optGrade.isPresent()) {
			messagesErreurs.add("L'id " + idGrade + " ne correspond à aucun grade.");
		}
		
		RemunerationEmploye remunerationEmploye = new RemunerationEmploye();
		
	
		remunerationEmploye.setMatricule(matricule);
		remunerationEmploye.setEntreprise(optEntreprise.get());
		remunerationEmploye.setProfilRemuneration(optProfilRemuneration.get());
		remunerationEmploye.setGrade(optGrade.get());
		
		
		
		return repoRemuEmp.save(remunerationEmploye);
	}
	
	public Optional<RemunerationEmploye> getRemuEmployeById (Integer id) {
		return repoRemuEmp.findById(id);
}
	public List<RemunerationEmploye> listerRemuEmploye() {
		return repoRemuEmp.findAll();
	}

}
	
	

