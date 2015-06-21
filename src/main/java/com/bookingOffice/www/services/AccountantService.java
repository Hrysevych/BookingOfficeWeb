package com.bookingOffice.www.services;

import java.util.List;

import com.bookingOffice.www.DAO.Order;
import com.bookingOffice.www.util.OrderAndPerson;

public interface AccountantService {

	public void markOrderSold(int orderId);

	public void markTicketSold(int id);

	public List<Order> getUnpaidValidOrders();

	public List<OrderAndPerson> getUnpaidValidOrdersWithNames();

}
