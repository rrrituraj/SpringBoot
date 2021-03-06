package com.restjdbc.springrestjdbcproject.entities;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "TICKET")
@DynamicUpdate
@NamedQueries(value = {
    @NamedQuery(name = "Ticket.getTicketInfoBySourceStation", query = "select t from Ticket t where t.sourceStation=?1")
})
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  @Column(name = "ticketId")
  private Integer ticketId;

  @Column(name = "passengerName")
  @NotEmpty
  private String passengerName;

  @Column(name = "bookingDate")
  private Date bookingDate;

  @Column(name = "sourceStation")
  private String sourceStation;

  @Column(name = "destStation")
  private String destStation;

  @Column(name = "email")
  private String email;

  public Ticket(String passengerName, Date bookingDate, String sourceStation, String destStation, String email) {
    this.passengerName = passengerName;
    this.bookingDate = bookingDate;
    this.sourceStation = sourceStation;
    this.destStation = destStation;
    this.email = email;
  }

  public Ticket() {
  }

  public Integer getTicketId() {
    return ticketId;
  }

  public void setTicketId(Integer ticketId) {
    this.ticketId = ticketId;
  }

  public String getPassengerName() {
    return passengerName;
  }

  public void setPassengerName(String passengerName) {
    this.passengerName = passengerName;
  }

  public Date getBookingDate() {
    return bookingDate;
  }

  public void setBookingDate(Date bookingDate) {
    this.bookingDate = bookingDate;
  }

  public String getSourceStation() {
    return sourceStation;
  }

  public void setSourceStation(String sourceStation) {
    this.sourceStation = sourceStation;
  }

  public String getDestStation() {
    return destStation;
  }

  public void setDestStation(String destStation) {
    this.destStation = destStation;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }
}
