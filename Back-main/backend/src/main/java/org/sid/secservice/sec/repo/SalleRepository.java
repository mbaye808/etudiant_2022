package org.sid.secservice.sec.repo;

import org.sid.secservice.sec.entities.Salle;
import org.sid.secservice.sec.entities.Seance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the Salle entity.
 */
@Repository
public interface SalleRepository extends JpaRepository<Salle, Long> {

  /*   @Query("select distinct salle from Salle salle left join fetch salle.materiels")
    List<Salle> findAllWithEagerRelationships();

    List<Salle> findBySeance(Optional<Seance> seance); */

   /*  @Query(value = "select distinct salle from Salle salle left join fetch salle.materiels",
        countQuery = "select count(distinct salle) from Salle salle")
    Page<Salle> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct salle from Salle salle left join fetch salle.materiels")
    List<Salle> findAllWithEagerRelationships();
   
    @Query("select distinct salle from Salle salle left join fetch salle.materiels where salle.batiment =:batiment")
    List<Salle> findAllSalleBatiment(@Param("batiment") Batiment batiment);
    @Query("select salle from Salle salle left join fetch salle.materiels where salle.id =:id")
    Optional<Salle> findOneWithEagerRelationships(@Param("id") Long id);
    List<Salle> findAllByOrderById(); */
}
