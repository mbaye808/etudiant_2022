package org.sid.secservice.sec.repo;


import org.springframework.stereotype.Repository;



import java.util.List;

import org.sid.secservice.sec.entities.AnneeAccademique;
import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.entities.Etudiant;
import org.sid.secservice.sec.entities.Groupe;
import org.sid.secservice.sec.entities.Historique;
import org.sid.secservice.sec.entities.Inscription;
import org.sid.secservice.sec.entities.Semestre;
import org.sid.secservice.sec.entities.Session;
import org.sid.secservice.sec.entities.UniteEnseignement;
import org.sid.secservice.sec.entities.enumeration.EnumSession;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;


/**
 * Spring Data JPA repository for the Historique entity.
 */

@Repository
public interface HistoriqueRepository extends JpaRepository<Historique, Long> {
  Historique findByInscriptionAndUniteEnseignementAndSession(Inscription inscription, UniteEnseignement uniteEnseignement, Session session);
  Historique findByInscriptionAndUniteEnseignementAndSessionSession(Inscription inscription2,UniteEnseignement uniteEnseignement, EnumSession rattrapage);

  //Historique findByInscriptionEtudiantAndUniteEnseignementAndMoyenneUEGreaterThanEqual(@Param("nomAnneeAccademique") String nomAnneeAccademique,@Param("etudiant") Etudiant etudiant, @Param("uniteEnseignement") UniteEnseignement uniteEnseignement, @Param("moyenneUE") Float moyenneUE);

       @Query("select min(h.moyenneUE) from Historique h where h.uniteEnseignement =:uniteEnseignement and h.inscription.groupe=:groupe  and h.inscription.anneeAccademique=:anneeAccademique")
        float findByMinGroupe(@Param("uniteEnseignement") UniteEnseignement uniteEnseignement,@Param("groupe") Groupe groupe, @Param("anneeAccademique") AnneeAccademique anneeAccademique);
        @Query("select max(h.moyenneUE) from Historique h where h.uniteEnseignement =:uniteEnseignement and h.inscription.groupe=:groupe and h.inscription.anneeAccademique=:anneeAccademique")
        float findByMaxGroupe(@Param("uniteEnseignement") UniteEnseignement uniteEnseignement,@Param("groupe") Groupe groupe,  @Param("anneeAccademique") AnneeAccademique anneeAccademique);
       
        @Query( "select  historique from Historique historique where (historique.inscription.anneeAccademique.nomAnneeAccademique<:nomAnneeAccademique  and historique.inscription.etudiant=:etudiant and historique.uniteEnseignement=:uniteEnseignement  ) and historique.moyenneUE>=:moyenneUE ")
        Historique findByInscriptionEtudiantAndUniteEnseignementAndMoyenneUEGreaterThanEqual(@Param("nomAnneeAccademique") String nomAnneeAccademique,@Param("etudiant") Etudiant etudiant, @Param("uniteEnseignement") UniteEnseignement uniteEnseignement, @Param("moyenneUE") Float moyenneUE);
            ////// SUM GROUPE ET SESSION //////////
        @Query("select sum(h.moyenneUE) from Historique h where h.uniteEnseignement =:uniteEnseignement and h.inscription.groupe=:groupe  and h.inscription.anneeAccademique=:anneeAccademique and h.session =:session")
        Float findBySumGroupeSession(@Param("uniteEnseignement") UniteEnseignement uniteEnseignement,@Param("groupe") Groupe groupe,@Param("anneeAccademique") AnneeAccademique anneeAccademique,@Param("session") Session session);
        @Query("select h from Historique h where h.uniteEnseignement =:uniteEnseignement and h.inscription.groupe=:groupe  and h.inscription.anneeAccademique=:anneeAccademique and h.session =:session")
        List<Historique> findBySumGroupeSessionList(@Param("uniteEnseignement") UniteEnseignement uniteEnseignement,@Param("groupe") Groupe groupe,@Param("anneeAccademique") AnneeAccademique anneeAccademique,@Param("session") Session session);
        List<Historique> findByInscriptionGroupeAndSemestreAndSessionAndInscriptionAnneeAccademique(Groupe groupe, Semestre semestre, Session session, AnneeAccademique anneeAccademique );      
        List<Historique> findByInscriptionAndSession(Inscription inscription ,Session session);
      
        List<Historique> findByInscriptionGroupeAndInscriptionAnneeAccademiqueAndSemestreAndSessionSessionAndMoyenneUELessThan(Groupe groupe,AnneeAccademique anneeAccademique , Semestre semestre, EnumSession normale,Float moyenneUE);

        List<Historique> findByInscriptionAndSessionAndMoyenneUEGreaterThanEqual(Inscription inscription, Session normale,Float moyenneUE);
        List<Historique> findByInscriptionAndSemestreAndSessionSessionAndMoyenneUeAnnuelGreaterThanEqual(Inscription inscription, Semestre semestre, EnumSession normale,Float moyenneUE);
        List<Historique> findByInscriptionGroupeAndInscriptionAnneeAccademiqueAndSessionSessionAndMoyenneUELessThan(Groupe groupe,AnneeAccademique anneeAccademique ,EnumSession normale,Float moyenneUE);
        List<Historique> findByUniteEnseignementAndInscriptionAnneeAccademiqueAndInscriptionGroupeAndSessionAndMoyenneUEGreaterThanEqual(UniteEnseignement uniteEnseignement, AnneeAccademique anneeAccademique, Groupe groupe, Session session,float f);
        List<Historique> findByUniteEnseignementAndInscriptionAnneeAccademiqueAndInscriptionGroupeAndSession(UniteEnseignement uniteEnseignement, AnneeAccademique anneeAccademique, Groupe groupe, Session session);
        List<Historique> findByInscriptionAndSemestreAndSessionAndMoyenneUEGreaterThanEqual(Inscription inscription,Semestre semestre, Session session, float f);
        List<Historique> findByInscriptionAndSemestreAndSession(Inscription inscription, Semestre semestre, Session session);
       
       
        Historique findByUniteEnseignementAndInscription(UniteEnseignement un, Inscription inscription );
        Historique findByUniteEnseignementAndSessionAndInscription(UniteEnseignement uEnseignement, Session session, Inscription inscription);
 


}
