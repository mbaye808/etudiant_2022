package org.sid.secservice.sec.entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "parcourAlumni")
public class ParcourAlumni implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @Column(name = "etablissement", nullable = false)
    private String etablissement;

    @Column(name = "formation", nullable = false)
    private String formation;

    @Column(name = "dateDebut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "dateFin", nullable = false)
    private LocalDate dateFin;

    @ManyToOne
    @JsonIgnoreProperties(value = "parcourAlumni", allowSetters = true)
    private AppUser appUser;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public String getFormation() {
        return formation;
    }

    public void setFormation(String formation) {
        this.formation = formation;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return "ParcourAlumni [dateDebut=" + dateDebut + ", dateFin=" + dateFin
                + ", etablissement=" + etablissement + ", formation=" + formation + ", id=" + id + "]";
    }

}
