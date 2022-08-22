package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

//import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A UniteEnseignement.
 */
@Entity
@Table(name = "unite_enseignement")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
//@Document(indexName = "uniteenseignement")
public class UniteEnseignement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "credit", nullable = false)
    private Float credit;

    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "intitules", nullable = false)
    private String intitules;

    @Column(name = "soutenance")
    private Boolean soutenance;

    @Column(name = "is_executed")
    private Boolean isExecuted;

    @Column(name = "is_validate")
    private Boolean isValidate;

    @Column(name = "coef_ue")
    private Float coefUE;

    @OneToMany(mappedBy = "uniteEnseignement")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<ElementConstitutif> elementConstitutifs = new HashSet<>();

    @ManyToOne
    private Semestre semestre;

    @ManyToOne
    private Niveau niveau;

    @ManyToOne
    private AnneeAccademique anneeAccademique;

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

    public UniteEnseignement code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Float getCredit() {
        return credit;
    }

    public UniteEnseignement credit(Float credit) {
        this.credit = credit;
        return this;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public String getDescription() {
        return description;
    }

    public UniteEnseignement description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String getIntitules() {
        return intitules;
    }

    public UniteEnseignement intitules(String intitules) {
        this.intitules = intitules;
        return this;
    }

    public void setIntitules(String intitules) {
        this.intitules = intitules;
    }

    public Boolean isSoutenance() {
        return soutenance;
    }

    public UniteEnseignement soutenance(Boolean soutenance) {
        this.soutenance = soutenance;
        return this;
    }

    public void setSoutenance(Boolean soutenance) {
        this.soutenance = soutenance;
    }

    public Boolean isIsExecuted() {
        return isExecuted;
    }

    public UniteEnseignement isExecuted(Boolean isExecuted) {
        this.isExecuted = isExecuted;
        return this;
    }

    public void setIsExecuted(Boolean isExecuted) {
        this.isExecuted = isExecuted;
    }

    public Boolean isIsValidate() {
        return isValidate;
    }

    public UniteEnseignement isValidate(Boolean isValidate) {
        this.isValidate = isValidate;
        return this;
    }

    public void setIsValidate(Boolean isValidate) {
        this.isValidate = isValidate;
    }

    public Float getCoefUE() {
        return coefUE;
    }

    public UniteEnseignement coefUE(Float coefUE) {
        this.coefUE = coefUE;
        return this;
    }

    public void setCoefUE(Float coefUE) {
        this.coefUE = coefUE;
    }

    public Set<ElementConstitutif> getElementConstitutifs() {
        return elementConstitutifs;
    }

    public UniteEnseignement elementConstitutifs(Set<ElementConstitutif> elementConstitutifs) {
        this.elementConstitutifs = elementConstitutifs;
        return this;
    }


    public void setElementConstitutifs(Set<ElementConstitutif> elementConstitutifs) {
        this.elementConstitutifs = elementConstitutifs;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public UniteEnseignement semestre(Semestre semestre) {
        this.semestre = semestre;
        return this;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public UniteEnseignement niveau(Niveau niveau) {
        this.niveau = niveau;
        return this;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public UniteEnseignement anneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
        return this;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
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
        UniteEnseignement uniteEnseignement = (UniteEnseignement) o;
        if (uniteEnseignement.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), uniteEnseignement.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "UniteEnseignement{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", credit=" + getCredit() +
            ", description='" + getDescription() + "'" +
            ", intitules='" + getIntitules() + "'" +
            ", soutenance='" + isSoutenance() + "'" +
            ", isExecuted='" + isIsExecuted() + "'" +
            ", isValidate='" + isIsValidate() + "'" +
            ", coefUE=" + getCoefUE() +
            "}";
    }
}
