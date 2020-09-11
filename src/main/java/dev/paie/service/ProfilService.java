package dev.paie.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.ProfilRepository;

@Service
public class ProfilService {

	private ProfilRepository profilRepository;

	public ProfilService(ProfilRepository profilRepository) {
		super();
		this.profilRepository = profilRepository;
	}
	
	public Optional<ProfilRemuneration> findById (Integer id) {
		return profilRepository.findById(id);
		
		
	}
	
	
	public List<ProfilRemuneration> listerProfils(Integer numeroPage, Integer taille) {
		return profilRepository.findAll(PageRequest.of(numeroPage, taille)).getContent();
	  
	}
	
	
	
}
