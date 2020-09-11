package dev.paie.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.web.bulletinSalaire.AfficherBulletinSalaireResponseDto;

@Service
public class BulletinSalaireService {

	private BulletinSalaireRepository bulletinSalaireRepository;
	private CotisationService cotisationService;

	public BulletinSalaireService(BulletinSalaireRepository bulletinSalaireRepository,
			CotisationService cotisationService) {
		super();
		this.bulletinSalaireRepository = bulletinSalaireRepository;
		this.cotisationService = cotisationService;
	}

	public List<BulletinSalaire> listerBulletins() {
		return bulletinSalaireRepository.findAll();
	}

	public AfficherBulletinSalaireResponseDto convertToDto(BulletinSalaire bs) {

		AfficherBulletinSalaireResponseDto dto = new AfficherBulletinSalaireResponseDto(bs);

		// Calcul salaire brut
		BigDecimal nbH = bs.getRemunerationEmploye().getGrade().getNbHeuresBase();
		BigDecimal taux = bs.getRemunerationEmploye().getGrade().getTauxBase();
		BigDecimal salaireBrut = nbH.multiply(taux);
		salaireBrut = salaireBrut.add(bs.getPrimeExceptionnelle());
		dto.setSalaireBrut(salaireBrut);

		// Calcul net imposable
		BigDecimal sretenue = null;
		List<Cotisation> cotisationNonImposable = cotisationService.getCotisationWithImposable(false);
		for (Cotisation c : cotisationNonImposable) {
			sretenue = (c.getTauxSalarial().multiply(salaireBrut)).add(sretenue);
		}
		BigDecimal netImposable = salaireBrut.subtract(sretenue);
		dto.setNetImposable(netImposable);

		// calcul net a payer
		BigDecimal simposable = null;
		List<Cotisation> cotisationImposable = cotisationService.getCotisationWithImposable(true);
		for (Cotisation c : cotisationImposable) {
			simposable = (c.getTauxSalarial().multiply(salaireBrut)).add(simposable);
		}
		BigDecimal netAPayer = netImposable.subtract(simposable);
		dto.setNetApayer(netAPayer);
		return dto;
	}

}
