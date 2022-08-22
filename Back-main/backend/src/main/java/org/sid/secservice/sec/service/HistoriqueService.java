package org.sid.secservice.sec.service;

import java.util.List;

import org.sid.secservice.sec.entities.Historique;
import org.sid.secservice.sec.entities.HistoriqueUniteEnseignement;
import org.sid.secservice.sec.entities.Inscription;
import org.sid.secservice.sec.entities.ParametreRepechage;
import org.sid.secservice.sec.entities.Session;
import org.sid.secservice.sec.entities.enumeration.EnumEtat;
import org.sid.secservice.sec.entities.enumeration.EnumSession;
import org.sid.secservice.sec.entities.enumeration.EnumTypeEvaluation;
import org.sid.secservice.sec.repo.HistoriqueRepository;
import org.sid.secservice.sec.repo.NoteRepository;
import org.sid.secservice.sec.repo.ParametreRepechageRepository;
import org.sid.secservice.sec.repo.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HistoriqueService {
    @Autowired
    private HistoriqueRepository historiqueRepository;


    public Historique getHistoriqueUe(HistoriqueUniteEnseignement historiqueUniteEnseignement,Inscription inscription,Session session){
        Historique historique=this.historiqueRepository.findByInscriptionAndUniteEnseignementAndSession(inscription, historiqueUniteEnseignement.getUniteEnseignement(), session);
        if(historique!=null)
            return historique;
        historique= this.historiqueRepository.findByInscriptionAndUniteEnseignementAndSessionSession(inscription,historiqueUniteEnseignement.getUniteEnseignement(), EnumSession.NORMALE);
        if(historique!=null)
            return historique;
       /*  System.out.println(inscriptionService.listeInscription(inscription));
        historique=getMoyenneHistorique(inscriptionService.listeInscription(inscription), historiqueUniteEnseignement); */
        return historique;
    }
    



    public Historique getHistoriqueUeOuPreSession(HistoriqueUniteEnseignement historiqueUniteEnseignement,Inscription inscription,Session session){
        Historique historique=this.historiqueRepository.findByInscriptionEtudiantAndUniteEnseignementAndMoyenneUEGreaterThanEqual(inscription.getAnneeAccademique().getNomAnneeAccademique(), inscription.getEtudiant(), historiqueUniteEnseignement.getUniteEnseignement(), 10f);
        if(historique!=null && (inscription.getGroupe().getNiveau().getFormation().getTypeEvaluatiion().getTypeEval()==EnumTypeEvaluation.LMD || inscription.getEtat()==EnumEtat.POURSOUTENANCE))
            return historique;
        historique=this.historiqueRepository.findByInscriptionAndUniteEnseignementAndSession(inscription,historiqueUniteEnseignement.getUniteEnseignement(), session);
        if(historique!=null)
            return historique;
       /*  historique=getMoyenneHistorique(inscriptionService.listeInscription(inscription), historiqueUniteEnseignement); */
        return historique ;
    }


}
