package org.sid.secservice.sec.repo;

import org.springframework.stereotype.Repository;



import java.util.List;

import org.sid.secservice.sec.entities.AnneeAccademique;
import org.sid.secservice.sec.entities.ElementConstitutif;
import org.sid.secservice.sec.entities.Formation;
import org.sid.secservice.sec.entities.HistoriqueElementContitutif;
import org.sid.secservice.sec.entities.HistoriqueUniteEnseignement;
import org.sid.secservice.sec.entities.Niveau;
import org.sid.secservice.sec.entities.Semestre;
import org.sid.secservice.sec.entities.enumeration.EnumTypeElemen;
import org.sid.secservice.sec.entities.enumeration.EnumTypeElementConstitutif;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;


/**
 * Spring Data JPA repository for the HistoriqueElementContitutif entity.
 */

@Repository
public interface HistoriqueElementContitutifRepository extends JpaRepository<HistoriqueElementContitutif, Long> {
    List<HistoriqueElementContitutif> findByHistoriqueUniteEnseignementAndIsExecuteTrueOrderByNewcode(HistoriqueUniteEnseignement historiqueUniteEnseignement);

/* List<HistoriqueElementContitutif> findByHistoriqueUniteEnseignementAndIsExecuteTrue(HistoriqueUniteEnseignement historiqueUniteEnseignement);
List<HistoriqueElementContitutif> findByHistoriqueUniteEnseignementOrderByNewcode(HistoriqueUniteEnseignement historiqueUniteEnseignement);
List<HistoriqueElementContitutif> findByHistoriqueUniteEnseignementAndIsExecuteTrueAndSpecialiteTrueOrderByNewcode(HistoriqueUniteEnseignement historiqueUniteEnseignement);
List<HistoriqueElementContitutif> findByHistoriqueUniteEnseignementAnneeAccademiqueAndHistoriqueUniteEnseignementUniteEnseignementNiveauFormationOrderByNewcode(AnneeAccademique anneeAccademique, Formation formation);
HistoriqueElementContitutif findByHistoriqueUniteEnseignementAndElementConstitutif(HistoriqueUniteEnseignement historiqueUniteEnseignement,ElementConstitutif elementConstitutif);
HistoriqueElementContitutif findByHistoriqueUniteEnseignementAnneeAccademiqueAndElementConstitutif(AnneeAccademique anneeAccademique,ElementConstitutif elementConstitutif);
HistoriqueElementContitutif findByHistoriqueUniteEnseignementAnneeAccademiqueAndElementConstitutifAndIsExecuteTrue(AnneeAccademique anneeAccademique,ElementConstitutif elementConstitutif);
List<HistoriqueElementContitutif> findByHistoriqueUniteEnseignementAnneeAccademiqueAndHistoriqueUniteEnseignementSemestreAndHistoriqueUniteEnseignementUniteEnseignementNiveau(AnneeAccademique anneeAccademique,Semestre semstre, Niveau niveau);
List<HistoriqueElementContitutif> findByHistoriqueUniteEnseignementAnneeAccademiqueAndHistoriqueUniteEnseignementSemestreTerminalAndHistoriqueUniteEnseignementUniteEnseignementNiveauAndIsExecuteTrue(AnneeAccademique anneeAccademique,Boolean semstre, Niveau niveau);
List<HistoriqueElementContitutif> findByHistoriqueUniteEnseignementAnneeAccademiqueAndHistoriqueUniteEnseignementSemestreAndHistoriqueUniteEnseignementUniteEnseignementNiveauAndIsExecuteTrueOrderByNewcode(AnneeAccademique anneeAccademique,Semestre semstre, Niveau niveau);
@Query("select h from HistoriqueElementContitutif h where h.historiqueUniteEnseignement.uniteEnseignement.niveau=:niveau and h.historiqueUniteEnseignement.semestre=:semestre and h.historiqueUniteEnseignement.anneeAccademique=:anneeAccademique and (h.typeElementConstitutif=:thorie_pratique or h.typeElementConstitutif=:thorie )  and h.isExecute=true ")
List<HistoriqueElementContitutif> findByTheoriePratique(@Param("niveau") Niveau niveau, @Param("semestre") Semestre semestre, @Param("anneeAccademique") AnneeAccademique anneeAccademique, @Param("thorie_pratique") EnumTypeElementConstitutif thorie_pratique, @Param("thorie") EnumTypeElementConstitutif thorie );
@Query("select h from HistoriqueElementContitutif h where h.historiqueUniteEnseignement.uniteEnseignement.niveau=:niveau and h.historiqueUniteEnseignement.semestre=:semestre and h.historiqueUniteEnseignement.anneeAccademique=:anneeAccademique and (h.elementConstitutif.type=:thorie_pratique or h.elementConstitutif.type=:thorie ) and h.isExecute=true")
List<HistoriqueElementContitutif> findByTheoriePratiqueAncien(@Param("niveau") Niveau niveau, @Param("semestre") Semestre semestre, @Param("anneeAccademique") AnneeAccademique anneeAccademique, @Param("thorie_pratique") EnumTypeElemen thorie_pratique, @Param("thorie") EnumTypeElemen thorie );

@Query("select h from HistoriqueElementContitutif h where h.historiqueUniteEnseignement.uniteEnseignement.niveau=:niveau  and h.historiqueUniteEnseignement.anneeAccademique=:anneeAccademique and (h.typeElementConstitutif=:thorie_pratique or h.typeElementConstitutif=:thorie )  and h.isExecute=true ")
List<HistoriqueElementContitutif> findByTheoriePratique(@Param("niveau") Niveau niveau, @Param("anneeAccademique") AnneeAccademique anneeAccademique, @Param("thorie_pratique") EnumTypeElementConstitutif thorie_pratique, @Param("thorie") EnumTypeElementConstitutif thorie );
@Query("select h from HistoriqueElementContitutif h where h.historiqueUniteEnseignement.uniteEnseignement.niveau=:niveau  and h.historiqueUniteEnseignement.anneeAccademique=:anneeAccademique and (h.elementConstitutif.type=:thorie_pratique or h.elementConstitutif.type=:thorie ) and h.isExecute=true")
List<HistoriqueElementContitutif> findByTheoriePratiqueAncien(@Param("niveau") Niveau niveau, @Param("anneeAccademique") AnneeAccademique anneeAccademique, @Param("thorie_pratique") EnumTypeElemen thorie_pratique, @Param("thorie") EnumTypeElemen thorie );

@Query("select h from HistoriqueElementContitutif h where h.historiqueUniteEnseignement.uniteEnseignement.niveau=:niveau and h.historiqueUniteEnseignement.semestre.terminal=:semestre and h.historiqueUniteEnseignement.anneeAccademique=:anneeAccademique and (h.typeElementConstitutif=:thorie_pratique or h.typeElementConstitutif=:thorie )  and h.isExecute=true ")
List<HistoriqueElementContitutif> findByTheoriePratique(@Param("niveau") Niveau niveau, @Param("semestre") Boolean semestre, @Param("anneeAccademique") AnneeAccademique anneeAccademique, @Param("thorie_pratique") EnumTypeElementConstitutif thorie_pratique, @Param("thorie") EnumTypeElementConstitutif thorie );
@Query("select h from HistoriqueElementContitutif h where h.historiqueUniteEnseignement.uniteEnseignement.niveau=:niveau and h.historiqueUniteEnseignement.semestre.terminal=:semestre and h.historiqueUniteEnseignement.anneeAccademique=:anneeAccademique and (h.elementConstitutif.type=:thorie_pratique or h.elementConstitutif.type=:thorie ) and h.isExecute=true")
List<HistoriqueElementContitutif> findByTheoriePratiqueAncien(@Param("niveau") Niveau niveau, @Param("semestre") Boolean semestre, @Param("anneeAccademique") AnneeAccademique anneeAccademique, @Param("thorie_pratique") EnumTypeElemen thorie_pratique, @Param("thorie") EnumTypeElemen thorie );



List<HistoriqueElementContitutif> findByHistoriqueUniteEnseignementOrderByNewcodeDesc(HistoriqueUniteEnseignement historiqueUniteEnseignement);
HistoriqueElementContitutif findByNewcodeAndHistoriqueUniteEnseignement(String code,HistoriqueUniteEnseignement historiqueUniteEnseignement);
HistoriqueElementContitutif findByNewcodeAndHistoriqueUniteEnseignementAndHistoriqueUniteEnseignementAnneeAccademique(String code,HistoriqueUniteEnseignement historiqueUniteEnseignement, AnneeAccademique accademique);
HistoriqueElementContitutif findByNewcodeAndHistoriqueUniteEnseignementAnneeAccademique(String code, AnneeAccademique accademique);
List<HistoriqueElementContitutif> findByHistoriqueUniteEnseignementAndIsExecuteTrueAndElementConstitutifSpecialiteOrderByNewcode(HistoriqueUniteEnseignement historiqueUniteEnseignement,Boolean var);
List<HistoriqueElementContitutif> findByHistoriqueUniteEnseignementAnneeAccademiqueAndHistoriqueUniteEnseignementSemestreTerminalAndHistoriqueUniteEnseignementUniteEnseignementNiveau(AnneeAccademique anneeAccademique,Boolean semstre, Niveau niveau);
@Query("select h from HistoriqueElementContitutif h where h.historiqueUniteEnseignement.uniteEnseignement.niveau=:niveau and h.historiqueUniteEnseignement.semestre.terminal=:semestre and h.historiqueUniteEnseignement.anneeAccademique=:anneeAccademique and (h.typeElementConstitutif=:thorie_pratique or h.typeElementConstitutif=:thorie ) ")
List<HistoriqueElementContitutif> findByTheoriePratiqueAndHistoriqueUniteEnseignementSemestreTerminal(@Param("niveau") Niveau niveau, @Param("semestre") Boolean semestre, @Param("anneeAccademique") AnneeAccademique anneeAccademique, @Param("thorie_pratique") EnumTypeElementConstitutif thorie_pratique, @Param("thorie") EnumTypeElementConstitutif thorie );
List<HistoriqueElementContitutif> findByHistoriqueUniteEnseignementAnneeAccademiqueAndHistoriqueUniteEnseignementSoutenanceTrueAndHistoriqueUniteEnseignementUniteEnseignementNiveauOrderByNewcode(AnneeAccademique anneeAccademique, Niveau niveau);
List<HistoriqueElementContitutif> findByHistoriqueUniteEnseignementAnneeAccademiqueAndHistoriqueUniteEnseignementSemestreAndHistoriqueUniteEnseignementUniteEnseignementNiveauAndElementConstitutifType(AnneeAccademique anneeAccademique,Semestre semstre, Niveau niveau, EnumTypeElemen type);
 */
}
