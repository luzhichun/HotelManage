package  cn.edu.njtech.entity;


import java.io.Serializable;
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
	private int tableId;

	/**
	 * tableName:
	 */
	private String tableName;

	/**
	 * tableStatus:
	 */
	private int tableStatus;

	/**
	 * orderDate:
	 */
	private String orderDate;
	/**
	 * orders:
	 */
	private Set<Orders> ordersSet = new HashSet<Orders>(0);

	public Dinnertable() {
		super();
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
	
	public Set<Orders> getOrdersSet() {
		return ordersSet;
	}

	public void setOrdersSet(Set<Orders> ordersSet) {
		this.ordersSet = ordersSet;
	}

	public Dinnertable(int tableId, String tableName, int tableStatus,
			String orderDate, Set<Orders> ordersSet) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.tableStatus = tableStatus;
		this.orderDate = orderDate;
		this.ordersSet = ordersSet;
	}
	
}
