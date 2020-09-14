package dev.paie.web.grade;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.paie.entite.Grade;
import dev.paie.service.GradeService;

@RestController
@RequestMapping("grades")
public class GradeController {

	private GradeService gradeService;

	public GradeController(GradeService gradeService) {
		super();
		this.gradeService = gradeService;
	}

	@GetMapping
	public List<GradeResponseDto> getAllGrades() {

		List<Grade> listGrade = gradeService.listGrade();
		List<GradeResponseDto> listeGradesDto = new ArrayList<>();
		for (Grade g : listGrade) {
			listeGradesDto.add(new GradeResponseDto(g.getId(), g.getCode()));
		}
		return listeGradesDto;
	}

	@GetMapping("{id}")
	public ResponseEntity<?> getGradeFromId(@PathVariable int id) {

		Optional<Grade> optionalGrade = gradeService.getGradeById(id);

		if (optionalGrade.isPresent()) {
			return ResponseEntity.status(HttpStatus.OK).body(optionalGrade.get());

		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("L’ID fourni ne correspond à aucun Grade.");
		}
	}

}
