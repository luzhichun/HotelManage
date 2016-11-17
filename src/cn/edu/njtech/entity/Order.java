package cn.edu.njtech.entity;

import java.io.Serializable;

public class Order implements Serializable{
	private int id;
	private int table_id;
	private String orderDate;
	private double totalPrice;
	private int orderStatus;
	public Order() {
		super();
	}
	public Order(int id, int tableId, String orderDate, double totalPrice,
			int orderStatus) {
		super();
		this.id = id;
		table_id = tableId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTable_id() {
		return table_id;
	}
	public void setTable_id(int tableId) {
		table_id = tableId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(int orderStatus) {
		this.orderStatus = orderStatus;
	}
	 
}
