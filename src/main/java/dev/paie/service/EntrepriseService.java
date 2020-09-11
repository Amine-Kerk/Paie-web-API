package dev.paie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.repository.EntrepriseRepository;

@Service
public class EntrepriseService {

	private EntrepriseRepository entrepriseRepository;

	public EntrepriseService(EntrepriseRepository entrepriseRepository) {
		super();
		this.entrepriseRepository = entrepriseRepository;
	}
	
	public Optional<Entreprise> findById (Integer id) {
		return entrepriseRepository.findById(id);
		
		
	}
	
	
	public List<Entreprise> listerEntreprises(Integer numeroPage, Integer taille) {
	return entrepriseRepository.findAll(PageRequest.of(numeroPage, taille)).getContent();
  
}
	
}
