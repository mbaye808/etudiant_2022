package org.sid.secservice.sec.repo;

import org.springframework.stereotype.Repository;
import org.sid.secservice.sec.entities.AnneeAccademique;
import org.springframework.data.jpa.repository.*;
import java.util.*;


/**
 * Spring Data JPA repository for the AnneeAccademique entity.
 */
@Repository
public interface AnneeAccademiqueRepository extends JpaRepository<AnneeAccademique, Long> {

    AnneeAccademique findByNomAnneeAccademique(String nomAnneeAccademique);
    AnneeAccademique findByActifTrue();
    List<AnneeAccademique> findAllByOrderByNomAnneeAccademiqueDesc();
    List<AnneeAccademique> findAllByOrderByNomAnneeAccademique();

}   

