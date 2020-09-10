package dev.paie.entite;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Entreprise {

	@Id
	private Integer id;
	private String siret;
	private String denomination;
	private String adresse;
	private String urssaf;
	private String codeNaf;

	@OneToMany(mappedBy = "entreprise")
	List<RemunerationEmploye> remunerationEmploye;

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}

	public String getUrssaf() {
		return urssaf;
	}

	public void setUrssaf(String urssaf) {
		this.urssaf = urssaf;
	}

	public String getCodeNaf() {
		return codeNaf;
	}

	public void setCodeNaf(String codeNaf) {
		this.codeNaf = codeNaf;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<RemunerationEmploye> getRemunerationEmploye() {
		return remunerationEmploye;
	}

	public void setRemunerationEmploye(List<RemunerationEmploye> remunerationEmploye) {
		this.remunerationEmploye = remunerationEmploye;
	}

}
