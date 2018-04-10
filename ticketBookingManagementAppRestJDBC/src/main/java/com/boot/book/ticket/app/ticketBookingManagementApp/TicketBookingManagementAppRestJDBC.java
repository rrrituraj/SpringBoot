package com.boot.book.ticket.app.ticketBookingManagementApp;

import com.boot.book.ticket.app.ticketBookingManagementApp.entities.Ticket;
import com.boot.book.ticket.app.ticketBookingManagementApp.services.TicketBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class TicketBookingManagementAppRestJDBC implements CommandLineRunner {

	@Autowired
	TicketBookingService ticketBookingService;

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingManagementAppRestJDBC.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Ticket ticket = new Ticket("Yashraj", new Date(), "New Delhi", "jaipur", "r.g7@kuchbhi.com");
		ticketBookingService.createTicket(ticket);

	}
}
