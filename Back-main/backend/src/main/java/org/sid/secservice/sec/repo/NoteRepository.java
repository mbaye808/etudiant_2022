package org.sid.secservice.sec.repo;


import java.util.List;
import org.springframework.stereotype.Repository;
import org.sid.secservice.sec.entities.AnneeAccademique;
import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.entities.ElementConstitutif;
import org.sid.secservice.sec.entities.Etudiant;
import org.sid.secservice.sec.entities.Niveau;
import org.sid.secservice.sec.entities.Note;
import org.sid.secservice.sec.entities.Semestre;
import org.sid.secservice.sec.entities.UniteEnseignement;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

/**
 * Spring Data JPA repository for the Note entity.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

	Note findByAnneeAccademiqueAndElementConstitutifAndEtudiant(AnneeAccademique anneeAccademique,ElementConstitutif elemenConstitutif, Etudiant etudiant);
	List<Note> findByElementConstitutifAndAndAnneeAccademiqueAndElementConstitutifUniteEnseignementNiveauAndDsNotNull(ElementConstitutif element, AnneeAccademique anneeAccademique, Niveau niveau);
	List<Note> findByElementConstitutifAndAndAnneeAccademiqueAndElementConstitutifUniteEnseignementNiveauAndCcNotNull(ElementConstitutif element, AnneeAccademique anneeAccademique, Niveau niveau);
	List<Note> findByElementConstitutifAndAndAnneeAccademiqueAndElementConstitutifUniteEnseignementNiveauAndTpNotNull(ElementConstitutif element, AnneeAccademique anneeAccademique, Niveau niveau);

	/* List<Note> findByElementConstitutif(ElementConstitutif elementConstitutif);

	List<Note> findByUniteEnseignement(UniteEnseignement uniteEnseignement);

	Note findByAnneeAccademiqueAndElementConstitutifAndEtudiant(AnneeAccademique anneeAccademique,ElementConstitutif elemenConstitutif, AppUser appUser);
	Note findByAnneeAccademiqueTrueAndElementConstitutifAndEtudiantIne( ElementConstitutif elemenConstitutif, String ine); */

	//List<Note> findByElementConstitutifUniteEnseignement(UniteEnseignement uniteEnseignement, ElementConstitutif elementConstitutif);

	/* @Query("select sum(n.moyenne) from Note n where n.elementConstitutif =:elementConstitutif  and n.anneeAccademique=:anneeAccademique ")
	Float findBySumGroupeAndAnneeAcademique(@Param("elementConstitutif") ElementConstitutif elementConstitutif,@Param("anneeAccademique") AnneeAccademique anneeAccademique);
	////

	List<Note> findByAnneeAccademiqueAndEtudiantAndElementConstitutifUniteEnseignementNiveauAndMoyenneLessThan(AnneeAccademique anneeAccademique, AppUser appUser, Niveau niveau, Float moyenne);

	List<Note> findByAnneeAccademiqueAndEtudiantAndElementConstitutifUniteEnseignementAndMoyenneLessThan(AnneeAccademique anneeAccademique, AppUser appUser, UniteEnseignement hUniteEnseignement, Float moyenne);


	List<Note> findByElementConstitutifAndAndAnneeAccademiqueAndTpNotNull(ElementConstitutif element,AnneeAccademique anneeAccademique);
	List<Note> findByElementConstitutifAndAndAnneeAccademique(ElementConstitutif element,AnneeAccademique anneeAccademique);
	List<Note> findByElementConstitutifAndAndAnneeAccademiqueAndCcNotNull(ElementConstitutif element,AnneeAccademique anneeAccademique);

	List<Note> findByElementConstitutifAndAndAnneeAccademiqueAndDsNotNull(ElementConstitutif element,
			AnneeAccademique anneeAccademique);

	List<Note> findByElementConstitutifUniteEnseignementAndEtudiantAndAnneeAccademiqueAndPointJuryNotNull(UniteEnseignement uniteEnseignement, AppUser appUser, AnneeAccademique anneeAccademique);

	List<Note> findByAnneeAccademiqueAndEtudiantAndElementConstitutifUniteEnseignementSemestreAndElementConstitutifUniteEnseignementNiveauAndAbsenceTrue(AnneeAccademique anneeAccademique, AppUser appUser, Semestre semestre, Niveau niveau);

	@Query("select min(n.moyenne) from Note n where n.elementConstitutif =:elementConstitutif  and n.anneeAccademique=:anneeAccademique ")
	Float findByMinGroupe(@Param("elementConstitutif") ElementConstitutif elementConstitutif,@Param("anneeAccademique") AnneeAccademique anneeAccademique);

	@Query("select max(n.moyenne) from Note n where n.elementConstitutif =:elementConstitutif  and n.anneeAccademique=:anneeAccademique ")
	Float findByMaxGroupe(@Param("elementConstitutif") ElementConstitutif elementConstitutif,@Param("anneeAccademique") AnneeAccademique anneeAccademique);

	@Query("select sum(n.moyenne) from Note n where n.elementConstitutif =:elementConstitutif  and n.anneeAccademique=:anneeAccademique ")
	Float findBySumGroupe(@Param("elementConstitutif") ElementConstitutif elementConstitutif,@Param("anneeAccademique") AnneeAccademique anneeAccademique);

	@Query("select min(n.tp) from Note n where n.elementConstitutif =:elementConstitutif  and n.anneeAccademique=:anneeAccademique ")
	Float findByMinGroupetp(@Param("elementConstitutif") ElementConstitutif elementConstitutif,@Param("anneeAccademique") AnneeAccademique anneeAccademique);

	@Query("select max(n.tp) from Note n where n.elementConstitutif =:elementConstitutif  and n.anneeAccademique=:anneeAccademique ")
	Float findByMaxGroupetp(@Param("elementConstitutif") ElementConstitutif elementConstitutif,@Param("anneeAccademique") AnneeAccademique anneeAccademique);

	@Query("select sum(n.tp) from Note n where n.elementConstitutif =:elementConstitutif  and n.anneeAccademique=:anneeAccademique ")
	Float findBySumGroupetp(@Param("elementConstitutif") ElementConstitutif elementConstitutif,
			@Param("anneeAccademique") AnneeAccademique anneeAccademique);

	@Query("select n from Note n where n.etudiant=:etudiant and n.elementConstitutif.uniteEnseignement=:uniteEnseignement and n.anneeAccademique=:anneeAccademique and n.moyenne<:moyenne")
	List<Note> findByNoteEliminatoire(@Param("etudiant") AppUser appUser,@Param("uniteEnseignement") UniteEnseignement uniteEnseignement,@Param("anneeAccademique") AnneeAccademique anneeAccademique, @Param("moyenne") Float moyenne);

	@Query("select n from Note n where n.etudiant=:etudiant and n.elementConstitutif.uniteEnseignement=:uniteEnseignement and n.anneeAccademique=:anneeAccademique and n.rattrapage<:moyenne")
	List<Note> findByNoteEliminatoirerattrapage(@Param("etudiant") AppUser appUser,@Param("uniteEnseignement") UniteEnseignement uniteEnseignement,@Param("anneeAccademique") AnneeAccademique anneeAccademique, @Param("moyenne") Float moyenne);

	List<Note> findByAnneeAccademiqueAndEtudiantAndPointJuryNotNull(AnneeAccademique anneeAccademique, AppUser appUser);
	List<Note> findByEtudiantAndAnneeAccademiqueAndElementConstitutifUniteEnseignementAndPointJuryNotNull(AppUser appUser, AnneeAccademique anneeAccademique, UniteEnseignement uniteEnseignement);
	List<Note> findByEtudiantAndAnneeAccademiqueAndElementConstitutifUniteEnseignementAndPointjuryRNotNull(AppUser appUser, AnneeAccademique anneeAccademique, UniteEnseignement uniteEnseignement);

	List<Note> findByElementConstitutifAndAndAnneeAccademiqueAndEtudiantAndPointJuryNotNull(ElementConstitutif element, AnneeAccademique anneeAccademique, AppUser appUser);
	Note findByElementConstitutifAndEtudiantAndAnneeAccademiqueAndElementConstitutifUniteEnseignementSemestre(ElementConstitutif element, AppUser appUser, AnneeAccademique anneeAccademique, Semestre semestre);

	Note findByElementConstitutifAndEtudiantAndAnneeAccademique(ElementConstitutif element, AppUser appUser,AnneeAccademique anneeAccademique);

    List<Note> findByElementConstitutifUniteEnseignementAndEtudiantAndAnneeAccademiqueAndAbsenceTrue(
            UniteEnseignement uniteEnseignement, AppUser appUser, AnneeAccademique anneeAccademique);

	List<Note> findByElementConstitutifUniteEnseignementAndEtudiantAndAnneeAccademiqueAndAbsenceRattrapageTrue(UniteEnseignement uniteEnseignement, AppUser appUser, AnneeAccademique anneeAccademique);

	List<Note> findByElementConstitutifUniteEnseignementAndEtudiantAndAnneeAccademiqueAndDsNotNull(UniteEnseignement uniteEnseignement, AppUser appUser, AnneeAccademique anneeAccademique); */
}
