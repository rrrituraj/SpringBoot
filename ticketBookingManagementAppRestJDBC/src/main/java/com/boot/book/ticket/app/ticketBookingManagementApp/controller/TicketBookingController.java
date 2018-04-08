package com.boot.book.ticket.app.ticketBookingManagementApp.controller;

import com.boot.book.ticket.app.ticketBookingManagementApp.entities.Ticket;
import com.boot.book.ticket.app.ticketBookingManagementApp.services.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tickets")
public class TicketBookingController {

	@Autowired
	TicketBookingService ticketBookingService;

	@PostMapping("/create")
	public Ticket createTicket(@RequestBody Ticket ticket) {
		return ticketBookingService.createTicket(ticket);
	}

	@GetMapping("/ticket/{ticketId}")
	public Ticket getTicketById(@PathVariable("ticketId") final Integer ticketId) {
		return ticketBookingService.getTicketById(ticketId);
	}

	@GetMapping("/")
	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingService.getAllBookedTickets();
	}

	@DeleteMapping("/deleteTicket/{ticketId}")
	public void deleteTicket(@PathVariable("ticketId") final Integer ticketId) {
		ticketBookingService.deleteTicket(ticketId);
	}

	@PutMapping("updateTicket/{ticketId}/{email:.+}")
	public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId, @PathVariable("email") String email) {
		return ticketBookingService.updateTicket(ticketId, email);
	}
}
