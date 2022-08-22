package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.sid.secservice.sec.entities.enumeration.EnumTypeEvaluation;

import javax.persistence.*;
import javax.validation.constraints.*;

//import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;




/**
 * A TypeEvaluation.
 */
@Entity
@Table(name = "type_evaluation")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
//@Document(indexName = "typeevaluation")
public class TypeEvaluation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type_eval", nullable = false, unique=true)
    private EnumTypeEvaluation typeEval;

    @OneToMany(mappedBy = "typeEvaluatiion")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Formation> formations = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumTypeEvaluation getTypeEval() {
        return typeEval;
    }

    public TypeEvaluation typeEval(EnumTypeEvaluation typeEval) {
        this.typeEval = typeEval;
        return this;
    }

    public void setTypeEval(EnumTypeEvaluation typeEval) {
        this.typeEval = typeEval;
    }

    public Set<Formation> getFormations() {
        return formations;
    }

    public TypeEvaluation formations(Set<Formation> formations) {
        this.formations = formations;
        return this;
    }

    public TypeEvaluation addFormation(Formation formation) {
        this.formations.add(formation);
        formation.setTypeEvaluatiion(this);
        return this;
    }

    public TypeEvaluation removeFormation(Formation formation) {
        this.formations.remove(formation);
        formation.setTypeEvaluatiion(null);
        return this;
    }

    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
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
        TypeEvaluation typeEvaluation = (TypeEvaluation) o;
        if (typeEvaluation.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), typeEvaluation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TypeEvaluation{" +
            "id=" + getId() +
            ", typeEval='" + getTypeEval() + "'" +
            "}";
    }
}
