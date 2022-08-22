package org.sid.secservice.sec.service;

import java.io.InputStream;
import java.sql.Date;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.sid.secservice.sec.entities.AnneeAccademique;
import org.sid.secservice.sec.entities.BulletinProvisoirExport;
import org.sid.secservice.sec.entities.Groupe;
import org.sid.secservice.sec.entities.Historique;
import org.sid.secservice.sec.entities.HistoriqueElementContitutif;
import org.sid.secservice.sec.entities.HistoriqueUniteEnseignement;
import org.sid.secservice.sec.entities.Inscription;
import org.sid.secservice.sec.entities.Note;
import org.sid.secservice.sec.entities.ParametreRepechage;
import org.sid.secservice.sec.entities.ProvisoirExport;
import org.sid.secservice.sec.entities.Provisoiretoutue;
import org.sid.secservice.sec.entities.Semestre;
import org.sid.secservice.sec.entities.Session;
import org.sid.secservice.sec.entities.enumeration.EnumEtat;
import org.sid.secservice.sec.entities.enumeration.EnumFormationType;
import org.sid.secservice.sec.entities.enumeration.EnumSession;
import org.sid.secservice.sec.entities.enumeration.EnumTypeElementConstitutif;
import org.sid.secservice.sec.entities.enumeration.EnumTypeEvaluation;
import org.sid.secservice.sec.repo.AnneeAccademiqueRepository;
import org.sid.secservice.sec.repo.GroupeRepository;
import org.sid.secservice.sec.repo.HistoriqueElementContitutifRepository;
import org.sid.secservice.sec.repo.HistoriqueRepository;
import org.sid.secservice.sec.repo.HistoriqueUniteEnseignementRepository;
import org.sid.secservice.sec.repo.InscriptionRepository;
import org.sid.secservice.sec.repo.NoteRepository;
import org.sid.secservice.sec.repo.SemestreRepository;
import org.sid.secservice.sec.repo.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class ExportBulletinService {

    private final DecimalFormat df = new DecimalFormat("#.##");
    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private CalculMoyenneService calculMoyenneService;


    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private SemestreRepository semestreRepository;
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private GroupeRepository groupeRepository;

    @Autowired
    private AnneeAccademiqueRepository anneeAccademiqueRepository;

    @Autowired
    private ParametreRepechageService parametreRepechageService;


    @Autowired
    HistoriqueService historiqueService;
    @Autowired
    private AbsenceService absenceService;


    @Autowired
    private HistoriqueElementContitutifRepository historiqueElementContitutifRepository;
    @Autowired
    private HistoriqueUniteEnseignementRepository historiqueUniteEnseignementRepository;
   
    //private ParametreRepechageService parametreRepechageService;
    final NumberFormat formatter = new DecimalFormat("#.##");
    final NumberFormat formatMoyenne = new DecimalFormat("#00.00");



    public BulletinProvisoirExport getDonneExport(Long idGroupe,Long idSemestre, Long idSession, String ineEtudiant ) {
        final Groupe groupe = groupeRepository.getOne(idGroupe);
        final Semestre semestre = semestreRepository.getOne(idSemestre);
        final Session session =sessionRepository.findById(idSession).get();
        //Inscription inscription = inscriptionRepository.getOne(idInscription);
        Inscription inscription = inscriptionRepository.findByGroupeAndEtudiantIneAndAnneeAccademiqueActifTrue(groupe, ineEtudiant);
        final BulletinProvisoirExport bul = new BulletinProvisoirExport();
        final ArrayList<Provisoiretoutue> toutues = new ArrayList<>();
        float moyenneS = 0;
        float credits = 0;
        float abs = 0;
        int repeche=0;
      /*   bul.setInscription(inscription); */
        Boolean absence=false;
        ParametreRepechage parametreRepechageabse=this.parametreRepechageService.StructureAndAnneeAcademique(inscription.getAnneeAccademique().getId(),inscription.getGroupe().getNiveau().getFormation().getDepartement().getId());
        if(parametreRepechageabse!=null && Boolean.TRUE.equals(parametreRepechageabse.isAbsence()))
            absence=true;
        AnneeAccademique anneeAccademique=inscription.getAnneeAccademique();
        int k=0;
        List<HistoriqueUniteEnseignement> unites=null;
        
        unites=historiqueUniteEnseignementRepository.findByUniteEnseignementNiveauAndSemestreAndAnneeAccademiqueActifTrueAndIsExecuteTrueOrderByNewCode(inscription.getGroupe().getNiveau(), semestre);

        if(!this.inscriptionRepository.findByGroupeNiveauAndEtudiantIneOrderByAnneeAccademiqueNomAnneeAccademiqueAsc(inscription.getGroupe().getNiveau(), ineEtudiant).isEmpty()){
            unites=historiqueUniteEnseignementRepository.findByUniteEnseignementNiveauAndSemestreAndAnneeAccademiqueAndIsExecuteTrueOrderByNewCode(inscription.getGroupe().getNiveau(), semestre,this.inscriptionRepository.findByGroupeNiveauAndEtudiantIneOrderByAnneeAccademiqueNomAnneeAccademiqueAsc(inscription.getGroupe().getNiveau(), ineEtudiant).get(0).getAnneeAccademique());
        }
        for (int i = 0; i < unites.size(); i++) {
            int absencein=this.absenceService.getAbsenceUe(unites.get(i).getId(), inscription.getId());
            final Provisoiretoutue toutue = new Provisoiretoutue();
            float moyenne = 0;
            float totalCoef = 0;
            float moyenneSousMoyenne = 0;
            float totalCoefsousMoyenne = 0;
            float moyenneUE = 0;
            Session session2=session;
            Historique historique = null; 
            Historique historique2 =historiqueService.getHistoriqueUeOuPreSession(unites.get(i),inscription, sessionRepository.findBySession(EnumSession.NORMALE));
            Float moyenneUe=0f;
            if(historique2!=null)
                moyenneUe=historique2.getMoyenneUE();

            HistoriqueUniteEnseignement historiqueUniteEnseignement=null;
            List<HistoriqueElementContitutif> elementConstitutifs=null;
            if((inscription.getGroupe().getNiveau().getFormation().getTypeEvaluatiion().getTypeEval()==EnumTypeEvaluation.LMD || inscription.getEtat()==EnumEtat.POURSOUTENANCE))
                historique = this.historiqueService.getHistoriqueUeOuPreSession(unites.get(i),inscription,session);
            if(unites.get(i).getAnneeAccademique().equals(inscription.getAnneeAccademique())){
                if ( historique!= null ){
                    anneeAccademique=historique.getInscription().getAnneeAccademique();
                    session2=historique.getSession();
                    historiqueUniteEnseignement=historiqueUniteEnseignementRepository.findByUniteEnseignementAndAnneeAccademique(historique.getUniteEnseignement(),historique.getInscription().getAnneeAccademique());
                    if(historiqueUniteEnseignement!=null)
                        elementConstitutifs = historiqueElementContitutifRepository.findByHistoriqueUniteEnseignementAndIsExecuteTrueOrderByNewcode(historiqueUniteEnseignement);
                    else
                        elementConstitutifs = historiqueElementContitutifRepository.findByHistoriqueUniteEnseignementAndIsExecuteTrueOrderByNewcode(unites.get(i));
                }else{
                    elementConstitutifs = historiqueElementContitutifRepository.findByHistoriqueUniteEnseignementAndIsExecuteTrueOrderByNewcode(unites.get(i));
                }
            }else{
                if (historique!= null){
                    session2=historique.getSession();
                    anneeAccademique=historique.getInscription().getAnneeAccademique();
                }
                   
                elementConstitutifs = historiqueElementContitutifRepository.findByHistoriqueUniteEnseignementAndIsExecuteTrueOrderByNewcode(unites.get(i));
            }   

            final Boolean enumTypeCalculNote;
            ParametreRepechage parametreRepechage=this.parametreRepechageService.StructureAndAnneeAcademique(anneeAccademique.getId(),inscription.getGroupe().getNiveau().getFormation().getDepartement().getId());
            if(parametreRepechage!=null && Boolean.TRUE.equals(parametreRepechage.isRattrapage()))
                enumTypeCalculNote=true;
            else
                enumTypeCalculNote=false;
            ArrayList<ProvisoirExport> provisions = new ArrayList<>();
            int ik=0;
            int repecheI=0;
            
            for ( HistoriqueElementContitutif elementConstitutif : elementConstitutifs) {
                if (elementConstitutif.isIsExecute()) {
                    Note note = null;
                    ProvisoirExport provision = new ProvisoirExport();
                    provision.setHistoriqueElementContitutif(elementConstitutif);
                    if (historique != null && (inscription.getGroupe().getNiveau().getFormation().getTypeEvaluatiion().getTypeEval()==EnumTypeEvaluation.LMD || inscription.getEtat()==EnumEtat.POURSOUTENANCE)) {
                        note = noteRepository.findByAnneeAccademiqueAndElementConstitutifAndEtudiant( historique.getInscription().getAnneeAccademique(),elementConstitutif.getElementConstitutif(), historique.getInscription().getEtudiant());
                    } else {
                        note = noteRepository.findByAnneeAccademiqueAndElementConstitutifAndEtudiant(inscription.getAnneeAccademique(), elementConstitutif.getElementConstitutif(),inscription.getEtudiant());
                    }
                    Float MoyEC = null;
                    if (note != null) {
                    // SESSION NORMALE
                        if(session2.getSession()==EnumSession.NORMALE){
                            if(Boolean.TRUE.equals(note.isAbsence()))
                                ik++;
                            if(note.getPointJury()!=null)
                                repecheI++;
                            setNoteCCtp(elementConstitutif, note, inscription, provision);
                            if (note.getDs() != null) {
                                provision.setDs(note.getDs());
                            }
                        }else{
                            if(Boolean.TRUE.equals(note.isAbsenceRattrapage()))
                                ik++;
                            if(note.getPointjuryR()!=null)
                                repecheI++;
                            if (note.getRattrapage() != null) {
                                provision.setDs(note.getRattrapage());
                            }
                        }
                        MoyEC=this.calculMoyenneService.calculMoyenneEc(note, session2, elementConstitutif.getCoeff(), true,moyenneUe,enumTypeCalculNote);
                        if(MoyEC!=null){
                            provision.setMoyenne((float) Math.round(MoyEC * 100) / 100);
                            moyenne+=provision.getMoyenne()*elementConstitutif.getCoeff();
                        }
                    }
                    totalCoef = totalCoef + elementConstitutif.getCoeff();
                    moyenneUE =  moyenne / totalCoef;
                    provision.setIntitule(elementConstitutif.getNewcode() + " : " + elementConstitutif.getIntitule());
                    provision.setIntitules(unites.get(i).getIntitules()); 
                    provision.setCoefficient(elementConstitutif.getCoeff());
                    if(absence && inscription.getGroupe().getNiveau().getFormation().getDepartement().getCode().equals("DGI") && inscription.getGroupe().getNiveau().isTerminal() && inscription.getGroupe().getNiveau().getFormation().getType()==EnumFormationType.DIC)
                        moyenneUE=(float)Math.round((moyenneUE-absencein/8f)*100)/100;
                    else
                        moyenneUE=(float)Math.round((moyenneUE)*100)/100;
                    if(ik==0)
                        provision.setMoyenneDefinitif(moyenneUE);
                    provision.setNbAbence(absencein);
                    provision.setCredit(unites.get(i).getCredit());
                    provisions.add(provision);
                }
            }
          
            float credit=0;
            toutue.setProvisoirs(provisions);
            toutue.setIntituleUE(unites.get(i).getIntitules()); 

            //credit=this.calculCreditService.getCreditUE(unites.get(i),inscription.getGroupe().getNiveau() );
            toutue.setCredit(unites.get(i).getCredit());
            if(ik==0)
                toutue.setMoyenneUE(moyenneUE);
            else
                k++;

            toutue.setMoyenne((float) Math.round((moyenneSousMoyenne/totalCoefsousMoyenne)*100)/100);
            toutue.setNbAbence(absencein);
            toutue.setHistoriqueUniteEnseignement(unites.get(i));
           
            if(repecheI!=0){
                toutue.setIsrepeche(true);
                repeche++;
            }
            toutues.add(toutue);
            moyenneS += moyenneUE * credit;
            credits += credit;
            abs += absencein;
        }
 
        bul.setNom(inscription.getEtudiant().getNom());
        bul.setIne(inscription.getEtudiant().getIne());
        float moyenne = 0;
        moyenne = (float) Math.round((moyenneS / credits) * 100) / 100;
        bul.setMoyenneG("" + abs);
        if(k==0)
            bul.setMoyenneGeneral(moyenne);
        if(repeche!=0)
            bul.setIsrepeche(true);
        bul.setSession(session.getSession().name());
        bul.setPrenom(inscription.getEtudiant().getPrenom());
        final SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
        final Date d = java.sql.Date.valueOf(inscription.getEtudiant().getDateNaissance());
        final String dateNaiss = s.format(d);
        bul.setDateNaissance(dateNaiss);
        bul.setLieuNaissance(inscription.getEtudiant().getLieuNaissance());
        // bul.setInscription(inscription);
        bul.setNomSemestre(semestre.getNomSemestre());
        bul.setLibelle(inscription.getGroupe().getLibelle() + " "+ inscription.getAnneeAccademique().getNomAnneeAccademique() + " " + semestre.getNomSemestre());
        bul.setToutues(toutues);
        return bul;
    }
   
 
    public void setNoteCCtp(HistoriqueElementContitutif historiqueElementContitutif,Note note,Inscription inscription,ProvisoirExport provision){
        if (historiqueElementContitutif.getTypeElementConstitutif() == EnumTypeElementConstitutif.THEORIE_PRATIQUE|| historiqueElementContitutif.getTypeElementConstitutif() == EnumTypeElementConstitutif.THEORIE) {
            if (note.getCc() != null)
                provision.setCc((float) Math.round(note.getCc() * 100) / 100);
            else {
                if (noteRepository.findByElementConstitutifAndAndAnneeAccademiqueAndElementConstitutifUniteEnseignementNiveauAndCcNotNull(historiqueElementContitutif.getElementConstitutif(), note.getAnneeAccademique(), inscription.getGroupe().getNiveau()).size() != 0) {
                    provision.setCc(0f);
                }
            }
            if (note.getDs() != null)
                provision.setDs((float) Math.round(note.getDs() * 100) / 100);
        }
        if (historiqueElementContitutif.getTypeElementConstitutif() == EnumTypeElementConstitutif.THEORIE_PRATIQUE||historiqueElementContitutif.getTypeElementConstitutif() == EnumTypeElementConstitutif.PRATIQUE) {
            if (note.getTp() != null) {
                provision.setTp((float) Math.round(note.getTp() * 100) / 100);
            } else {
                if (noteRepository.findByElementConstitutifAndAndAnneeAccademiqueAndElementConstitutifUniteEnseignementNiveauAndTpNotNull(historiqueElementContitutif.getElementConstitutif(),note.getAnneeAccademique(), inscription.getGroupe().getNiveau()).size() != 0) {
                    provision.setTp(0f);
                }
            }
        }
    }
}
