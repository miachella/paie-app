package dev.paie.web.bulletinSalaire;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.BulletinSalaire;
import dev.paie.service.BulletinSalaireService;

@RestController
@RequestMapping("bulletinSalaire")
public class BulletinSalaireController {

	private BulletinSalaireService bulletinSalaireService;

	public BulletinSalaireController(BulletinSalaireService bulletinSalaireService) {
		super();
		this.bulletinSalaireService = bulletinSalaireService;
	}

	@GetMapping
	public List<AfficherBulletinSalaireResponseDto> getListeBulletins() {
		List<BulletinSalaire> listeObj = bulletinSalaireService.listerBulletins();
		List<AfficherBulletinSalaireResponseDto> listeDto = new ArrayList<>();
		for (BulletinSalaire bs : listeObj) {
			AfficherBulletinSalaireResponseDto dto = bulletinSalaireService.convertToDto(bs);
			listeDto.add(dto);
		}
		return listeDto;

	}

}
