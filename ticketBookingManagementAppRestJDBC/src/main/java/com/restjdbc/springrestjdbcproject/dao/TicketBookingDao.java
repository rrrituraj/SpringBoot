package com.restjdbc.springrestjdbcproject.dao;

import com.restjdbc.springrestjdbcproject.entities.Ticket;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketBookingDao extends CrudRepository<Ticket, Integer> {
  List<Ticket> findTicketByDestStation(String destStation);
  List<Ticket> getTicketInfoBySourceStation(String sourceStation);
}
