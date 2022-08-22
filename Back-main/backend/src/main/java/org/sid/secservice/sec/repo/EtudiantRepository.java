package org.sid.secservice.sec.repo;

import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.entities.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long>{
	// méthode permettant de retourner le Username
	
	// AppUser findByUsername(String username);

	Etudiant findByIne(String idf);

  
	

}
