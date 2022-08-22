package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A Note.
 */
@Entity
@Table(name = "note")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Note implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateSequence")
    @SequenceGenerator(name = "hibernateSequence")
    private Long id;

    @Column(name = "tp")
    private Float tp;

    @Column(name = "moyenne")
    private Float moyenne;

    @Column(name = "cc")
    private Float cc;

    @Column(name = "rattrapage")
    private Float rattrapage;

    @Column(name = "renonciation")
    private Boolean renonciation;

    @Column(name = "ds")
    private Float ds;

    @Column(name = "point_jury")
    private Float pointJury;

    @Column(name = "pointjury_r")
    private Float pointjuryR;

    @Column(name = "absence")
    private Boolean absence;

    @Column(name = "absence_rattrapage")
    private Boolean absenceRattrapage;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = "notes", allowSetters = true)
    private ElementConstitutif elementConstitutif;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "notes", allowSetters = true)
    private Etudiant etudiant;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "notes", allowSetters = true)
    private AnneeAccademique anneeAccademique;

    @ManyToOne
    @JsonIgnoreProperties(value = "notes", allowSetters = true)
    private Inscription inscription;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTp() {
        return tp;
    }

    public Note tp(Float tp) {
        this.tp = tp;
        return this;
    }

    public void setTp(Float tp) {
        this.tp = tp;
    }

    public Float getMoyenne() {
        return moyenne;
    }

    public Note moyenne(Float moyenne) {
        this.moyenne = moyenne;
        return this;
    }

    public void setMoyenne(Float moyenne) {
        this.moyenne = moyenne;
    }

    public Float getCc() {
        return cc;
    }

    public Note cc(Float cc) {
        this.cc = cc;
        return this;
    }

    public void setCc(Float cc) {
        this.cc = cc;
    }

    public Float getRattrapage() {
        return rattrapage;
    }

    public Note rattrapage(Float rattrapage) {
        this.rattrapage = rattrapage;
        return this;
    }

    public void setRattrapage(Float rattrapage) {
        this.rattrapage = rattrapage;
    }

    public Boolean isRenonciation() {
        return renonciation;
    }

    public Note renonciation(Boolean renonciation) {
        this.renonciation = renonciation;
        return this;
    }

    public void setRenonciation(Boolean renonciation) {
        this.renonciation = renonciation;
    }

    public Float getDs() {
        return ds;
    }

    public Note ds(Float ds) {
        this.ds = ds;
        return this;
    }

    public void setDs(Float ds) {
        this.ds = ds;
    }

    public Float getPointJury() {
        return pointJury;
    }

    public Note pointJury(Float pointJury) {
        this.pointJury = pointJury;
        return this;
    }

    public void setPointJury(Float pointJury) {
        this.pointJury = pointJury;
    }

    public Float getPointjuryR() {
        return pointjuryR;
    }

    public Note pointjuryR(Float pointjuryR) {
        this.pointjuryR = pointjuryR;
        return this;
    }

    public void setPointjuryR(Float pointjuryR) {
        this.pointjuryR = pointjuryR;
    }

    public Boolean isAbsence() {
        return absence;
    }

    public Note absence(Boolean absence) {
        this.absence = absence;
        return this;
    }

    public void setAbsence(Boolean absence) {
        this.absence = absence;
    }

    public Boolean isAbsenceRattrapage() {
        return absenceRattrapage;
    }

    public Note absenceRattrapage(Boolean absenceRattrapage) {
        this.absenceRattrapage = absenceRattrapage;
        return this;
    }

    public void setAbsenceRattrapage(Boolean absenceRattrapage) {
        this.absenceRattrapage = absenceRattrapage;
    }

    public ElementConstitutif getElementConstitutif() {
        return elementConstitutif;
    }

    public Note elementConstitutif(ElementConstitutif elementConstitutif) {
        this.elementConstitutif = elementConstitutif;
        return this;
    }

    public void setElementConstitutif(ElementConstitutif elementConstitutif) {
        this.elementConstitutif = elementConstitutif;
    }

    

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public Note anneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
        return this;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public Note inscription(Inscription inscription) {
        this.inscription = inscription;
        return this;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Note)) {
            return false;
        }
        return id != null && id.equals(((Note) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Note{" +
            "id=" + getId() +
            ", tp=" + getTp() +
            ", moyenne=" + getMoyenne() +
            ", cc=" + getCc() +
            ", rattrapage=" + getRattrapage() +
            ", renonciation='" + isRenonciation() + "'" +
            ", ds=" + getDs() +
            ", pointJury=" + getPointJury() +
            ", pointjuryR=" + getPointjuryR() +
            ", absence='" + isAbsence() + "'" +
            ", absenceRattrapage='" + isAbsenceRattrapage() + "'" +
            "}";
    }
}

