package dev.paie.service;


import org.springframework.stereotype.Service;


import dev.paie.repository.PeriodeRepository;
@Service
public class PeriodeService {

	
	private PeriodeRepository repoPeriode;

	public PeriodeService(PeriodeRepository repoPeriode) {
		this.repoPeriode = repoPeriode;
	}

	
}
