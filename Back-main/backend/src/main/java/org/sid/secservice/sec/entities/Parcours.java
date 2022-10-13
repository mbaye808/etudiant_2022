package org.sid.secservice.sec.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "parcours_alumni")
public class Parcours implements Serializable{


    @Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "ecole", nullable = false)
    private String ecole;

    @Column(name = "ine", nullable = false)
    private String ine;

    @Column(name = "diplome", nullable = false)
    private String diplome;

    @Column(name = "domaine_etude", nullable = false)
    private String domaineEtude;

   @Column(name = "annee_debut", nullable = false)
    private String anneeDebut;

    @Column(name = "mois_debut", nullable = false)
    private String moisDebut; 

    @Column(name = "annee_fin", nullable = false)
    private String anneeFin;

    @Column(name = "mois_fin", nullable = false)
    private String moisFin;  

    @ManyToOne
    private AnneePromo anneePromo;


    @ManyToOne
    private Etudiant etudiant;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getEcole() {
        return ecole;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

    public String getDomaineEtude() {
        return domaineEtude;
    }

    public void setDomaineEtude(String domaineEtude) {
        this.domaineEtude = domaineEtude;
    }

    public AnneePromo getAnneePromo() {
        return anneePromo;
    }

    public void setAnneePromo(AnneePromo anneePromo) {
        this.anneePromo = anneePromo;
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

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    @Override
    public String toString() {
        return "Parcours [anneeDebut=" + anneeDebut + ", anneeFin=" + anneeFin + ", diplome=" + diplome
                + ", domaineEtude=" + domaineEtude + ", ecole=" + ecole + ", moisDebut=" + moisDebut
                + ", moisFin=" + moisFin + "]";
    }
    

}
