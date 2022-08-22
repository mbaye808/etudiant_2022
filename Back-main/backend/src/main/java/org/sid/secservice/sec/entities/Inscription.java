package org.sid.secservice.sec.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import org.sid.secservice.sec.entities.enumeration.EnumEtat;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


/**
 * A Inscription.
 */
@Entity
@Table(name = "inscription")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
//@Document(indexName = "inscription")
public class Inscription implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "etat", nullable = false)
    private EnumEtat etat;

    public EnumEtat getEtat() {
        return etat;
    }

    public void setEtat(EnumEtat etat) {
        this.etat = etat;
    }

    @NotNull
    @Column(name = "certificat", nullable = false)
    private Boolean certificat;

    @Column(name = "date_inscription")
    private LocalDate dateInscription;



    @ManyToOne
    private AnneeAccademique anneeAccademique;

    @ManyToOne
    private Groupe groupe;

    @ManyToOne
    private Seance seance;


    @ManyToOne
    @NotNull
    private Etudiant etudiant;

    @ManyToOne
    private Niveau niveau;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public Boolean isCertificat() {
        return certificat;
    }

    public Inscription certificat(Boolean certificat) {
        this.certificat = certificat;
        return this;
    }

    public void setCertificat(Boolean certificat) {
        this.certificat = certificat;
    }

    public LocalDate getDateInscription() {
        return dateInscription;
    }

    public Inscription dateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
        return this;
    }

    public void setDateInscription(LocalDate dateInscription) {
        this.dateInscription = dateInscription;
    }



    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public Inscription anneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
        return this;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public Inscription groupe(Groupe groupe) {
        this.groupe = groupe;
        return this;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    



    public Seance getSeance() {
        return seance;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public Inscription etudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
        return this;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public Inscription niveau(Niveau niveau) {
        this.niveau = niveau;
        return this;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Inscription inscription = (Inscription) o;
        if (inscription.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), inscription.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Inscription [anneeAccademique=" + anneeAccademique + ", etudiant=" + etudiant + ", certificat="
                + certificat + ", dateInscription=" + dateInscription + ", etat=" + etat + ", groupe=" + groupe
                + ", id=" + id + ", niveau=" + niveau + "]";
    }
    
}

