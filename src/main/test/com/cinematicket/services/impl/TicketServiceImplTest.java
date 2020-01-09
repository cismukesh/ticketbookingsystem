package com.cinematicket.services.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.cinematicket.entities.Ticket;
import com.cinematicket.entities.User;
import com.cinematicket.repository.TicketRepository;
import com.cinematicket.services.TicketService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TicketServiceImplTest {

	@MockBean
	private TicketRepository ticketRepository;

	@Autowired
	private TicketService ticketService;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveTicket() {
		Ticket ticket = new Ticket();
		User bookedBy = new User();
		bookedBy.setEmail("test@gmail.com");
		bookedBy.setPassword("test");
		bookedBy.setId(1l);
		bookedBy.setUsername("test Usr");
		ticket.setBookedBy(bookedBy);
		ticket.setIsBooked(true);
		ticket.setId(1l);
		when(ticketRepository.save(Mockito.any(Ticket.class))).thenReturn(ticket);
		ticketService.saveTicket(ticket);
		
	} 

	@Test
	public void testGetAllTicket() {
		List<Ticket> list = new ArrayList<Ticket>();
		Ticket ticket = new Ticket();
		User bookedBy = new User();
		bookedBy.setEmail("test@gmail.com");
		bookedBy.setPassword("test");
		bookedBy.setId(1l);
		bookedBy.setUsername("test Usr");
		ticket.setBookedBy(bookedBy);
		ticket.setIsBooked(true);
		ticket.setId(1l);
		
		Ticket ticket1 = new Ticket();
		ticket.setIsBooked(false);
		ticket.setId(2l);
		
		list.add(ticket);
		list.add(ticket1);
		
		when(ticketRepository.findAll()).thenReturn(list);
		
		List<Ticket>fetchedList=ticketService.getAllTicket();
		
		assertEquals(list.size(), fetchedList.size());
		assertEquals(list.get(0).getId(), fetchedList.get(0).getId());
	}

	@Test
	public void testGetTicketById() {
		Ticket ticket = new Ticket();
		User bookedBy = new User();
		bookedBy.setEmail("test@gmail.com");
		bookedBy.setPassword("test");
		bookedBy.setId(1l);
		bookedBy.setUsername("test Usr");
		ticket.setBookedBy(bookedBy);
		ticket.setIsBooked(true);
		ticket.setId(1l);
		when(ticketRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(ticket));
		Optional<Ticket> optTicket = ticketService.getTicketById(1l);
		assertEquals(ticket.getId(), optTicket.get().getId());
	}

}
