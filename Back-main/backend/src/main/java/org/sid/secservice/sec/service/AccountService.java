package org.sid.secservice.sec.service;

import java.util.List;
import javax.validation.Valid;
import org.sid.secservice.sec.entities.AppRole;
import org.sid.secservice.sec.entities.AppUser;

public interface AccountService {
	AppUser addNewUser(AppUser appUser);
	AppRole addNewRole(AppRole appRole);
	void addRoleToUser(String username,String roleName);
	AppUser loadUserByUsername(String username);
	List<AppUser> listUsers();
	AppUser fetchAppUserByIne(String idf);
	AppUser saveUser(@Valid AppUser appUser);
    AppUser fetchAppUserByEmail(String email);
}
