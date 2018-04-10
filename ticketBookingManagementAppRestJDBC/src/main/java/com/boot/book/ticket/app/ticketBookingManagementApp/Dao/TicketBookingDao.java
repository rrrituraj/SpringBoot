package com.boot.book.ticket.app.ticketBookingManagementApp.Dao;

import com.boot.book.ticket.app.ticketBookingManagementApp.entities.Ticket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer> {
	List<Ticket> findTicketByDestStation(String destStation);

	List<Ticket> getTicketInfoBySourceStation(String sourceStation);
}
