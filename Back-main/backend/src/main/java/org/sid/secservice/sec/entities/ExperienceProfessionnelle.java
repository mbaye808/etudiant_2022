package org.sid.secservice.sec.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "experience")
public class ExperienceProfessionnelle implements Serializable{

    @Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "intitule_poste", nullable = false)
    private String intitulePoste;

    @Column(name = "ine", nullable = false)
    private String ine;

    @Column(name = "type_emploi", nullable = false)
    private String typeEmploi;

    @Column(name = "nom_entreprise", nullable = false)
    private String nomEnttreprise;

    @Column(name = "lieu", nullable = false)
    private String lieu;

    @Column(name = "annee_debut", nullable = false)
    private String anneeDebut;

    @Column(name = "mois_debut", nullable = false)
    private String moisDebut; 

    @Column(name = "annee_fin", nullable = false)
    private String anneeFin;

    @Column(name = "mois_fin", nullable = false)
    private String moisFin; 

    @Column(name = "secteur", nullable = false)
    private String secteur;

    @Column(name = "titre_profil", nullable = false)
    private String titreProfil;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitulePoste() {
        return intitulePoste;
    }

    public void setIntitulePoste(String intitulePoste) {
        this.intitulePoste = intitulePoste;
    }

    public String getTypeEmploi() {
        return typeEmploi;
    }

    public void setTypeEmploi(String typeEmploi) {
        this.typeEmploi = typeEmploi;
    }

    public String getNomEnttreprise() {
        return nomEnttreprise;
    }

    public void setNomEnttreprise(String nomEnttreprise) {
        this.nomEnttreprise = nomEnttreprise;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }
    
    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getAnneeDebut() {
        return anneeDebut;
    }

    public void setAnneeDebut(String anneeDebut) {
        this.anneeDebut = anneeDebut;
    }

    public String getMoisDebut() {
        return moisDebut;
    }

    public void setMoisDebut(String moisDebut) {
        this.moisDebut = moisDebut;
    }

    public String getAnneeFin() {
        return anneeFin;
    }

    public void setAnneeFin(String anneeFin) {
        this.anneeFin = anneeFin;
    }

    public String getMoisFin() {
        return moisFin;
    }

    public void setMoisFin(String moisFin) {
        this.moisFin = moisFin;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
    }

    public String getTitreProfil() {
        return titreProfil;
    }

    public void setTitreProfil(String titreProfil) {
        this.titreProfil = titreProfil;
    }

    @Override
    public String toString() {
        return "ExperienceProfessionnelle [anneeDebut=" + anneeDebut + ", anneeFin=" + anneeFin + ", intitulePoste="
                + intitulePoste + ", lieu=" + lieu + ", moisDebut=" + moisDebut + ", moisFin=" + moisFin
                + ", nomEnttreprise=" + nomEnttreprise + ", secteur=" + secteur + ", titreProfil=" + titreProfil
                + ", typeEmploi=" + typeEmploi + "]";
    }

   
     
}
