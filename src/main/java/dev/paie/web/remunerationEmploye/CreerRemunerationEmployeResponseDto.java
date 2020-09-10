package dev.paie.web.remunerationEmploye;

import dev.paie.entite.RemunerationEmploye;

public class CreerRemunerationEmployeResponseDto extends CreerRemunerationEmployeRequestDto {

	public CreerRemunerationEmployeResponseDto(RemunerationEmploye remunerationEmploye) {
		this.setId(remunerationEmploye.getId());
		this.setMatricule(remunerationEmploye.getMatricule());
		this.setEntreprise(remunerationEmploye.getEntreprise());
		this.setProfilRemuneration(remunerationEmploye.getProfilRemuneration());
		this.setGrade(remunerationEmploye.getGrade());
	}

}
