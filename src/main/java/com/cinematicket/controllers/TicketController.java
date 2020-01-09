package com.cinematicket.controllers;

import java.util.Optional;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinematicket.dto.TicketDTO;
import com.cinematicket.entities.Ticket;
import com.cinematicket.entities.User;
import com.cinematicket.services.TicketService;
import com.cinematicket.services.UserService;
import com.cinematicket.services.impl.MailService;

@Controller
public class TicketController {
	private static final Logger LOGGER = Logger.getLogger(TicketController.class.getName());

	@Autowired
	private TicketService ticketService;

	@Autowired
	private UserService userService;

	@Autowired
	private MailService mailService;

	@RequestMapping("/")
	public String getTicketList(Model model) {
		model.addAttribute("seats", ticketService.getAllTicket());
		return "index";
	}

	/**
	 * for book the ticket
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/bookticket")
	public String bookTicket(@RequestParam Long id, Model model, HttpServletRequest request) {
		Long userId = (Long) request.getSession().getAttribute("loggedInUserId");
		if (userId != null) {
			Optional<Ticket> ticketOpt = ticketService.getTicketById(id);
			//ticket booking and sending email
			if (ticketOpt.isPresent()) {
				Ticket ticket = ticketOpt.get();
				ticket.setIsBooked(true);
				User user = userService.getUserById(userId).get();
				ticket.setBookedBy(user);
				ticketService.saveTicket(ticket);
				// email sending for confirmatin of ticket....
				mailService.sendMail("ticket booked configuration",
						"Hello " + user.getUsername() + "\n Your ticket is booked successfully. \n Here is you seat no="
								+ ticket.getSeatNo() + "\n Thanks",
						user.getEmail());
				LOGGER.info("ticket booked successfully....");
			}
		} else {
			return "redirect:/login?id=" + id;
		}
		return "redirect:/";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/cancelticket")
	public String cancelTicket(@RequestParam Long id, Model model, HttpServletRequest request) {
		Long userId = (Long) request.getSession().getAttribute("loggedInUserId");
		if (userId != null) {
			Optional<Ticket> ticketOpt = ticketService.getTicketById(id);
			//cancellation process of ticket
			if (ticketOpt.isPresent()) {
				Ticket ticket = ticketOpt.get();
				if (userId.equals(ticket.getBookedBy().getId())) {
					ticket.setIsBooked(false);
					ticket.setBookedBy(null);
					ticketService.saveTicket(ticket);
					LOGGER.info("ticket cancelled successfully....");
				}
			}
		} else {
			return "redirect:/login?id=" + id + "&cancel=true";
		}
		return "redirect:/";
	}
}
