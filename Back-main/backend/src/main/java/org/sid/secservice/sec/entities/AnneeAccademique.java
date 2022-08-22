package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

//import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;

/**
 * A AnneeAccademique.
 */
@Entity
@Table(name = "annee_accademique")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
//@Document(indexName = "anneeaccademique")
public class AnneeAccademique implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "nom_annee_accademique", nullable = false)
    private String nomAnneeAccademique;

    @Column(name = "actif")
    private Boolean actif;

    @OneToMany(mappedBy = "anneeAccademique")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Inscription> inscriptions = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomAnneeAccademique() {
        return nomAnneeAccademique;
    }

    public AnneeAccademique nomAnneeAccademique(String nomAnneeAccademique) {
        this.nomAnneeAccademique = nomAnneeAccademique;
        return this;
    }

    public void setNomAnneeAccademique(String nomAnneeAccademique) {
        this.nomAnneeAccademique = nomAnneeAccademique;
    }

    public Boolean isActif() {
        return actif;
    }

    public AnneeAccademique actif(Boolean actif) {
        this.actif = actif;
        return this;
    }

    public void setActif(Boolean actif) {
        this.actif = actif;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public AnneeAccademique inscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
        return this;
    }

    public AnneeAccademique addInscription(Inscription inscription) {
        this.inscriptions.add(inscription);
        inscription.setAnneeAccademique(this);
        return this;
    }

    public AnneeAccademique removeInscription(Inscription inscription) {
        this.inscriptions.remove(inscription);
        inscription.setAnneeAccademique(null);
        return this;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
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
        AnneeAccademique anneeAccademique = (AnneeAccademique) o;
        if (anneeAccademique.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), anneeAccademique.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "AnneeAccademique{" +
            "id=" + getId() +
            ", nomAnneeAccademique='" + getNomAnneeAccademique() + "'" +
            ", actif='" + isActif() + "'" +
            "}";
    }
}
