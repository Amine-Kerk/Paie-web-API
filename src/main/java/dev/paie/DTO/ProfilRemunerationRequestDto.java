package dev.paie.DTO;

import java.util.List;

import com.sun.istack.NotNull;

public class ProfilRemunerationRequestDto {
	
	@NotNull
	private String code;

   
	private List<Integer> idCotisations;

	
	private List<Integer> idAvantages;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Integer> getIdCotisations() {
		return idCotisations;
	}

	public void setIdCotisations(List<Integer> idCotisations) {
		this.idCotisations = idCotisations;
	}

	public List<Integer> getIdAvantages() {
		return idAvantages;
	}

	public void setIdAvantages(List<Integer> idAvantages) {
		this.idAvantages = idAvantages;
	}

}
