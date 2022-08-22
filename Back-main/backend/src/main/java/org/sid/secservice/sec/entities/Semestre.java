package org.sid.secservice.sec.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

///mport org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;

import java.util.Objects;

/**
 * A Semestre.
 */
@Entity
@Table(name = "semestre")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
//@Document(indexName = "semestre")
public class Semestre implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "nom_semestre", nullable = false)
    private String nomSemestre;

    @Column(name = "terminal")
    private Boolean terminal;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public Semestre code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNomSemestre() {
        return nomSemestre;
    }

    public Semestre nomSemestre(String nomSemestre) {
        this.nomSemestre = nomSemestre;
        return this;
    }

    public void setNomSemestre(String nomSemestre) {
        this.nomSemestre = nomSemestre;
    }

    public Boolean isTerminal() {
        return terminal;
    }

    public Semestre terminal(Boolean terminal) {
        this.terminal = terminal;
        return this;
    }

    public void setTerminal(Boolean terminal) {
        this.terminal = terminal;
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
        Semestre semestre = (Semestre) o;
        if (semestre.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), semestre.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Semestre{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", nomSemestre='" + getNomSemestre() + "'" +
            ", terminal='" + isTerminal() + "'" +
            "}";
    }
}

