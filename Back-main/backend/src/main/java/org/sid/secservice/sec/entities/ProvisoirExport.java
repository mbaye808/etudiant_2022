package org.sid.secservice.sec.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ProvisoirExport implements Serializable {

    private Float tp;
    private Float cc;
    private Float ds;
    private Float coefficient;
    private Float coefficientTheorique;
    private Float coefficientPratique;
    private String coefficientGestion;

    private String intitule;
    private String intituleUE;

    private String intitules;
    private Float moyenne;
    private String moyenneGestion;

    private Float moyenneRatt;
    private Float credit;
    private Float totalCreditValide;
    private String code;
    private String code1;
    private String type;
    private Float moyenneDefinitif;
    private Float moyenneDefinitifratt;
    private String ueAnnuel;
    private String num;
    private String ueValide;
    private String ueValide1;
    private Integer nbAbence = 0;
    private Integer nbAbenceUEClasse = 0;

    private Integer nbAbences = 0;
    private Integer absenceTheorique;
    private Integer absencePratique;

    private String max;
    private String min;
    private String moyenneClass;
    private String session;
    private Float totalcooeftheorique;
    private Float totalmoyennetheorique;
    private Float moyenneclasstheorique;

    private Float moyenneclasspratique;
    private Float moyenneclasspratique2;
    private Float moyenneclasstheorique2;

    private Float totalmoyennepratique;
    private Float totalmoyenneclasstheorique;
    private String totalMoyenneClasseTheorique;
    private String totalMoyenneClassePratique;
    private String moyenneEcClassePratique;
    private String moyenneEcClasseTheorique;

    private Float totalmoyenneclasspratique;
    private Float moyennepratique;
    private Float moyennepratiqu2;
    private String nomSemestre;

    private Float moyennetheorique;
    private Float moyennetheorique2;

    private Float moyennePratique;
    private Float moyenneTheorique;
    private Float totalcoefpratique;
    private Integer absenceetudidant;
    private Float moyenneEcClass;
    private Integer absenceclass;
    private float notepond;
    private Float moyClassEC;
    private Float totalcoefUE;
    private Float moyenneUEClass;
    private Float moyenneClassePratique;
    private Float moyenneClasseTheorique;
    private Float totalCoefECTheorique;
    private Float totalCoefECPratique;
    private Float noteTheorique;
    private Float notePratique;
    private String codeUE;

    private String cod;
    private String cre;
    private String niveau;

    private String moyenneCl;
    private String moyenneG;
    private String Rang1;

    private Integer annuelCreditNiveau;
    private Integer totalCreditNiveau;
    private String decisionNiveauPrecedante;

    private Float moyenneClasseue;
    // DUT GESTION
    private String methodeQuantitative;

    // Formation lmd gestion
    private String nomFormation;
    private String nomAnneeAccademique;
    private String prenom;
    private String nom;
    private String dateNaissance;
    private String lieuNaissance;
    private String annee;


    private HistoriqueElementContitutif historiqueElementContitutif;


    // DUT GESTION

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getNomAnneeAccademique() {
        return nomAnneeAccademique;
    }

    public void setNomAnneeAccademique(String nomAnneeAccademique) {
        this.nomAnneeAccademique = nomAnneeAccademique;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public Float getMoyenneEcClass() {
        return moyenneEcClass;
    }

    public void setMoyenneEcClass(Float moyenneEcClass) {
        this.moyenneEcClass = moyenneEcClass;
    }

    public String getCodeUE() {
        return codeUE;
    }

    public void setCodeUE(String codeUE) {
        this.codeUE = codeUE;
    }

    public Float getMoyenneClasseue() {
        return moyenneClasseue;
    }

    public void setMoyenneClasseue(Float moyenneClasseue) {
        this.moyenneClasseue = moyenneClasseue;
    }

    public String getIntituleUE() {
        return intituleUE;
    }

    public void setIntituleUE(String intituleUE) {
        this.intituleUE = intituleUE;
    }

    public Float getTp() {
        return tp;
    }

    public void setTp(Float tp) {
        this.tp = tp;
    }

    public Float getCc() {
        return cc;
    }

    public void setCc(Float cc) {
        this.cc = cc;
    }

    public Float getDs() {
        return ds;
    }

    public void setDs(Float ds) {
        this.ds = ds;
    }

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getIntitules() {
        return intitules;
    }

    public void setIntitules(String intitules) {
        this.intitules = intitules;
    }

    public Float getMoyenne() {
        return moyenne;
    }

    public void setMoyenne(Float moyenne) {
        this.moyenne = moyenne;
    }

    public Float getMoyenneRatt() {
        return moyenneRatt;
    }

    public void setMoyenneRatt(Float moyenneRatt) {
        this.moyenneRatt = moyenneRatt;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMoyenneGestion() {
        return moyenneGestion;
    }

    public void setMoyenneGestion(String moyenneGestion) {
        this.moyenneGestion = moyenneGestion;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Float getMoyenneDefinitif() {
        return moyenneDefinitif;
    }

    public void setMoyenneDefinitif(Float moyenneDefinitif) {
        this.moyenneDefinitif = moyenneDefinitif;
    }

    public Float getMoyenneDefinitifratt() {
        return moyenneDefinitifratt;
    }

    public void setMoyenneDefinitifratt(Float moyenneDefinitifratt) {
        this.moyenneDefinitifratt = moyenneDefinitifratt;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getUeValide() {
        return ueValide;
    }

    public void setUeValide(String ueValide) {
        this.ueValide = ueValide;
    }

    public String getUeValide1() {
        return ueValide1;
    }

    public void setUeValide1(String ueValide1) {
        this.ueValide1 = ueValide1;
    }

    public Integer getNbAbence() {
        return nbAbence;
    }

    public void setNbAbence(Integer nbAbence) {
        this.nbAbence = nbAbence;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMoyenneClass() {
        return moyenneClass;
    }

    public void setMoyenneClass(String moyenneClass) {
        this.moyenneClass = moyenneClass;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Float getNotepond() {
        return notepond;
    }

    public void setNotepond(Float notepond) {
        this.notepond = notepond;
    }

    public Integer getabsenceetudidant() {
        return absenceetudidant;
    }

    public Integer getabsenceclass() {
        return absenceclass;
    }

    public void setabsenceclass(Integer absenceclass) {
        this.absenceclass = absenceclass;
    }

    public void setabsenceetudidant(Integer absenceetudidant) {
        this.absenceetudidant = absenceetudidant;
    }

    public void settotalcoefpratique(Float totalcoefpratique) {
        this.totalcoefpratique = totalcoefpratique;
    }

    public Float gettotalcoefpratique() {
        return totalcoefpratique;
    }

    public void settotalmoyenneclasspratique(Float totalmoyenneclasspratique) {
        this.totalmoyenneclasspratique = totalmoyenneclasspratique;
    }

    public Float gettotalmoyenneclasspratique() {
        return totalmoyenneclasspratique;
    }

    public Float gettotalmoyenneclasstheorique() {
        return totalmoyenneclasstheorique;
    }

    public void settotalmoyenneclasstheorique(Float totalmoyenneclasstheorique) {
        this.totalmoyenneclasstheorique = totalmoyenneclasstheorique;
    }

    public Float gettotalmoyennepratique() {
        return totalmoyennepratique;
    }

    public void setmoyenneclasstheorique(Float moyenneclasstheorique) {
        this.moyenneclasstheorique = moyenneclasstheorique;
    }

    public Float getmoyenneclasstheorique() {
        return moyenneclasstheorique;
    }

    public void setmoyennetheorique(Float moyennetheorique) {
        this.moyennetheorique = moyennetheorique;
    }

    public Float getmoyennetheorique() {
        return moyennetheorique;
    }

    public void setmoyenneclasspratique(Float moyenneclasspratique) {
        this.moyenneclasspratique = moyenneclasspratique;
    }

    public Float getmoyenneclasspratique() {
        return moyenneclasspratique;
    }

    public void setmoyennepratique(Float moyennepratique) {
        this.moyennepratique = moyennepratique;
    }

    public Float getmoyennepratique() {
        return moyennepratique;
    }

    public void settotalmoyennepratique(Float totalmoyennepratique) {
        this.totalmoyennepratique = totalmoyennepratique;
    }

    public Float gettotalmoyennetheorique() {
        return totalmoyennetheorique;
    }




    public Float gettotalcooeftheorique() {
        return totalcooeftheorique;
    }

    public void settotalcooeftheorique(Float totalcooeftheorique) {
        this.totalcooeftheorique = totalcooeftheorique;
    }

    public Integer getNbAbences() {
        return nbAbences;
    }

    public void setNbAbences(Integer nbAbences) {
        this.nbAbences = nbAbences;
    }

    public Float getMoyClassEC() {
        return moyClassEC;
    }

    public void setMoyClassEC(Float moyClassEC) {
        this.moyClassEC = moyClassEC;
    }

    public Float getTotalcoefUE() {
        return totalcoefUE;
    }

    public void setTotalcoefUE(Float totalcoefUE) {
        this.totalcoefUE = totalcoefUE;
    }

    public Float getMoyenneUEClass() {
        return moyenneUEClass;
    }

    public void setMoyenneUEClass(Float moyenneUEClass) {
        this.moyenneUEClass = moyenneUEClass;
    }

    public Float getCoefficientTheorique() {
        return coefficientTheorique;
    }

    public void setCoefficientTheorique(Float coefficientTheorique) {
        this.coefficientTheorique = coefficientTheorique;
    }

    public Float getCoefficientPratique() {
        return coefficientPratique;
    }

    public void setCoefficientPratique(Float coefficientPratique) {
        this.coefficientPratique = coefficientPratique;
    }







    public Float getMoyenneClasseTheorique() {
        return moyenneClasseTheorique;
    }

    public void setMoyenneClasseTheorique(Float moyenneClasseTheorique) {
        this.moyenneClasseTheorique = moyenneClasseTheorique;
    }

    public Float getMoyenneClassePratique() {
        return moyenneClassePratique;
    }

    public void setMoyenneClassePratique(Float moyenneClassePratique) {
        this.moyenneClassePratique = moyenneClassePratique;
    }

    public Float getTotalCoefECTheorique() {
        return totalCoefECTheorique;
    }

    public void setTotalCoefECTheorique(Float totalCoefECTheorique) {
        this.totalCoefECTheorique = totalCoefECTheorique;
    }

    public Float getTotalCoefECPratique() {
        return totalCoefECPratique;
    }

    public void setTotalCoefECPratique(Float totalCoefECPratique) {
        this.totalCoefECPratique = totalCoefECPratique;
    }

    public Integer getAbsenceTheorique() {
        return absenceTheorique;
    }

    public void setAbsenceTheorique(Integer absenceTheorique) {
        this.absenceTheorique = absenceTheorique;
    }

    public Integer getAbsencePratique() {
        return absencePratique;
    }

    public void setAbsencePratique(Integer absencePratique) {
        this.absencePratique = absencePratique;
    }

    public Float getNotePratique() {
        return notePratique;
    }

    public void setNotePratique(Float notePratique) {
        this.notePratique = notePratique;
    }

    public Float getNoteTheorique() {
        return noteTheorique;
    }

    public void setNoteTheorique(Float noteTheorique) {
        this.noteTheorique = noteTheorique;
    }

    public String getTotalMoyenneClasseTheorique() {
        return totalMoyenneClasseTheorique;
    }

    public void setTotalMoyenneClasseTheorique(String totalMoyenneClasseTheorique) {
        this.totalMoyenneClasseTheorique = totalMoyenneClasseTheorique;
    }

    public void setTotalMoyenneClassePratique(String totalMoyenneClassePratique) {
        this.totalMoyenneClassePratique = totalMoyenneClassePratique;
    }

    public String getMoyenneEcClasseTheorique() {
        return moyenneEcClasseTheorique;
    }

    public void setMoyenneEcClasseTheorique(String moyenneEcClasseTheorique) {
        this.moyenneEcClasseTheorique = moyenneEcClasseTheorique;
    }

    public String getMoyenneEcClassePratique() {
        return moyenneEcClassePratique;
    }

    public void setMoyenneEcClassePratique(String moyenneEcClassePratique) {
        this.moyenneEcClassePratique = moyenneEcClassePratique;
    }

    public String getTotalMoyenneClassePratique() {
        return totalMoyenneClassePratique;
    }

    public Float getMoyenneclasspratique2() {
        return moyenneclasspratique2;
    }

    public void setMoyenneclasspratique2(Float moyenneclasspratique2) {
        this.moyenneclasspratique2 = moyenneclasspratique2;
    }

    public Float getMoyenneclasstheorique2() {
        return moyenneclasstheorique2;
    }

    public void setMoyenneclasstheorique2(Float moyenneclasstheorique2) {
        this.moyenneclasstheorique2 = moyenneclasstheorique2;
    }

    public Float getMoyennetheorique2() {
        return moyennetheorique2;
    }

    public void setMoyennetheorique2(Float moyennetheorique2) {
        this.moyennetheorique2 = moyennetheorique2;
    }

    public Float getMoyennepratiqu2() {
        return moyennepratiqu2;
    }

    public void setMoyennepratiqu2(Float moyennepratiqu2) {
        this.moyennepratiqu2 = moyennepratiqu2;
    }

    public Float getTotalCreditValide() {
        return totalCreditValide;
    }

    public void setTotalCreditValide(Float totalCreditValide) {
        this.totalCreditValide = totalCreditValide;
    }

    public Integer getNbAbenceUEClasse() {
        return nbAbenceUEClasse;
    }

    public void setNbAbenceUEClasse(Integer nbAbenceUEClasse) {
        this.nbAbenceUEClasse = nbAbenceUEClasse;
    }

    public String getMethodeQuantitative() {
        return methodeQuantitative;
    }

    public void setMethodeQuantitative(String methodeQuantitative) {
        this.methodeQuantitative = methodeQuantitative;
    }

    public String getUeAnnuel() {
        return ueAnnuel;
    }

    public void setUeAnnuel(String ueAnnuel) {
        this.ueAnnuel = ueAnnuel;
    }


    public void setTotalmoyennetheorique(Float totalmoyennetheorique) {
        this.totalmoyennetheorique = totalmoyennetheorique;
    }

    public void setNotepond(float notepond) {
        this.notepond = notepond;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCre() {
        return cre;
    }

    public void setCre(String cre) {
        this.cre = cre;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getMoyenneCl() {
        return moyenneCl;
    }

    public void setMoyenneCl(String moyenneCl) {
        this.moyenneCl = moyenneCl;
    }

    public String getMoyenneG() {
        return moyenneG;
    }

    public void setMoyenneG(String moyenneG) {
        this.moyenneG = moyenneG;
    }

    public String getRang1() {
        return Rang1;
    }

    public void setRang1(String rang1) {
        Rang1 = rang1;
    }

    public Integer getAnnuelCreditNiveau() {
        return annuelCreditNiveau;
    }

    public void setAnnuelCreditNiveau(Integer annuelCreditNiveau) {
        this.annuelCreditNiveau = annuelCreditNiveau;
    }

    public Integer getTotalCreditNiveau() {
        return totalCreditNiveau;
    }

    public void setTotalCreditNiveau(Integer totalCreditNiveau) {
        this.totalCreditNiveau = totalCreditNiveau;
    }

    public String getDecisionNiveauPrecedante() {
        return decisionNiveauPrecedante;
    }

    public void setDecisionNiveauPrecedante(String decisionNiveauPrecedante) {
        this.decisionNiveauPrecedante = decisionNiveauPrecedante;
    }

 /*    public List<ProvisoirExport> getAnnuelEnjambiste() {
        return annuelEnjambiste;
    }

    public void setAnnuelEnjambiste(List<ProvisoirExport> annuelEnjambiste) {
        this.annuelEnjambiste = annuelEnjambiste;
    } */

    public String getNomSemestre() {
        return nomSemestre;
    }

    public void setNomSemestre(String nomSemestre) {
        this.nomSemestre = nomSemestre;
    }

    public String getCoefficientGestion() {
        return coefficientGestion;
    }

    public void setCoefficientGestion(String coefficientGestion) {
        this.coefficientGestion = coefficientGestion;
    }

    public HistoriqueElementContitutif getHistoriqueElementContitutif() {
        return historiqueElementContitutif;
    }

    public void setHistoriqueElementContitutif(HistoriqueElementContitutif historiqueElementContitutif) {
        this.historiqueElementContitutif = historiqueElementContitutif;
    }


    

}
