package com.cinematicket.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "seatNo", unique = true)
	private Integer seatNo;

	@Column(name = "isBooked")
	private Boolean isBooked = Boolean.FALSE;

	@ManyToOne
	@JoinColumn(name = "bookedBy")
	private User bookedBy;

	
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
	 * @return the seatNo
	 */
	public Integer getSeatNo() {
		return seatNo;
	}

	/**
	 * @param seatNo
	 *            the seatNo to set
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
	 * @param isBooked
	 *            the isBooked to set
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
	 * @param bookedBy
	 *            the bookedBy to set
	 */
	public void setBookedBy(User bookedBy) {
		this.bookedBy = bookedBy;
	}
}
