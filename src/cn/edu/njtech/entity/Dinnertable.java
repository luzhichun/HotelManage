package  cn.edu.njtech.entity;


import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * dinnertable:
 */
public class Dinnertable implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * tableId:
	 */
	private int tableid;

	/**
	 * tableName:
	 */
	private String tablename;

	/**
	 * tableStatus:
	 */
	private int tablestatus;

	/**
	 * orderDate:
	 */
	private Date orderdate;

	/**
	 * orders:
	 */
	private Set<Orders> ordersSet = new HashSet<Orders>(0);

	public Dinnertable() {
		super();
	}

	public Dinnertable(int tableid, String tablename, int tablestatus,
			Date orderdate, Set<Orders> ordersSet) {
		super();
		this.tableid = tableid;
		this.tablename = tablename;
		this.tablestatus = tablestatus;
		this.orderdate = orderdate;
		this.ordersSet = ordersSet;
	}

	public void setTableid(int tableid) {
		this.tableid = tableid;
	}

	public int getTableid() {
		return tableid;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getTablename() {
		return tablename;
	}

	public void setTablestatus(int tablestatus) {
		this.tablestatus = tablestatus;
	}

	public int getTablestatus() {
		return tablestatus;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrdersSet(Set<Orders> ordersSet) {
		this.ordersSet = ordersSet;
	}

	public Set<Orders> getOrdersSet() {
		return ordersSet;
	}

	public String toString() {
		return "Dinnertable [tableid=" + tableid + ",tablename=" + tablename
				+ ",tablestatus=" + tablestatus + ",orderdate=" + orderdate
				+ ",ordersSet=" + ordersSet + "]";
	}

}
