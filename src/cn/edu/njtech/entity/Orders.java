package cn.edu.njtech.entity;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * FileName: Orders
 * 
 * @Description: 订单实体类
 * 
 * @author: 刘明亮
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class Orders implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ordersId:订单ID
	 */
	private int ordersId;

	/**
	 * orderDate:订单日期
	 */
	private String orderDate;

	/**
	 * totalPrice:总价
	 */
	private double totalPrice;

	/**
	 * orderStatus:订单状态
	 */
	private int orderStatus;

	/**
	 * dinnertable:订单餐桌
	 */
	private int tableId;
	private String tableName;

	/**
	 * orderdetail:订单详细
	 */
	private Set<OrderDetail> orderdetailSet = new HashSet<OrderDetail>(0);

	public Orders() {
		super();
	}

	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
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

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public Set<OrderDetail> getOrderdetailSet() {
		return orderdetailSet;
	}

	public void setOrderdetailSet(Set<OrderDetail> orderdetailSet) {
		this.orderdetailSet = orderdetailSet;
	}

	public Orders(int ordersId, String orderDate, double totalPrice,
			int orderStatus, int tableId, String tableName,
			Set<OrderDetail> orderdetailSet) {
		super();
		this.ordersId = ordersId;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.orderStatus = orderStatus;
		this.tableId = tableId;
		this.tableName = tableName;
		this.orderdetailSet = orderdetailSet;
	}

	@Override
	public String toString() {
		return "Orders [ordersId=" + ordersId + ", orderDate=" + orderDate
				+ ", totalPrice=" + totalPrice + ", orderStatus=" + orderStatus
				+ ", tableId=" + tableId + ", tableName=" + tableName
				+ ", orderdetailSet=" + orderdetailSet + "]";
	}
	
}
