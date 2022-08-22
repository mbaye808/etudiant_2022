package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;


/**
 * A HistoriqueEnseignement.
 */
@Entity
@Table(name = "historiqueEnseignement")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class HistoriqueEnseignement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateSequence")
    @SequenceGenerator(name = "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "intitule", nullable = false)
    private String intitule;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TypeEnseignement type;

    @NotNull
    @Column(name = "volume_horaire", nullable = false)
    private Integer volumeHoraire;

    @Column(name = "code")
    private String code;

    @Column(name = "num")
    private Integer num;
    
    @NotNull
    @ManyToOne
    @JsonIgnoreProperties(value = "historiqueEnseignements", allowSetters = true)
    private HistoriqueElementContitutif historiqueElementContitutif;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public HistoriqueEnseignement intitule(String intitule) {
        this.intitule = intitule;
        return this;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public TypeEnseignement getType() {
        return type;
    }

    public HistoriqueEnseignement type(TypeEnseignement type) {
        this.type = type;
        return this;
    }

    public void setType(TypeEnseignement type) {
        this.type = type;
    }

    public Integer getVolumeHoraire() {
        return volumeHoraire;
    }

    public HistoriqueEnseignement volumeHoraire(Integer volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
        return this;
    }

    public void setVolumeHoraire(Integer volumeHoraire) {
        this.volumeHoraire = volumeHoraire;
    }

    public String getCode() {
        return code;
    }

    public HistoriqueEnseignement code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getNum() {
        return num;
    }

    public HistoriqueEnseignement num(Integer num) {
        this.num = num;
        return this;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public HistoriqueElementContitutif getHistoriqueElementContitutif() {
        return historiqueElementContitutif;
    }

    public HistoriqueEnseignement historiqueElementContitutif(HistoriqueElementContitutif historiqueElementContitutif) {
        this.historiqueElementContitutif = historiqueElementContitutif;
        return this;
    }

    public void setHistoriqueElementContitutif(HistoriqueElementContitutif historiqueElementContitutif) {
        this.historiqueElementContitutif = historiqueElementContitutif;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HistoriqueEnseignement)) {
            return false;
        }
        return id != null && id.equals(((HistoriqueEnseignement) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "HistoriqueEnseignement{" +
            "id=" + getId() +
            ", intitule='" + getIntitule() + "'" +
            ", type='" + getType() + "'" +
            ", volumeHoraire=" + getVolumeHoraire() +
            ", code='" + getCode() + "'" +
            ", num=" + getNum() +
            "}";
    }
}
