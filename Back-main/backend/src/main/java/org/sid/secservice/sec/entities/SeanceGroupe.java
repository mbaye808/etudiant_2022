package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A SeanceGroupe.
 */
@Entity
@Table(name = "seance_groupe")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SeanceGroupe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateSequence")
    @SequenceGenerator(name = "hibernateSequence")
    private Long id;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "seanceGroupes", allowSetters = true)
    private Seance seance;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "seanceGroupes", allowSetters = true)
    private Groupe groupe;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Seance getSeance() {
        return seance;
    }

    public SeanceGroupe seance(Seance seance) {
        this.seance = seance;
        return this;
    }

    public void setSeance(Seance seance) {
        this.seance = seance;
    }

    public Groupe getGroupe() {
        return groupe;
    }

    public SeanceGroupe groupe(Groupe groupe) {
        this.groupe = groupe;
        return this;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SeanceGroupe)) {
            return false;
        }
        return id != null && id.equals(((SeanceGroupe) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SeanceGroupe{" +
            "id=" + getId() +
            "seance" + getSeance()+
            "}";
    }
}
