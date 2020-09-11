package dev.paie.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import dev.paie.entite.ProfilRemuneration;
import dev.paie.service.ProfilService;

@RestController
@RequestMapping("profil")
public class ProfilController {

	
	private ProfilService profilService ;

	public ProfilController(ProfilService profilService) {
		super();
		this.profilService = profilService;
	} 
	
	// Get/grade
			@GetMapping
		    public List<ProfilRemuneration> listerProfils( @RequestParam Integer start, @RequestParam Integer size) {
		        return profilService.listerProfils(start, size);
		    }
}
