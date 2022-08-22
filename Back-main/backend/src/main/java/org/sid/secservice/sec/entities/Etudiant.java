package org.sid.secservice.sec.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.time.LocalDate;


/**
 * A Etudiant.
 */
@Entity
@Table(name = "etudiant")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Etudiant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateSequence")
    @SequenceGenerator(name = "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "ine", nullable = false)
    private String ine;

    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotNull
    @Column(name = "prenom", nullable = false)
    private String prenom;


    @NotNull
    @Column(name = "date_naissance", nullable = false)
    private LocalDate dateNaissance;

    @NotNull
    @Column(name = "lieu_naissance", nullable = false)
    private String lieuNaissance;

    @Column(name = "adresse")
    private String adresse;

   
    @Column(name = "telephone")
    private String telephone;

    @Column(name = "prise_en_charge")
    private Boolean priseEnCharge;

    @Column(name = "inscription")
    private Boolean inscription;

    @Column(name = "cin")
    private String cin;

    @Lob
    @Column(name = "photo")
    private byte[] photo;

    @Column(name = "photo_content_type")
    private String photoContentType;


    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIne() {
        return ine;
    }

    public Etudiant ine(String ine) {
        this.ine = ine;
        return this;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public String getNom() {
        return nom;
    }

    public Etudiant nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Etudiant prenom(String prenom) {
        this.prenom = prenom;
        return this;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

  
    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public Etudiant dateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
        return this;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public Etudiant lieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
        return this;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getAdresse() {
        return adresse;
    }

    public Etudiant adresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public Etudiant telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Boolean isPriseEnCharge() {
        return priseEnCharge;
    }

    public Etudiant priseEnCharge(Boolean priseEnCharge) {
        this.priseEnCharge = priseEnCharge;
        return this;
    }

    public void setPriseEnCharge(Boolean priseEnCharge) {
        this.priseEnCharge = priseEnCharge;
    }
    
    public Boolean isInscription() {
        return inscription;
    }

    public Etudiant inscription(Boolean inscription) {
        this.inscription = inscription;
        return this;
    }

    public void setInscription(Boolean inscription) {
        this.inscription = inscription;
    }

    public String getCin() {
        return cin;
    }

    public Etudiant cin(String cin) {
        this.cin = cin;
        return this;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public Etudiant photo(byte[] photo) {
        this.photo = photo;
        return this;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public Etudiant photoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
        return this;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

        // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Etudiant)) {
            return false;
        }
        return id != null && id.equals(((Etudiant) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Etudiant{" +
            "id=" + getId() +
            ", ine='" + getIne() + "'" +
            ", nom='" + getNom() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", dateNaissance='" + getDateNaissance() + "'" +
            ", lieuNaissance='" + getLieuNaissance() + "'" +
            ", adresse='" + getAdresse() + "'" +
            ", telephone='" + getTelephone() + "'" +
            ", priseEnCharge='" + isPriseEnCharge() + "'" +
            ", cin='" + getCin() + "'" +
            ", photo='" + getPhoto() + "'" +
            ", photoContentType='" + getPhotoContentType() + "'" +
            "}";
    }
}
