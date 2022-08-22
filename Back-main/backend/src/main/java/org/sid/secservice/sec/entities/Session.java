package org.sid.secservice.sec.entities;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.sid.secservice.sec.entities.enumeration.EnumSession;

import javax.persistence.*;
import javax.validation.constraints.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//import org.springframework.data.elasticsearch.annotations.Document;
import java.io.Serializable;
import java.util.Objects;

//import sn.pgi.consultationbulletin.domaine.enumeration.EnumSession;

/**
 * A Session.
 */
@Entity
@Table(name = "session")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
//@Document(indexName = "session")
public class Session implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =   "hibernateSequence")
    @SequenceGenerator(name =   "hibernateSequence")
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "jhi_session", nullable = false)
    private EnumSession session;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EnumSession getSession() {
        return session;
    }

    public Session session(EnumSession session) {
        this.session = session;
        return this;
    }

    public void setSession(EnumSession session) {
        this.session = session;
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
        Session session = (Session) o;
        if (session.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), session.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Session{" +
            "id=" + getId() +
            ", session='" + getSession() + "'" +
            "}";
    }
}
