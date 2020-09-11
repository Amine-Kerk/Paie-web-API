package dev.paie.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.Entreprise;
import dev.paie.service.EntrepriseService;

@RestController
@RequestMapping("entreprise")
public class EntrepriseController {

	
	private EntrepriseService entrepriseService ;

	public EntrepriseController(EntrepriseService entrepriseService) {
		super();
		this.entrepriseService = entrepriseService;
	} 
	
	
	
	// Get/entreprise
	@GetMapping
    public List<Entreprise> listerEntreprises( @RequestParam Integer start, @RequestParam Integer size) {
        return entrepriseService.listerEntreprises(start, size);
    }
	
	
	
	
	
	

}
