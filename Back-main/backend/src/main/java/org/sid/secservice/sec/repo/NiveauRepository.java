package org.sid.secservice.sec.repo;

import org.springframework.stereotype.Repository;
import org.sid.secservice.sec.entities.Niveau;
import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Niveau entity.
 */

@Repository
public interface NiveauRepository extends JpaRepository<Niveau, Long> {

/* 	Niveau findByCodeNiveau(String codeNiveau);
	Niveau findByCodeNiveauDisi(String codeNiveauDisi);
	Niveau findByCodeNiveauDisiContaining(String codeNiveauDisi);
	Niveau findByCodeNiveauDisiAndCodeOptionDisi(String codeNiveauDisi,String codeOptionDisi); */
}

