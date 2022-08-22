package org.sid.secservice.sec.web;

import java.security.Principal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.sid.secservice.sec.JWTUtil;
import org.sid.secservice.sec.entities.AppRole;
import org.sid.secservice.sec.entities.AppUser;
import org.sid.secservice.sec.entities.Token;
import org.sid.secservice.sec.repo.EtudiantRepository;
import org.sid.secservice.sec.service.AccountService;
import org.sid.secservice.sec.service.AccountServiceImpl;
import org.sid.secservice.sec.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;

@RestController
@CrossOrigin(origins = "http://localhost:4201")

public class AccountRestController {
	
	@Autowired
	private AccountService accountService;
	@Autowired

	private AccountServiceImpl accountServiceImpl;


	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private EtudiantRepository etudiantRepository;
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	
	@GetMapping(path = "/users")
	public List<AppUser> appUsers(){
		return accountService.listUsers();
	} 
	@PostMapping(path = "/register")
	@CrossOrigin(origins = "http://localhost:4201")
	public AppUser saveUser(@Valid @RequestBody AppUser appUser) throws Exception {
		String tempIne = appUser.getIne();
		String tempMail = appUser.getEmail();
		AppUser userObj = null;

		if(tempIne != null &&   !"".equals(tempIne)) {
			AppUser userobj = accountService.fetchAppUserByIne(tempIne);
			if(userobj != null) {
				throw new Exception("L'INE "+tempIne+" existe, veillez entrer le bon INE !!!");
			}
			userobj = accountService.fetchAppUserByEmail(tempMail);
			if(userobj != null) {
				throw new Exception("L'email "+tempMail+" existe, veillez entrer le bon mail !!!");
			}
			
				if( etudiantRepository.findByIne(tempIne)==null) {
					throw new Exception("L'Etudiant n est pas dans la base de données");
				}
				userObj = accountService.saveUser(appUser);
		}
		return userObj;
	}

	@PostMapping(path = "/loginAuth")
 	@CrossOrigin(origins = "http://localhost:4201") 
	public Token loginUser(@RequestBody AppUser appUser, HttpServletRequest request) throws Exception{
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(appUser.getEmail(), appUser.getPassword()));

		} catch (BadCredentialsException e) {
			throw new Exception("Incorrect email or password");
		}
		final UserDetails userDetails = userDetailsServiceImpl.loadUserByUsername(appUser.getEmail());
		Algorithm algo1 =Algorithm.HMAC256(JWTUtil.SECRET);
		String jwtAccessToken= JWT.create()
				.withSubject(userDetails.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis()+JWTUtil.EXPIRE_ACCESS_TOKEN))
				.withIssuer(request.getRequestURL().toString())
				.withClaim("roles", userDetails.getAuthorities().stream().map(ga->ga.getAuthority()).collect(Collectors.toList()))
				.sign(algo1);
		System.out.println(new Token(jwtAccessToken));
		return  new Token(jwtAccessToken);
	}


	@PostMapping(path = "/roles")
	public AppRole saveRole(@RequestBody AppRole appRole) {
		return accountService.addNewRole(appRole);
	}
	@PostMapping(path = "/addRoleToUser")
	public void addRoleToUser(@RequestBody RoleUserForm roleUserForm) {
		accountService.addRoleToUser(roleUserForm.getUsername(), roleUserForm.getRoleName());
	}
	@GetMapping(path = "/refreshToken")
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String authToken =request.getHeader(JWTUtil.AUTH_HEADER);
		if(authToken!=null && authToken.startsWith(JWTUtil.PREFIX)) {
			try {
				String jwt=authToken.substring(JWTUtil.PREFIX.length());
				Algorithm algorithm=Algorithm.HMAC256(JWTUtil.SECRET);
				JWTVerifier jwtVerifier=JWT.require(algorithm).build();
				DecodedJWT decodedJWT= jwtVerifier.verify(jwt);
				String username=decodedJWT.getSubject();
				AppUser appUser =accountService.loadUserByUsername(username);
				String jwtAccessToken= JWT.create()
						.withSubject(appUser.getEmail())
						.withExpiresAt(new Date(System.currentTimeMillis()+JWTUtil.EXPIRE_ACCESS_TOKEN))
						.withIssuer(request.getRequestURL().toString())
						.withClaim("roles", appUser.getAppRole().stream().map(r->r.getRoleName()).collect(Collectors.toList()))
						.sign(algorithm);
				Map<String, String> idToken=new HashMap<>();
				idToken.put("access-token", jwtAccessToken);
				idToken.put("refresh-token", jwt);
				response.setContentType("application/json");
				new ObjectMapper().writeValue(response.getOutputStream(), idToken);
			}
			catch (Exception e) {
				
				throw e;
				
			}
		}
		else {
			throw new RuntimeException("refresh Token required!!!");
		}
	}
	@GetMapping(path = "/profile")
	public AppUser profile(Principal principal) {
		return accountService.loadUserByUsername(principal.getName());
	}

	@GetMapping(path = "/userConnecter")
	public Optional<AppUser> userConnecter() {
		System.out.println("IN userConnecter");
		return accountServiceImpl.getUserWithAuthorities();
	}


}
@Data
class RoleUserForm{
	private String username;
	private String roleName;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
}





