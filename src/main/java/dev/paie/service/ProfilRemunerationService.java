package dev.paie.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.ProfilRemunerationRepository;


@Service
public class ProfilRemunerationService {

	private ProfilRemunerationRepository repoProfilRemu;

	public ProfilRemunerationService(ProfilRemunerationRepository repoProfilRemu) {
		this.repoProfilRemu = repoProfilRemu;
	}

	
	public Optional<ProfilRemuneration> getProfilById (Integer id) {
		return repoProfilRemu.findById(id);
	}
	
	public List<ProfilRemuneration> listerProfils() {
		return repoProfilRemu.findAll();
	}
	
	
}
