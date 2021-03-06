package com.bookingOffice.www.DAO;

import java.util.List;

public interface TicketDAO {

	public Ticket getTicket(int id);

	public void addTicket(Ticket ticket);
	
	public void deleteTicket(int id);

	public List<Ticket> getTicketsByPerson(Person person);

	public List<Ticket> getTicketsByOrder(int orderId);

}
