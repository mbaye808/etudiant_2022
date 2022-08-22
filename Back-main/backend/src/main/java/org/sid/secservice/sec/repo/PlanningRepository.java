package org.sid.secservice.sec.repo;

import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.sid.secservice.sec.entities.AnneeAccademique;
import org.sid.secservice.sec.entities.Groupe;
import org.sid.secservice.sec.entities.Planning;
import org.sid.secservice.sec.entities.Seance;
import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Planning entity.
 */
@SuppressWarnings("unused")
@Repository
public interface PlanningRepository extends JpaRepository<Planning, Long> {
/* 
    List<Planning> findBySeance(Optional<Seance> seance);

    List<Planning> findByGroupeAndAnneeAccademique(Groupe groupe,AnneeAccademique anneeAccademique); */
    
   /*  List<Planning> findByGroupeAndAnneeAccademiqueActifTrue(Groupe groupe);
    List<Planning> findByGroupeAndAnneeAccademique(Groupe groupe,AnneeAccademique anneeAccademique);
    Planning findByGroupeAndDateDebutAndDateFin(Groupe groupe, LocalDate dateDebut, LocalDate dateFin); */
}
