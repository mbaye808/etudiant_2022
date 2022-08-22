package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A ParametreRepechage.
 */
@Entity
@Table(name = "parametre_repechage")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class ParametreRepechage implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateSequence")
    @SequenceGenerator(name = "hibernateSequence")
    private Long id;

    @Column(name = "compensation")
    private Boolean compensation;

    @Column(name = "rattrapage")
    private Boolean rattrapage;

    @NotNull
    @Column(name = "seuil_moyenne_ue_compensation", nullable = false)
    private Float seuilMoyenneUeCompensation;

    @NotNull
    @Column(name = "seuil_moyenne_ue_validation", nullable = false)
    private Float seuilMoyenneUeValidation;

    @NotNull
    @Column(name = "seuil_moyenne_generale_compensation", nullable = false)
    private Float seuilMoyenneGeneraleCompensation;

    @NotNull
    @Column(name = "seuil_moyenne_generale_validation", nullable = false)
    private Float seuilMoyenneGeneraleValidation;

    @Column(name = "note_eliminatoire")
    private Float noteEliminatoire;

    @Column(name = "absence")
    private Boolean absence;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties("parametreRepechages")
    private Structure structure;

    @OneToOne(optional = false)
    @NotNull
    @JoinColumn(unique = true)
    private AnneeAccademique anneeAccademique;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean isCompensation() {
        return compensation;
    }

    public ParametreRepechage compensation(Boolean compensation) {
        this.compensation = compensation;
        return this;
    }

    public void setCompensation(Boolean compensation) {
        this.compensation = compensation;
    }

    public Boolean isRattrapage() {
        return rattrapage;
    }

    public ParametreRepechage rattrapage(Boolean rattrapage) {
        this.rattrapage = rattrapage;
        return this;
    }

    public void setRattrapage(Boolean rattrapage) {
        this.rattrapage = rattrapage;
    }

    public Float getSeuilMoyenneUeCompensation() {
        return seuilMoyenneUeCompensation;
    }

    public ParametreRepechage seuilMoyenneUeCompensation(Float seuilMoyenneUeCompensation) {
        this.seuilMoyenneUeCompensation = seuilMoyenneUeCompensation;
        return this;
    }

    public void setSeuilMoyenneUeCompensation(Float seuilMoyenneUeCompensation) {
        this.seuilMoyenneUeCompensation = seuilMoyenneUeCompensation;
    }

    public Float getSeuilMoyenneUeValidation() {
        return seuilMoyenneUeValidation;
    }

    public ParametreRepechage seuilMoyenneUeValidation(Float seuilMoyenneUeValidation) {
        this.seuilMoyenneUeValidation = seuilMoyenneUeValidation;
        return this;
    }

    public void setSeuilMoyenneUeValidation(Float seuilMoyenneUeValidation) {
        this.seuilMoyenneUeValidation = seuilMoyenneUeValidation;
    }

    public Float getSeuilMoyenneGeneraleCompensation() {
        return seuilMoyenneGeneraleCompensation;
    }

    public ParametreRepechage seuilMoyenneGeneraleCompensation(Float seuilMoyenneGeneraleCompensation) {
        this.seuilMoyenneGeneraleCompensation = seuilMoyenneGeneraleCompensation;
        return this;
    }

    public void setSeuilMoyenneGeneraleCompensation(Float seuilMoyenneGeneraleCompensation) {
        this.seuilMoyenneGeneraleCompensation = seuilMoyenneGeneraleCompensation;
    }

    public Float getSeuilMoyenneGeneraleValidation() {
        return seuilMoyenneGeneraleValidation;
    }

    public ParametreRepechage seuilMoyenneGeneraleValidation(Float seuilMoyenneGeneraleValidation) {
        this.seuilMoyenneGeneraleValidation = seuilMoyenneGeneraleValidation;
        return this;
    }

    public void setSeuilMoyenneGeneraleValidation(Float seuilMoyenneGeneraleValidation) {
        this.seuilMoyenneGeneraleValidation = seuilMoyenneGeneraleValidation;
    }

    public Float getNoteEliminatoire() {
        return noteEliminatoire;
    }

    public ParametreRepechage noteEliminatoire(Float noteEliminatoire) {
        this.noteEliminatoire = noteEliminatoire;
        return this;
    }

    public void setNoteEliminatoire(Float noteEliminatoire) {
        this.noteEliminatoire = noteEliminatoire;
    }

    public Boolean isAbsence() {
        return absence;
    }

    public ParametreRepechage absence(Boolean absence) {
        this.absence = absence;
        return this;
    }

    public void setAbsence(Boolean absence) {
        this.absence = absence;
    }

    public Structure getStructure() {
        return structure;
    }

    public ParametreRepechage structure(Structure structure) {
        this.structure = structure;
        return this;
    }

    public void setStructure(Structure structure) {
        this.structure = structure;
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public ParametreRepechage anneeAccademique(AnneeAccademique anneeAccademique) {
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
        if (!(o instanceof ParametreRepechage)) {
            return false;
        }
        return id != null && id.equals(((ParametreRepechage) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "ParametreRepechage{" +
            "id=" + getId() +
            ", compensation='" + isCompensation() + "'" +
            ", rattrapage='" + isRattrapage() + "'" +
            ", seuilMoyenneUeCompensation=" + getSeuilMoyenneUeCompensation() +
            ", seuilMoyenneUeValidation=" + getSeuilMoyenneUeValidation() +
            ", seuilMoyenneGeneraleCompensation=" + getSeuilMoyenneGeneraleCompensation() +
            ", seuilMoyenneGeneraleValidation=" + getSeuilMoyenneGeneraleValidation() +
            ", noteEliminatoire=" + getNoteEliminatoire() +
            ", absence='" + isAbsence() + "'" +
            "}";
    }
}
