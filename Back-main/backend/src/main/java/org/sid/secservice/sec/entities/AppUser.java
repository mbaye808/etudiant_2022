package org.sid.secservice.sec.entities;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class AppUser {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "firstName", nullable = false)
	@NotEmpty
	@Size(min = 2, message = "Le prenom doit avoir au moins deux caracteres")
	private String firstName;
	
	@Column(name = "lastName", nullable = false)
	@NotEmpty
	@Size(min = 2, message = "Le nom doit avoir au moins deux caracteres")
	private String lastName;
	
	@NotEmpty
	@Email(message = "Email invalid")
	private String email;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private String dateNaiss;
	
	@Column(name = "ine", nullable = false)
	@NotEmpty
	@Size(min = 9, message = "L'INE doit avoir au moins 9 caracteres")
	private String ine;
	
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	@NotEmpty
	//@Size(min=6,max=6,message="Le mot de pass doit avoir 8 caracteres")
	private String password;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<AppRole> appRole = new ArrayList<>();
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	/* public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	} */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDateNaiss() {
		return dateNaiss;
	}

	public void setDateNaiss(String dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	public String getIne() {
		return ine;
	}

	public void setIne(String ine) {
		this.ine = ine;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<AppRole> getAppRole() {
		return appRole;
	}

	public void setAppRole(Collection<AppRole> appRoles) {
		this.appRole = appRoles;
	}

}
