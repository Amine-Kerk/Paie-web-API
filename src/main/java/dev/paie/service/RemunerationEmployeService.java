package dev.paie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.DTO.RemunerationEmployeRequestDto;
import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.repository.EntrepriseRepository;
import dev.paie.repository.GradeRepository;
import dev.paie.repository.ProfilRemunerationRepository;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
public class RemunerationEmployeService {
	private RemunerationEmployeRepository repoRemuEmp;
	private EntrepriseRepository repoEntreprise;
	private ProfilRemunerationRepository profilRepo;
	private GradeRepository repoGrade;

	public RemunerationEmployeService(RemunerationEmployeRepository repoRemuEmp, EntrepriseRepository repoEntreprise,
			ProfilRemunerationRepository profilRepo, GradeRepository repoGrade) {
		this.repoRemuEmp = repoRemuEmp;
		this.repoEntreprise = repoEntreprise;
		this.profilRepo = profilRepo;
		this.repoGrade = repoGrade;
	}

	
	public RemunerationEmploye creerRemunerationEmploye(RemunerationEmployeRequestDto dto) {

		RemunerationEmploye returnedRemu = new RemunerationEmploye();

		Optional<Entreprise> entrepriseNewRemu = repoEntreprise.findById(dto.getIdEntreprise());

		Optional<ProfilRemuneration> profilNewRemu = profilRepo.findById(dto.getIdProfilRemu());

		Optional<Grade> gradeNewRemu = repoGrade.findById(dto.getIdGrade());

		if (entrepriseNewRemu.isPresent() && profilNewRemu.isPresent() && gradeNewRemu.isPresent()) {

			RemunerationEmploye newRemu = new RemunerationEmploye (dto.getMatricule(),entrepriseNewRemu.get(),profilNewRemu.get(),gradeNewRemu.get());

			returnedRemu = repoRemuEmp.save(newRemu);
		}

		return returnedRemu;
	}

}
