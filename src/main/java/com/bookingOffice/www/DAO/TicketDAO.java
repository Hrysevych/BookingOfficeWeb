package com.bookingOffice.www.DAO;

import java.util.List;

public interface TicketDAO {

	public Ticket getTicket(int id);

	public void addTicket(Ticket ticket);

	public List<Ticket> getTicketsByPerson(Person person);

	public List<Ticket> getTicketsByOrder(int orderId);

}
