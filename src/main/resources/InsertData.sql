INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial) 
VALUES (1, 'SP01', true, 'URSSAF CSG NON DEDUCTIBLE', null, 0.024000);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (2, 'SP02', true, 'URSSAF CRDS', null, 0.005000);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (3, 'EP01', false, 'URSSAF MALADIE - MATERNITE - INVALIDITE', 0.128000, 0.007500);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (4, 'EP02', false, 'URSSAF SOLIDARITE', 0.003000, null);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (5, 'EP03', false, 'URSSAF ACCIDENT DU TRAVAIL', 0.012000, null);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (6, 'EP04', false, 'URSSAF ALLOC. FAMILIALES', 0.054000, null);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (7, 'EP05', false, 'URSSAF ASS. VIEILLESSE PLAF.', 0.084000, 0.067500);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (8, 'EP06', false, 'URSSAF ASS. VIEILLESSE DEPLAF.', 0.016000, 0.001000);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (9, 'EP07', false, 'URSSAF FNAL', 0.001000, null);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (10, 'EP12', false, 'ASSEDIC Tr. A', 0.040000, 0.024000);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (11, 'EP14', false, 'ASSEDIC Tr. B', 0.040000, 0.024000);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (12, 'EP19', false, 'FONDS DE GARANTIE (AGS)', 0.003000, null);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (13, 'EP20', false, 'RETRAITE ARRCO NC T1', 0.045000, 0.030000);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (14, 'EP21', false, 'RETRAITE ARRCO NC T2', 0.012150, 0.081000);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (15, 'EP28', false, 'TAXE APPRENTISSAGE', 0.006800, null);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (16, 'EP37', false, 'CSG DEDUCTIBLE', null, 0.051000);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (17, 'EPR1', false, 'AGFF NC TRANCHE 1', 0.012000, 0.008000);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (18, 'EPR2', false, 'AGFF NC TRANCHE 2', 0.013000, 0.009000);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (19, 'E900', false, 'PREVOYANCE NON CADRE TA', 0.003700, 0.003700);
INSERT INTO cotisation (id, code, imposable, libelle, taux_patronal, taux_salarial)
VALUES (20, 'E901', false, 'PREVOYANCE NON CADRE TB', 0.007320, 0.004880);
INSERT INTO entreprise (id, adresse, code_naf, denomination, siret, urssaf) 
VALUES (1, null, '6202A', 'Dev Institut', '80966785000022', null);
INSERT INTO entreprise (id, adresse, code_naf, denomination, siret, urssaf) 
VALUES (2, null, '6202A', 'Sopra-Steria', '5555555000022', null);
INSERT INTO entreprise (id, adresse, code_naf, denomination, siret, urssaf) 
VALUES (3, null, '6202A', 'Capgemini', '6666665000022', null);
INSERT INTO grade (id, code, nb_heures_base, taux_base) VALUES (1, 'GRADE_A', 152, 11);
INSERT INTO grade (id, code, nb_heures_base, taux_base) VALUES (2, 'GRADE_B', 152, 21);
INSERT INTO grade (id, code, nb_heures_base, taux_base) VALUES (3, 'GRADE_C', 152, 31);
INSERT INTO profil_remuneration (id, code) VALUES (1, 'Technicien');
INSERT INTO profil_remuneration (id, code) VALUES (2, 'Cadre');
INSERT INTO profil_remuneration (id, code) VALUES (3, 'Stagiaire');
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (1, 3);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (1, 4);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (1, 5);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (1, 6);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (1, 7);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (1, 8);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (1, 9);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (1, 1);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (1, 2);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 3);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 4);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 5);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 6);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 7);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 8);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 9);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 10);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 12);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 13);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 17);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 19);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 15);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 16);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 1);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (2, 2);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (3, 3);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (3, 4);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (3, 5);
INSERT INTO profil_remuneration_cotisations (profil_remuneration_id, cotisations_id)
VALUES (3, 1);
INSERT INTO periode (id, date_debut, date_fin) VALUES (1, '2019-01-01', '2019-01-31');
INSERT INTO periode (id, date_debut, date_fin) VALUES (2, '2019-02-01', '2019-02-28');
INSERT INTO periode (id, date_debut, date_fin) VALUES (3, '2019-03-01', '2019-03-31');
INSERT INTO periode (id, date_debut, date_fin) VALUES (4, '2019-04-01', '2019-04-30');
INSERT INTO periode (id, date_debut, date_fin) VALUES (5, '2019-05-01', '2019-05-31');
INSERT INTO periode (id, date_debut, date_fin) VALUES (6, '2019-06-01', '2019-06-30');
INSERT INTO periode (id, date_debut, date_fin) VALUES (7, '2019-07-01', '2019-07-31');
INSERT INTO periode (id, date_debut, date_fin) VALUES (8, '2019-08-01', '2019-08-31');
INSERT INTO periode (id, date_debut, date_fin) VALUES (9, '2019-09-01', '2019-09-30');
INSERT INTO periode (id, date_debut, date_fin) VALUES (10, '2019-10-01', '2019-10-31');
INSERT INTO periode (id, date_debut, date_fin) VALUES (11, '2019-11-01', '2019-11-30');
INSERT INTO periode (id, date_debut, date_fin) VALUES (12, '2019-12-01', '2019-12-31');