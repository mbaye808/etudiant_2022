package org.sid.secservice.sec.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "annee_promo")
public class AnneePromo implements Serializable{

    @Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

    @Column(name = "nom_promo", nullable = false)
    private String nomPromo;
    
}
