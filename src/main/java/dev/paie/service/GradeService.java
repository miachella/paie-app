package dev.paie.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import dev.paie.entite.Grade;
import dev.paie.repository.GradeRepository;

@Service
public class GradeService {

	private GradeRepository gradeRepository;

	public GradeService(GradeRepository gradeRepository) {
		super();
		this.gradeRepository = gradeRepository;
	}

	public Optional<Grade> getGrade(int id) {
		return gradeRepository.findById(id);
	}

}
