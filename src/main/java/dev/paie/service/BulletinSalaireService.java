package dev.paie.service;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinSalaireRepository;



@Service
public class BulletinSalaireService {

	private BulletinSalaireRepository bulletinSalaireRepository;
	private CotisationService cotisationService;
	
	public BulletinSalaireService(BulletinSalaireRepository bulletinSalaireRepository,
			CotisationService cotisationService) {
		super();
		this.bulletinSalaireRepository = bulletinSalaireRepository;
		this.cotisationService = cotisationService;
	}
	
	
	
	public List<BulletinSalaire> listerBulletins() {
		return bulletinSalaireRepository.findAll();
	}
	
	
	
}
