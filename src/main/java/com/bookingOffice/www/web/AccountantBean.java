package com.bookingOffice.www.web;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;

import com.bookingOffice.www.services.AccountantService;
import com.bookingOffice.www.util.OrderAndPerson;

@Named
@Scope("session")
public class AccountantBean {
	@Inject
	private AccountantService accountantService;

	private List<OrderAndPerson> orders = null;
	private OrderAndPerson order = null;

	public AccountantBean() {
		order = new OrderAndPerson();
	}

	public void refreshOrdersList() {
		orders = accountantService.getUnpaidValidOrdersWithNames();
	}

	public String markOrderPayed(String stringId) {
		int id = Integer.valueOf(stringId);
		accountantService.markOrderSold(id);
		
		return "Accountant";
	}

	/**
	 * @return the orders
	 */
	public List<OrderAndPerson> getOrders() {
		return orders;
	}

	/**
	 * @param orders
	 *            the orders to set
	 */
	public void setOrders(List<OrderAndPerson> orders) {
		this.orders = orders;
	}

	/**
	 * @return the order
	 */
	public OrderAndPerson getOrder() {
		return order;
	}

	/**
	 * @param order
	 *            the order to set
	 */
	public void setOrder(OrderAndPerson order) {
		this.order = order;
	}

}
