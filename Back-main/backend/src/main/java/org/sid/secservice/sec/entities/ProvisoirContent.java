package org.sid.secservice.sec.entities;

import java.io.Serializable;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ProvisoirContent implements Serializable {
    private Float moyenneUE;
    private String code;
    private String code1;
    private Integer credit;
    private String intitules;
    private String intitule;
    private String ueValide;
    private Float coefficient;

    private Float moyenne;
    private Float moyenneRatt;
    private Float totalCreditValide;
    private Float moyenneDefinitif;
    private String moyenneDefinitifUE;
    private String moyenneDefinitifUEGestion;

    public String getMoyenneDefinitifUEGestion() {
        return moyenneDefinitifUEGestion;
    }

    public void setMoyenneDefinitifUEGestion(String moyenneDefinitifUEGestion) {
        this.moyenneDefinitifUEGestion = moyenneDefinitifUEGestion;
    }

    public String getMoyenneDefinitifUE() {
        return moyenneDefinitifUE;
    }

    public void setMoyenneDefinitifUE(String moyenneDefinitifUE) {
        this.moyenneDefinitifUE = moyenneDefinitifUE;
    }

    private String ueValide1;
    private Integer nbAbence = 0;
    private Integer nbAbences = 0;
    private String max;
    private String min;
    private String moyenneClass;
    private String moyenneClasse;
    private String session;
    private String annee;

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

    private ArrayList<ProvisoirExport> provisoirs = new ArrayList<ProvisoirExport>();
    private ArrayList<ProvisoirExport> provisoirentete = new ArrayList<ProvisoirExport>();
    private ArrayList<ProvisoirExport> provisoirsIntitules = new ArrayList<ProvisoirExport>();

    
    public ArrayList<ProvisoirExport> getProvisoirsIntitules() {
        return provisoirsIntitules;
    }

    public void setProvisoirsIntitules(ArrayList<ProvisoirExport> provisoirsIntitules) {
        this.provisoirsIntitules = provisoirsIntitules;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public String getIntitules() {
        return intitules;
    }

    public void setIntitules(String intitules) {
        this.intitules = intitules;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public String getUeValide() {
        return ueValide;
    }

    public void setUeValide(String ueValide) {
        this.ueValide = ueValide;
    }

    public Float getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
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

    public Float getMoyenneDefinitif() {
        return moyenneDefinitif;
    }

    public void setMoyenneDefinitif(Float moyenneDefinitif) {
        this.moyenneDefinitif = moyenneDefinitif;
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

    public ArrayList<ProvisoirExport> getProvisoirs() {
        return provisoirs;
    }

    public void setProvisoirs(ArrayList<ProvisoirExport> provisoirs) {
        this.provisoirs = provisoirs;
    }

    public ArrayList<ProvisoirExport> getProvisoirentete() {
        return provisoirentete;
    }

    public void setProvisoirentete(ArrayList<ProvisoirExport> provisoirentete) {
        this.provisoirentete = provisoirentete;
    }

    /**
     * @return String return the code1
     */
    public String getCode1() {
        return code1;
    }

    /**
     * @param code1 the code1 to set
     */
    public void setCode1(String code1) {
        this.code1 = code1;
    }

    /**
     * @return String return the moyenneClasse
     */
    public String getMoyenneClasse() {
        return moyenneClasse;
    }

    /**
     * @param moyenneClasse the moyenneClasse to set
     */
    public void setMoyenneClasse(String moyenneClasse) {
        this.moyenneClasse = moyenneClasse;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

}