package org.sid.secservice.sec.entities;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


@Entity
@Table(name = "niveau")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Niveau implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hibernateSequence")
    @SequenceGenerator(name = "hibernateSequence")
    private Long id;

    @NotNull
    @Column(name = "code_niveau", nullable = false)
    private String codeNiveau;

    @NotNull
    @Column(name = "libelle", nullable = false)
    private String libelle;



    @NotNull
    @Column(name = "terminal", nullable = false)
    private Boolean terminal;


    @NotNull
    @Column(name = "entrant", nullable = false)
    private Boolean entrant;

    @NotNull
    @Column(name = "sortant", nullable = false)
    private Boolean sortant;

    @Column(name = "code_niveau_disi")
    private String codeNiveauDisi;

    @Column(name = "code_option_disi")
    private String codeOptionDisi;

    @ManyToOne(optional = false)
    @NotNull
    @JsonIgnoreProperties(value = "niveaus", allowSetters = true)
    private Formation formation;

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodeNiveau() {
        return codeNiveau;
    }

    public Niveau codeNiveau(String codeNiveau) {
        this.codeNiveau = codeNiveau;
        return this;
    }

    public void setCodeNiveau(String codeNiveau) {
        this.codeNiveau = codeNiveau;
    }

    public String getLibelle() {
        return libelle;
    }

    public Niveau libelle(String libelle) {
        this.libelle = libelle;
        return this;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    


    public Boolean isTerminal() {
        return terminal;
    }

    public Niveau terminal(Boolean terminal) {
        this.terminal = terminal;
        return this;
    }

    public void setTerminal(Boolean terminal) {
        this.terminal = terminal;
    }



    public Boolean isEntrant() {
        return entrant;
    }

    public Niveau entrant(Boolean entrant) {
        this.entrant = entrant;
        return this;
    }

    public void setEntrant(Boolean entrant) {
        this.entrant = entrant;
    }

    public Boolean isSortant() {
        return sortant;
    }

    public Niveau sortant(Boolean sortant) {
        this.sortant = sortant;
        return this;
    }

    public void setSortant(Boolean sortant) {
        this.sortant = sortant;
    }

    public String getCodeNiveauDisi() {
        return codeNiveauDisi;
    }

    public Niveau codeNiveauDisi(String codeNiveauDisi) {
        this.codeNiveauDisi = codeNiveauDisi;
        return this;
    }

    public void setCodeNiveauDisi(String codeNiveauDisi) {
        this.codeNiveauDisi = codeNiveauDisi;
    }

    public String getCodeOptionDisi() {
        return codeOptionDisi;
    }

    public Niveau codeOptionDisi(String codeOptionDisi) {
        this.codeOptionDisi = codeOptionDisi;
        return this;
    }

    public void setCodeOptionDisi(String codeOptionDisi) {
        this.codeOptionDisi = codeOptionDisi;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Niveau)) {
            return false;
        }
        return id != null && id.equals(((Niveau) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Niveau{" +
            "id=" + getId() +
            ", codeNiveau='" + getCodeNiveau() + "'" +
            ", libelle='" + getLibelle() + "'" +
            ", terminal='" + isTerminal() + "'" +
            ", entrant='" + isEntrant() + "'" +
            ", sortant='" + isSortant() + "'" +
            ", codeNiveauDisi='" + getCodeNiveauDisi() + "'" +
            ", codeOptionDisi='" + getCodeOptionDisi() + "'" +
            "}";
    }
}
    
