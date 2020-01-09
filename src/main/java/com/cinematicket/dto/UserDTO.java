package com.cinematicket.dto;

import java.io.Serializable;

public class UserDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String email;

	private String password;
	
	private Long seatId;
	
	private Boolean cancel;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
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
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the seatId
	 */
	public Long getSeatId() {
		return seatId;
	}

	/**
	 * @param seatId the seatId to set
	 */
	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	/**
	 * @return the cancel
	 */
	public Boolean getCancel() {
		return cancel;
	}

	/**
	 * @param cancel the cancel to set
	 */
	public void setCancel(Boolean cancel) {
		this.cancel = cancel;
	}
}
