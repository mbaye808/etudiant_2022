package org.sid.secservice.sec.repo;


import java.util.List;

import org.sid.secservice.sec.entities.HistoriqueElementContitutif;
import org.sid.secservice.sec.entities.HistoriqueEnseignement;
import org.sid.secservice.sec.entities.TypeEnseignement;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


/**
 * Spring Data repository for the HistoriqueEnseignement entity.
 */

@Repository
public interface HistoriqueEnseignementRepository extends JpaRepository<HistoriqueEnseignement, Long> {
   /*  HistoriqueEnseignement findOneByTypeAndHistoriqueElementContitutif(TypeEnseignement tEnumtypeMembre,HistoriqueElementContitutif historiqueElementContitutif);
    List<HistoriqueEnseignement> findByTypeAndHistoriqueElementContitutif(TypeEnseignement tEnumtypeMembre,HistoriqueElementContitutif historiqueElementContitutif);


    List<HistoriqueEnseignement> findByTypeAndHistoriqueElementContitutifOrderById(TypeEnseignement tEnumtypeMembre,HistoriqueElementContitutif historiqueElementContitutif);

    @Query("select h from HistoriqueEnseignement h where h.historiqueElementContitutif.id=:id  ")
    List<HistoriqueEnseignement>   findByHistoriqueElementConstitutifId( @Param("id") Long id);
    @Query("select h from HistoriqueEnseignement h where h.historiqueElementContitutif.historiqueUniteEnseignement.id=:id  ")
    List<HistoriqueEnseignement>   findByHistoriqueElementConstitutifhistoriqueUniteEnseignementId( @Param("id") Long id);
    @Query("select h from HistoriqueEnseignement h where h.historiqueElementContitutif.historiqueUniteEnseignement.uniteEnseignement.niveau.id=:idniveau and h.historiqueElementContitutif.historiqueUniteEnseignement.semestre.id=:idsemestre and h.historiqueElementContitutif.historiqueUniteEnseignement.anneeAccademique.id=:idAnne  ")
    List<HistoriqueEnseignement> findHistoriqueEnseignement(@Param("idniveau") Long idniveau,@Param("idsemestre") Long idsemestre, @Param("idAnne") Long idAnne);

    @Query("select h from HistoriqueEnseignement h where h.historiqueElementContitutif.historiqueUniteEnseignement.uniteEnseignement.niveau.id=:idniveau and h.historiqueElementContitutif.historiqueUniteEnseignement.anneeAccademique.id=:idAnne ")
    List<HistoriqueEnseignement> findHistoriqueEnseignementNiveau(@Param("idniveau") Long idniveau, @Param("idAnne") Long idAnne);
    @Query("select h from HistoriqueEnseignement h where   h.historiqueElementContitutif.historiqueUniteEnseignement.anneeAccademique.id=:idAnne")
    List<HistoriqueEnseignement> findHistoriqueEnseignementNiveau( @Param("idAnne") Long idAnne);

    @Query("select sum(h.volumeHoraire) from HistoriqueEnseignement h where h.historiqueElementContitutif.historiqueUniteEnseignement.uniteEnseignement.niveau.id=:idniveau and h.historiqueElementContitutif.historiqueUniteEnseignement.semestre.terminal=:semestre and h.historiqueElementContitutif.historiqueUniteEnseignement.anneeAccademique.id=:idAnne and h.historiqueElementContitutif.isExecute=:isExecute ")
    Float findHistoriqueEnseignementSum(@Param("idniveau") Long idniveau,@Param("semestre") Boolean semestre, @Param("idAnne") Long idAnne,@Param("isExecute") Boolean isExecute); */

}
