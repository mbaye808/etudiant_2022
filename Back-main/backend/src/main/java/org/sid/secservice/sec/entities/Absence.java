package org.sid.secservice.sec.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Objects;

/**
 * A Absence.
 */
@Entity
@Table(name = "absence")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Absence implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "absent", nullable = false)
    private Boolean absent;

    @NotNull
    @Column(name = "justificatif", nullable = false)
    private Boolean justificatif;

    @Column(name = "coefficient")
    private Float coefficient;

    public int getNombreAbsence() {
        return nombreAbsence;
    }

    public void setNombreAbsence(int nombreAbsence) {
        this.nombreAbsence = nombreAbsence;
    }

    @Column(name = "nombreAbsence")
    private int nombreAbsence;

    @Column(name = "idUniteEnseignement")
    private Long idUe;

    @Column(name = "idInscription")
    private Long idInscription;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isAbsent() {
        return absent;
    }

    public Absence absent(Boolean absent) {
        this.absent = absent;
        return this;
    }

    public void setAbsent(Boolean absent) {
        this.absent = absent;
    }

    public Boolean isJustificatif() {
        return justificatif;
    }

    public Absence justificatif(Boolean justificatif) {
        this.justificatif = justificatif;
        return this;
    }

    public Long getIdUe() {
        return idUe;
    }

    public void setIdUe(Long idUe) {
        this.idUe = idUe;
    }

    public Long getIdInscription() {
        return idInscription;
    }

    public void setIdInscription(Long idInscription) {
        this.idInscription = idInscription;
    }

    public void setJustificatif(Boolean justificatif) {
        this.justificatif = justificatif;
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
        Absence absence = (Absence) o;
        if (absence.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), absence.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Absence{" +
            "id=" + getId() +
            ", absent='" + isAbsent() + "'" +
            ", justificatif='" + isJustificatif() + "'" +
            "}";
    }
}
