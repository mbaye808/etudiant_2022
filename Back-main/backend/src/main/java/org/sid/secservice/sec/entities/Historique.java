package org.sid.secservice.sec.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Historique.
 */
@Entity
@Table(name = "historique")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
//@Document(indexName = "historique")
public class Historique implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @Column(name = "moyenne_ue")
    private Float moyenneUE;

    @Column(name = "moyenne_ue_annuel")
    private Float moyenneUeAnnuel;

    @Column(name = "sous_moyenne_ue")
    private Float sousMoyenneUe;

    @ManyToOne
    private UniteEnseignement uniteEnseignement;

    @ManyToOne
    private Inscription inscription;

    @ManyToOne
    private Session session;

    @ManyToOne
    private Semestre semestre;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getMoyenneUE() {
        return moyenneUE;
    }

    public Historique moyenneUE(Float moyenneUE) {
        this.moyenneUE = moyenneUE;
        return this;
    }

    public void setMoyenneUE(Float moyenneUE) {
        this.moyenneUE = moyenneUE;
    }

    public Float getMoyenneUeAnnuel() {
        return moyenneUeAnnuel;
    }

    public Historique moyenneUeAnnuel(Float moyenneUeAnnuel) {
        this.moyenneUeAnnuel = moyenneUeAnnuel;
        return this;
    }

    public void setMoyenneUeAnnuel(Float moyenneUeAnnuel) {
        this.moyenneUeAnnuel = moyenneUeAnnuel;
    }

    public Float getSousMoyenneUe() {
        return sousMoyenneUe;
    }

    public Historique sousMoyenneUe(Float sousMoyenneUe) {
        this.sousMoyenneUe = sousMoyenneUe;
        return this;
    }

    public void setSousMoyenneUe(Float sousMoyenneUe) {
        this.sousMoyenneUe = sousMoyenneUe;
    }

    public UniteEnseignement getUniteEnseignement() {
        return uniteEnseignement;
    }

    public Historique uniteEnseignement(UniteEnseignement uniteEnseignement) {
        this.uniteEnseignement = uniteEnseignement;
        return this;
    }

    public void setUniteEnseignement(UniteEnseignement uniteEnseignement) {
        this.uniteEnseignement = uniteEnseignement;
    }

    public Inscription getInscription() {
        return inscription;
    }

    public Historique inscription(Inscription inscription) {
        this.inscription = inscription;
        return this;
    }

    public void setInscription(Inscription inscription) {
        this.inscription = inscription;
    }

    public Session getSession() {
        return session;
    }

    public Historique session(Session session) {
        this.session = session;
        return this;
    }

    public void setSession(Session session) {
        this.session = session;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public Historique semestre(Semestre semestre) {
        this.semestre = semestre;
        return this;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
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
        Historique historique = (Historique) o;
        if (historique.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), historique.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Historique{" +
            "id=" + getId() +
            ", moyenneUE=" + getMoyenneUE() +
            ", moyenneUeAnnuel=" + getMoyenneUeAnnuel() +
            ", sousMoyenneUe=" + getSousMoyenneUe() +
            "}";
    }
}
