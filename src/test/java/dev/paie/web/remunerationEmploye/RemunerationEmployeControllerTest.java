package dev.paie.web.remunerationEmploye;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import dev.paie.entite.Entreprise;
import dev.paie.entite.Grade;
import dev.paie.entite.ProfilRemuneration;
import dev.paie.entite.RemunerationEmploye;
import dev.paie.service.EntrepriseService;
import dev.paie.service.GradeService;
import dev.paie.service.ProfilRemunerationService;
import dev.paie.service.RemunerationEmployeService;

@WebMvcTest(RemunerationEmployeController.class)
public class RemunerationEmployeControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private RemunerationEmployeService remunerationEmployeService;
	@MockBean
	private EntrepriseService entrepriseService;
	@MockBean
	private ProfilRemunerationService profilRemunerationService;
	@MockBean
	private GradeService gradeService;

	@Test
	void testCreerEmploye() throws Exception {

		// given
		Entreprise entreprise = new Entreprise();
		entreprise.setId(34);
		ProfilRemuneration profilRemuneration = new ProfilRemuneration();
		profilRemuneration.setId(42);
		Grade grade = new Grade();
		grade.setId(12);

		RemunerationEmploye remunerationEmploye = new RemunerationEmploye();
		remunerationEmploye.setId(1);
		remunerationEmploye.setMatricule("coucou le matricule");
		remunerationEmploye.setEntreprise(entreprise);
		remunerationEmploye.setProfilRemuneration(profilRemuneration);
		remunerationEmploye.setGrade(grade);

		// when
		Mockito.when(remunerationEmployeService.ajouterRemunerationEmploye(1, "coucou le matricule", entreprise.getId(),
				profilRemuneration.getId(), grade.getId())).thenReturn(remunerationEmploye);

		// then
		mockMvc.perform(MockMvcRequestBuilders.post("/remunerationEmploye").contentType(MediaType.APPLICATION_JSON)
				.content("{ \"id\": " + remunerationEmploye.getId() + "," + " \"matricule\": \""
						+ remunerationEmploye.getMatricule() + "\" ," + " \"entreprise\": { \"id\": "
						+ remunerationEmploye.getEntreprise().getId() + "} ," + " \"profilRemuneration\": { \"id\": "
						+ remunerationEmploye.getProfilRemuneration().getId() + "} , \"grade\": { \"id\": "
						+ remunerationEmploye.getGrade().getId() + "}  }"))
				.andExpect(status().isOk());
	}

}
