package com.bookingOffice.www.util;

import java.sql.Date;

public class SellsReport {
	private Date date;
	private int ticketsQuantity;
	private double totalSum;
	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	/**
	 * @return the ticketsQuantity
	 */
	public int getTicketsQuantity() {
		return ticketsQuantity;
	}
	/**
	 * @param ticketsQuantity the ticketsQuantity to set
	 */
	public void setTicketsQuantity(int ticketsQuantity) {
		this.ticketsQuantity = ticketsQuantity;
	}
	/**
	 * @return the totalSum
	 */
	public double getTotalSum() {
		return totalSum;
	}
	/**
	 * @param totalSum the totalSum to set
	 */
	public void setTotalSum(double totalSum) {
		this.totalSum = totalSum;
	}
	/**
	 * @param ticketsQuantity
	 * @param totalSum
	 */
	public SellsReport(int ticketsQuantity, double totalSum) {
		super();
		this.ticketsQuantity = ticketsQuantity;
		this.totalSum = totalSum;
	}
	/**
	 * @param date
	 * @param ticketsQuantity
	 * @param totalSum
	 */
	public SellsReport(Date date, int ticketsQuantity, double totalSum) {
		super();
		this.date = date;
		this.ticketsQuantity = ticketsQuantity;
		this.totalSum = totalSum;
	}
}
