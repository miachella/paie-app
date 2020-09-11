package dev.paie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Entreprise;
import dev.paie.repository.EntrepriseRepository;

@Service
public class EntrepriseService {

	private EntrepriseRepository entrepriseRepository;

	public EntrepriseService(EntrepriseRepository entrepriseRepository) {
		super();
		this.entrepriseRepository = entrepriseRepository;
	}

	public Optional<Entreprise> getEntrepriseById(int id) {
		return entrepriseRepository.findById(id);
	}

}
