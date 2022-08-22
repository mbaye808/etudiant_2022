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
 * A Salle.
 */
@Entity
@Table(name = "salle")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Salle implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "nom", nullable = false)
    private String nom;

    @NotNull
    @Column(name = "capacite", nullable = false)
    private Integer capacite;

    @Column(name = "etage")
    private String etage;


    @OneToMany(mappedBy = "salle")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    private Set<Seance> seances = new HashSet<>();


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

    public Salle code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public Salle nom(String nom) {
        this.nom = nom;
        return this;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getCapacite() {
        return capacite;
    }

    public Salle capacite(Integer capacite) {
        this.capacite = capacite;
        return this;
    }

    public void setCapacite(Integer capacite) {
        this.capacite = capacite;
    }

    public String getEtage() {
        return etage;
    }

    public Salle etage(String etage) {
        this.etage = etage;
        return this;
    }

    public void setEtage(String etage) {
        this.etage = etage;
    }

    public Set<Seance> getSeances() {
        return seances;
    }

    public Salle seances(Set<Seance> seances) {
        this.seances = seances;
        return this;
    }

    public Salle addSeance(Seance seance) {
        this.seances.add(seance);
        seance.setSalle(this);
        return this;
    }

    public Salle removeSeance(Seance seance) {
        this.seances.remove(seance);
        seance.setSalle(null);
        return this;
    }

    public void setSeances(Set<Seance> seances) {
        this.seances = seances;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Salle)) {
            return false;
        }
        return id != null && id.equals(((Salle) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Salle{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", nom='" + getNom() + "'" +
            ", capacite=" + getCapacite() +
            ", etage='" + getEtage() + "'" +
            "}";
    }
}
