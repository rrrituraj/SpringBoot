package com.boot.book.ticket.app.ticketBookingManagementApp.Dao;

import com.boot.book.ticket.app.ticketBookingManagementApp.entities.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer> {
}
