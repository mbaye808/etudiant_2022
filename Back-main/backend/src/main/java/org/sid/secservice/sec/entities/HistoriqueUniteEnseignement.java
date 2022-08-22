package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.sid.secservice.sec.entities.enumeration.TypeUniteEnseignement;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;



/**
 * A HistoriqueUniteEnseignement.
 */
@Entity
@Table(name = "historique_unite_enseignement")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class HistoriqueUniteEnseignement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @Column(name = "new_code")
    private String newCode;

    @NotNull
    @Column(name = "intitules", nullable = false)
    private String intitules;

    @Column(name = "is_execute")
    private Boolean isExecute;

    @Column(name = "credit")
    private Float credit;

    @Column(name = "is_validate")
    private Boolean isValidate;

    @Column(name = "coef_ue")
    private Float coefUE;

    @Column(name = "soutenance")
    private Boolean soutenance;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_unite_enseignement")
    private TypeUniteEnseignement typeUniteEnseignement;



    public TypeUniteEnseignement getTypeUniteEnseignement() {
        return typeUniteEnseignement;
    }

    public void setTypeUniteEnseignement(TypeUniteEnseignement typeUniteEnseignement) {
        this.typeUniteEnseignement = typeUniteEnseignement;
    }

    @ManyToOne
    @JsonIgnoreProperties(value = "historiqueUniteEnseignements", allowSetters = true)
    private AnneeAccademique anneeAccademique;

    @ManyToOne
    @JsonIgnoreProperties(value = "historiqueUniteEnseignements", allowSetters = true)
    private UniteEnseignement uniteEnseignement;

    public UniteEnseignement getUniteEnseignement() {
        return uniteEnseignement;
    }

    public void setUniteEnseignement(UniteEnseignement uniteEnseignement) {
        this.uniteEnseignement = uniteEnseignement;
    }

    
    public HistoriqueUniteEnseignement uniteEnseignement(UniteEnseignement uniteEnseignement) {
        this.uniteEnseignement = uniteEnseignement;
        return this;
    }

    public HistoriqueUniteEnseignement typeUniteEnseignement(TypeUniteEnseignement typeUniteEnseignement) {
        this.typeUniteEnseignement = typeUniteEnseignement;
        return this;
    }


    @ManyToOne
    @JsonIgnoreProperties(value = "historiqueUniteEnseignements", allowSetters = true)
    private Semestre semestre;



    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewCode() {
        return newCode;
    }

    public HistoriqueUniteEnseignement newCode(String newCode) {
        this.newCode = newCode;
        return this;
    }

    public void setNewCode(String newCode) {
        this.newCode = newCode;
    }

    public String getIntitules() {
        return intitules;
    }

    public HistoriqueUniteEnseignement intitules(String intitules) {
        this.intitules = intitules;
        return this;
    }

    public void setIntitules(String intitules) {
        this.intitules = intitules;
    }

    public Boolean isIsExecute() {
        return isExecute;
    }

    public HistoriqueUniteEnseignement isExecute(Boolean isExecute) {
        this.isExecute = isExecute;
        return this;
    }

    public void setIsExecute(Boolean isExecute) {
        this.isExecute = isExecute;
    }

    public Float getCredit() {
        return credit;
    }

    public HistoriqueUniteEnseignement credit(Float credit) {
        this.credit = credit;
        return this;
    }

    public void setCredit(Float credit) {
        this.credit = credit;
    }

    public Boolean isIsValidate() {
        return isValidate;
    }

    public HistoriqueUniteEnseignement isValidate(Boolean isValidate) {
        this.isValidate = isValidate;
        return this;
    }

    public void setIsValidate(Boolean isValidate) {
        this.isValidate = isValidate;
    }

    public Float getCoefUE() {
        return coefUE;
    }

    public HistoriqueUniteEnseignement coefUE(Float coefUE) {
        this.coefUE = coefUE;
        return this;
    }

    public void setCoefUE(Float coefUE) {
        this.coefUE = coefUE;
    }

    public Boolean isSoutenance() {
        return soutenance;
    }

    public HistoriqueUniteEnseignement soutenance(Boolean soutenance) {
        this.soutenance = soutenance;
        return this;
    }

    public void setSoutenance(Boolean soutenance) {
        this.soutenance = soutenance;
    }

    public String getDescription() {
        return description;
    }

    public HistoriqueUniteEnseignement description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public HistoriqueUniteEnseignement anneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
        return this;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
    }


    public Semestre getSemestre() {
        return semestre;
    }

    public HistoriqueUniteEnseignement semestre(Semestre semestre) {
        this.semestre = semestre;
        return this;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }


    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HistoriqueUniteEnseignement)) {
            return false;
        }
        return id != null && id.equals(((HistoriqueUniteEnseignement) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "HistoriqueUniteEnseignement{" +
            "id=" + getId() +
            ", newCode='" + getNewCode() + "'" +
            ", intitules='" + getIntitules() + "'" +
            ", isExecute='" + isIsExecute() + "'" +
            ", credit=" + getCredit() +
            ", isValidate='" + isIsValidate() + "'" +
            ", coefUE=" + getCoefUE() +
            ", soutenance='" + isSoutenance() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
}
