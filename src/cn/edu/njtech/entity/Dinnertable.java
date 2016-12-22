package  cn.edu.njtech.entity;


import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * FileName: Dinnertable
 * 
 * @Description: 餐桌实体类
 * 
 * @author: 刘明亮
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class Dinnertable implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * tableId:餐桌ID
	 */
	private int tableId;

	/**
	 * tableName:餐桌名称
	 */
	private String tableName;

	/**
	 * tableStatus:餐桌状态
	 */
	private int tableStatus;

	/**
	 * orderDate:预定日期
	 */
	private String orderDate;
	/**
	 * orders:订单
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

	@Override
	public String toString() {
		return "Dinnertable [tableId=" + tableId + ", tableName=" + tableName
				+ ", tableStatus=" + tableStatus + ", orderDate=" + orderDate
				+ ", ordersSet=" + ordersSet + "]";
	}
	
}
