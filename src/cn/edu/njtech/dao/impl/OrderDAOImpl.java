package cn.edu.njtech.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.edu.njtech.dao.IOrderDAO;
import cn.edu.njtech.entity.Orders;

public class OrderDAOImpl implements IOrderDAO{

	@Override
	public List<Orders> getOrder(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> selectAllOrder() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> showOrderDetail(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteOrderById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteOrderDetailById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Orders> getOrderTable(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
}
