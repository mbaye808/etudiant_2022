package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.sid.secservice.sec.entities.enumeration.EnumTypeElementConstitutif;

import javax.persistence.*;

import java.io.Serializable;


/**
 * A HistoriqueElementContitutif.
 */
@Entity
@Table(name = "historique_element_contitutif")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class HistoriqueElementContitutif implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @Column(name = "newcode")
    private String newcode;

    @Column(name = "is_execute")
    private Boolean isExecute;

    @Column(name = "coeff")
    private Float coeff;

    @Column(name = "tpe")
    private Integer tpe;

    @Column(name = "intitule")
    private String intitule;

    @Column(name = "coef_tp")
    private Float coefTP;

    @Column(name = "specialite")
    private Boolean specialite;

    @Enumerated(EnumType.STRING)
    @Column(name = "type_element_constitutif")
    private EnumTypeElementConstitutif typeElementConstitutif;

    @ManyToOne
    @JsonIgnoreProperties(value = "historiqueElementContitutifs", allowSetters = true)
    private HistoriqueUniteEnseignement historiqueUniteEnseignement;

    @ManyToOne
    @JsonIgnoreProperties(value = "historiqueElementContitutifs", allowSetters = true)
    private ElementConstitutif elementConstitutif;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewcode() {
        return newcode;
    }

    public HistoriqueElementContitutif newcode(String newcode) {
        this.newcode = newcode;
        return this;
    }

    public void setNewcode(String newcode) {
        this.newcode = newcode;
    }

    public Boolean isIsExecute() {
        return isExecute;
    }

    public HistoriqueElementContitutif isExecute(Boolean isExecute) {
        this.isExecute = isExecute;
        return this;
    }

    public void setIsExecute(Boolean isExecute) {
        this.isExecute = isExecute;
    }

    public Float getCoeff() {
        return coeff;
    }

    public HistoriqueElementContitutif coeff(Float coeff) {
        this.coeff = coeff;
        return this;
    }

    public void setCoeff(Float coeff) {
        this.coeff = coeff;
    }

    public Integer getTpe() {
        return tpe;
    }

    public HistoriqueElementContitutif tpe(Integer tpe) {
        this.tpe = tpe;
        return this;
    }

    public void setTpe(Integer tpe) {
        this.tpe = tpe;
    }

    public String getIntitule() {
        return intitule;
    }

    public HistoriqueElementContitutif intitule(String intitule) {
        this.intitule = intitule;
        return this;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Float getCoefTP() {
        return coefTP;
    }

    public HistoriqueElementContitutif coefTP(Float coefTP) {
        this.coefTP = coefTP;
        return this;
    }

    public void setCoefTP(Float coefTP) {
        this.coefTP = coefTP;
    }

    public Boolean isSpecialite() {
        return specialite;
    }

    public HistoriqueElementContitutif specialite(Boolean specialite) {
        this.specialite = specialite;
        return this;
    }

    public void setSpecialite(Boolean specialite) {
        this.specialite = specialite;
    }

    public EnumTypeElementConstitutif getTypeElementConstitutif() {
        return typeElementConstitutif;
    }

    public HistoriqueElementContitutif typeElementConstitutif(EnumTypeElementConstitutif typeElementConstitutif) {
        this.typeElementConstitutif = typeElementConstitutif;
        return this;
    }

    public void setTypeElementConstitutif(EnumTypeElementConstitutif typeElementConstitutif) {
        this.typeElementConstitutif = typeElementConstitutif;
    }

    public HistoriqueUniteEnseignement getHistoriqueUniteEnseignement() {
        return historiqueUniteEnseignement;
    }

    public HistoriqueElementContitutif historiqueUniteEnseignement(HistoriqueUniteEnseignement historiqueUniteEnseignement) {
        this.historiqueUniteEnseignement = historiqueUniteEnseignement;
        return this;
    }

    public void setHistoriqueUniteEnseignement(HistoriqueUniteEnseignement historiqueUniteEnseignement) {
        this.historiqueUniteEnseignement = historiqueUniteEnseignement;
    }

    public ElementConstitutif getElementConstitutif() {
        return elementConstitutif;
    }

    public HistoriqueElementContitutif elementConstitutif(ElementConstitutif elementConstitutif) {
        this.elementConstitutif = elementConstitutif;
        return this;
    }

    public void setElementConstitutif(ElementConstitutif elementConstitutif) {
        this.elementConstitutif = elementConstitutif;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof HistoriqueElementContitutif)) {
            return false;
        }
        return id != null && id.equals(((HistoriqueElementContitutif) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "HistoriqueElementContitutif{" +
            "id=" + getId() +
            ", newcode='" + getNewcode() + "'" +
            ", isExecute='" + isIsExecute() + "'" +
            ", coeff=" + getCoeff() +
            ", tpe=" + getTpe() +
            ", intitule='" + getIntitule() + "'" +
            ", coefTP=" + getCoefTP() +
            ", specialite='" + isSpecialite() + "'" +
            ", typeElementConstitutif='" + getTypeElementConstitutif() + "'" +
            "}";
    }
}
