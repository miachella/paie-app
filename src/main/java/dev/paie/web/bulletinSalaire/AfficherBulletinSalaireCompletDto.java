package dev.paie.web.bulletinSalaire;

import java.math.BigDecimal;
import java.util.List;

import dev.paie.entite.BulletinSalaire;

public class AfficherBulletinSalaireCompletDto extends AfficherBulletinSalaireResponseDto {

	private BigDecimal base;
	private BigDecimal tauxSalarial;
	private BigDecimal montantSalarial;
	private BigDecimal primeExceptionnelle;
	private List<String> cotisationsNILibelle;
	private List<BigDecimal> cotisationsNITauxSalarial;
	private List<BigDecimal> cotisationsNIMontantSalarial;
	private BigDecimal totalRetenue;
	private List<BigDecimal> cotisationsNITauxPatronal;
	private List<BigDecimal> cotisationsNIMontantPatronal;
	private BigDecimal totalRetenuePatronal;
	private List<String> cotisationsILibelle;
	private List<BigDecimal> cotisationsITauxSalarial;
	private List<BigDecimal> cotisationsIMontantSalarial;

	public AfficherBulletinSalaireCompletDto(BulletinSalaire bulletinSalaire) {
		super(bulletinSalaire);
	}

	public BigDecimal getBase() {
		return base;
	}

	public void setBase(BigDecimal base) {
		this.base = base;
	}

	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}

	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}

	public BigDecimal getMontantSalarial() {
		return montantSalarial;
	}

	public void setMontantSalarial(BigDecimal montantSalarial) {
		this.montantSalarial = montantSalarial;
	}

	public BigDecimal getPrimeExceptionnelle() {
		return primeExceptionnelle;
	}

	public void setPrimeExceptionnelle(BigDecimal primeExceptionnelle) {
		this.primeExceptionnelle = primeExceptionnelle;
	}

	public List<String> getCotisationsNILibelle() {
		return cotisationsNILibelle;
	}

	public void setCotisationsNILibelle(List<String> cotisationsNILibelle) {
		this.cotisationsNILibelle = cotisationsNILibelle;
	}

	public List<BigDecimal> getCotisationsNITauxSalarial() {
		return cotisationsNITauxSalarial;
	}

	public void setCotisationsNITauxSalarial(List<BigDecimal> cotisationsNITauxSalarial) {
		this.cotisationsNITauxSalarial = cotisationsNITauxSalarial;
	}

	public List<BigDecimal> getCotisationsNIMontantSalarial() {
		return cotisationsNIMontantSalarial;
	}

	public void setCotisationsNIMontantSalarial(List<BigDecimal> cotisationsNIMontantSalarial) {
		this.cotisationsNIMontantSalarial = cotisationsNIMontantSalarial;
	}

	public BigDecimal getTotalRetenue() {
		return totalRetenue;
	}

	public void setTotalRetenue(BigDecimal totalRetenue) {
		this.totalRetenue = totalRetenue;
	}

	public List<BigDecimal> getCotisationsNITauxPatronal() {
		return cotisationsNITauxPatronal;
	}

	public void setCotisationsNITauxPatronal(List<BigDecimal> cotisationsNITauxPatronal) {
		this.cotisationsNITauxPatronal = cotisationsNITauxPatronal;
	}

	public List<BigDecimal> getCotisationsNIMontantPatronal() {
		return cotisationsNIMontantPatronal;
	}

	public void setCotisationsNIMontantPatronal(List<BigDecimal> cotisationsNIMontantPatronal) {
		this.cotisationsNIMontantPatronal = cotisationsNIMontantPatronal;
	}

	public BigDecimal getTotalRetenuePatronal() {
		return totalRetenuePatronal;
	}

	public void setTotalRetenuePatronal(BigDecimal totalRetenuePatronal) {
		this.totalRetenuePatronal = totalRetenuePatronal;
	}

	public List<String> getCotisationsILibelle() {
		return cotisationsILibelle;
	}

	public void setCotisationsILibelle(List<String> cotisationsILibelle) {
		this.cotisationsILibelle = cotisationsILibelle;
	}

	public List<BigDecimal> getCotisationsITauxSalarial() {
		return cotisationsITauxSalarial;
	}

	public void setCotisationsITauxSalarial(List<BigDecimal> cotisationsITauxSalarial) {
		this.cotisationsITauxSalarial = cotisationsITauxSalarial;
	}

	public List<BigDecimal> getCotisationsIMontantSalarial() {
		return cotisationsIMontantSalarial;
	}

	public void setCotisationsIMontantSalarial(List<BigDecimal> cotisationsIMontantSalarial) {
		this.cotisationsIMontantSalarial = cotisationsIMontantSalarial;
	}

}
