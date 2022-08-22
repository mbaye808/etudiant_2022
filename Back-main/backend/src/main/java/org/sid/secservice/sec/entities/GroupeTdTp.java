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
 * A GroupeTdTp.
 */
@Entity
@Table(name = "groupe_td_tp")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class GroupeTdTp implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateSequence")
    @SequenceGenerator(name = "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "libelle", nullable = false)
    private String libelle;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "groupeTdTps", allowSetters = true)
    private Groupe groupe;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @NotNull
    @JoinTable(name = "groupe_td_tp_historique_enseignement",
               joinColumns = @JoinColumn(name = "groupe_td_tp_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "historique_enseignement_id", referencedColumnName = "id"))
    private Set<HistoriqueEnseignement> historiqueEnseignements = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "groupe_td_tp_inscription",
               joinColumns = @JoinColumn(name = "groupe_td_tp_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "inscription_id", referencedColumnName = "id"))
    private Set<Inscription> inscriptions = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "groupeTdTps", allowSetters = true)
    private AnneeAccademique anneeAccademique;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public GroupeTdTp libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public GroupeTdTp groupe(Groupe groupe) {
        this.groupe = groupe;
        return this;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public Set<HistoriqueEnseignement> getHistoriqueEnseignements() {
        return historiqueEnseignements;
    }

    public GroupeTdTp historiqueEnseignements(Set<HistoriqueEnseignement> historiqueEnseignements) {
        this.historiqueEnseignements = historiqueEnseignements;
        return this;
    }

    public GroupeTdTp addHistoriqueEnseignement(HistoriqueEnseignement historiqueEnseignement) {
        this.historiqueEnseignements.add(historiqueEnseignement);
        return this;
    }

    public GroupeTdTp removeHistoriqueEnseignement(HistoriqueEnseignement historiqueEnseignement) {
        this.historiqueEnseignements.remove(historiqueEnseignement);
      
        return this;
    }

    public void setHistoriqueEnseignements(Set<HistoriqueEnseignement> historiqueEnseignements) {
        this.historiqueEnseignements = historiqueEnseignements;
    }

    public Set<Inscription> getInscriptions() {
        return inscriptions;
    }

    public GroupeTdTp inscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
        return this;
    }

    public GroupeTdTp addInscription(Inscription inscription) {
        this.inscriptions.add(inscription);
        return this;
    }

    public GroupeTdTp removeInscription(Inscription inscription) {
        this.inscriptions.remove(inscription);
        return this;
    }

    public void setInscriptions(Set<Inscription> inscriptions) {
        this.inscriptions = inscriptions;
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public GroupeTdTp anneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
        return this;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GroupeTdTp)) {
            return false;
        }
        return id != null && id.equals(((GroupeTdTp) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "GroupeTdTp{" +
            "id=" + getId() +
            ", libelle='" + getLibelle() + "'" +
            "}";
    }
}
