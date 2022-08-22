package org.sid.secservice.sec.repo;

import java.util.Optional;

import org.sid.secservice.sec.entities.AppUser;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long>{
	// méthode permettant de retourner le Username
	
	// AppUser findByUsername(String username);

	AppUser findByIne(String idf);

    AppUser findByEmail(String email);


	 
String USERS_BY_LOGIN_CACHE = "usersByEmail";

@EntityGraph(attributePaths = "appRole")  
 @Cacheable(cacheNames = USERS_BY_LOGIN_CACHE)
    Optional<AppUser> findOneWithAppRoleByEmail(String login);
}
