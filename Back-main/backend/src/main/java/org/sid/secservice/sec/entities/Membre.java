package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * A Membre.
 */
@Entity
@Table(name = "membre")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Membre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @Column(name = "telephone")
    private String telephone;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "lieu_naissance")
    private String lieuNaissance;

    @Column(name = "cin")
    private String cin;

    @ManyToOne
    private User user;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "nom")
    private String nom;


    @Column(name = "retraite")
    private Boolean retraite;

    @Column(name = "categorie")
    private String categorie;

    @Column(name = "autre_universite")
    private String autreUniversite;

    @ManyToOne
    @JsonIgnoreProperties(value = "membres", allowSetters = true)
    private Structure structure;


    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public Membre telephone(String telephone) {
        this.telephone = telephone;
        return this;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public Membre dateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
        return this;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public Membre lieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
        return this;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getCin() {
        return cin;
    }

    public Membre cin(String cin) {
        this.cin = cin;
        return this;
    }

    public void setCin(String cin) {
        this.cin = cin;
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

    public Boolean isRetraite() {
        return retraite;
    }

    public Membre retraite(Boolean retraite) {
        this.retraite = retraite;
        return this;
    }

    public void setRetraite(Boolean retraite) {
        this.retraite = retraite;
    }

    public String getCategorie() {
        return categorie;
    }

    public Membre categorie(String categorie) {
        this.categorie = categorie;
        return this;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAutreUniversite() {
        return autreUniversite;
    }

    public Membre autreUniversite(String autreUniversite) {
        this.autreUniversite = autreUniversite;
        return this;
    }

    public void setAutreUniversite(String autreUniversite) {
        this.autreUniversite = autreUniversite;
    }

    public Structure getStructure() {
        return structure;
    }

    public Membre structure(Structure structure) {
        this.structure = structure;
        return this;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Membre)) {
            return false;
        }
        return id != null && id.equals(((Membre) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Membre{" +
            "id=" + getId() +
            ", telephone='" + getTelephone() + "'" +
            ", dateNaissance='" + getDateNaissance() + "'" +
            ", lieuNaissance='" + getLieuNaissance() + "'" +
            ", cin='" + getCin() + "'" +
            ", prenom='" + getPrenom() + "'" +
            ", nom='" + getNom() + "'" +
            ", retraite='" + isRetraite() + "'" +
            ", categorie='" + getCategorie() + "'" +
            ", autreUniversite='" + getAutreUniversite() + "'" +
            "}";
    }
}
