package dev.paie.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.repository.BulletinSalaireRepository;

@Service
public class BulletinSalaireService {

	private BulletinSalaireRepository bulletinSalaireRepository;
	private RemunerationEmployeService remunerationEmployeService;
	private PeriodeService periodeService;
	private CotisationService cotisationService;

	public BulletinSalaireService(BulletinSalaireRepository bulletinSalaireRepository,
			RemunerationEmployeService remunerationEmployeService, PeriodeService periodeService,
			CotisationService cotisationService) {
		super();
		this.bulletinSalaireRepository = bulletinSalaireRepository;
		this.remunerationEmployeService = remunerationEmployeService;
		this.periodeService = periodeService;
		this.cotisationService = cotisationService;
	}

	public List<BulletinSalaire> listerBulletins() {
		return bulletinSalaireRepository.findAll();
	}

}
