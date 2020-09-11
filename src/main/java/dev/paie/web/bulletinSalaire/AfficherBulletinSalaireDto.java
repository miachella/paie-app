package dev.paie.web.bulletinSalaire;

import java.time.LocalDateTime;

import dev.paie.entite.Periode;

public class AfficherBulletinSalaireDto {

	private LocalDateTime dateCreation;
	private Periode periode;
	private String Matricule;

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Periode getPeriode() {
		return periode;
	}

	public void setPeriode(Periode periode) {
		this.periode = periode;
	}

	public String getMatricule() {
		return Matricule;
	}

	public void setMatricule(String matricule) {
		Matricule = matricule;
	}

}
