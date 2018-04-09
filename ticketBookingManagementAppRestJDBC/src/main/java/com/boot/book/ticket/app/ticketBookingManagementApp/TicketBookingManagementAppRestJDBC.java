package com.boot.book.ticket.app.ticketBookingManagementApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
//@EntityScan(basePackageClasses = {com.boot.book.ticket.app.ticketBookingManagementApp})
public class TicketBookingManagementAppRestJDBC {

	/*@Autowired
	TicketBookingService ticketBookingService;
*/
	public static void main(String[] args) {
		SpringApplication.run(TicketBookingManagementAppRestJDBC.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		Ticket ticket = new Ticket("Rituraj", new Date(), "New Delhi", "MughalSarai", "r.g7@kuchbhi.com");
		ticketBookingService.createTicket(ticket);

	}*/
}
