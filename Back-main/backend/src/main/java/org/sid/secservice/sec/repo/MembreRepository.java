package org.sid.secservice.sec.repo;

import org.springframework.stereotype.Repository;
import org.sid.secservice.sec.entities.Membre;
import org.sid.secservice.sec.entities.Niveau;
import org.sid.secservice.sec.entities.Seance;
import org.sid.secservice.sec.entities.Structure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.*;
import java.util.List;

/**
 * Spring Data JPA repository for the Membre entity.
 */
@SuppressWarnings("unused")
@Repository
public interface MembreRepository extends JpaRepository<Membre, Long> {

    

   /*  List<Membre> findByStructure(Structure structure);

    Membre findOneByUserLogin(String username);

    Membre findByUserLogin(String userName);

    Membre findByUser(User user);

    Membre findByMatricule(String matricule);
    List<Membre> findByStructureAndTypeMembreOrderByStructureCode(Structure structure,EnumtypeMembre enumtypeMembre);

    List<Membre> findByStructureEtablissementUniversitaireAndTypeMembreOrderByStructureCode(EtablissementUniversitaire etablissementUniversitaire,EnumtypeMembre enumtypeMembre);
    List<Membre> findByStructureEtablissementUniversitaireOrderByStructureCode(EtablissementUniversitaire etablissementUniversitaire);
    List<Membre> findByStructureEtablissementUniversitaireAndCategorieAndTypeMembreOrderByStructureCode(EtablissementUniversitaire etablissementUniversitaire,String categorie,EnumtypeMembre enumtypeMembre);
    Page<Membre> findByStructure(Structure structure, Pageable pageable);

     List<Membre> findByStructureOrderByUserLastNameAsc(Structure structure);

     List<Membre> findAll();
     List<Membre> findAllByOrderByUserLastNameAsc();

    List<Membre> findByStructureOrderByStructureCode(Structure structure);

    List<Membre> findByStructureAndCategorieAndTypeMembreOrderByStructureCode(Structure structure, String categorie,
            EnumtypeMembre valueOf); */

}
