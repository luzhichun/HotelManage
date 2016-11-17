package cn.edu.njtech.entity;

import java.io.Serializable;

public class Food implements Serializable{
	private int id;
	private String foodName;
	private int foodType_id;
	private double price;
	private double mprice;
	private String remark;
	private String img;
	private String typeName;
	
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	public Food() {
		super();
	}
	public Food(int id, String foodName, int foodTypeId, double price,
			double mprice, String remark, String img) {
		super();
		this.id = id;
		this.foodName = foodName;
		foodType_id = foodTypeId;
		this.price = price;
		this.mprice = mprice;
		this.remark = remark;
		this.img = img;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getFoodType_id() {
		return foodType_id;
	}
	public void setFoodType_id(int foodTypeId) {
		foodType_id = foodTypeId;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getMprice() {
		return mprice;
	}
	public void setMprice(double mprice) {
		this.mprice = mprice;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	@Override
	public String toString() {
		return "Food [foodName=" + foodName + ", foodType_id=" + foodType_id
				+ ", id=" + id + ", img=" + img + ", mprice=" + mprice
				+ ", price=" + price + ", remark=" + remark + "]";
	}
	
}
