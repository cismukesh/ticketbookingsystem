package com.cinematicket.dto;

import java.io.Serializable;

import com.cinematicket.entities.User;

public class TicketDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	private Integer seatNo ;
	
	private Boolean isBooked;
	
	private User bookedBy;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the seatNo
	 */
	public Integer getSeatNo() {
		return seatNo;
	}

	/**
	 * @param seatNo the seatNo to set
	 */
	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}

	/**
	 * @return the isBooked
	 */
	public Boolean getIsBooked() {
		return isBooked;
	}

	/**
	 * @param isBooked the isBooked to set
	 */
	public void setIsBooked(Boolean isBooked) {
		this.isBooked = isBooked;
	}

	/**
	 * @return the bookedBy
	 */
	public User getBookedBy() {
		return bookedBy;
	}

	/**
	 * @param bookedBy the bookedBy to set
	 */
	public void setBookedBy(User bookedBy) {
		this.bookedBy = bookedBy;
	}
	
}
