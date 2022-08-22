package org.sid.secservice.sec.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.sid.secservice.sec.entities.AppRole;
import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.repo.AppRoleRepository;
import org.sid.secservice.sec.repo.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{

	@Autowired
	private AppUserRepository appUserRepository;
	@Autowired
	private AppRoleRepository appRoleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public AppUser addNewUser(AppUser appUser) {
		
		return appUserRepository.save(appUser);
	}

	@Override
	public AppRole addNewRole(AppRole appRole) {
		
		return appRoleRepository.save(appRole);
	}

	@Override
	public void addRoleToUser(String email, String roleName) {
		
		AppUser appUser = appUserRepository.findByEmail(email);
		AppRole appRole = appRoleRepository.findByRoleName(roleName);
		
		appUser.getAppRole().add(appRole);
	}

	@Override
	public AppUser loadUserByUsername(String email) {
		
		
		return appUserRepository.findByEmail(email);
	}

	@Override
	public List<AppUser> listUsers() {
		
		return appUserRepository.findAll();
	}

	@Override
	public AppUser fetchAppUserByIne(String idf) {

		return appUserRepository.findByIne(idf);
	}

	@Override
	public AppUser saveUser(@Valid AppUser appUser) {
		String pwd=appUser.getPassword();
		appUser.setPassword(passwordEncoder.encode(pwd));
		return appUserRepository.save(appUser);
	}

	@Override
	public AppUser fetchAppUserByEmail(String email) {
		
		return appUserRepository.findByEmail(email);
	}
	@Transactional(readOnly = true)
    public Optional<AppUser> getUserWithAuthorities() {
        return getCurrentUserLogin().flatMap(appUserRepository::findOneWithAppRoleByEmail);
    }
	public static Optional<String> getCurrentUserLogin() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        return Optional.ofNullable(extractPrincipal(securityContext.getAuthentication()));
    }

    private static String extractPrincipal(Authentication authentication) {
        if (authentication == null) {
            return null;
        } else if (authentication.getPrincipal() instanceof UserDetails) {
            UserDetails springSecurityUser = (UserDetails) authentication.getPrincipal();
            return springSecurityUser.getUsername();
        } else if (authentication.getPrincipal() instanceof String) {
            return (String) authentication.getPrincipal();
        }
        return null;
    }
}
