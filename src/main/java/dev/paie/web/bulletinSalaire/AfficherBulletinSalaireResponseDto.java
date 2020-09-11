package dev.paie.web.bulletinSalaire;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import dev.paie.entite.BulletinSalaire;

public class AfficherBulletinSalaireResponseDto extends AfficherBulletinSalaireDto {

	private BigDecimal salaireBrut;
	private BigDecimal netImposable;
	private BigDecimal netApayer;

	public AfficherBulletinSalaireResponseDto(BulletinSalaire bulletinSalaire) {
		this.setDateCreation(LocalDateTime.now());
		this.setMatricule(bulletinSalaire.getRemunerationEmploye().getMatricule());
	}

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
