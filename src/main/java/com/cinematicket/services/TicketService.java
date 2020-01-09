package com.cinematicket.services;

import java.util.List;
import java.util.Optional;

import com.cinematicket.entities.Ticket;

public interface TicketService {

	
	/**
	 * fetching ticket using the id
	 * @param id
	 * @return
	 */
	Optional<Ticket> getTicketById(Long id);
	/**
	 * for save update ticket
	 * 
	 * @param ticket
	 * @return
	 */
	Ticket saveTicket(Ticket ticket);

	/**
	 * for fetch list of all ticket
	 * 
	 * @return
	 */
	List<Ticket> getAllTicket();

}
