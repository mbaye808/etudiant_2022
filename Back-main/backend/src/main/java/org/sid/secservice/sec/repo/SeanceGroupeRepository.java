package org.sid.secservice.sec.repo;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.List;

import org.sid.secservice.sec.entities.AnneeAccademique;
import org.sid.secservice.sec.entities.Groupe;
import org.sid.secservice.sec.entities.GroupeTdTp;
import org.sid.secservice.sec.entities.HistoriqueElementContitutif;
import org.sid.secservice.sec.entities.HistoriqueEnseignement;
import org.sid.secservice.sec.entities.Membre;
import org.sid.secservice.sec.entities.Seance;
import org.sid.secservice.sec.entities.SeanceGroupe;
import org.sid.secservice.sec.entities.Semestre;
import org.sid.secservice.sec.entities.Structure;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the SeanceGroupe entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SeanceGroupeRepository extends JpaRepository<SeanceGroupe, Long> {

        List<SeanceGroupe> findBySeance(Seance seance);

        List<SeanceGroupe> findBySeanceMembreId(Long idMembre);

        List<SeanceGroupe> findByGroupeAndSeanceHeureDebutAfterAndSeanceHeureDebutBefore(Groupe var, ZonedDateTime tdebut,
                        ZonedDateTime tfin);

   /*  List<SeanceGroupe> findBySeance(Seance seance);
    SeanceGroupe findBySeanceAndGroupe(Seance seance,Groupe groupe);
    SeanceGroupe findByGroupeAndSeanceHeureDebutAndSeanceHeureFinAndSeanceGroupeTdTp(Groupe groupe,ZonedDateTime heureDebut,ZonedDateTime heureFin,GroupeTdTp groupeTdTp);

    List<SeanceGroupe> findByGroupeAndSeanceHeureDebutAfterAndSeanceHeureDebutBeforeAndSeanceGroupeTdTp( Groupe groupe,ZonedDateTime heureDebut,ZonedDateTime heureFin,GroupeTdTp groupeTdTp);
  
    List<SeanceGroupe> findByGroupeAndSeanceHeureDebutAfterAndSeanceHeureDebutBeforeAndSeancePlanningAnneeAccademiqueAndSeanceHistoriqueEnseignementHistoriqueElementContitutifHistoriqueUniteEnseignementSemestre(Groupe groupe, ZonedDateTime heureDebut,ZonedDateTime heureFin,  AnneeAccademique anneeAccademique, Semestre semestre);
    List<SeanceGroupe> findByGroupeAndAndSeanceHistoriqueEnseignementAndSeanceGroupeTdTp( Groupe groupe,  HistoriqueEnseignement historiqueEnseignement,GroupeTdTp groupeTdTp);
    List<SeanceGroupe> findByGroupeAndAndSeanceHistoriqueEnseignementAndSeanceEtatSeanceTrue( Groupe groupe,  HistoriqueEnseignement historiqueEnseignement);
    List<SeanceGroupe> findBySeanceMembreIdAndSeancePlanningAnneeAccademiqueActifTrue( Long id);
    List<SeanceGroupe> findByGroupeAndAndSeanceHistoriqueEnseignementAndSeanceGroupeTdTpAndSeanceEtatSeance( Groupe groupe,  HistoriqueEnseignement historiqueEnseignement,GroupeTdTp groupeTdTp,boolean bool);

    List<SeanceGroupe> findByGroupeAndAndSeanceHistoriqueEnseignementHistoriqueElementContitutifAndSeanceEtatSeance( Groupe groupe,  HistoriqueElementContitutif historiqueElementContitutif,boolean bool);


    @Query("select sum(DATE_PART('hour', seance.seance.heureFin - seance.seance.heureDebut) * 60 + DATE_PART('minute', seance.seance.heureFin - seance.seance.heureDebut)) from SeanceGroupe seance  where seance.seance.historiqueEnseignement=:historiqueEnseignement and seance.seance.etatSeance=:etat and seance.groupe=:groupe and seance.seance.groupeTdTp=:groupeTdTp and seance.seance.heureFin<=:heureFin")
    Float findByEtatSeancePlanningAnneeAccademique(@Param("etat") Boolean etat, @Param("historiqueEnseignement") HistoriqueEnseignement historiqueEnseignement, @Param("groupeTdTp") GroupeTdTp groupeTdTp,@Param("groupe") Groupe groupe, @Param("heureFin") ZonedDateTime heureFin);

    @Query("select sum(DATE_PART('hour', seance.seance.heureFin - seance.seance.heureDebut) * 60 + DATE_PART('minute', seance.seance.heureFin - seance.seance.heureDebut)) from SeanceGroupe seance  where seance.seance.historiqueEnseignement=:historiqueEnseignement and seance.seance.etatSeance=:etat and seance.groupe=:groupe and seance.seance.heureFin<=:heureFin")
    Float findByEtatSeancePlanningAnneeAccademique(@Param("etat") Boolean etat, @Param("historiqueEnseignement") HistoriqueEnseignement historiqueEnseignement,@Param("groupe") Groupe groupe, @Param("heureFin") ZonedDateTime heureFin);
    
    @Query("select sum(DATE_PART('hour', seance.seance.heureFin - seance.seance.heureDebut) * 60 + DATE_PART('minute', seance.seance.heureFin - seance.seance.heureDebut)) from SeanceGroupe seance  where seance.seance.historiqueEnseignement=:historiqueEnseignement and seance.seance.groupeTdTp=:groupeTdTp and seance.groupe=:groupe and seance.seance.heureFin<=:heureFin")
    Float findByEtatSeancePlanningAnneeAccademique(@Param("historiqueEnseignement") HistoriqueEnseignement historiqueEnseignement,@Param("groupeTdTp") GroupeTdTp groupeTdTp,@Param("groupe") Groupe groupe, @Param("heureFin") ZonedDateTime heureFin);

    @Query("select sum(DATE_PART('hour', seance.seance.heureFin - seance.seance.heureDebut) * 60 + DATE_PART('minute', seance.seance.heureFin - seance.seance.heureDebut)) from SeanceGroupe seance  where seance.seance.historiqueEnseignement=:historiqueEnseignement and seance.groupe=:groupe  and seance.seance.heureFin<=:heureFin")
    Float findByEtatSeancePlanningAnneeAccademique(@Param("historiqueEnseignement") HistoriqueEnseignement historiqueEnseignement,@Param("groupe") Groupe groupe, @Param("heureFin") ZonedDateTime heureFin);
 
    @Query("select sum(DATE_PART('hour', seance.seance.heureFin - seance.seance.heureDebut) * 60 + DATE_PART('minute', seance.seance.heureFin - seance.seance.heureDebut)) from SeanceGroupe seance  where seance.seance.historiqueEnseignement=:historiqueEnseignement and seance.seance.groupeTdTp=:groupeTdTp and seance.groupe=:groupe and seance.seance.etatSeance=:etat and seance.seance.heureFin<=:heureFin")
    Float findByEtatSeancePlanningAnneeAccademique(@Param("historiqueEnseignement") HistoriqueEnseignement historiqueEnseignement,@Param("groupeTdTp") GroupeTdTp groupeTdTp,@Param("groupe") Groupe groupe, @Param("heureFin") ZonedDateTime heureFin,@Param("etat") Boolean etat);

    @Query("select sum(DATE_PART('hour', seance.seance.heureFin - seance.seance.heureDebut) * 60 + DATE_PART('minute', seance.seance.heureFin - seance.seance.heureDebut)) from SeanceGroupe seance  where seance.seance.historiqueEnseignement=:historiqueEnseignement and seance.groupe=:groupe and seance.seance.etatSeance=:etat and seance.seance.heureFin<=:heureFin")
    Float findByEtatSeancePlanningAnneeAccademique(@Param("historiqueEnseignement") HistoriqueEnseignement historiqueEnseignement,@Param("groupe") Groupe groupe, @Param("heureFin") ZonedDateTime heureFin,@Param("etat") Boolean etat);
 

    @Query("select s from SeanceGroupe s where  ((s.seance.heureDebut <=:debut and s.seance.heureDebut>=:fin)  or (s.seance.heureFin<=:debut and s.seance.heureFin>=:fin)) and s.seance.salle =:salle ")
    List<SeanceGroupe> findBySeanceSalle(@Param("debut") ZonedDateTime heureDebut, @Param("fin") ZonedDateTime heureFin, @Param("salle") Salle salle);

    @Query("select s from SeanceGroupe s where  ((s.seance.heureDebut Between :debut and :fin) or (:debut Between s.seance.heureDebut and s.seance.heureFin ) or (:fin Between s.seance.heureDebut and s.seance.heureFin ) or (s.seance.heureFin Between :debut and :fin))   and s.seance.groupeTdTp =:groupeTdTp and s.groupe=:groupe  ")
    List<SeanceGroupe> findBySeanceClasse(@Param("debut") ZonedDateTime debut, @Param("fin") ZonedDateTime fin, @Param("groupeTdTp") GroupeTdTp groupeTdTp,@Param("groupe") Groupe groupe);

    @Query("select s from SeanceGroupe s where  ((s.seance.heureDebut<=:debut and s.seance.heureFin>=:debut) or (s.seance.heureDebut<=:fin and s.seance.heureFin>=:fin))  and s.seance.membre=:membre  ")
    List<SeanceGroupe> findBySeanceEnseignant(@Param("debut") ZonedDateTime heureDebut, @Param("fin") ZonedDateTime heureFin, @Param("membre") Membre membre);
    Collection<SeanceGroupe> findByGroupeAndSeancePlanningAnneeAccademique(Groupe one, AnneeAccademique one2);
    //
    @Query("select s from SeanceGroupe s where  ((s.seance.heureDebut Between :debut and :fin) or (:debut Between s.seance.heureDebut and s.seance.heureFin ) or (:fin Between s.seance.heureDebut and s.seance.heureFin ) or (s.seance.heureFin Between :debut and :fin)  or (s.seance.heureDebut=:debut and s.seance.heureFin=:fin)   )   and s.seance.groupeTdTp =:groupeTdTp and s.groupe=:groupe ")
    List<SeanceGroupe> findByClasse(@Param("debut") ZonedDateTime debut, @Param("fin") ZonedDateTime fin, @Param("groupeTdTp") GroupeTdTp groupeTdTp,@Param("groupe") Groupe groupe);

    @Query("select s from SeanceGroupe s where  ((s.seance.heureDebut Between :debut and :fin)  or (:fin Between s.seance.heureDebut and s.seance.heureFin ) or (s.seance.heureFin Between :debut and :fin) or (s.seance.heureDebut=:debut and s.seance.heureFin=:fin ))    and s.groupe=:groupe  ")
    List<SeanceGroupe> findByClasse(@Param("debut") ZonedDateTime debut, @Param("fin") ZonedDateTime fin,@Param("groupe") Groupe groupe);
    @Query("select s from SeanceGroupe s where  ((:debut Between s.seance.heureDebut and s.seance.heureFin ) or (:fin Between s.seance.heureDebut and s.seance.heureFin )) and s.groupe=:groupe  ")
    List<SeanceGroupe> findByClasse1(@Param("debut") ZonedDateTime debut, @Param("fin") ZonedDateTime fin,@Param("groupe") Groupe groupe);
    @Query("select s from SeanceGroupe s where  ((:debut Between s.seance.heureDebut and s.seance.heureFin ) or (:fin Between s.seance.heureDebut and s.seance.heureFin )) and s.seance.groupeTdTp =:groupeTdTp and s.groupe=:groupe  ")
    List<SeanceGroupe> findByClasse1(@Param("debut") ZonedDateTime debut, @Param("fin") ZonedDateTime fin, @Param("groupeTdTp") GroupeTdTp groupeTdTp,@Param("groupe") Groupe groupe);
    List<SeanceGroupe> findByGroupeAndSeanceHeureDebutAfterAndSeanceHeureDebutBefore( Groupe groupe,ZonedDateTime heureDebut,ZonedDateTime heureFin);
    List<SeanceGroupe> findByGroupeAndSeanceHeureDebutAfterAndSeanceHeureDebutBeforeAndSeancePlanningAnneeAccademique( Groupe groupe,ZonedDateTime heureDebut,ZonedDateTime heureFin,AnneeAccademique anneeAccademique);
    List<SeanceGroupe> findBySeanceMembreId(Long idMembre);

    List<SeanceGroupe> findByGroupeAndSeanceHeureDebutAfterAndSeanceHeureDebutBeforeAndSeancePlanningAnneeAccademiqueAndSeanceMembreId( Groupe groupe,ZonedDateTime heureDebut,ZonedDateTime heureFin,AnneeAccademique anneeAccademique,Long idMembre);
    @Query("select seance  from SeanceGroupe seance  where seance.seance.historiqueEnseignement.historiqueElementContitutif.historiqueUniteEnseignement.semestre.terminal=:semestre and seance.seance.planning.anneeAccademique.id=:idannee and seance.groupe.id=:idgroupe ")
    List<SeanceGroupe> findBySemestreGroupeAnneeAccademique( @Param("semestre") Boolean semestre, @Param("idannee") Long idannee ,@Param("idgroupe") Long idgroupe);

    @Query("select seance  from SeanceGroupe seance  where seance.seance.historiqueEnseignement.historiqueElementContitutif.historiqueUniteEnseignement.semestre.terminal=:semestre and seance.seance.planning.anneeAccademique.id=:idannee and seance.groupe.niveau.formation.departement.id=:departement ")
    List<SeanceGroupe> findBySemestreDepartementAnneeAccademique( @Param("semestre") Boolean semestre, @Param("idannee") Long idannee ,@Param("departement") Long departement);
    List<SeanceGroupe> findBySeanceMembreIdAndSeanceHeureDebutAfterAndSeanceHeureDebutBefore(Long idenseignant, ZonedDateTime tdebut,ZonedDateTime tfin);

    @Query("select distinct seance.groupe.niveau.formation.departement from SeanceGroupe seance  where seance.seance.membre =:membre and seance.seance.etatSeance='true' and seance.seance.planning.anneeAccademique=:anneeAccademique")
    List<Structure> findByDepartement( @Param("membre") Membre membre, @Param("anneeAccademique") AnneeAccademique anneeAccademique);


    List<SeanceGroupe> findByGroupeAndSeancePlanningAnneeAccademiqueAndSeanceHeureDebutAfterAndSeanceHeureDebutBeforeOrderBySeanceHeureDebutAscSeanceHeureFinAsc(Groupe groupe,AnneeAccademique anneeAccademique,  ZonedDateTime tdebut,ZonedDateTime tfin);
    List<SeanceGroupe> findByGroupeAndSeancePlanningAnneeAccademiqueAndSeancePlanningOrderBySeanceHeureDebutAscSeanceHeureFinAsc(Groupe groupe, AnneeAccademique anneeAccademique, Planning planning);
    List<SeanceGroupe> findByGroupeAndSeancePlanningAnneeAccademiqueAndSeanceHistoriqueEnseignementHistoriqueElementContitutifHistoriqueUniteEnseignementSemestre(
            Groupe groupe, AnneeAccademique one, Semestre one2);
    List<SeanceGroupe> findBySeanceHistoriqueEnseignementHistoriqueElementContitutifId( Long id);
    List<SeanceGroupe> findBySeanceHistoriqueEnseignementHistoriqueElementContitutifHistoriqueUniteEnseignementIdAndSeanceEtatSeanceTrue( Long id);
    List<SeanceGroupe> findBySeanceHistoriqueEnseignementHistoriqueElementContitutifIdAndSeanceEtatSeanceTrue( Long id);
    List<SeanceGroupe> findBySeanceHistoriqueEnseignementIdAndSeanceEtatSeanceTrue( Long id);
    Iterable<? extends SeanceGroupe> findBySeanceHistoriqueEnseignementId(Long id); */
}
