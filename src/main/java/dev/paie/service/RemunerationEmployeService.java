package dev.paie.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.exception.PaieException;
import dev.paie.repository.RemunerationEmployeRepository;

@Service
public class RemunerationEmployeService {

	private RemunerationEmployeRepository remunerationEmployeRepository;
	private EntrepriseService entrepriseService;
	private ProfilRemunerationService profilRemunerationService;
	private GradeService gradeService;

	public RemunerationEmployeService(RemunerationEmployeRepository remunerationEmployeRepository,
			EntrepriseService entrepriseService, ProfilRemunerationService profilRemunerationService,
			GradeService gradeService) {
		super();
		this.remunerationEmployeRepository = remunerationEmployeRepository;
		this.entrepriseService = entrepriseService;
		this.profilRemunerationService = profilRemunerationService;
		this.gradeService = gradeService;
	}

	@Transactional
	public RemunerationEmploye ajouterRemunerationEmploye(Integer id, String matricule, Integer entrepriseId,
			Integer profilRemunerationId, Integer gradeId) {
		List<String> messagesErreurs = new ArrayList<>();

		// récupération de l'instance d'entreprise
		Optional<Entreprise> optEntreprise = entrepriseService.getEntrepriseById(entrepriseId);
		if (!optEntreprise.isPresent()) {
			messagesErreurs.add("L'id " + entrepriseId + " ne correspond à aucune entreprise en BDD.");
		}

		// récupération de l'instance de profil
		Optional<ProfilRemuneration> optProfilRemuneration = profilRemunerationService
				.getProfilById(profilRemunerationId);
		if (!optProfilRemuneration.isPresent()) {
			messagesErreurs
					.add("L'id " + profilRemunerationId + " ne correspond à aucun profil de rémunération en BDD.");
		}

		// récupération de l'instance d'entreprise
		Optional<Grade> optGrade = gradeService.getGradeById(gradeId);
		if (!optEntreprise.isPresent()) {
			messagesErreurs.add("L'id " + gradeId + " ne correspond à aucun grade en BDD.");
		}

		if (!messagesErreurs.isEmpty()) {
			throw new PaieException(messagesErreurs);
		}

		RemunerationEmploye remunerationEmploye = new RemunerationEmploye();
		remunerationEmploye.setId(id);
		remunerationEmploye.setMatricule(matricule);
		remunerationEmploye.setEntreprise(optEntreprise.get());
		remunerationEmploye.setProfilRemuneration(optProfilRemuneration.get());
		remunerationEmploye.setGrade(optGrade.get());

		return remunerationEmployeRepository.save(remunerationEmploye);

	}

}
