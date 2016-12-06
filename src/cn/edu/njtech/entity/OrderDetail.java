package cn.edu.njtech.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * orderdetail:
 */
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * orderDetailId:
	 */
	private int orderDetailId;

	/**
	 * foodCount:
	 */
	private int foodCount;

	/**
	 * orders:
	 */
	private int orderId;

	/**
	 * food:
	 */
	private int food_id;
	private String foodName;
	private double price;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public OrderDetail() {
		super();
	}
	public int getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	public int getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getFood_id() {
		return food_id;
	}
	public void setFood_id(int food_id) {
		this.food_id = food_id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public OrderDetail(int orderDetailId, int foodCount, int orderId,
			int food_id, String foodName) {
		super();
		this.orderDetailId = orderDetailId;
		this.foodCount = foodCount;
		this.orderId = orderId;
		this.food_id = food_id;
		this.foodName = foodName;
	}
	@Override
	public String toString() {
		return "OrderDetail [orderDetailId=" + orderDetailId + ", foodCount="
				+ foodCount + ", orderId=" + orderId + ", food_id=" + food_id
				+ ", foodName=" + foodName + ", price=" + price + "]";
	}
	
}