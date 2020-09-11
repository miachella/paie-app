package dev.paie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Periode;
import dev.paie.repository.PeriodeRepository;

@Service
public class PeriodeService {

	private PeriodeRepository periodeRepository;

	public PeriodeService(PeriodeRepository periodeRepository) {
		super();
		this.periodeRepository = periodeRepository;
	}

	public Optional<Periode> getPeriodeById(int id) {
		return periodeRepository.findById(id);
	}

}
