package org.sid.secservice.sec.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class BulletinProvisoirExport implements Serializable{

    private String nom;
    private String nom1;
    private String prenom;
    private Float penalite;
    private Float penaliteSemNterminal;
    private String nomFamille;
    private String nom_Famille;
    private Float totalGroupe1;
    private Float totalGroupe2;
    private Float moyenneAnnuelle;
    private Float moyenneAnnuelleG1;
    private Float moyenneAnnuelleG2;
    private Float totalCreditValideS1;
    // private Inscription inscription;
    private String moyenneSemestre;
    private String moyenneSemestreratt;
    int nombreEC ;
    int nombreUE ;


    public int getNombreEC() {
        return nombreEC;
    }

    public void setNombreEC(int nombreEC) {
        this.nombreEC = nombreEC;
    }

    public int getNombreUE() {
        return nombreUE;
    }

    public void setNombreUE(int nombreUE) {
        this.nombreUE = nombreUE;
    }

    private String prenoms;
    private String prenomFamille;
    private String dateNaissance;

    private String dateNaissanceEtudiant;

    private String dateNaissance1;

    private String lieuNaissance;
    private String nomSemestre;
    private String nomDuSemestre;
    private String libelle;
    private Integer absenceSemestre;
    private Integer absenceSemestreNterminal;
    private String nomAnneeAccademique;
    private String chef;
    private String nomAnneeAccademiqueEtudiant;
    private String nomFormation;
    private String semetreNterminal;
    private String option;
    private String annee;
    private String AnneeScolaire;

    private String nomAnneeAccademique1;

    private String annee1;

    private String ine;
    private String di;
    private Float ma;
    private Float max;
    private Float maxe;
    private Float mal;
    private Float mi;
    private Float min;
    private Float mine;
    private Float mil;
    private String niveau;
    private String nivLMD;
    private String moyenneG;
    private String decisionSemestriel;


    public String getDecisionSemestriel() {
        return decisionSemestriel;
    }

    public void setDecisionSemestriel(String decisionSemestriel) {
        this.decisionSemestriel = decisionSemestriel;
    }

    private String moyenneGratt;

    private Float moyenneGeneral;

    private String moyenneG1;
    private String moyenneG2;
    private Integer totalCredit;

    private Float totalCreditValide;

    private Integer crediannuelle;

    private String moyenneCl;
    private Float moyenneCla;
    private Float moyenneClas;
    private Float moyenneClass;
    private Float moyenneClasse;
    private Float moyClassEC;
    private Float moyenneEcClass;
    private String co;
    private String cod;
    private String code;
    private String codd;
    private String uevalidee;
    private String cre;
    private String cred;
    private Integer credi;
    private Integer credit;
    private Float moyenTT;
    private Float moyenTTT;
    private String rang;
    private String rang1;
    private String rang2;
    private int total3;
    private String total;
    private String dec;
    private String decConseil;
    private String adresse;
    private String rangAnnuelNormal;
    private String moyenneAnnuelleNormale;
    private String creditNormal;
    private Float moyenneGc;
    private String range;
    private Float totalcooeftheorique;
    private Float totalmoyennetheorique;
    private Float moyenneclasstheorique;
    private Float moyenneclasspratique;
    private Float moyenneclasstheorique2;
    private Float moyenneclasspratique2;
    private Float totalmoyennepratique;
    private Float totalmoyenneclasstheorique;
    private Float totalmoyenneclasspratique;
    private Float moyennepratique;
    private Float moyennetheorique;

    private Float moyenneannuelle;

    private Float moyennepratique2;
    private Float moyennetheorique2;

    private Float totalcoefpratique;
    private Integer absenceetudidant;
    private Float moyenneannueltheorique;
    private Float moyenneannuelpratique;
    private Float moyenneannuelclasstheorique;
    private Float moyenneannuelclasspratique;
    private Integer absenceclass;
    private String semestrePrecedant;

    private String moyennesemstrenterminal;
    private String specialite;
    private String laSession;
    private String signatureLicenceBio;

    // private Integer penalite;
    private String session;
    private float totalcoefUE;
    private Integer nbAbences = 0;
    private String ueValide;
    private float moyenneGClasse;
    private Float totalCreditValideSemestrePrecedant;
    private Float totalCreditValideSemestrePourLannee;
    private String nomDuSemestrePrecedant;
    private Integer niveauPrecedant;
    private Integer numSemestrePrece;
    private String groupeOption;
    private String textTotalCreditFormation;
    private String nomFormationLicenceOuMaster;
    private String chefDepartement;
    private String dep;
    private String nomNiveauFormation;


 
    private String mention;
    private Integer absencetheorie;
    private Integer absencepratique;
    private Integer absenceclassetheorie;
    private Integer absenceclassepratique;
    private String qrCode;


    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    private List<Provisoiretoutue> toutues1 = new ArrayList<>();
    private List<Provisoiretoutue> toutues = new ArrayList<>();

    // DUT GESTION
    private List<Provisoiretoutue> toutues2 = new ArrayList<>();
    private List<Provisoiretoutue> toutues3 = new ArrayList<>();
    private List<Provisoiretoutue> toutues4 = new ArrayList<>();
    private ArrayList<ProvisoirContent> toutuescontent = new ArrayList<ProvisoirContent>();

    // Fin DUT GESTION

    public ArrayList<ProvisoirContent> getToutuescontent() {
        return toutuescontent;
    }

    public void setToutuescontent(ArrayList<ProvisoirContent> toutuescontent) {
        this.toutuescontent = toutuescontent;
    }

    private float moyenneGroupe1;
    private float moyenneGroupe2;

    // Enjambiste
    private List<Provisoiretoutue> toutAnnuelEnjambiste = new ArrayList<>();
    private List<ProvisoirExport> moyGeRangMoyclass = new ArrayList<>();
    private List<ProvisoirExport> moyGeS1S2Annuel = new ArrayList<>();

    
    public List<ProvisoirExport> getMoyGeS1S2Annuel() {
        return moyGeS1S2Annuel;
    }

    public void setMoyGeS1S2Annuel(List<ProvisoirExport> moyGeS1S2Annuel) {
        this.moyGeS1S2Annuel = moyGeS1S2Annuel;
    }

    private List<ProvisoirExport> moyGeRangMoyAnnuel = new ArrayList<>();
    private List<ProvisoirExport> annuelEnjambiste = new ArrayList<>();

    // Formation lmd gestion
    private List<ProvisoirExport> information = new ArrayList<>();
    private List<ProvisoirExport> formationOption = new ArrayList<>();


    public List<ProvisoirExport> getFormationOption() {
        return formationOption;
    }

    public void setFormationOption(List<ProvisoirExport> formationOption) {
        this.formationOption = formationOption;
    }

    public List<ProvisoirExport> getInformation() {
        return information;
    }

    public void setInformation(List<ProvisoirExport> information) {
        this.information = information;
    }

    private boolean isrepeche;
    
    public boolean isIsrepeche() {
        return isrepeche;
    }

    public void setIsrepeche(boolean isrepeche) {
        this.isrepeche = isrepeche;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getSemetreNterminal() {
        return semetreNterminal;
    }

    public void setSemetreNterminal(String semetreNterminal) {
        this.semetreNterminal = semetreNterminal;
    }

    public String getMoyennesemstrenterminal() {
        return moyennesemstrenterminal;
    }

    public void setMoyennesemstrenterminal(String moyennesemstrenterminal) {
        this.moyennesemstrenterminal = moyennesemstrenterminal;
    }

    public String getUevalidee() {
        return uevalidee;
    }

    public void setUevalidee(String uevalidee) {
        this.uevalidee = uevalidee;
    }

    public String getMoyenneSemestre() {
        return moyenneSemestre;
    }

    public void setMoyenneSemestre(String moyenneSemestre) {
        this.moyenneSemestre = moyenneSemestre;
    }

    public String getMoyenneSemestreratt() {
        return moyenneSemestreratt;
    }

    public void setMoyenneSemestreratt(String moyenneSemestreratt) {
        this.moyenneSemestreratt = moyenneSemestreratt;
    }

    public Integer getCrediannuelle() {
        return crediannuelle;
    }

    public void setCrediannuelle(Integer crediannuelle) {
        this.crediannuelle = crediannuelle;
    }

    public String getNom1() {
        return nom1;
    }

    public void setNom1(String nom1) {
        this.nom1 = nom1;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }



    public Float getMoyenneannuelle() {
        return moyenneannuelle;
    }

    public void setMoyenneannuelle(Float moyenneannuelle) {
        this.moyenneannuelle = moyenneannuelle;
    }

    ///////////////////////////
    public Float getPenalite() {
        return penalite;
    }

    public void setPenalite(Float penalite) {
        this.penalite = penalite;
    }

    public Float getPenaliteSemNterminal() {
        return penaliteSemNterminal;
    }

    public void setPenaliteSemNterminal(Float penaliteSemNterminal) {
        this.penaliteSemNterminal = penaliteSemNterminal;
    }


    public Integer getAbsenceSemestreNterminal() {
        return absenceSemestreNterminal;
    }

    public void setAbsenceSemestreNterminal(Integer absenceSemestreNterminal) {
        this.absenceSemestreNterminal = absenceSemestreNterminal;
    }

    public Integer getAbsenceSemestre() {
        return absenceSemestre;
    }

    public void setAbsenceSemestre(Integer absenceSemestre) {
        this.absenceSemestre = absenceSemestre;
    }





    public String getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(String dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getDateNaissance1() {
        return dateNaissance1;
    }

    public void setDateNaissance1(String dateNaissance1) {
        this.dateNaissance1 = dateNaissance1;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    // Nom semestre
    public String getNomSemestre() {
        return nomSemestre;
    }

    public void setNomSemestre(String nomSemestre) {
        this.nomSemestre = nomSemestre;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public String getNomAnneeAccademique() {
        return nomAnneeAccademique;
    }

    public void setNomAnneeAccademique(String nomAnneeAccademique) {
        this.nomAnneeAccademique = nomAnneeAccademique;
    }

    public String getNomAnneeAccademique1() {
        return nomAnneeAccademique1;
    }

    public void setNomAnneeAccademique1(String nomAnneeAccademique1) {
        this.nomAnneeAccademique1 = nomAnneeAccademique1;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getAnnee1() {
        return annee1;
    }

    public void setAnnee1(String annee1) {
        this.annee1 = annee1;
    }

    public Float getMa() {
        return ma;
    }

    public void setMa(Float ma) {
        this.ma = ma;
    }

    public Float getMax() {
        return max;
    }

    public void setMax(Float max) {
        this.max = max;
    }

    public Float getMaxe() {
        return maxe;
    }

    public void setMaxe(Float maxe) {
        this.maxe = maxe;
    }

    public Float getMal() {
        return mal;
    }

    public void setMal(Float mal) {
        this.mal = mal;
    }

    public Float getMi() {
        return mi;
    }

    public void setMi(Float mi) {
        this.mi = mi;
    }

    public Float getMin() {
        return min;
    }

    public void setMin(Float min) {
        this.min = min;
    }

    public Float getMine() {
        return mine;
    }

    public void setMine(Float mine) {
        this.mine = mine;
    }

    public Float getMil() {
        return mil;
    }

    public void setMil(Float mil) {
        this.mil = mil;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getNivLMD() {
        return nivLMD;
    }

    public void setNivLMD(String nivLMD) {
        this.nivLMD = nivLMD;
    }

    public String getMoyenneG() {
        return moyenneG;
    }

    public void setMoyenneG(String moyenneG) {
        this.moyenneG = moyenneG;
    }

    public String getMoyenneGratt() {
        return moyenneG;
    }

    public void setMoyenneGratt(String moyenneGratt) {
        this.moyenneGratt = moyenneGratt;
    }

    public String getMoyenneG1() {
        return moyenneG1;
    }

    public void setMoyenneG1(String moyenneG1) {
        this.moyenneG1 = moyenneG1;
    }

    public String getMoyenneG2() {
        return moyenneG2;
    }

    public void setMoyenneG2(String moyenneG2) {
        this.moyenneG2 = moyenneG2;
    }

    public Integer getTotalCredit() {
        return totalCredit;
    }

    public void setTotalCredit(Integer totalCredit) {
        this.totalCredit = totalCredit;
    }

    public String getMoyenneCl() {
        return moyenneCl;
    }

    public void setMoyenneCl(String moyenneCl) {
        this.moyenneCl = moyenneCl;
    }

    public String getDec() {
        return dec;
    }

    public void setDec(String dec) {
        this.dec = dec;
    }

    public Float getMoyenneCla() {
        return moyenneCla;
    }

    public void setMoyenneCla(Float moyenneCla) {
        this.moyenneCla = moyenneCla;
    }

    public Float getMoyenneClas() {
        return moyenneClas;
    }

    public void setMoyenneClas(Float moyenneClas) {
        this.moyenneClas = moyenneClas;
    }

    public Float getMoyenneClass() {
        return moyenneClass;
    }

    public void setMoyenneClass(Float moyenneClass) {
        this.moyenneClass = moyenneClass;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodd() {
        return codd;
    }

    public void setCodd(String codd) {
        this.codd = codd;
    }

    public String getCre() {
        return cre;
    }

    public void setCre(String cre) {
        this.cre = cre;
    }

    public String getCred() {
        return cred;
    }

    public void setCred(String cred) {
        this.cred = cred;
    }

    public Integer getCredi() {
        return credi;
    }

    public void setCredi(Integer credi) {
        this.credi = credi;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Float getMoyenTT() {
        return moyenTT;
    }

    public void setMoyenTT(Float moyenTT) {
        this.moyenTT = moyenTT;
    }

    public Float getMoyenTTT() {
        return moyenTTT;
    }

    public void setMoyenTTT(Float moyenTTT) {
        this.moyenTTT = moyenTTT;
    }

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getDi() {
        return di;
    }

    public void setDi(String di) {
        this.di = di;
    }

    public String getRang() {
        return rang;
    }

    public void setRang(String rang) {
        this.rang = rang;
    }

    public String getRang1() {
        return rang1;
    }

    public void setRang1(String rang1) {
        this.rang1 = rang1;
    }

    public int getTotal3() {
        return total3;
    }

    public void setTotal3(int total3) {
        this.total3 = total3;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Float getMoyenneGc() {
        return moyenneGc;
    }

    public void setMoyenneGc(Float moyenneGc) {
        this.moyenneGc = moyenneGc;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public List<Provisoiretoutue> getToutues() {
        return this.toutues;
    }

    public void setToutues(ArrayList<Provisoiretoutue> toutues) {
        this.toutues = toutues;
    }


    private List<ProvisoirExport> provisoire = new ArrayList<ProvisoirExport>();

    public List<ProvisoirExport> getProvisoire() {
        return this.provisoire;
    }

    public void setProvisoire(ArrayList<ProvisoirExport> provisoire) {
        this.provisoire = provisoire;
    }

    private List<ProvisoirExport> provisoire2 = new ArrayList<ProvisoirExport>();

    public List<ProvisoirExport> getProvisoire2() {
        return this.provisoire2;
    }

    public void setProvisoire2(ArrayList<ProvisoirExport> provisoire2) {
        this.provisoire2 = provisoire2;
    }

    private List<ProvisoirExport> provisoire3 = new ArrayList<ProvisoirExport>();

    public List<ProvisoirExport> getProvisoire3() {
        return this.provisoire3;
    }

    public void setProvisoire3(ArrayList<ProvisoirExport> provisoire3) {
        this.provisoire3 = provisoire3;
    }

    private List<ProvisoirExport> provisoire4 = new ArrayList<ProvisoirExport>();

    public List<ProvisoirExport> getProvisoire4() {
        return this.provisoire4;
    }

    public void setProvisoire4(ArrayList<ProvisoirExport> provisoire4) {
        this.provisoire4 = provisoire4;
    }

    private List<ProvisoirExport> provisoire5 = new ArrayList<ProvisoirExport>();

    public List<ProvisoirExport> getProvisoire5() {
        return this.provisoire5;
    }

    public void setProvisoire5(ArrayList<ProvisoirExport> provisoire5) {
        this.provisoire5 = provisoire5;
    }

    private List<ProvisoirExport> provisoire6 = new ArrayList<ProvisoirExport>();

    public List<ProvisoirExport> getProvisoire6() {
        return this.provisoire6;
    }

    public void setProvisoire6(ArrayList<ProvisoirExport> provisoire6) {
        this.provisoire6 = provisoire6;
    }

    private List<ProvisoirExport> provisoire7 = new ArrayList<ProvisoirExport>();

    public List<ProvisoirExport> getProvisoire7() {
        return this.provisoire7;
    }

    public void setProvisoire7(ArrayList<ProvisoirExport> provisoire7) {
        this.provisoire7 = provisoire7;
    }

    /*
     * private List<ProvisoirExport> provisoire5 = new ArrayList<ProvisoirExport>();
     *
     * public List<ProvisoirExport> getProvisoire5() { return this.provisoire5; }
     *
     * public void setProvisoire5(ArrayList<ProvisoirExport> provisoire5) {
     * this.provisoire5 = provisoire5; }
     */
  
    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }




    public Float getTotalcooeftheorique() {
        return totalcooeftheorique;
    }

    public void setTotalcooeftheorique(Float totalcooeftheorique) {
        this.totalcooeftheorique = totalcooeftheorique;
    }

    public Float getMoyenneannueltheorique() {
        return moyenneannueltheorique;
    }

    public void setMoyenneannueltheorique(Float moyenneannueltheorique) {
        this.moyenneannueltheorique = moyenneannueltheorique;
    }

    public Float getMoyenneannuelpratique() {
        return moyenneannuelpratique;
    }

    public void setMoyenneannuelpratique(Float moyenneannuelpratique) {
        this.moyenneannuelpratique = moyenneannuelpratique;
    }

    public Float getMoyenneannuelclasstheorique() {
        return moyenneannuelclasstheorique;
    }

    public void setMoyenneannuelclasstheorique(Float moyenneannuelclasstheorique) {
        this.moyenneannuelclasstheorique = moyenneannuelclasstheorique;
    }

    public Float getMoyenneannuelclasspratique() {
        return moyenneannuelclasspratique;
    }

    public void setMoyenneannuelclasspratique(Float moyenneannuelclasspratique) {
        this.moyenneannuelclasspratique = moyenneannuelclasspratique;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public Float getMoyenneClasse() {
        return moyenneClasse;
    }

    public void setMoyenneClasse(Float moyenneClasse) {
        this.moyenneClasse = moyenneClasse;
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

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getDateNaissanceEtudiant() {
        return dateNaissanceEtudiant;
    }

    public void setDateNaissanceEtudiant(String dateNaissanceEtudiant) {
        this.dateNaissanceEtudiant = dateNaissanceEtudiant;
    }

    public String getNomDuSemestre() {
        return nomDuSemestre;
    }

    public void setNomDuSemestre(String nomDuSemestre) {
        this.nomDuSemestre = nomDuSemestre;
    }

    public String getNomAnneeAccademiqueEtudiant() {
        return nomAnneeAccademiqueEtudiant;
    }

    public void setNomAnneeAccademiqueEtudiant(String nomAnneeAccademiqueEtudiant) {
        this.nomAnneeAccademiqueEtudiant = nomAnneeAccademiqueEtudiant;
    }

    public String getAnneeScolaire() {
        return AnneeScolaire;
    }

    public void setAnneeScolaire(String anneeScolaire) {
        AnneeScolaire = anneeScolaire;
    }

    public String getPrenomFamille() {
        return prenomFamille;
    }

    public void setPrenomFamille(String prenomFamille) {
        this.prenomFamille = prenomFamille;
    }

    public String getUeValide() {
        return ueValide;
    }

    public void setUeValide(String ueValide) {
        this.ueValide = ueValide;
    }

    public String getNom_Famille() {
        return nom_Famille;
    }

    public void setNom_Famille(String nom_Famille) {
        this.nom_Famille = nom_Famille;
    }

    public Float getMoyenneEcClass() {
        return moyenneEcClass;
    }

    public void setMoyenneEcClass(Float moyenneEcClass) {
        this.moyenneEcClass = moyenneEcClass;
    }

    public float getTotalcoefUE() {
        return totalcoefUE;
    }

    public void setTotalcoefUE(float totalcoefUE) {
        this.totalcoefUE = totalcoefUE;
    }

    public float getMoyenneGClasse() {
        return moyenneGClasse;
    }

    public void setMoyenneGClasse(float moyenneGClasse) {
        this.moyenneGClasse = moyenneGClasse;
    }

    public Float getTotalCreditValide() {
        return totalCreditValide;
    }

    public void setTotalCreditValide(Float totalCreditValide) {
        this.totalCreditValide = totalCreditValide;
    }

    public Float getTotalCreditValideSemestrePrecedant() {
        return totalCreditValideSemestrePrecedant;
    }

    public void setTotalCreditValideSemestrePrecedant(Float totalCreditValideSemestrePrecedant) {
        this.totalCreditValideSemestrePrecedant = totalCreditValideSemestrePrecedant;
    }

    public Float getTotalCreditValideSemestrePourLannee() {
        return totalCreditValideSemestrePourLannee;
    }

    public void setTotalCreditValideSemestrePourLannee(Float totalCreditValideSemestrePourLannee) {
        this.totalCreditValideSemestrePourLannee = totalCreditValideSemestrePourLannee;
    }

    public String getNomDuSemestrePrecedant() {
        return nomDuSemestrePrecedant;
    }

    public void setNomDuSemestrePrecedant(String nomDuSemestrePrecedant) {
        this.nomDuSemestrePrecedant = nomDuSemestrePrecedant;
    }

    public Integer getNiveauPrecedant() {
        return niveauPrecedant;
    }

    public void setNiveauPrecedant(Integer niveauPrecedant) {
        this.niveauPrecedant = niveauPrecedant;
    }

    public String getDecConseil() {
        return decConseil;
    }

    public void setDecConseil(String decConseil) {
        this.decConseil = decConseil;
    }

    public Integer getNumSemestrePrece() {
        return numSemestrePrece;
    }

    public void setNumSemestrePrece(Integer numSemestrePrece) {
        this.numSemestrePrece = numSemestrePrece;
    }

    public String getGroupeOption() {
        return groupeOption;
    }

    public void setGroupeOption(String groupeOption) {
        this.groupeOption = groupeOption;
    }

    public String getTextTotalCreditFormation() {
        return textTotalCreditFormation;
    }

    public void setTextTotalCreditFormation(String textTotalCreditFormation) {
        this.textTotalCreditFormation = textTotalCreditFormation;
    }

    // svp c pour GCBA

    public String getMention() {
        return mention;
    }

    public void setMention(String mention) {
        this.mention = mention;
    }

    public String getNomFormationLicenceOuMaster() {
        return nomFormationLicenceOuMaster;
    }

    public void setNomFormationLicenceOuMaster(String nomFormationLicenceOuMaster) {
        this.nomFormationLicenceOuMaster = nomFormationLicenceOuMaster;
    }

    public Float getMoyenneGeneral() {
        return moyenneGeneral;
    }

    public void setMoyenneGeneral(Float moyenneGeneral) {
        this.moyenneGeneral = moyenneGeneral;
    }

    public Float getTotalGroupe1() {
        return totalGroupe1;
    }

    public void setTotalGroupe1(Float totalGroupe1) {
        this.totalGroupe1 = totalGroupe1;
    }

    public List<Provisoiretoutue> getToutues2() {
        return toutues2;
    }

    public void setToutues2(List<Provisoiretoutue> toutues2) {
        this.toutues2 = toutues2;
    }

    public float getMoyenneGroupe1() {
        return moyenneGroupe1;
    }

    public void setMoyenneGroupe1(float moyenneGroupe1) {
        this.moyenneGroupe1 = moyenneGroupe1;
    }

    public List<Provisoiretoutue> getToutues4() {
        return toutues4;
    }

    public void setToutues4(List<Provisoiretoutue> toutues4) {
        this.toutues4 = toutues4;
    }

    public float getMoyenneGroupe2() {
        return moyenneGroupe2;
    }

    public void setMoyenneGroupe2(float moyenneGroupe2) {
        this.moyenneGroupe2 = moyenneGroupe2;
    }

    public List<Provisoiretoutue> getToutues1() {
        return toutues1;
    }

    public void setToutues1(List<Provisoiretoutue> toutues1) {
        this.toutues1 = toutues1;
    }

    public List<Provisoiretoutue> getToutues3() {
        return toutues3;
    }

    public void setToutues3(List<Provisoiretoutue> toutues3) {
        this.toutues3 = toutues3;
    }

    public Float getTotalGroupe2() {
        return totalGroupe2;
    }

    public void setTotalGroupe2(Float totalGroupe2) {
        this.totalGroupe2 = totalGroupe2;
    }

    public Float getMoyenneAnnuelle() {
        return moyenneAnnuelle;
    }

    public void setMoyenneAnnuelle(Float moyenneAnnuelle) {
        this.moyenneAnnuelle = moyenneAnnuelle;
    }

    public Float getMoyenneAnnuelleG1() {
        return moyenneAnnuelleG1;
    }

    public void setMoyenneAnnuelleG1(Float moyenneAnnuelleG1) {
        this.moyenneAnnuelleG1 = moyenneAnnuelleG1;
    }

    public Float getMoyenneAnnuelleG2() {
        return moyenneAnnuelleG2;
    }

    public void setMoyenneAnnuelleG2(Float moyenneAnnuelleG2) {
        this.moyenneAnnuelleG2 = moyenneAnnuelleG2;
    }

    public Integer getAbsencetheorie() {
        return absencetheorie;
    }

    public void setAbsencetheorie(Integer absencetheorie) {
        this.absencetheorie = absencetheorie;
    }

    public Integer getAbsencepratique() {
        return absencepratique;
    }

    public void setAbsencepratique(Integer absencepratique) {
        this.absencepratique = absencepratique;
    }

    public Float getTotalCreditValideS1() {
        return totalCreditValideS1;
    }

    public void setTotalCreditValideS1(Float totalCreditValideS1) {
        this.totalCreditValideS1 = totalCreditValideS1;
    }

    public Integer getAbsenceclassetheorie() {
        return absenceclassetheorie;
    }

    public void setAbsenceclassetheorie(Integer absenceclassetheorie) {
        this.absenceclassetheorie = absenceclassetheorie;
    }

    public Integer getAbsenceclassepratique() {
        return absenceclassepratique;
    }

    public void setAbsenceclassepratique(Integer absenceclassepratique) {
        this.absenceclassepratique = absenceclassepratique;
    }

    public String getDep() {
        return dep;
    }

    public void setDep(String dep) {
        this.dep = dep;
    }

    public String getChefDepartement() {
        return chefDepartement;
    }

    public void setChefDepartement(String chefDepartement) {
        this.chefDepartement = chefDepartement;
    }

  
    public String getNomNiveauFormation() {
        return nomNiveauFormation;
    }

    public void setNomNiveauFormation(String nomNiveauFormation) {
        this.nomNiveauFormation = nomNiveauFormation;
    }

    public String getRang2() {
        return rang2;
    }

    public void setRang2(String rang2) {
        this.rang2 = rang2;
    }

    public String getRangAnnuelNormal() {
        return rangAnnuelNormal;
    }

    public void setRangAnnuelNormal(String rangAnnuelNormal) {
        this.rangAnnuelNormal = rangAnnuelNormal;
    }

    public String getMoyenneAnnuelleNormale() {
        return moyenneAnnuelleNormale;
    }

    public void setMoyenneAnnuelleNormale(String moyenneAnnuelleNormale) {
        this.moyenneAnnuelleNormale = moyenneAnnuelleNormale;
    }

    public String getCreditNormal() {
        return creditNormal;
    }

    public void setCreditNormal(String creditNormal) {
        this.creditNormal = creditNormal;
    }

    public String getChef() {
        return chef;
    }

    public void setChef(String chef) {
        this.chef = chef;
    }

    public List<Provisoiretoutue> getToutAnnuelEnjambiste() {
        return toutAnnuelEnjambiste;
    }

    public void setToutAnnuelEnjambiste(List<Provisoiretoutue> toutAnnuelEnjambiste) {
        this.toutAnnuelEnjambiste = toutAnnuelEnjambiste;
    }

    public List<ProvisoirExport> getMoyGeRangMoyclass() {
        return moyGeRangMoyclass;
    }

    public void setMoyGeRangMoyclass(List<ProvisoirExport> moyGeRangMoyclass) {
        this.moyGeRangMoyclass = moyGeRangMoyclass;
    }

    public List<ProvisoirExport> getMoyGeRangMoyAnnuel() {
        return moyGeRangMoyAnnuel;
    }

    public void setMoyGeRangMoyAnnuel(List<ProvisoirExport> moyGeRangMoyAnnuel) {
        this.moyGeRangMoyAnnuel = moyGeRangMoyAnnuel;
    }

    public List<ProvisoirExport> getAnnuelEnjambiste() {
        return annuelEnjambiste;
    }

    public void setAnnuelEnjambiste(List<ProvisoirExport> annuelEnjambiste) {
        this.annuelEnjambiste = annuelEnjambiste;
    }

    public String getLaSession() {
        return laSession;
    }

    public void setLaSession(String laSession) {
        this.laSession = laSession;
    }

    public String getSignatureLicenceBio() {
        return signatureLicenceBio;
    }

    public void setSignatureLicenceBio(String signatureLicenceBio) {
        this.signatureLicenceBio = signatureLicenceBio;
    }

/* 
    public Inscription getInscription() {
        return inscription;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }
   */
    public String getSemestrePrecedant() {
        return semestrePrecedant;
    }

    public void setSemestrePrecedant(String semestrePrecedant) {
        this.semestrePrecedant = semestrePrecedant;
    }

    public String getNomFamille() {
        return nomFamille;
    }

    public void setNomFamille(String nomFamille) {
        this.nomFamille = nomFamille;
    }

    public Float getTotalmoyennetheorique() {
        return totalmoyennetheorique;
    }

    public void setTotalmoyennetheorique(Float totalmoyennetheorique) {
        this.totalmoyennetheorique = totalmoyennetheorique;
    }

    public Float getMoyenneclasstheorique() {
        return moyenneclasstheorique;
    }

    public void setMoyenneclasstheorique(Float moyenneclasstheorique) {
        this.moyenneclasstheorique = moyenneclasstheorique;
    }

    public Float getMoyenneclasspratique() {
        return moyenneclasspratique;
    }

    public void setMoyenneclasspratique(Float moyenneclasspratique) {
        this.moyenneclasspratique = moyenneclasspratique;
    }

    public Float getMoyenneclasstheorique2() {
        return moyenneclasstheorique2;
    }

    public void setMoyenneclasstheorique2(Float moyenneclasstheorique2) {
        this.moyenneclasstheorique2 = moyenneclasstheorique2;
    }

    public Float getMoyenneclasspratique2() {
        return moyenneclasspratique2;
    }

    public void setMoyenneclasspratique2(Float moyenneclasspratique2) {
        this.moyenneclasspratique2 = moyenneclasspratique2;
    }

    public Float getTotalmoyennepratique() {
        return totalmoyennepratique;
    }

    public void setTotalmoyennepratique(Float totalmoyennepratique) {
        this.totalmoyennepratique = totalmoyennepratique;
    }

    public Float getTotalmoyenneclasstheorique() {
        return totalmoyenneclasstheorique;
    }

    public void setTotalmoyenneclasstheorique(Float totalmoyenneclasstheorique) {
        this.totalmoyenneclasstheorique = totalmoyenneclasstheorique;
    }

    public Float getTotalmoyenneclasspratique() {
        return totalmoyenneclasspratique;
    }

    public void setTotalmoyenneclasspratique(Float totalmoyenneclasspratique) {
        this.totalmoyenneclasspratique = totalmoyenneclasspratique;
    }

    public Float getMoyennepratique() {
        return moyennepratique;
    }

    public void setMoyennepratique(Float moyennepratique) {
        this.moyennepratique = moyennepratique;
    }

    public Float getMoyennetheorique() {
        return moyennetheorique;
    }

    public void setMoyennetheorique(Float moyennetheorique) {
        this.moyennetheorique = moyennetheorique;
    }

    public Float getMoyennepratique2() {
        return moyennepratique2;
    }

    public void setMoyennepratique2(Float moyennepratique2) {
        this.moyennepratique2 = moyennepratique2;
    }

    public Float getMoyennetheorique2() {
        return moyennetheorique2;
    }

    public void setMoyennetheorique2(Float moyennetheorique2) {
        this.moyennetheorique2 = moyennetheorique2;
    }

    public Float getTotalcoefpratique() {
        return totalcoefpratique;
    }

    public void setTotalcoefpratique(Float totalcoefpratique) {
        this.totalcoefpratique = totalcoefpratique;
    }

    public Integer getAbsenceetudidant() {
        return absenceetudidant;
    }

    public void setAbsenceetudidant(Integer absenceetudidant) {
        this.absenceetudidant = absenceetudidant;
    }

    public Integer getAbsenceclass() {
        return absenceclass;
    }

    public void setAbsenceclass(Integer absenceclass) {
        this.absenceclass = absenceclass;
    }





    

}
