package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Groupe.
 */
@Entity
@Table(name = "groupe")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Groupe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "libelle", nullable = false)
    private String libelle;

    @Column(name = "specialite")
    private String specialite;

    @ManyToOne

    @JsonIgnoreProperties(value = "groupes", allowSetters = true)
    private Niveau niveau;


    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public Groupe code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public Groupe libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getSpecialite() {
        return specialite;
    }

    public Groupe specialite(String specialite) {
        this.specialite = specialite;
        return this;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public Groupe niveau(Niveau niveau) {
        this.niveau = niveau;
        return this;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }




    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Groupe)) {
            return false;
        }
        return id != null && id.equals(((Groupe) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Groupe{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", specialite='" + getSpecialite() + "'" +
            "}";
    }
}

