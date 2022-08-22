package org.sid.secservice.sec.repo;

import org.springframework.stereotype.Repository;



import java.util.List;

import org.sid.secservice.sec.entities.AnneeAccademique;
import org.sid.secservice.sec.entities.Formation;
import org.sid.secservice.sec.entities.HistoriqueUniteEnseignement;
import org.sid.secservice.sec.entities.Niveau;
import org.sid.secservice.sec.entities.Semestre;
import org.sid.secservice.sec.entities.UniteEnseignement;
import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the HistoriqueUniteEnseignement entity.
 */

@Repository
public interface HistoriqueUniteEnseignementRepository extends JpaRepository<HistoriqueUniteEnseignement, Long> {
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndSemestreAndAnneeAccademiqueOrderByNewCode(Niveau niveau, Semestre semestre, AnneeAccademique anneeAccademique);
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndAnneeAccademiqueAndSoutenanceAndIsExecuteTrueOrderByNewCode(Niveau niveau, AnneeAccademique anneeAccademique, boolean var);
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndSemestreAndAnneeAccademiqueAndUniteEnseignementIsValidateAndIsExecuteTrueOrderByNewCode(Niveau niveau, Semestre semestre, AnneeAccademique anneeAccademique, boolean var);
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndSemestreAndUniteEnseignementIsValidateAndIsExecuteTrueOrderByNewCode( Niveau niveau, Semestre semestre, boolean var);
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndSemestreTerminalAndAnneeAccademiqueAndIsExecuteTrueOrderByNewCode(Niveau niveau, Boolean boolean1, AnneeAccademique anneeAccademique);
        List<HistoriqueUniteEnseignement> findByAnneeAccademiqueActifTrueAndIsExecuteTrueOrderByNewCode();


        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndSemestreAndAnneeAccademiqueActifTrueAndIsExecuteTrueOrderByNewCode(Niveau niveau, Semestre semestre);
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndSemestreAndAnneeAccademiqueAndIsExecuteTrueOrderByNewCode(Niveau niveau, Semestre semestre,AnneeAccademique anneeAccademique);
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndSemestreIdAndAnneeAccademiqueTrueAndIsExecuteTrueOrderByNewCode(Niveau niveau, Long semestre);

        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndSemestreAndIsExecuteTrueOrderByNewCode(Niveau niveau, Semestre semestre);

        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndAnneeAccademique(Niveau niveau,AnneeAccademique anneeAccademique);
        List<HistoriqueUniteEnseignement> findByAnneeAccademiqueAndIsExecuteTrueOrderByNewCode(AnneeAccademique anneeAccademique);
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauFormationAndAnneeAccademique(Formation formation,AnneeAccademique anneeAccademique);
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndAnneeAccademiqueOrderByNewCode(Niveau niveau,AnneeAccademique anneeAccademique);
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndAnneeAccademiqueActifTrueAndIsExecuteTrueOrderByNewCode(Niveau niveau);
        HistoriqueUniteEnseignement findByUniteEnseignementAndAnneeAccademique(UniteEnseignement uniteEnseignement,AnneeAccademique anneeAccademique);
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndSemestreAndAnneeAccademiqueOrderByNewCodeDesc(Niveau niveau, Semestre semestre, AnneeAccademique anneeAccademique);
        HistoriqueUniteEnseignement findByNewCodeAndAnneeAccademique(String newCode, AnneeAccademique anneeAccademique);
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndIsExecuteTrueOrderByNewCode(Niveau niveau);
        List<HistoriqueUniteEnseignement> findByUniteEnseignement(UniteEnseignement uniteEnseignement);
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndAndSoutenanceAndAnneeAccademiqueAndIsExecuteTrueOrderByNewCode(Niveau niveau, Boolean boolean1, AnneeAccademique anneeAccademique);
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndSemestreTerminalFalseAndAnneeAccademiqueAndIsExecuteTrueOrderByNewCode( Niveau niveau, AnneeAccademique anneeAccademique);
        List<HistoriqueUniteEnseignement> findByUniteEnseignementNiveauAndSemestreTerminalTrueAndAnneeAccademiqueAndIsExecuteTrueOrderByNewCode(Niveau niveau, AnneeAccademique anneeAccademique);
}
