package dev.paie.web.entreprise;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.Entreprise;
import dev.paie.service.EntrepriseService;

@RestController
@RequestMapping("entreprises")
public class EntrepriseController {

	private EntrepriseService entrepriseService;

	public EntrepriseController(EntrepriseService entrepriseService) {
		super();
		this.entrepriseService = entrepriseService;
	}

	@GetMapping
	public List<EntrepriseResponseDto> getAllEntreprises() {

		List<Entreprise> listEntreprise = entrepriseService.listEntreprise();
		List<EntrepriseResponseDto> listeEntreprisesDto = new ArrayList<>();
		for (Entreprise e : listEntreprise) {
			listeEntreprisesDto.add(new EntrepriseResponseDto(e.getSiret(), e.getDenomination()));
		}
		return listeEntreprisesDto;
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getEntrepriseFromId(@PathVariable int id) {

		Optional<Entreprise> optionalEntreprise = entrepriseService.getEntrepriseById(id);

		if (optionalEntreprise.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).header("message", "Entreprisée trouvée")
					.body(optionalEntreprise.get());

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L’ID fourni ne correspond à aucune entreprise.");
		}
	}

}
