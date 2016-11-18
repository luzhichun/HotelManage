package cn.edu.njtech.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * orderdetail:
 */
public class Orderdetail implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * orderDetailId:
	 */
	private int orderdetailid;

	/**
	 * foodCount:
	 */
	private int foodcount;

	/**
	 * orders:
	 */
	private Orders orders;

	/**
	 * food:
	 */
	private Food food;

	public Orderdetail() {
		super();
	}

	public Orderdetail(int orderdetailid, int foodcount, Orders orders,
			Food food) {
		super();
		this.orderdetailid = orderdetailid;
		this.foodcount = foodcount;
		this.orders = orders;
		this.food = food;
	}

	public void setOrderdetailid(int orderdetailid) {
		this.orderdetailid = orderdetailid;
	}

	public int getOrderdetailid() {
		return orderdetailid;
	}

	public void setFoodcount(int foodcount) {
		this.foodcount = foodcount;
	}

	public int getFoodcount() {
		return foodcount;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Food getFood() {
		return food;
	}

	public String toString() {
		return "Orderdetail [orderdetailid=" + orderdetailid + ",foodcount="
				+ foodcount + ",orders=" + orders + ",food=" + food + "]";
	}

}
