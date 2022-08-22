package org.sid.secservice.sec.repo;


import org.springframework.stereotype.Repository;
import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.entities.Groupe;
import org.sid.secservice.sec.entities.Inscription;
import org.sid.secservice.sec.entities.Niveau;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Spring Data JPA repository for the Inscription entity.
 */

@Repository
public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

	Inscription findByGroupeAndEtudiantIneAndAnneeAccademiqueActifTrue(Groupe groupe, String ine );
	List<Inscription> findByGroupeNiveauAndEtudiantIneOrderByAnneeAccademiqueNomAnneeAccademiqueAsc(Niveau niveau,String ine);

	@Query( "select  distinct inscription.groupe from Inscription inscription where inscription.etudiant.ine=:ine and inscription.anneeAccademique.actif='true'")
	List<Groupe> findByEtudiantIneAndAnneeAccademiqueActifTrue(@Param("ine") String ine);

	@Query( "select  distinct inscription from Inscription inscription where inscription.etudiant.ine=:ine and inscription.anneeAccademique.actif='true'")
	List<Inscription> findByEtudiantIneAndAnneeAccademique(@Param("ine") String ine);
}
