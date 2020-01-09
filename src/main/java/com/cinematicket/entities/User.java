package com.cinematicket.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	/**
	 * 
	 */

	@Id
	@GeneratedValue
	private Long id;

	@Column(name = "username", nullable = false)
	private String username;

	@Column(name = "email", nullable = false, unique = true)
	private String email;

	@JsonIgnore
	@Column(name = "password", nullable = false)
	private String password;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id-
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 *            the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 * the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
