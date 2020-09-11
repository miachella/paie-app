package dev.paie.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Cotisation;
import dev.paie.repository.BulletinSalaireRepository;
import dev.paie.web.bulletinSalaire.AfficherBulletinSalaireCompletDto;
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

	public AfficherBulletinSalaireCompletDto convertToFullDto(BulletinSalaire bs) {

		AfficherBulletinSalaireCompletDto dto = new AfficherBulletinSalaireCompletDto(bs);

		// Calcul salaire brut
		BigDecimal base = bs.getRemunerationEmploye().getGrade().getNbHeuresBase();
		BigDecimal tauxSalarial = bs.getRemunerationEmploye().getGrade().getTauxBase();
		dto.setTauxSalarial(tauxSalarial);
		BigDecimal salaireBrut = base.multiply(tauxSalarial);
		BigDecimal primeExceptionnelle = bs.getPrimeExceptionnelle();
		salaireBrut = salaireBrut.add(primeExceptionnelle);

		dto.setBase(base);
		dto.setTauxSalarial(tauxSalarial);
		dto.setPrimeExceptionnelle(primeExceptionnelle);
		dto.setSalaireBrut(salaireBrut);

		// Calcul net imposable
		BigDecimal totalRetenue = null;
		BigDecimal retenueS = null;
		BigDecimal retenueP = null;
		List<Cotisation> cotisationNonImposable = cotisationService.getCotisationWithImposable(false);
		List<String> cotisationsNILibelle = new ArrayList<>();
		List<BigDecimal> cotisationsNITauxSalarial = new ArrayList<>();
		List<BigDecimal> cotisationsNIMontantSalarial = new ArrayList<>();
		List<BigDecimal> cotisationsNITauxPatronal = new ArrayList<>();
		List<BigDecimal> cotisationsNIMontantPatronal = new ArrayList<>();
		BigDecimal totalRetenuePatronal = null;
		for (Cotisation c : cotisationNonImposable) {
			cotisationsNILibelle.add(c.getLibelle());
			cotisationsNITauxSalarial.add(c.getTauxSalarial());
			retenueS = c.getTauxSalarial().multiply(salaireBrut);
			cotisationsNIMontantSalarial.add(retenueS);
			totalRetenue = (retenueS).add(totalRetenue);
			cotisationsNITauxPatronal.add(c.getTauxPatronal());
			retenueP = c.getTauxPatronal().multiply(salaireBrut);
			cotisationsNIMontantPatronal.add(retenueP);
			totalRetenuePatronal = (retenueP).add(totalRetenuePatronal);
		}
		BigDecimal netImposable = salaireBrut.subtract(totalRetenue);
		dto.setCotisationsNILibelle(cotisationsNILibelle);
		dto.setCotisationsNITauxSalarial(cotisationsNITauxSalarial);
		dto.setCotisationsNIMontantSalarial(cotisationsNIMontantSalarial);
		dto.setTotalRetenue(totalRetenue);
		dto.setCotisationsNITauxPatronal(cotisationsNITauxPatronal);
		dto.setCotisationsNIMontantPatronal(cotisationsNIMontantPatronal);
		dto.setTotalRetenuePatronal(totalRetenuePatronal);
		dto.setNetImposable(netImposable);

		// calcul net a payer
		BigDecimal simposable = null;
		BigDecimal montant = null;
		List<Cotisation> cotisationImposable = cotisationService.getCotisationWithImposable(true);
		List<String> cotisationsILibelle = new ArrayList<>();
		List<BigDecimal> cotisationsITauxSalarial = new ArrayList<>();
		List<BigDecimal> cotisationsIMontantSalarial = new ArrayList<>();
		for (Cotisation c : cotisationImposable) {
			cotisationsILibelle.add(c.getLibelle());
			cotisationsITauxSalarial.add(c.getTauxSalarial());
			montant = c.getTauxSalarial().multiply(salaireBrut);
			cotisationsIMontantSalarial.add(montant);
			simposable = montant.add(simposable);
		}
		BigDecimal netAPayer = netImposable.subtract(simposable);
		dto.setCotisationsILibelle(cotisationsILibelle);
		dto.setCotisationsITauxSalarial(cotisationsITauxSalarial);
		dto.setCotisationsIMontantSalarial(cotisationsIMontantSalarial);
		dto.setNetApayer(netAPayer);
		return dto;
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
