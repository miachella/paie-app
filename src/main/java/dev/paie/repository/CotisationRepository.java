package dev.paie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.paie.entite.Cotisation;

public interface CotisationRepository extends JpaRepository<Cotisation, Integer> {

	@Query("SELECT c FROM Cotisation c WHERE c.imposable = ?1")
	List<Cotisation> findAllWithImposable(boolean imposable);

}
