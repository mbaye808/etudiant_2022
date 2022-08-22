package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;


public class ReclamationCopy implements Serializable {

    private static final long serialVersionUID = 1L;

  
    private Long id;


    private String etat;


    private String ine;


    private Float noteReclamation;

    private String date;


    private String typeReclamation;


    private String nature;


    private String description;


    private String dateDebut;


    private String dateFin;

  
    private byte[] photo;


    private String photoContentType;



  
    private HistoriqueElementContitutif historiqueElementContitutif;

  
    private AnneeAccademique anneeAccademique;

  
    private Session session;

  
    private Groupe groupe;
  
    private Semestre semestre;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public ReclamationCopy etat(String etat) {
        this.etat = etat;
        return this;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    

    public String getIne() {
        return ine;
    }

    public void setIne(String ine) {
        this.ine = ine;
    }

    public Float getNoteReclamation() {
        return noteReclamation;
    }

    public ReclamationCopy noteReclamation(Float noteReclamation) {
        this.noteReclamation = noteReclamation;
        return this;
    }

    public void setNoteReclamation(Float noteReclamation) {
        this.noteReclamation = noteReclamation;
    }

    public String getDate() {
        return date;
    }

    public ReclamationCopy date(String date) {
        this.date = date;
        return this;
    }

    public void setDate(String date) {
        this.date = date;
    }


    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    

    
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    public Groupe getGroupe() {
        return groupe;
    }

    public void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }

    public HistoriqueElementContitutif getHistoriqueElementContitutif() {
        return historiqueElementContitutif;
    }

    public void setHistoriqueElementContitutif(HistoriqueElementContitutif historiqueElementContitutif) {
        this.historiqueElementContitutif = historiqueElementContitutif;
    }

    public String getTypeReclamation() {
        return typeReclamation;
    }

    public void setTypeReclamation(String typeReclamation) {
        this.typeReclamation = typeReclamation;
    }

    public String getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(String dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getDateFin() {
        return dateFin;
    }

    public void setDateFin(String dateFin) {
        this.dateFin = dateFin;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getPhotoContentType() {
        return photoContentType;
    }

    public void setPhotoContentType(String photoContentType) {
        this.photoContentType = photoContentType;
    }

    public AnneeAccademique getAnneeAccademique() {
        return anneeAccademique;
    }

    public void setAnneeAccademique(AnneeAccademique anneeAccademique) {
        this.anneeAccademique = anneeAccademique;
    }

    

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ReclamationCopy)) {
            return false;
        }
        return id != null && id.equals(((ReclamationCopy) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Reclamation [date=" + date + ", description=" + description + ", etat=" + etat + ", nature=" + nature
                + ", noteReclamation=" + noteReclamation + ", photo=" + Arrays.toString(photo)
                + ", photoContentType=" + photoContentType + ", typeReclamation=" + typeReclamation + "]";
    }

    
    // prettier-ignore
   
}
