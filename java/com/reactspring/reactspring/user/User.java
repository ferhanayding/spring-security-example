package com.reactspring.reactspring.user;



import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;
import com.reactspring.reactspring.shared.Views;

import lombok.Data;
@Data
@Entity
public class User {

	
	@Id
	@GeneratedValue
	private long id;
	
	@NotNull(message ="{hoaxify.constraint.username.NotNull.message}")
	@UniqueUsername
	@Size(min = 4 , max = 255)
	@JsonView(Views.Base.class)
	private String username;

	@NotNull
	@Size(min = 4 , max = 255)
	@JsonView(Views.Base.class)
	private String displayname;

	@NotNull
	@Size(min = 8 , max = 255)
	@Pattern(regexp="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$"
	, message = "{hoaxify.constraint.password.Pattern.message}")
	private String password;
	
	@JsonView(Views.Base.class)
	private String image;
	
	

	
}
