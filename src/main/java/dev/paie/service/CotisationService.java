package dev.paie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Cotisation;
import dev.paie.repository.CotisationRepository;

@Service
public class CotisationService {

	private CotisationRepository cotisationRepository;

	public CotisationService(CotisationRepository cotisationRepository) {
		super();
		this.cotisationRepository = cotisationRepository;
	}

	public Optional<Cotisation> getCotisationWithImposable(boolean imposable) {
		return cotisationRepository.findAllWithImposable(imposable);
	}

}
