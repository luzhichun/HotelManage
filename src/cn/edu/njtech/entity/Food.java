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
	private int foodid;

	/**
	 * foodName:
	 */
	private String foodname;

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
	private Foodtype foodtype;

	/**
	 * orderdetail:
	 */
	private Set<Orderdetail> orderdetailSet = new HashSet<Orderdetail>(0);

	public Food() {
		super();
	}

	public Food(int foodid, String foodname, double price, double mprice,
			String remark, String img, Foodtype foodtype,
			Set<Orderdetail> orderdetailSet) {
		super();
		this.foodid = foodid;
		this.foodname = foodname;
		this.price = price;
		this.mprice = mprice;
		this.remark = remark;
		this.img = img;
		this.foodtype = foodtype;
		this.orderdetailSet = orderdetailSet;
	}

	public void setFoodid(int foodid) {
		this.foodid = foodid;
	}

	public int getFoodid() {
		return foodid;
	}

	public void setFoodname(String foodname) {
		this.foodname = foodname;
	}

	public String getFoodname() {
		return foodname;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getPrice() {
		return price;
	}

	public void setMprice(double mprice) {
		this.mprice = mprice;
	}

	public double getMprice() {
		return mprice;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getImg() {
		return img;
	}

	public void setFoodtype(Foodtype foodtype) {
		this.foodtype = foodtype;
	}

	public Foodtype getFoodtype() {
		return foodtype;
	}

	public void setOrderdetailSet(Set<Orderdetail> orderdetailSet) {
		this.orderdetailSet = orderdetailSet;
	}

	public Set<Orderdetail> getOrderdetailSet() {
		return orderdetailSet;
	}

	public String toString() {
		return "Food [foodid=" + foodid + ",foodname=" + foodname + ",price="
				+ price + ",mprice=" + mprice + ",remark=" + remark + ",img="
				+ img + ",foodtype=" + foodtype + ",orderdetailSet="
				+ orderdetailSet + "]";
	}

}
