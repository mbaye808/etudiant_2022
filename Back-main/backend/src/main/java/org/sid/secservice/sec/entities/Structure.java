package org.sid.secservice.sec.entities;



import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * A Structure.
 */
@Entity
@Table(name = "structure",uniqueConstraints=@UniqueConstraint(columnNames={"code"}))
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Structure implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "code", nullable = false)
    private String code;

    @NotNull
    @Column(name = "libelle", nullable = false)
    private String libelle;

 

    @Column(name = "adresse")
    private String adresse;

    @Column(name = "note_eliminatoire")
    private Float noteEliminatoire;

    @Column(name = "chef")
    private String chef;

    @Column(name = "compensation")
    private Boolean compensation;

    @Column(name = "seuil_compensation")
    private Float seuilCompensation;

    @Column(name = "seuil_validation")
    private Float seuilValidation;

    @Column(name = "seuil_moyenne_semestre")
    private Float seuilMoyenneSemestre;
    
    @Column(name = "seuil_moyenne_semestre_validation")
    private Float seuilMoyenneSemestreValidation;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "image_content_type")
    private String imageContentType;
    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public Structure code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public Structure libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

   
    public String getAdresse() {
        return adresse;
    }

    public Structure adresse(String adresse) {
        this.adresse = adresse;
        return this;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public Float getNoteEliminatoire() {
        return noteEliminatoire;
    }

    public Structure noteEliminatoire(Float noteEliminatoire) {
        this.noteEliminatoire = noteEliminatoire;
        return this;
    }

    public void setNoteEliminatoire(Float noteEliminatoire) {
        this.noteEliminatoire = noteEliminatoire;
    }

    public String getChef() {
        return chef;
    }

    public Structure chef(String chef) {
        this.chef = chef;
        return this;
    }

    public void setChef(String chef) {
        this.chef = chef;
    }

    public Boolean isCompensation() {
        return compensation;
    }

    public Structure compensation(Boolean compensation) {
        this.compensation = compensation;
        return this;
    }

    public void setCompensation(Boolean compensation) {
        this.compensation = compensation;
    }

    public Float getSeuilCompensation() {
        return seuilCompensation;
    }

    public Structure seuilCompensation(Float seuilCompensation) {
        this.seuilCompensation = seuilCompensation;
        return this;
    }

    public void setSeuilCompensation(Float seuilCompensation) {
        this.seuilCompensation = seuilCompensation;
    }

    public Float getSeuilValidation() {
        return seuilValidation;
    }

    public Structure seuilValidation(Float seuilValidation) {
        this.seuilValidation = seuilValidation;
        return this;
    }

    public void setSeuilValidation(Float seuilValidation) {
        this.seuilValidation = seuilValidation;
    }

    public Float getSeuilMoyenneSemestre() {
        return seuilMoyenneSemestre;
    }

    public Structure seuilMoyenneSemestre(Float seuilMoyenneSemestre) {
        this.seuilMoyenneSemestre = seuilMoyenneSemestre;
        return this;
    }

    public void setSeuilMoyenneSemestre(Float seuilMoyenneSemestre) {
        this.seuilMoyenneSemestre = seuilMoyenneSemestre;
    }

    public byte[] getImage() {
        return image;
    }

    public Structure image(byte[] image) {
        this.image = image;
        return this;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public Structure imageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
        return this;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Structure)) {
            return false;
        }
        return id != null && id.equals(((Structure) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Structure{" +
            "id=" + getId() +
            ", code='" + getCode() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", adresse='" + getAdresse() + "'" +
            ", noteEliminatoire=" + getNoteEliminatoire() +
            ", chef='" + getChef() + "'" +
            ", compensation='" + isCompensation() + "'" +
            ", seuilCompensation=" + getSeuilCompensation() +
            ", seuilValidation=" + getSeuilValidation() +
            ", seuilMoyenneSemestre=" + getSeuilMoyenneSemestre() +
            "}";
    }

    public Float getSeuilMoyenneSemestreValidation() {
        return seuilMoyenneSemestreValidation;
    }

    public void setSeuilMoyenneSemestreValidation(Float seuilMoyenneSemestreValidation) {
        this.seuilMoyenneSemestreValidation = seuilMoyenneSemestreValidation;
    }
}
