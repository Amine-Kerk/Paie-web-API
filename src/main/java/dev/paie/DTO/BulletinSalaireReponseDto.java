package dev.paie.DTO;

import java.math.BigDecimal;


public class BulletinSalaireReponseDto extends BulletinSalaireRequestDto {
	
	
	private BigDecimal salaireBrut;
	private BigDecimal netImposable;
	private BigDecimal netApayer;
	
	
	
	
	public BigDecimal getSalaireBrut() {
		return salaireBrut;
	}

	public void setSalaireBrut(BigDecimal salaireBrut) {
		this.salaireBrut = salaireBrut;
	}

	public BigDecimal getNetImposable() {
		return netImposable;
	}

	public void setNetImposable(BigDecimal netImposable) {
		this.netImposable = netImposable;
	}

	public BigDecimal getNetApayer() {
		return netApayer;
	}

	public void setNetApayer(BigDecimal netApayer) {
		this.netApayer = netApayer;
	}

}
	

	
