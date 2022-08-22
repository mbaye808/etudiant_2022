package org.sid.secservice.sec.repo;


import org.sid.secservice.sec.entities.GroupeTdTp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the GroupeTdTp entity.
 */
@Repository
public interface GroupeTdTpRepository extends JpaRepository<GroupeTdTp, Long> {

  /*  List<GroupeTdTp> findByGroupTdTp(Optional<GroupeTdTp> groupeTdTp);

   @Query("select distinct groupeTdTp from GroupeTdTp groupeTdTp left join fetch groupeTdTp.historiqueEnseignements left join fetch groupeTdTp.inscriptions")
   List<GroupeTdTp> findAllWithEagerRelationships();

   @Query(value = "select distinct groupeTdTp from GroupeTdTp groupeTdTp left join fetch groupeTdTp.historiqueEnseignements left join fetch groupeTdTp.inscriptions",
        countQuery = "select count(distinct groupeTdTp) from GroupeTdTp groupeTdTp")
    Page<GroupeTdTp> findAllWithEagerRelationships(Pageable pageable);

    @Query("select groupeTdTp from GroupeTdTp groupeTdTp left join fetch groupeTdTp.historiqueEnseignements left join fetch groupeTdTp.inscriptions where groupeTdTp.id =:id")
    Optional<GroupeTdTp> findOneWithEagerRelationships(@Param("id") Long id);

    @Query("select distinct groupeTdTp from GroupeTdTp groupeTdTp left join fetch groupeTdTp.historiqueEnseignements left join fetch groupeTdTp.inscriptions where groupeTdTp.groupe.id=:id and groupeTdTp.anneeAccademique.id=:idanne order by groupeTdTp.id desc")
    List<GroupeTdTp> findAllWithEagerRelationshipsGroupe(@Param("id") Long id,@Param("idanne") Long idanne );
 */
   /*  @Query(value = "select distinct groupeTdTp from GroupeTdTp groupeTdTp left join fetch groupeTdTp.historiqueEnseignements left join fetch groupeTdTp.inscriptions",
        countQuery = "select count(distinct groupeTdTp) from GroupeTdTp groupeTdTp")
    Page<GroupeTdTp> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct groupeTdTp from GroupeTdTp groupeTdTp left join fetch groupeTdTp.historiqueEnseignements left join fetch groupeTdTp.inscriptions")
    List<GroupeTdTp> findAllWithEagerRelationships();
    @Query("select distinct groupeTdTp from GroupeTdTp groupeTdTp left join fetch groupeTdTp.historiqueEnseignements left join fetch groupeTdTp.inscriptions where groupeTdTp.groupe.id=:id and groupeTdTp.anneeAccademique.id=:idanne order by groupeTdTp.id desc")
    List<GroupeTdTp> findAllWithEagerRelationshipsGroupe(@Param("id") Long id,@Param("idanne") Long idanne );
    @Query("select groupeTdTp from GroupeTdTp groupeTdTp left join fetch groupeTdTp.historiqueEnseignements left join fetch groupeTdTp.inscriptions where groupeTdTp.id =:id")
    Optional<GroupeTdTp> findOneWithEagerRelationships(@Param("id") Long id);
    Inscription  findByInscriptions(Inscription inscription); 
    //Inscription  findByInscriptionsAndHistoriqueEnseignements(Inscription inscription, HistoriqueEnseignement historiqueEnseignement); 
    List<GroupeTdTp>  findByInscriptionsAndHistoriqueEnseignements(Inscription inscription, HistoriqueEnseignement historiqueEnseignement); 
    List<GroupeTdTp> findByhistoriqueEnseignements(HistoriqueEnseignement historiqueEnseignement);

    List<GroupeTdTp> findByHistoriqueEnseignementsId(Long id); 


    @Query("select groupeTdTp from GroupeTdTp groupeTdTp  left join fetch groupeTdTp.inscriptions where groupeTdTp.id =:id")
    Optional<GroupeTdTp> findOneWithEagerRelationshipsInscriptions(@Param("id") Long id);

    @Query("select distinct groupeTdTp from GroupeTdTp groupeTdTp left join fetch groupeTdTp.historiqueEnseignements  where groupeTdTp.groupe.niveau.formation.departement.id=:id and groupeTdTp.anneeAccademique.id=:idanne order by groupeTdTp.id desc")
    List<GroupeTdTp> findAllWithEagerRelationshipsDepartement(@Param("id") Long id,@Param("idanne") Long idanne );
 */

}
