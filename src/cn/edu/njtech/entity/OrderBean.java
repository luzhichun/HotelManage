package cn.edu.njtech.entity;

import java.io.Serializable;

public class OrderBean implements Serializable{
	private int oid;
	private int foodId;
	private String foodName;
	private double foodPrice;
	private int foodCount;
	
	public OrderBean() {
		super();
	}
	public OrderBean(int oid, int foodId, String foodName, double foodPrice,
			int foodCount) {
		super();
		this.oid = oid;
		this.foodId = foodId;
		this.foodName = foodName;
		this.foodPrice = foodPrice;
		this.foodCount = foodCount;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getFoodId() {
		return foodId;
	}
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public double getFoodPrice() {
		return foodPrice;
	}
	public void setFoodPrice(double foodPrice) {
		this.foodPrice = foodPrice;
	}
	public int getFoodCount() {
		return foodCount;
	}
	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}
	
}
