package com.boot.book.ticket.app.ticketBookingManagementApp.services;

import com.boot.book.ticket.app.ticketBookingManagementApp.Dao.TicketBookingDao;
import com.boot.book.ticket.app.ticketBookingManagementApp.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketBookingService {
	@Autowired
	TicketBookingDao ticketBookingDao;

	public Ticket createTicket(Ticket ticket) {
		return ticketBookingDao.save(ticket);
	}

	public Ticket getTicketById(Integer ticketId) {
		return ticketBookingDao.findById(ticketId).orElse(null);
	}

	public Iterable<Ticket> getAllBookedTickets() {
		return ticketBookingDao.findAll();
	}

	public void deleteTicket(Integer ticketId) {
		ticketBookingDao.deleteById(ticketId);
	}

	public Ticket updateTicket(Integer ticketId, String email) {
		Ticket ticketFromDb = ticketBookingDao.findById(ticketId).orElse(new Ticket());
		ticketFromDb.setEmail(email);
		return ticketBookingDao.save(ticketFromDb);
	}

}
