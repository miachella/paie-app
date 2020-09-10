package dev.paie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.repository.ProfilRemunerationRepository;

@Service
public class ProfilRemunerationService {

	private ProfilRemunerationRepository profilRemunerationRepository;

	public ProfilRemunerationService(ProfilRemunerationRepository profilRemunerationRepository) {
		super();
		this.profilRemunerationRepository = profilRemunerationRepository;
	}

	public Optional<ProfilRemuneration> getProfil(int id) {
		return profilRemunerationRepository.findById(id);
	}

}
