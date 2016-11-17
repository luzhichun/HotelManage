package cn.edu.njtech.entity;

import java.io.Serializable;

public class DinnerTable implements Serializable{
	private int id;
	private String tableName;
	private int tableStatus;
	private String orderDate;
	
	public DinnerTable() {
		super();
	}
	public DinnerTable(int id, String tableName, int tableStatus,
			String orderDate) {
		super();
		this.id = id;
		this.tableName = tableName;
		this.tableStatus = tableStatus;
		this.orderDate = orderDate;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getTableStatus() {
		return tableStatus;
	}
	public void setTableStatus(int tableStatus) {
		this.tableStatus = tableStatus;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	

}
