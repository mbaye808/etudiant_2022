package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.sid.secservice.sec.entities.enumeration.EnumFormationType;

import javax.persistence.*;
import javax.validation.constraints.*;

//import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;



/**
 * A Formation.
 */
@Entity
@Table(name = "formation")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
//@Document(indexName = "formation")
public class Formation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "code_formation", nullable = false)
    private String codeFormation;

    @NotNull
    @Column(name = "nom_formation", nullable = false)
    private String nomFormation;

    @Column(name = "jour")
    private Boolean jour;

    @Column(name = "description")
    private String description;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type", nullable = false)
    private EnumFormationType type;

    @Column(name = "decision_jury_soutenance")
    private String decisionJurySoutenance;

    @Column(name = "id_disi")
    private String id_disi;

    @OneToMany(mappedBy = "formation")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Niveau> niveaus = new HashSet<>();

    @ManyToOne(optional = false)
    @NotNull
    private TypeFormation typeFormation;

    @ManyToOne(optional = false)
    @NotNull
    private TypeEvaluation typeEvaluatiion;

  

    @ManyToOne(optional = false)
    @NotNull
    private Structure departement;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeFormation() {
        return codeFormation;
    }

    public Formation codeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
        return this;
    }

    public void setCodeFormation(String codeFormation) {
        this.codeFormation = codeFormation;
    }

    public String getNomFormation() {
        return nomFormation;
    }

    public Formation nomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
        return this;
    }

    public void setNomFormation(String nomFormation) {
        this.nomFormation = nomFormation;
    }

    public Boolean isJour() {
        return jour;
    }

    public Formation jour(Boolean jour) {
        this.jour = jour;
        return this;
    }

    public void setJour(Boolean jour) {
        this.jour = jour;
    }

    public String getDescription() {
        return description;
    }

    public Formation description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EnumFormationType getType() {
        return type;
    }

    public Formation type(EnumFormationType type) {
        this.type = type;
        return this;
    }

    public void setType(EnumFormationType type) {
        this.type = type;
    }

    public String getDecisionJurySoutenance() {
        return decisionJurySoutenance;
    }

    public Formation decisionJurySoutenance(String decisionJurySoutenance) {
        this.decisionJurySoutenance = decisionJurySoutenance;
        return this;
    }

    public void setDecisionJurySoutenance(String decisionJurySoutenance) {
        this.decisionJurySoutenance = decisionJurySoutenance;
    }

    public String getId_disi() {
        return id_disi;
    }

    public Formation id_disi(String id_disi) {
        this.id_disi = id_disi;
        return this;
    }

    public void setId_disi(String id_disi) {
        this.id_disi = id_disi;
    }

    public Set<Niveau> getNiveaus() {
        return niveaus;
    }

    public Formation niveaus(Set<Niveau> niveaus) {
        this.niveaus = niveaus;
        return this;
    }

    public Formation addNiveau(Niveau niveau) {
        this.niveaus.add(niveau);
        //niveau.setFormation(this);
        return this;
    }

    public Formation removeNiveau(Niveau niveau) {
        this.niveaus.remove(niveau);
        //niveau.setFormation(null);
        return this;
    }

    public void setNiveaus(Set<Niveau> niveaus) {
        this.niveaus = niveaus;
    }

    public TypeFormation getTypeFormation() {
        return typeFormation;
    }

    public Formation typeFormation(TypeFormation typeFormation) {
        this.typeFormation = typeFormation;
        return this;
    }

    public void setTypeFormation(TypeFormation typeFormation) {
        this.typeFormation = typeFormation;
    }

    public TypeEvaluation getTypeEvaluatiion() {
        return typeEvaluatiion;
    }

    public Formation typeEvaluatiion(TypeEvaluation typeEvaluation) {
        this.typeEvaluatiion = typeEvaluation;
        return this;
    }

    public void setTypeEvaluatiion(TypeEvaluation typeEvaluation) {
        this.typeEvaluatiion = typeEvaluation;
    }



    public Structure getDepartement() {
        return departement;
    }

    public Formation departement(Structure structure) {
        this.departement = structure;
        return this;
    }

    public void setDepartement(Structure structure) {
        this.departement = structure;
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
        Formation formation = (Formation) o;
        if (formation.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), formation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Formation{" +
            "id=" + getId() +
            ", codeFormation='" + getCodeFormation() + "'" +
            ", nomFormation='" + getNomFormation() + "'" +
            ", jour='" + isJour() + "'" +
            ", description='" + getDescription() + "'" +
            ", type='" + getType() + "'" +
            ", decisionJurySoutenance='" + getDecisionJurySoutenance() + "'" +
            ", id_disi='" + getId_disi() + "'" +
            "}";
    }
}
