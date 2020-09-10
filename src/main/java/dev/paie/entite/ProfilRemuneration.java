package dev.paie.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class ProfilRemuneration {

	@Id
	private Integer id;
	private String code;

	@ManyToMany
	@JoinTable(name = "profil_remuneration_cotisations", joinColumns = @JoinColumn(name = "profil_remuneration_id"), inverseJoinColumns = @JoinColumn(name = "cotisations_id"))
	private List<Cotisation> cotisations;

	@ManyToMany
	@JoinTable(name = "profil_remuneration_avantages", joinColumns = @JoinColumn(name = "profil_remuneration_id"), inverseJoinColumns = @JoinColumn(name = "avantages_id"))
	private List<Avantage> avantages;

	@OneToMany(mappedBy = "profilRemuneration")
	List<RemunerationEmploye> remunerationEmploye;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Cotisation> getCotisations() {
		return cotisations;
	}

	public void setCotisations(List<Cotisation> cotisations) {
		this.cotisations = cotisations;
	}

	public List<Avantage> getAvantages() {
		return avantages;
	}

	public void setAvantages(List<Avantage> avantages) {
		this.avantages = avantages;
	}

	public List<RemunerationEmploye> getRemunerationEmploye() {
		return remunerationEmploye;
	}

	public void setRemunerationEmploye(List<RemunerationEmploye> remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}

}
