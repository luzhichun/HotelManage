package cn.edu.njtech.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.njtech.entity.Orders;

public interface IOrderDAO {
	public List<Orders> getOrder(int id)throws SQLException;
	public List<Orders> selectAllOrder()throws SQLException;
	public List<Orders> showOrderDetail(int id)throws SQLException;
	public int deleteOrderById(int id)throws SQLException;
	public int deleteOrderDetailById(int id)throws SQLException;
	public List<Orders> getOrderTable(int id)throws SQLException;
}
