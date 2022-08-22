package org.sid.secservice.sec.repo;

import org.springframework.stereotype.Repository;
import org.sid.secservice.sec.entities.Semestre;
import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Semestre entity.
 */
@Repository
public interface SemestreRepository extends JpaRepository<Semestre, Long> {

	Semestre findByNomSemestre(String nomSemestre);

}
