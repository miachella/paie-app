package dev.paie.web.profilRemuneration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.ProfilRemuneration;
import dev.paie.service.ProfilRemunerationService;

@RestController
@RequestMapping("profilsRemunerations")
public class ProfilRemunerationController {

	private ProfilRemunerationService profilRemunerationService;

	public ProfilRemunerationController(ProfilRemunerationService profilRemunerationService) {
		super();
		this.profilRemunerationService = profilRemunerationService;
	}

	@GetMapping
	public List<ProfilRemunerationResponseDto> getAllProfilRemunerations() {

		List<ProfilRemuneration> listProfilRemuneration = profilRemunerationService.listProfil();
		List<ProfilRemunerationResponseDto> listeEntreprisesDto = new ArrayList<>();
		for (ProfilRemuneration g : listProfilRemuneration) {
			listeEntreprisesDto.add(new ProfilRemunerationResponseDto(g.getId(), g.getCode()));
		}
		return listeEntreprisesDto;
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getProfilRemunerationFromId(@PathVariable int id) {

		Optional<ProfilRemuneration> optionalProfilRemuneration = profilRemunerationService.getProfilById(id);

		if (optionalProfilRemuneration.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optionalProfilRemuneration.get());

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L’ID fourni ne correspond à aucun Grade.");
		}
	}
}
