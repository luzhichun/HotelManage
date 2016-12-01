package cn.edu.njtech.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * food:
 */
public class Food implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * foodId:
	 */
	private int foodId;

	/**
	 * foodName:
	 */
	private String foodName;

	/**
	 * price:
	 */
	private double price;

	/**
	 * mprice:
	 */
	private double mprice;

	/**
	 * remark:
	 */
	private String remark;

	/**
	 * img:
	 */
	private String img;

	/**
	 * foodtype:
	 */
	private int foodType_id;

	/**
	 * orderdetail:
	 */
	private String foodType;
	
	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	private Set<Orderdetail> orderdetailSet = new HashSet<Orderdetail>(0);

	public Food() {
		super();
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

	public int getFoodType_id() {
		return foodType_id;
	}

	public void setFoodType_id(int foodType_id) {
		this.foodType_id = foodType_id;
	}

	public Set<Orderdetail> getOrderdetailSet() {
		return orderdetailSet;
	}

	public void setOrderdetailSet(Set<Orderdetail> orderdetailSet) {
		this.orderdetailSet = orderdetailSet;
	}

	public Food(int foodId, String foodName, double price, double mprice,
			String remark, String img, int foodType_id,
			Set<Orderdetail> orderdetailSet) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
		this.mprice = mprice;
		this.remark = remark;
		this.img = img;
		this.foodType_id = foodType_id;
		this.orderdetailSet = orderdetailSet;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", price="
				+ price + ", mprice=" + mprice + ", remark=" + remark
				+ ", img=" + img + ", foodType_id=" + foodType_id
				+ ", foodType=" + foodType + ", orderdetailSet="
				+ orderdetailSet + "]";
	}
	
}
