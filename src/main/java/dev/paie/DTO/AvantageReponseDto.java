package dev.paie.DTO;



import dev.paie.entite.Avantage;


public class AvantageReponseDto extends AvantageRequestDto {

	private int id;

	public AvantageReponseDto(Avantage avantage) {

		this.id = avantage.getId();
		this.setCode(avantage.getCode());
		this.setNom(avantage.getNom());
		this.setMontant(avantage.getMontant());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}


	
	
	
	
