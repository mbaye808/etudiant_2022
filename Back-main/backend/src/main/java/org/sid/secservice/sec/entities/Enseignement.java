package org.sid.secservice.sec.entities;


import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

///import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Enseignement.
 */
@Entity
@Table(name = "enseignement")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
//@Document(indexName = "enseignement")
public class Enseignement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "intitule", nullable = false)
    private String intitule;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type", nullable = false)
    private TypeEnseignement type;

    @NotNull
    @Column(name = "volume_horaire", nullable = false)
    private Integer volumeHoraire;

    @Column(name = "code")
    private String code;

    @Column(name = "num")
    private String num;

    @ManyToOne
    private ElementConstitutif elementConstitutif;


    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public Enseignement intitule(String intitule) {
        this.intitule = intitule;
        return this;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public TypeEnseignement getType() {
        return type;
    }

    public Enseignement type(TypeEnseignement type) {
        this.type = type;
        return this;
    }

    public void setType(TypeEnseignement type) {
        this.type = type;
    }

    public Integer getVolumeHoraire() {
        return volumeHoraire;
    }

    public Enseignement volumeHoraire(Integer volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
        return this;
    }

    public void setVolumeHoraire(Integer volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }

    public String getCode() {
        return code;
    }

    public Enseignement code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getNum() {
        return num;
    }

    public Enseignement num(String num) {
        this.num = num;
        return this;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public ElementConstitutif getElementConstitutif() {
        return elementConstitutif;
    }

    public Enseignement elementConstitutif(ElementConstitutif elementConstitutif) {
        this.elementConstitutif = elementConstitutif;
        return this;
    }

    public void setElementConstitutif(ElementConstitutif elementConstitutif) {
        this.elementConstitutif = elementConstitutif;
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
        Enseignement enseignement = (Enseignement) o;
        if (enseignement.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), enseignement.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Enseignement{" +
            "id=" + getId() +
            ", intitule='" + getIntitule() + "'" +
            ", type='" + getType() + "'" +
            ", volumeHoraire=" + getVolumeHoraire() +
            ", code='" + getCode() + "'" +
            ", num=" + getNum() +
            "}";
    }
}
