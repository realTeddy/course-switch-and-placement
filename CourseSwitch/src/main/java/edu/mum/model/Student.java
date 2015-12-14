package edu.mum.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.*;

public class Student {
	private String id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public String getId() {
		return id;
	}

	@NotNull
	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	@NotNull
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	@NotNull
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	@NotNull
	@Email
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	@NotNull
	public void setPassword(String password) {
		this.password = password;
	}
}
