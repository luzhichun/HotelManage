package cn.edu.njtech.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.njtech.entity.Order;
import cn.edu.njtech.entity.OrderBean;

public interface IOrderDAO {
	public List<Order> getOrder(int id)throws SQLException;
	public List<Order> selectAllOrder()throws SQLException;
	public List<OrderBean> showOrderDetail(int id)throws SQLException;
	public int deleteOrderById(int id)throws SQLException;
	public int deleteOrderDetailById(int id)throws SQLException;
	public List<Order> getOrderTable(int id)throws SQLException;
}
