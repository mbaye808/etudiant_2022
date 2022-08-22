package org.sid.secservice.sec.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Provisoiretoutue implements Serializable {
    private Float moyenneUE;
    private String code;
    private Float credit;
    private String intitules;
    private String intitule;
    private String ueValide;
    private Float moyenneMethodeQuantG1;
    private Float moyenneMethodeQuantG2;
    private Float moyenneTechniqueGestionG2;
    private Float coefficient;
    private Float coefficientTheorique;
    private Float coefficientPratique;

    private String intituleUE;

    private Float moyenne;
    private Float moyenneRatt;
    private Float totalCreditValide;
    private String code1;
    private String type;
    private Float moyenneDefinitif;
    private Float moyenneDefinitifratt;
    private String ueAnnuel;
    private String num;
    private String ueValide1;
    private Integer nbAbence = 0;
    private Integer nbAbenceUEClasse = 0;

    private Integer nbAbences = 0;
    private String max;
    private String min;
    private String moyenneClass;
    private String moyenneClass1;
    private String session;
    private Float moyenneEcClass;
    private Integer absenceclass;
    private Float moyClassEC;
    private Float moyenneUEClass;
    private String methodeQuantitative;
    private HistoriqueUniteEnseignement historiqueUniteEnseignement;
    private Boolean isrepeche;



    // DUT GESTION
    private List<ProvisoirExport> provisoir1 = new ArrayList<>();// Pour Tableau 1
    private List<ProvisoirExport> provisoir2 = new ArrayList<>();// Pour Tableau 2
    private List<ProvisoirExport> provisoir3 = new ArrayList<>();// Pour Tableau 3
    private List<ProvisoirExport> provisoir4 = new ArrayList<>();// Pour Tableau 4

    // Enjambiste
    private ArrayList<ProvisoirExport> annuelEnjambiste = new ArrayList<>();

    
    public HistoriqueUniteEnseignement getHistoriqueUniteEnseignement() {
        return historiqueUniteEnseignement;
    }

    public void setHistoriqueUniteEnseignement(HistoriqueUniteEnseignement historiqueUniteEnseignement) {
        this.historiqueUniteEnseignement = historiqueUniteEnseignement;
    }
    public Float getMoyenneUE() {
        return moyenneUE;
    }

    public void setMoyenneUE(Float moyenneUE) {
        this.moyenneUE = moyenneUE;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    public Boolean getIsrepeche() {
        return isrepeche;
    }

    public void setIsrepeche(Boolean isrepeche) {
        this.isrepeche = isrepeche;
    }
    private ArrayList<ProvisoirExport> provisoirs = new ArrayList<>();
    private ArrayList<ProvisoirExport> donneeMatiereGenerale = new ArrayList<>();
    private ArrayList<ProvisoirExport> donneeMatiereMethodeQuant = new ArrayList<>();

    public ArrayList<ProvisoirExport> getProvisoirs() {
        return provisoirs;
    }

    public void setProvisoirs(ArrayList<ProvisoirExport> provisoires) {
        this.provisoirs = provisoires;
    }

    public Float getCredit() {
        return credit;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public String getIntitules() {
        return intitules;
    }

    public void setIntitules(String intitules) {
        this.intitules = intitules;
    }

    public String getUeValide() {
        return ueValide;
    }

    public void setUeValide(String ueValide) {
        this.ueValide = ueValide;
    }

    public ArrayList<ProvisoirExport> getDonneeMatiereGenerale() {
        return donneeMatiereGenerale;
    }

    public void setDonneeMatiereGenerale(ArrayList<ProvisoirExport> donneeMatiereGenerale) {
        this.donneeMatiereGenerale = donneeMatiereGenerale;
    }

    public ArrayList<ProvisoirExport> getDonneeMatiereMethodeQuant() {
        return donneeMatiereMethodeQuant;
    }

    public void setDonneeMatiereMethodeQuant(ArrayList<ProvisoirExport> donneeMatiereMethodeQuant) {
        this.donneeMatiereMethodeQuant = donneeMatiereMethodeQuant;
    }

    public Provisoiretoutue() {
    }

    public Float getMoyenneMethodeQuantG1() {
        return moyenneMethodeQuantG1;
    }

    public void setMoyenneMethodeQuantG1(Float moyenneMethodeQuantG1) {
        this.moyenneMethodeQuantG1 = moyenneMethodeQuantG1;
    }

    public List<ProvisoirExport> getProvisoir2() {
        return provisoir2;
    }

    public void setProvisoir2(List<ProvisoirExport> provisoir2) {
        this.provisoir2 = provisoir2;
    }

    public List<ProvisoirExport> getProvisoir3() {
        return provisoir3;
    }

    public void setProvisoir3(List<ProvisoirExport> provisoir3) {
        this.provisoir3 = provisoir3;
    }

    public List<ProvisoirExport> getProvisoir4() {
        return provisoir4;
    }

    public void setProvisoir4(List<ProvisoirExport> provisoir4) {
        this.provisoir4 = provisoir4;
    }

    public List<ProvisoirExport> getProvisoir1() {
        return provisoir1;
    }

    public void setProvisoir1(List<ProvisoirExport> provisoir1) {
        this.provisoir1 = provisoir1;
    }

    public Provisoiretoutue(String intitule) {
        this.intitule = intitule;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getMethodeQuantitative() {
        return methodeQuantitative;
    }

    public void setMethodeQuantitative(String methodeQuantitative) {
        this.methodeQuantitative = methodeQuantitative;
    }

    public Float getMoyenneMethodeQuantG2() {
        return moyenneMethodeQuantG2;
    }

    public void setMoyenneMethodeQuantG2(Float moyenneMethodeQuantG2) {
        this.moyenneMethodeQuantG2 = moyenneMethodeQuantG2;
    }

    public Float getMoyenneTechniqueGestionG2() {
        return moyenneTechniqueGestionG2;
    }

    public void setMoyenneTechniqueGestionG2(Float moyenneTechniqueGestionG2) {
        this.moyenneTechniqueGestionG2 = moyenneTechniqueGestionG2;
    }

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
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

    public String getIntituleUE() {
        return intituleUE;
    }

    public void setIntituleUE(String intituleUE) {
        this.intituleUE = intituleUE;
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

    public Float getTotalCreditValide() {
        return totalCreditValide;
    }

    public void setTotalCreditValide(Float totalCreditValide) {
        this.totalCreditValide = totalCreditValide;
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

    public String getUeAnnuel() {
        return ueAnnuel;
    }

    public void setUeAnnuel(String ueAnnuel) {
        this.ueAnnuel = ueAnnuel;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public Integer getNbAbenceUEClasse() {
        return nbAbenceUEClasse;
    }

    public void setNbAbenceUEClasse(Integer nbAbenceUEClasse) {
        this.nbAbenceUEClasse = nbAbenceUEClasse;
    }

    public Integer getNbAbences() {
        return nbAbences;
    }

    public void setNbAbences(Integer nbAbences) {
        this.nbAbences = nbAbences;
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

    public Float getMoyenneEcClass() {
        return moyenneEcClass;
    }

    public void setMoyenneEcClass(Float moyenneEcClass) {
        this.moyenneEcClass = moyenneEcClass;
    }

    public Integer getAbsenceclass() {
        return absenceclass;
    }

    public void setAbsenceclass(Integer absenceclass) {
        this.absenceclass = absenceclass;
    }

    public Float getMoyClassEC() {
        return moyClassEC;
    }

    public void setMoyClassEC(Float moyClassEC) {
        this.moyClassEC = moyClassEC;
    }

    public Float getMoyenneUEClass() {
        return moyenneUEClass;
    }

    public void setMoyenneUEClass(Float moyenneUEClass) {
        this.moyenneUEClass = moyenneUEClass;
    }

    private ArrayList<ProvisoirContent> toutuescontent = new ArrayList<ProvisoirContent>();
    private ArrayList<ProvisoirExport> provisoirsIntitules = new ArrayList<ProvisoirExport>();


    public ArrayList<ProvisoirExport> getProvisoirsIntitules() {
        return provisoirsIntitules;
    }

    public void setProvisoirsIntitules(ArrayList<ProvisoirExport> provisoirsIntitules) {
        this.provisoirsIntitules = provisoirsIntitules;
    }

    public ArrayList<ProvisoirContent> getToutuescontent() {
        return toutuescontent;
    }

    public void setToutuescontent(ArrayList<ProvisoirContent> toutuescontent) {
        this.toutuescontent = toutuescontent;
    }

    public ArrayList<ProvisoirExport> getAnnuelEnjambiste() {
        return annuelEnjambiste;
    }

    public void setAnnuelEnjambiste(ArrayList<ProvisoirExport> annuelEnjambiste) {
        this.annuelEnjambiste = annuelEnjambiste;
    }

}