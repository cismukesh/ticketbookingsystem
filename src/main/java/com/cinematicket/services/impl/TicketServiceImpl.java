package com.cinematicket.services.impl;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cinematicket.entities.Ticket;
import com.cinematicket.repository.TicketRepository;
import com.cinematicket.services.TicketService;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	public Ticket saveTicket(Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	@Override
	public List<Ticket> getAllTicket() {
		return ticketRepository.findAll();
	}

	@Override
	public Optional<Ticket> getTicketById(Long id) {
		return ticketRepository.findById(id);
	}

	@PostConstruct
	private void putDefalutTicket() {
		if (ticketRepository.count() == 0) {
			for (int i = 1; i <= 30; i++) {
				Ticket ticket= new Ticket();
				ticket.setSeatNo(i);
				ticket.setIsBooked(false);
				saveTicket(ticket);
			}
		}
	}

}
