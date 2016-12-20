package cn.edu.njtech.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.edu.njtech.common.Page;
import cn.edu.njtech.entity.OrderDetail;
import cn.edu.njtech.entity.Orders;

public interface IOrderDAO {
	public List<Orders> getOrder(int id)throws SQLException;
	public List<Orders> selectAllOrder(Page page)throws SQLException;
	public List<OrderDetail> showOrderDetail(Map<String,Object> map)throws SQLException;
	public int UpdateOrderById(Orders o)throws SQLException;
	public int deleteOrderDetailById(int id)throws SQLException;
	public List<Orders> getOrderTable(int id)throws SQLException;
	public int getNum();
}
