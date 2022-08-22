package org.sid.secservice.sec.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.sid.secservice.sec.entities.enumeration.EnumTypeFormation;

import javax.persistence.*;
import javax.validation.constraints.*;

//import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.Objects;


/**
 * A TypeFormation.
 */
@Entity
@Table(name = "type_formation")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
//@Document(indexName = "typeformation")
public class TypeFormation implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "type_format", nullable = false, unique=true)
    private EnumTypeFormation typeFormat;

    @OneToMany(mappedBy = "typeFormation")
    @JsonIgnore
    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    private Set<Formation> formations = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumTypeFormation getTypeFormat() {
        return typeFormat;
    }

    public TypeFormation typeFormat(EnumTypeFormation typeFormat) {
        this.typeFormat = typeFormat;
        return this;
    }

    public void setTypeFormat(EnumTypeFormation typeFormat) {
        this.typeFormat = typeFormat;
    }

    public Set<Formation> getFormations() {
        return formations;
    }

    public TypeFormation formations(Set<Formation> formations) {
        this.formations = formations;
        return this;
    }

    public TypeFormation addFormation(Formation formation) {
        this.formations.add(formation);
        formation.setTypeFormation(this);
        return this;
    }

    public TypeFormation removeFormation(Formation formation) {
        this.formations.remove(formation);
        formation.setTypeFormation(null);
        return this;
    }

    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
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
        TypeFormation typeFormation = (TypeFormation) o;
        if (typeFormation.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), typeFormation.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "TypeFormation{" +
            "id=" + getId() +
            ", typeFormat='" + getTypeFormat() + "'" +
            "}";
    }
}
