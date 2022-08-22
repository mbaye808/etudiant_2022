package org.sid.secservice.sec.repo;

import java.util.List;
import java.util.Optional;

import org.sid.secservice.sec.entities.Reclamation;
import org.sid.secservice.sec.entities.ReclamationCopy;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Reclamation entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ReclamationRepository extends JpaRepository<Reclamation, Long> {

    List<Reclamation> findByAnneeAccademiqueActifTrueAndIne(String ine);
    List<Reclamation> findByAnneeAccademiqueActifTrueAndGroupeIdAndSemestreId(Long idGroupe,Long idSemestre);
    List<Reclamation> findByAnneeAccademiqueActifTrueAndGroupeId(Long idgroupe);
    List<Reclamation> findByAnneeAccademiqueActifTrue();
}
