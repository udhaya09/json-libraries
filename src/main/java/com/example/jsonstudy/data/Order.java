package com.example.jsonstudy.data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Order {

	private int orderId;
	private String customerName;
	private double tax;
	private BigDecimal subTotal;
	private BigDecimal total;
	private boolean isPaid;
	private Date orderDate;
	private List<String> items;
	private Map<String, Integer> itemQuantities;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public double getTax() {
		return tax;
	}

	public void setTax(double tax) {
		this.tax = tax;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public boolean getIsPaid() {
		return isPaid;
	}

	public void setIsPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
		
	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public List<String> getItems() {
		return items;
	}

	public void setItems(List<String> items) {
		this.items = items;
	}

	public Map<String, Integer> getItemQuantities() {
		return itemQuantities;
	}

	public void setItemQuantities(Map<String, Integer> itemQuantities) {
		this.itemQuantities = itemQuantities;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderId=");
		builder.append(orderId);
		builder.append(", customerName=");
		builder.append(customerName);
		builder.append(", tax=");
		builder.append(tax);
		builder.append(", subTotal=");
		builder.append(subTotal);
		builder.append(", total=");
		builder.append(total);
		builder.append(", isPaid=");
		builder.append(isPaid);
		builder.append(", orderDate=");
		builder.append(orderDate);
		builder.append(", items=");
		builder.append(items);
		builder.append(", itemQuantities=");
		builder.append(itemQuantities);
		builder.append("]");
		return builder.toString();
	}

}
