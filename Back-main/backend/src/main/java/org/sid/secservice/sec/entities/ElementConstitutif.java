package org.sid.secservice.sec.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.sid.secservice.sec.entities.enumeration.EnumTypeElementConstitutif;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;


/**
 * A ElementConstitutif.
 */
@Entity
@Table(name = "element_constitutif")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
//@Document(indexName = "elementconstitutif")
public class ElementConstitutif implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    public EnumTypeElementConstitutif getType() {
        return type;
    }

    public void setType(EnumTypeElementConstitutif type) {
        this.type = type;
    }

    @NotNull
    @Column(name = "intitule", nullable = false)
    private String intitule;

    @NotNull
    @Column(name = "t_pe", nullable = false)
    private Integer tPE;

    @Column(name = "code")
    private String code;

    @Column(name = "coefficient")
    private Float coefficient;

    @Column(name = "num")
    private String num;

    @Column(name = "is_executed")
    private Boolean isExecuted;

    @Column(name = "coef_tp")
    private Float coefTP;

    @Column(name = "specialite")
    private Boolean specialite;

    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_type")
    private EnumTypeElementConstitutif type;

    @ManyToOne
    private UniteEnseignement uniteEnseignement;
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

    public ElementConstitutif intitule(String intitule) {
        this.intitule = intitule;
        return this;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Integer gettPE() {
        return tPE;
    }

    public ElementConstitutif tPE(Integer tPE) {
        this.tPE = tPE;
        return this;
    }

    public void settPE(Integer tPE) {
        this.tPE = tPE;
    }

    public String getCode() {
        return code;
    }

    public ElementConstitutif code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getCoefficient() {
        return coefficient;
    }

    public ElementConstitutif coefficient(Float coefficient) {
        this.coefficient = coefficient;
        return this;
    }

    public void setCoefficient(Float coefficient) {
        this.coefficient = coefficient;
    }

    public String getNum() {
        return num;
    }

    public ElementConstitutif num(String num) {
        this.num = num;
        return this;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Boolean isIsExecuted() {
        return isExecuted;
    }

    public ElementConstitutif isExecuted(Boolean isExecuted) {
        this.isExecuted = isExecuted;
        return this;
    }

    public void setIsExecuted(Boolean isExecuted) {
        this.isExecuted = isExecuted;
    }

    public Float getCoefTP() {
        return coefTP;
    }

    public ElementConstitutif coefTP(Float coefTP) {
        this.coefTP = coefTP;
        return this;
    }

    public void setCoefTP(Float coefTP) {
        this.coefTP = coefTP;
    }

    public Boolean isSpecialite() {
        return specialite;
    }

    public ElementConstitutif specialite(Boolean specialite) {
        this.specialite = specialite;
        return this;
    }

    public void setSpecialite(Boolean specialite) {
        this.specialite = specialite;
    }

    
    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    public UniteEnseignement getUniteEnseignement() {
        return uniteEnseignement;
    }

    public void setUniteEnseignement(UniteEnseignement uniteEnseignement) {
        this.uniteEnseignement = uniteEnseignement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ElementConstitutif elementConstitutif = (ElementConstitutif) o;
        if (elementConstitutif.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), elementConstitutif.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "ElementConstitutif{" +
            "id=" + getId() +
            ", intitule='" + getIntitule() + "'" +
            ", tPE=" + gettPE() +
            ", code='" + getCode() + "'" +
            ", coefficient=" + getCoefficient() +
            ", num='" + getNum() + "'" +
            ", isExecuted='" + isIsExecuted() + "'" +
            ", coefTP=" + getCoefTP() +
            ", specialite='" + isSpecialite() + "'" +
            ", type='" + getType() + "'" +
            "}";
    }
}
