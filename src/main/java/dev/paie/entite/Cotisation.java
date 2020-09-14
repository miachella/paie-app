package dev.paie.entite;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Cotisation {

	@Id
	private Integer id;
	private String code;
	private String libelle;

	@Column(columnDefinition = "Decimal(10,6)")
	private BigDecimal tauxSalarial;

	@Column(columnDefinition = "Decimal(10,6)")
	private BigDecimal tauxPatronal;
	private Boolean imposable = false;

	@ManyToMany
	@JoinTable(name = "profil_remuneration_cotisations", joinColumns = @JoinColumn(name = "cotisations_id"), inverseJoinColumns = @JoinColumn(name = "profil_remuneration_id"))
	private List<ProfilRemuneration> profilRemunerations;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public BigDecimal getTauxSalarial() {
		return tauxSalarial;
	}

	public void setTauxSalarial(BigDecimal tauxSalarial) {
		this.tauxSalarial = tauxSalarial;
	}

	public BigDecimal getTauxPatronal() {
		return tauxPatronal;
	}

	public void setTauxPatronal(BigDecimal tauxPatronal) {
		this.tauxPatronal = tauxPatronal;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getImposable() {
		return imposable;
	}

	public void setImposable(Boolean imposable) {
		this.imposable = imposable;
	}

	public List<ProfilRemuneration> getProfilRemunerations() {
		return profilRemunerations;
	}

	public void setProfilRemunerations(List<ProfilRemuneration> profilRemunerations) {
		this.profilRemunerations = profilRemunerations;
	}
}
