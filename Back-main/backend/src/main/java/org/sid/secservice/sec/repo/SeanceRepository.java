package org.sid.secservice.sec.repo;

import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.sid.secservice.sec.entities.Niveau;
import org.sid.secservice.sec.entities.Salle;
import org.sid.secservice.sec.entities.Seance;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Spring Data JPA repository for the Seance entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SeanceRepository extends JpaRepository<Seance, Long> {


    @Query("select s from Seance s where  ((s.heureDebut Between :debut and :fin) or (:debut Between s.heureDebut and s.heureFin ) or (:fin Between s.heureDebut and s.heureFin ) or (s.heureFin Between :debut and :fin) or (s.heureDebut=:debut) or (s.heureDebut=:debut and s.heureFin=:fin ))  and s.salle=:salle  ")
    List<Seance> findBysalle(@Param("debut") ZonedDateTime debut, @Param("fin") ZonedDateTime fin,@Param("salle") Salle salle);

    // List<Seance> findBysalle(ZonedDateTime debut, ZonedDateTime fin, Salle salle);

  //List<Seance> findBysalle(@Param("debut") ZonedDateTime debut, @Param("fin") ZonedDateTime fin,@Param("salle") Salle salle);

  /*   @Query(value = "select distinct seance from Seance seance left join fetch seance.materiels",
        countQuery = "select count(distinct seance) from Seance seance")
    Page<Seance> findAllWithEagerRelationships(Pageable pageable);

    @Query("select distinct seance from Seance seance left join fetch seance.materiels")
    List<Seance> findAllWithEagerRelationships();

    @Query("select seance from Seance seance left join fetch seance.materiels where seance.id =:id")
    Seance findOneWithEagerRelationships(@Param("id") Long id);
    List<Seance> findByPlanning(Planning planning);

    List<Seance> findByPlanningGroupeAndHeureDebutAfterAndHeureDebutBefore( Groupe groupe,ZonedDateTime heureDebut,ZonedDateTime heureFin);
    List<Seance> findByHeureDebutAfterAndHeureDebutBefore(ZonedDateTime heureDebut,ZonedDateTime heureFin);

    List<Seance> findByMembreIdAndHeureDebutAfterAndHeureDebutBefore(Long idMembre,ZonedDateTime heureDebut,ZonedDateTime heureFin);
    Seance   findByPlanningGroupeAndHeureDebutAndHeureFin(Groupe groupe,ZonedDateTime heureDebut,ZonedDateTime heureFin);
    Seance findByPlanningGroupeAndHeureFin(  Groupe groupe,ZonedDateTime heureDebut);
    List<Seance> findByHeureDebutAndPlanningGroupe(ZonedDateTime heureDebut , Groupe groupe);
    List<Seance> findByHeureFinAndPlanningGroupe(ZonedDateTime heureDebut, Groupe groupe);
    Seance findBySalleAndHeureDebutAndHeureFin( Salle salle,ZonedDateTime heuredebut, ZonedDateTime heurefin);

    List<Seance> findBySalleAndHeureDebutAfterAndHeureDebutBefore(Salle salle,ZonedDateTime heureDebut, ZonedDateTime heureFin);
    List<Seance> findByPlanningGroupeAndPlanningAnneeAccademiqueAndHistoriqueEnseignementHistoriqueElementContitutifHistoriqueUniteEnseignementSemestre( Groupe groupe,  AnneeAccademique anneeAccademique, Semestre semestre);
    List<Seance> findByPlanningGroupeAndHeureDebutAfterAndHeureDebutBeforeAndEtatSeanceTrue( Groupe groupe, ZonedDateTime heureDebut,ZonedDateTime heureFin);
    List<Seance> findByHistoriqueEnseignementAndEtatSeance(HistoriqueEnseignement historiqueEnseignement,Boolean boolean1) ;
    List<Seance> findByHistoriqueEnseignement(HistoriqueEnseignement historiqueEnseignement) ;
    List<Seance> findBySalleAndPlanningAnneeAccademique(  Salle salle,AnneeAccademique anneeAccademique);

    @Query("select seance from Seance seance  where seance.membre =:membre and seance.planning.anneeAccademique=:anneeAccademique")
    List<Seance> findByMembreAndAnneeAcademique( @Param("membre") Membre membre, @Param("anneeAccademique") AnneeAccademique anneeAccademique);

    List<Seance> findByPlanningGroupeAndPlanningAnneeAccademiqueAndPlanningOrderByHeureDebutAscHeureFinAsc(
        Groupe groupe, AnneeAccademique anneeAccademique, Planning planning
    );

    List<Seance> findByHeureDebutAfterAndHeureFinBeforeAndEtatSeanceTrueAndPlanningGroupeNiveauFormationTypeFormationAndMembreStructure(
        ZonedDateTime heureDebut, ZonedDateTime heureFin, TypeFormation typeFormation, Structure structure
    );
    List<Seance> findByHeureDebutAfterAndHeureFinBeforeAndEtatSeanceTrueAndPlanningGroupeNiveauFormationTypeFormationAndMembreTypeMembre(
        ZonedDateTime heureDebut, ZonedDateTime heureFin, TypeFormation typeFormation, EnumtypeMembre enumtypeMembre
    );
    List<Seance> findByHeureDebutAfterAndHeureFinBeforeAndEtatSeanceTrueAndPlanningGroupeNiveauFormationTypeFormationAndMembreTypeMembreAndMembreCategorie(
        ZonedDateTime heureDebut, ZonedDateTime heureFin, TypeFormation typeFormation, EnumtypeMembre enumtypeMembre,String categorie
    );
    @Query("select seance from Seance seance  where seance.planning.groupe.niveau.formation.departement=:departement and seance.planning.groupe.niveau.formation.typeFormation=:typeFormation and (seance.membre.typeMembre =:typeMembre1 or seance.membre.typeMembre =:typeMembre2 ) and seance.planning.anneeAccademique.id=:anneeAccademique and seance.etatSeance='true'")
    List<Seance> findBYseanceDepartement(
        @Param("departement") Structure departement, @Param("typeFormation") TypeFormation typeFormation,  @Param("typeMembre1") EnumtypeMembre enumtypeMembre,@Param("typeMembre2") EnumtypeMembre enumtypeMembre1,@Param("anneeAccademique") Long anneeAccademique
    );
    @Query("select seance from Seance seance  where seance.planning.groupe.niveau.formation.departement.etablissementUniversitaire=:etablissementUniversitaire and seance.planning.groupe.niveau.formation.typeFormation=:typeFormation and (seance.membre.typeMembre =:typeMembre1 or seance.membre.typeMembre =:typeMembre2 ) and seance.planning.anneeAccademique.id=:anneeAccademique and seance.etatSeance='true'")
    List<Seance> findBYseanceDepartementEtablissement(
        @Param("etablissementUniversitaire") EtablissementUniversitaire etablissementUniversitaire, @Param("typeFormation") TypeFormation typeFormation,  @Param("typeMembre1") EnumtypeMembre enumtypeMembre,@Param("typeMembre2") EnumtypeMembre enumtypeMembre1,@Param("anneeAccademique") Long anneeAccademique
    );
    List<Seance> findByHeureDebutAfterAndHeureFinBeforeAndEtatSeanceTrueAndMembreAndMembreStructureAndPlanningGroupeNiveauFormationTypeFormation(
        ZonedDateTime heureDebut, ZonedDateTime heureFin, Membre membre, Structure structure, TypeFormation typeFormation
    );

    List<Seance> findByHeureDebutAfterAndHeureFinBeforeAndEtatSeanceTrueAndMembreStructure(
        ZonedDateTime heureDebut, ZonedDateTime heureFin, Structure structure
    );
    @Query("select sum(DATE_PART('hour', heure_fin - heure_debut) * 60 + DATE_PART('minute', heure_fin - heure_debut)) from Seance seance  where seance.membre =:membre and seance.planning.anneeAccademique=:anneeAccademique and seance.etatSeance=true")
    Float findByEtatSeanceTrueAnMembreAndPlanningAnneeAccademique(@Param("membre") Membre membre, @Param("anneeAccademique") AnneeAccademique anneeAccademique);

    @Query("select sum(DATE_PART('hour', heure_fin - heure_debut) * 60 + DATE_PART('minute', heure_fin - heure_debut)) from Seance seance  where seance.historiqueEnseignement=:historiqueEnseignement and seance.etatSeance=:etat and seance.groupeTdTp=:groupeTdTp and seance.heureFin<=:heureFin")
    Float findByEtatSeancePlanningAnneeAccademique(@Param("etat") Boolean etat, @Param("historiqueEnseignement") HistoriqueEnseignement historiqueEnseignement, @Param("groupeTdTp") GroupeTdTp groupeTdTp, @Param("heureFin") ZonedDateTime heureFin);

    @Query("select sum(DATE_PART('hour', heure_fin - heure_debut) * 60 + DATE_PART('minute', heure_fin - heure_debut)) from Seance seance  where seance.historiqueEnseignement=:historiqueEnseignement and seance.etatSeance=:etat  and seance.heureFin<=:heureFin")
    Float findByEtatSeancePlanningAnneeAccademique(@Param("etat") Boolean etat, @Param("historiqueEnseignement") HistoriqueEnseignement historiqueEnseignement, @Param("heureFin") ZonedDateTime heureFin);
    
    @Query("select sum(DATE_PART('hour', heure_fin - heure_debut) * 60 + DATE_PART('minute', heure_fin - heure_debut)) from Seance seance  where seance.historiqueEnseignement=:historiqueEnseignement and seance.groupeTdTp=:groupeTdTp and seance.heureFin<=:heureFin")
    Float findByEtatSeancePlanningAnneeAccademique(@Param("historiqueEnseignement") HistoriqueEnseignement historiqueEnseignement,@Param("groupeTdTp") GroupeTdTp groupeTdTp, @Param("heureFin") ZonedDateTime heureFin);

    @Query("select sum(DATE_PART('hour', heure_fin - heure_debut) * 60 + DATE_PART('minute', heure_fin - heure_debut)) from Seance seance  where seance.historiqueEnseignement=:historiqueEnseignement  and seance.heureFin<=:heureFin")
    Float findByEtatSeancePlanningAnneeAccademique(@Param("historiqueEnseignement") HistoriqueEnseignement historiqueEnseignement, @Param("heureFin") ZonedDateTime heureFin);
   
    List<Seance> findByPlanningGroupeAndHeureDebutAfterAndHeureDebutBeforeOrderByHeureDebutAsc( Groupe groupe,ZonedDateTime heureDebut,ZonedDateTime heureFin);

    @Query("select s from Seance s where  ((s.heureDebut Between :debut and :fin) or (:debut Between s.heureDebut and s.heureFin ) or (:fin Between s.heureDebut and s.heureFin ) or (s.heureFin Between :debut and :fin) or (s.heureDebut=:debut) or (s.heureDebut=:debut and s.heureFin=:fin ))  and s.salle=:salle  ")
    List<Seance> findBysalle(@Param("debut") ZonedDateTime debut, @Param("fin") ZonedDateTime fin,@Param("salle") Salle salle);

    @Query("select s from Seance s where  ((s.heureDebut Between :debut and :fin) or (:debut Between s.heureDebut and s.heureFin ) or (:fin Between s.heureDebut and s.heureFin ) or (s.heureFin Between :debut and :fin)  or (s.heureDebut=:debut and s.heureFin=:fin ))  and s.membre=:membre  ")
    List<Seance> findByEnseignement(@Param("debut") ZonedDateTime debut, @Param("fin") ZonedDateTime fin,@Param("membre") Membre membre);
    @Query("select s from Seance s where  (((s.heureDebut Between :debut and :fin)) or ((:debut Between s.heureDebut and s.heureFin) ) or ((:fin Between s.heureDebut and s.heureFin)  ) or ((s.heureFin Between :debut and :fin))  or ((s.heureDebut=:debut and s.heureFin=:fin ) ))  and s.groupeTdTp=:groupeTdTp and s.planning.groupe=:groupe  ")
    List<Seance> findByClasse(@Param("debut") ZonedDateTime debut, @Param("fin") ZonedDateTime fin,@Param("groupe") Groupe groupe,@Param("groupeTdTp") GroupeTdTp groupeTdTp);

    List<Seance> findBySalleAndHeureDebutAfterAndHeureFinBefore(Salle one,   ZonedDateTime heureDebut, ZonedDateTime heureFin);

    List<Seance> findByMembre(Membre one);

    List<Seance> findByHistoriqueEnseignementId(Long id);
    List<Seance> findByHistoriqueEnseignementHistoriqueElementContitutifId( Long id); */
}
