package com.restjdbc.springrestjdbcproject.service;


import com.restjdbc.springrestjdbcproject.dao.TicketBookingDao;
import com.restjdbc.springrestjdbcproject.entities.Ticket;
import java.util.List;
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

  public List<Ticket> findTicketByDestStation(String destStation) {
    return ticketBookingDao.findTicketByDestStation(destStation);
  }

  public List<Ticket> getAllBySourceStation(String srcStation) {
    return ticketBookingDao.getTicketInfoBySourceStation(srcStation);
  }
}