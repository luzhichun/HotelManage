package cn.edu.njtech.entity;

import java.io.Serializable;

public class OrderDetail implements Serializable{
	private int id;
	private int orderId;
	private int food_id;
	private int foodCount;
	
	public OrderDetail() {
		super();
	}
	public OrderDetail(int id, int orderId, int foodId, int foodCount) {
		super();
		this.id = id;
		this.orderId = orderId;
		food_id = foodId;
		this.foodCount = foodCount;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public void setFood_id(int foodId) {
		food_id = foodId;
	}
	public int getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	
}
