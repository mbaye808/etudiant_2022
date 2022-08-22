package org.sid.secservice.sec.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.sid.secservice.sec.entities.Historique;
import org.sid.secservice.sec.entities.HistoriqueElementContitutif;
import org.sid.secservice.sec.entities.HistoriqueUniteEnseignement;
import org.sid.secservice.sec.entities.Inscription;
import org.sid.secservice.sec.entities.Note;
import org.sid.secservice.sec.entities.Session;
import org.sid.secservice.sec.entities.enumeration.EnumSession;
import org.sid.secservice.sec.entities.enumeration.EnumTypeElementConstitutif;
import org.sid.secservice.sec.repo.NoteRepository;
import org.sid.secservice.sec.repo.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculMoyenneService {
    @Autowired
    private NoteRepository noteRepository;

    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private HistoriqueService historiqueService;

    @Autowired
    private AbsenceService absenceService; 

    
    public Float calculMoyenneUe(List<HistoriqueElementContitutif> elementConstitutif,Inscription inscription, Session session, boolean pointjury,Boolean enumTypeCalculNote){
        float moyenne = 0;
        float totalCoef=0;
        Historique historique =null;
        if(!elementConstitutif.isEmpty())
            historique =historiqueService.getHistoriqueUe(elementConstitutif.get(0).getHistoriqueUniteEnseignement(),inscription, sessionRepository.findBySession(EnumSession.NORMALE));
        Float moyenneUe=0f;
        if(historique!=null)
            moyenneUe=historique.getMoyenneUE();

        for (HistoriqueElementContitutif element : elementConstitutif) {
            Note note = noteRepository.findByAnneeAccademiqueAndElementConstitutifAndEtudiant( inscription.getAnneeAccademique(),element.getElementConstitutif(), inscription.getEtudiant());
            if (note != null){
                Float ec=this.calculMoyenneEc(note, session, element.getCoeff(),pointjury,moyenneUe,enumTypeCalculNote);
                if(ec!=null)
                    moyenne+=ec*element.getCoeff();
            } 
            totalCoef += element.getCoeff();
        }
        return (float)Math.round((moyenne/totalCoef)*100)/100 ;
    }
    public Float calculMoyenneUeSansArr(List<HistoriqueElementContitutif> elementConstitutif,Inscription inscription, Session session, boolean pointjury,Boolean enumTypeCalculNote){
        float moyenne = 0;
        float totalCoef=0;
        Historique historique =null;
        if(!elementConstitutif.isEmpty())
            historique =historiqueService.getHistoriqueUe(elementConstitutif.get(0).getHistoriqueUniteEnseignement(),inscription, sessionRepository.findBySession(EnumSession.NORMALE));
        Float moyenneUe=0f;
        if(historique!=null)
            moyenneUe=historique.getMoyenneUE();
        for (HistoriqueElementContitutif element : elementConstitutif) {
            Note note = noteRepository.findByAnneeAccademiqueAndElementConstitutifAndEtudiant( inscription.getAnneeAccademique(),element.getElementConstitutif(), inscription.getEtudiant());
            if (note != null){
                Float ec=this.calculMoyenneEc(note, session, element.getCoeff(),pointjury,moyenneUe,enumTypeCalculNote);
                if(ec!=null)
                    moyenne+=ec*element.getCoeff();
            } 
            totalCoef += element.getCoeff();
        }
        return moyenne/totalCoef ;
    }

    //OPTIONNEL
    public Float calculMoyenneEcRegle2(Note note,Float coef,boolean pointjury){
        Float moyenne=0f;
        if(note.getMoyenne()!=null && ((note.getRattrapage()!=null && note.getMoyenne()>note.getRattrapage()) || note.getRattrapage()==null)){
            moyenne +=note.getMoyenne();
        }else if(note.getRattrapage()!=null){
            moyenne +=note.getRattrapage();
        }else
            return null;
        if(note.getPointjuryR() != null  &&  pointjury)
            moyenne +=  note.getPointjuryR()/coef;
        
        return  (float)Math.round(moyenne*100)/100 ;
    }
    //OBLIGATOIRE
    public Float calculMoyenneEcRegle1(Note note,Float coef,boolean pointjury,Float moyenneUE){
        Float moyenne=0f;
        if(note.getMoyenne()!=null && (note.getMoyenne()>=10f || moyenneUE>=10f)){
            moyenne +=note.getMoyenne();
        }else if(note.getRattrapage()!=null){
            moyenne +=note.getRattrapage();
        }else
            return null;
        if(note.getPointjuryR() != null  &&  pointjury)
            moyenne +=  note.getPointjuryR()/coef;
        
        return  (float)Math.round(moyenne*100)/100 ;
    }
    

    public Float calculMoyenneEc(Note note,Session session,Float coef,boolean pointjury,Float moyenneUE,Boolean enumTypeCalculNote){
        Float moyenne=0f;
        if(session.getSession()==EnumSession.NORMALE){
            if(note.getMoyenne()!=null){
                moyenne +=note.getMoyenne();
            }else{
                return null;
            }
            if(note.getPointJury() != null && pointjury)
                moyenne +=  note.getPointJury()/coef;
        } else{
            if(enumTypeCalculNote)
                return this.calculMoyenneEcRegle1(note, coef, pointjury,moyenneUE);
            return this.calculMoyenneEcRegle2(note, coef, pointjury);
        }
        return  (float)Math.round(moyenne*100)/100 ;
    }
    public Float calculMoyenneTypeEc(Note note,HistoriqueElementContitutif historiqueElementContitutif,EnumTypeElementConstitutif enumTypeElementConstitutif){
        Float moyenne=0f;
        if(enumTypeElementConstitutif==EnumTypeElementConstitutif.THEORIE){
            if(note.getMoyenne()!=null){
                if(note.getPointJury() != null)
                    moyenne +=  note.getPointJury()/historiqueElementContitutif.getCoeff();
                moyenne += note.getMoyenne() ;
            }
        } else{
            if(note.getTp()!=null)
                moyenne=note.getTp();
        }
        return moyenne;
    }

    


}
