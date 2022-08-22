package org.sid.secservice.sec.repo;

import java.util.List;

import org.sid.secservice.sec.entities.ParametreRepechage;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;



/**
 * Spring Data  repository for the ParametreRepechage entity.
 */
@Repository
public interface ParametreRepechageRepository extends JpaRepository<ParametreRepechage, Long> {
    List<ParametreRepechage> findByStructureId(Long id);
    ParametreRepechage findByAnneeAccademiqueIdAndStructureId(Long id,Long idStructure); 
}
