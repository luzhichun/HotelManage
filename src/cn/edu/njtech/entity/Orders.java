package cn.edu.njtech.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * orders:
 */
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ordersId:
	 */
	private int ordersid;

	/**
	 * orderDate:
	 */
	private Date orderdate;

	/**
	 * totalPrice:
	 */
	private double totalprice;

	/**
	 * orderStatus:
	 */
	private int orderstatus;

	/**
	 * dinnertable:
	 */
	private Dinnertable dinnertable;

	/**
	 * orderdetail:
	 */
	private Set<Orderdetail> orderdetailSet = new HashSet<Orderdetail>(0);

	public Orders() {
		super();
	}

	public Orders(int ordersid, Date orderdate, double totalprice,
			int orderstatus, Dinnertable dinnertable,
			Set<Orderdetail> orderdetailSet) {
		super();
		this.ordersid = ordersid;
		this.orderdate = orderdate;
		this.totalprice = totalprice;
		this.orderstatus = orderstatus;
		this.dinnertable = dinnertable;
		this.orderdetailSet = orderdetailSet;
	}

	public void setOrdersid(int ordersid) {
		this.ordersid = ordersid;
	}

	public int getOrdersid() {
		return ordersid;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setTotalprice(double totalprice) {
		this.totalprice = totalprice;
	}

	public double getTotalprice() {
		return totalprice;
	}

	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}

	public int getOrderstatus() {
		return orderstatus;
	}

	public void setDinnertable(Dinnertable dinnertable) {
		this.dinnertable = dinnertable;
	}

	public Dinnertable getDinnertable() {
		return dinnertable;
	}

	public void setOrderdetailSet(Set<Orderdetail> orderdetailSet) {
		this.orderdetailSet = orderdetailSet;
	}

	public Set<Orderdetail> getOrderdetailSet() {
		return orderdetailSet;
	}

	public String toString() {
		return "Orders [ordersid=" + ordersid + ",orderdate=" + orderdate
				+ ",totalprice=" + totalprice + ",orderstatus=" + orderstatus
				+ ",dinnertable=" + dinnertable + ",orderdetailSet="
				+ orderdetailSet + "]";
	}

}
