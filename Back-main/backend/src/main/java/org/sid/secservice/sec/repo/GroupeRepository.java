package org.sid.secservice.sec.repo;

import org.springframework.stereotype.Repository;



import java.util.List;

import org.sid.secservice.sec.entities.Formation;
import org.sid.secservice.sec.entities.Groupe;
import org.sid.secservice.sec.entities.Niveau;
import org.sid.secservice.sec.entities.Structure;
import org.sid.secservice.sec.entities.enumeration.EnumNivLMD;
import org.sid.secservice.sec.entities.enumeration.EnumTypeEvaluation;
import org.sid.secservice.sec.entities.enumeration.EnumTypeFormation;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
/**
 * Spring Data JPA repository for the Groupe entity.
 */

@Repository
public interface GroupeRepository extends JpaRepository<Groupe, Long> {
    List<Groupe> findByNiveau(Niveau niveau);
    Groupe findByCode(String code);

/* 
    List<Groupe> findByNiveauOrderByCode(Niveau niveau);

    List<Groupe> findByNiveauFormationTypeEvaluatiionTypeEval(EnumTypeEvaluation enumTypeEvaluation);
    @Query("select  groupe from Groupe groupe where groupe.niveau.formation.departement.id=:id")
    List<Groupe> findByNiveauFormationDepartement( @Param("id")  Long id);
    List<Groupe> findByNiveauFormationDepartementAndNiveauFormationTypeFormationTypeFormat(Structure structure, EnumTypeFormation FPCE);
    List<Groupe> findByNiveauFormationTypeFormationTypeFormatAndNiveauFormationDepartement(EnumTypeFormation FPCT, Structure structure);
    Groupe findByLibelle(String libelle);
    List<Groupe> findByNiveauFormation(Formation formation);
    Groupe findByCode(String code);
    List<Groupe> findByNiveauFormationDepartementAndNiveauNivLMD(Structure structure,EnumNivLMD nivLMD); */
}
