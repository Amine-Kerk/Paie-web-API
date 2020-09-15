package dev.paie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.repository.EntrepriseRepository;

@Service
public class EntrepriseService {

	

		private EntrepriseRepository repoEntreprise;

		public EntrepriseService(EntrepriseRepository repoEntreprise) {
			this.repoEntreprise = repoEntreprise;
		}

		public Optional<Entreprise> recupererEntreprise(int id) {
			return repoEntreprise.findById(id);
		}

		public List<Entreprise> listerEntreprise() {
			return repoEntreprise.findAll();
		}
		
		public Optional<Entreprise> findEntrepriseById (Integer id) {
			return repoEntreprise.findById(id);
		}
    
		
	
}
