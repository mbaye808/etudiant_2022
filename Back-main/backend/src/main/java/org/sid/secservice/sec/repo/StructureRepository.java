package org.sid.secservice.sec.repo;


import org.springframework.stereotype.Repository;
import org.sid.secservice.sec.entities.Structure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import org.springframework.data.jpa.repository.*;
/**
 * Spring Data JPA repository for the Structure entity.
 */
@SuppressWarnings("unused")
@Repository
public interface StructureRepository extends JpaRepository<Structure, Long> {

    List<Structure> findAll();
}
