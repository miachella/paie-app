package dev.paie.web.remunerationEmploye;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.RemunerationEmploye;
import dev.paie.exception.PaieException;
import dev.paie.service.RemunerationEmployeService;

@RestController
@RequestMapping("remunerationEmploye")
public class RemunerationEmployeController {

	private RemunerationEmployeService remunerationEmployeService;

	public RemunerationEmployeController(RemunerationEmployeService remunerationEmployeService) {
		super();
		this.remunerationEmployeService = remunerationEmployeService;
	}

	@PostMapping
	public ResponseEntity<?> creerEmploye(
			@RequestBody @Validated CreerRemunerationEmployeRequestDto remunerationEmploye, BindingResult empValid) {

		if (!empValid.hasErrors()) {
			RemunerationEmploye remunerationEmployeCree = remunerationEmployeService.ajouterRemunerationEmploye(
					remunerationEmploye.getId(), remunerationEmploye.getMatricule(),
					remunerationEmploye.getEntreprise().getId(), remunerationEmploye.getProfilRemuneration().getId(),
					remunerationEmploye.getGrade().getId());
			CreerRemunerationEmployeResponseDto remunerationEmployeResponse = new CreerRemunerationEmployeResponseDto(
					remunerationEmployeCree);

			return ResponseEntity.ok(remunerationEmployeResponse);
		} else {
			return ResponseEntity.badRequest().body("Tous les champs sont obligatoires !");
		}

	}

	@ExceptionHandler(PaieException.class)
	public ResponseEntity<List<String>> onPaieException(PaieException ex) {
		return ResponseEntity.badRequest().body(ex.getMessagesErreurs());
	}

}
