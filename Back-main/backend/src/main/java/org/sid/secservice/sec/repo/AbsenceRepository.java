package org.sid.secservice.sec.repo;


import org.springframework.stereotype.Repository;



import org.springframework.data.jpa.repository.*;

import java.util.List;

import org.sid.secservice.sec.entities.Absence;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.ZonedDateTime;

/**
 * Spring Data JPA repository for the Absence entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
        Absence findByIdInscriptionAndIdUe(Long idInscription, Long idUniteEnseignement); 
}
