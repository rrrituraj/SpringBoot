package com.boot.book.ticket.app.ticketBookingManagementApp;

import com.boot.book.ticket.app.ticketBookingManagementApp.entities.Ticket;
import com.boot.book.ticket.app.ticketBookingManagementApp.services.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TicketBookingManagementAppApplication implements CommandLineRunner {

	@Autowired
	TicketBookingService ticketBookingService;

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingManagementAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ticket ticket = new Ticket("Rituraj", new Date(), "New Delhi", "MughalSarai", "r.g7@kuchbhi.com");
		ticketBookingService.createTicket(ticket);

	}
}
