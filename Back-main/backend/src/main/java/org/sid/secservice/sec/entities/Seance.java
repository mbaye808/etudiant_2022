package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;

import java.io.Serializable;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * A Seance.
 */
@Entity
@Table(name = "seance")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Seance implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateSequence")
    @SequenceGenerator(name = "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "heure_debut", nullable = false)
    private ZonedDateTime heureDebut;

    @NotNull
    @Column(name = "heure_fin", nullable = false)
    private ZonedDateTime heureFin;

    @Column(name = "etat_seance")
    private Boolean etatSeance;

    @Column(name = "online")
    private String online;

    @ManyToOne
    @JsonIgnoreProperties(value = "seances", allowSetters = true)
    private Salle salle;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "seances", allowSetters = true)
    private Planning planning;

    @ManyToOne
    @JsonIgnoreProperties(value = "seances", allowSetters = true)
    private Membre membre;

    @ManyToOne
    @JsonIgnoreProperties(value = "seances", allowSetters = true)
    private HistoriqueEnseignement historiqueEnseignement;
    @ManyToOne
    @JsonIgnoreProperties(value = "seances", allowSetters = true)
    private Enseignement enseignement;

    @ManyToOne
    @JsonIgnoreProperties(value = "seances", allowSetters = true)
    private GroupeTdTp groupeTdTp;

    @ManyToMany(fetch = FetchType.EAGER)
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(name = "seance_ressources",
               joinColumns = @JoinColumn(name = "seance_id", referencedColumnName = "id"),
               inverseJoinColumns = @JoinColumn(name = "ressources_id", referencedColumnName = "id"))
    private Set<Membre> ressources = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ZonedDateTime getHeureDebut() {
        return heureDebut;
    }

    public Seance heureDebut(ZonedDateTime heureDebut) {
        this.heureDebut = heureDebut;
        return this;
    }

    public void setHeureDebut(ZonedDateTime heureDebut) {
        this.heureDebut = heureDebut;
    }

    public ZonedDateTime getHeureFin() {
        return heureFin;
    }

    public Seance heureFin(ZonedDateTime heureFin) {
        this.heureFin = heureFin;
        return this;
    }

    public void setHeureFin(ZonedDateTime heureFin) {
        this.heureFin = heureFin;
    }

    public Boolean isEtatSeance() {
        return etatSeance;
    }

    public Seance etatSeance(Boolean etatSeance) {
        this.etatSeance = etatSeance;
        return this;
    }

    public void setEtatSeance(Boolean etatSeance) {
        this.etatSeance = etatSeance;
    }

    public String getOnline() {
        return online;
    }

    public Seance online(String online) {
        this.online = online;
        return this;
    }

    public void setOnline(String online) {
        this.online = online;
    }

    public Salle getSalle() {
        return salle;
    }

    public Seance salle(Salle salle) {
        this.salle = salle;
        return this;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }


    public Planning getPlanning() {
        return planning;
    }

    public Seance planning(Planning planning) {
        this.planning = planning;
        return this;
    }

    public void setPlanning(Planning planning) {
        this.planning = planning;
    }

    public Membre getMembre() {
        return membre;
    }

    public Seance membre(Membre membre) {
        this.membre = membre;
        return this;
    }

    public void setMembre(Membre membre) {
        this.membre = membre;
    }

    

   

    public HistoriqueEnseignement getHistoriqueEnseignement() {
        return historiqueEnseignement;
    }

    public Seance historiqueEnseignement(HistoriqueEnseignement historiqueEnseignement) {
        this.historiqueEnseignement = historiqueEnseignement;
        return this;
    }

    public void setHistoriqueEnseignement(HistoriqueEnseignement historiqueEnseignement) {
        this.historiqueEnseignement = historiqueEnseignement;
    }

    public GroupeTdTp getGroupeTdTp() {
        return groupeTdTp;
    }

    public Seance groupeTdTp(GroupeTdTp groupeTdTp) {
        this.groupeTdTp = groupeTdTp;
        return this;
    }

    public void setGroupeTdTp(GroupeTdTp groupeTdTp) {
        this.groupeTdTp = groupeTdTp;
    }

    public Set<Membre> getRessources() {
        return ressources;
    }

    public Seance ressources(Set<Membre> membres) {
        this.ressources = membres;
        return this;
    }

    public Seance addRessources(Membre membre) {
        this.ressources.add(membre);

        return this;
    }

    public Seance removeRessources(Membre membre) {
        this.ressources.remove(membre);
        return this;
    }

    public void setRessources(Set<Membre> membres) {
        this.ressources = membres;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Seance)) {
            return false;
        }
        return id != null && id.equals(((Seance) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Seance{" +
            "id=" + getId() +
            ", heureDebut='" + getHeureDebut() + "'" +
            ", heureFin='" + getHeureFin() + "'" +
            ", etatSeance='" + isEtatSeance() + "'" +
            ", online='" + getOnline() + "'" +
            "}";
    }
}
