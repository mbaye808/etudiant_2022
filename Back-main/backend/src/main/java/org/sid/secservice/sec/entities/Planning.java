package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

/**
 * A Planning.
 */
@Entity
@Table(name = "planning")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Planning implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateSequence")
    @SequenceGenerator(name = "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @NotNull
    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @Column(name = "etat")
    private Boolean etat;

    @OneToMany(mappedBy = "planning")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Seance> seances = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "plannings", allowSetters = true)
    private Groupe groupe;

    @ManyToOne
    @JsonIgnoreProperties(value = "plannings", allowSetters = true)
    private AnneeAccademique anneeAccademique;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public Planning dateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
        return this;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public Planning dateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
        return this;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Boolean isEtat() {
        return etat;
    }

    public Planning etat(Boolean etat) {
        this.etat = etat;
        return this;
    }

    public void setEtat(Boolean etat) {
        this.etat = etat;
    }

    public Set<Seance> getSeances() {
        return seances;
    }

    public Planning seances(Set<Seance> seances) {
        this.seances = seances;
        return this;
    }

    public Planning addSeance(Seance seance) {
        this.seances.add(seance);
        seance.setPlanning(this);
        return this;
    }

    public Planning removeSeance(Seance seance) {
        this.seances.remove(seance);
        seance.setPlanning(null);
        return this;
    }

    public void setSeances(Set<Seance> seances) {
        this.seances = seances;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public Planning groupe(Groupe groupe) {
        this.groupe = groupe;
        return this;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public Planning anneeAccademique(AnneeAccademique anneeAccademique) {
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
        if (!(o instanceof Planning)) {
            return false;
        }
        return id != null && id.equals(((Planning) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Planning{" +
            "id=" + getId() +
            ", dateDebut='" + getDateDebut() + "'" +
            ", dateFin='" + getDateFin() + "'" +
            ", etat='" + isEtat() + "'" +
            "}";
    }
}
