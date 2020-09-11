package dev.paie.web.bulletinSalaire;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import dev.paie.entite.BulletinSalaire;
import dev.paie.entite.Grade;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.service.BulletinSalaireService;
import dev.paie.service.CotisationService;
import dev.paie.service.EntrepriseService;
import dev.paie.service.GradeService;
import dev.paie.service.PeriodeService;
import dev.paie.service.ProfilRemunerationService;
import dev.paie.service.RemunerationEmployeService;

@WebMvcTest(BulletinSalaireController.class)
public class BulletinSalaireControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private BulletinSalaireService bulletinSalaireService;
	@MockBean
	private RemunerationEmployeService remunerationEmployeService;
	@MockBean
	private PeriodeService periodeService;
	@MockBean
	private CotisationService cotisationService;
	@MockBean
	private EntrepriseService entrepriseService;
	@MockBean
	private GradeService gradeService;
	@MockBean
	private ProfilRemunerationService profilRemunerationService;

	@Test
	void testGetListeBulletins() throws Exception {
		// given
		BulletinSalaire bs1 = new BulletinSalaire();
		bs1.setId(1);
		Grade g1 = new Grade();
		g1.setNbHeuresBase(new BigDecimal("152"));
		g1.setTauxBase(new BigDecimal("21"));
		RemunerationEmploye e1 = new RemunerationEmploye();
		e1.setGrade(g1);
		e1.setMatricule("coucou");
		bs1.setRemunerationEmploye(e1);
		AfficherBulletinSalaireResponseDto dto1 = new AfficherBulletinSalaireResponseDto(bs1);
		BulletinSalaire bs2 = new BulletinSalaire();
		bs2.setId(2);
		// when
		Mockito.when(bulletinSalaireService.listerBulletins()).thenReturn(Arrays.asList(bs1, bs2));
		Mockito.when(bulletinSalaireService.convertToDto(bs1)).thenReturn(dto1);
		// then
		mockMvc.perform(MockMvcRequestBuilders.get("/bulletinSalaire")).andExpect(status().isOk())
				.andExpect(jsonPath("[0].matricule").value("coucou"));
	}
}
