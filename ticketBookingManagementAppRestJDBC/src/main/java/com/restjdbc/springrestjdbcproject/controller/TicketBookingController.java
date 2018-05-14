package com.restjdbc.springrestjdbcproject.controller;


import com.restjdbc.springrestjdbcproject.entities.Ticket;
import com.restjdbc.springrestjdbcproject.service.TicketBookingService;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("api/tickets")
public class TicketBookingController {

  @Autowired
  TicketBookingService ticketBookingService;

  @PostMapping("/create")
  public ResponseEntity<Ticket> createTicket(@Valid @RequestBody Ticket ticket) {
    /*if (ticket.getPassengerName() == null) {
      throw new MethodArgumentNotValidException("Not Valid Argument Passed");
    }*/
    Ticket serviceTicket = ticketBookingService.createTicket(ticket);
    HttpHeaders responseHeaders=new HttpHeaders();
    URI newTicketUri=ServletUriComponentsBuilder.fromCurrentRequest().path("/created_id_is:_{id}").buildAndExpand(serviceTicket.getTicketId()).toUri();
    responseHeaders.setLocation(newTicketUri);

    return new ResponseEntity<>(serviceTicket, responseHeaders, HttpStatus.CREATED);
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

  @GetMapping("/destStation/{destStation}")
  public List<Ticket> getAllByDestStation(@PathVariable("destStation") final String destStation) {
    return ticketBookingService.findTicketByDestStation(destStation);
  }

  @PutMapping("updateTicket/{ticketId}/{email:.+}")
  public Ticket updateTicket(@PathVariable("ticketId") Integer ticketId, @PathVariable("email") String email) {
    return ticketBookingService.updateTicket(ticketId, email);
  }

  @GetMapping("sourceStation/{srcStation}")
  public List<Ticket> getAllBySourceStation(@PathVariable("srcStation") final String srcStation) {
    return ticketBookingService.getAllBySourceStation(srcStation);
  }
}
