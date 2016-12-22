package cn.edu.njtech.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.edu.njtech.common.Page;
import cn.edu.njtech.dao.IOrderDAO;
import cn.edu.njtech.entity.OrderDetail;
import cn.edu.njtech.entity.Orders;
import cn.edu.njtech.service.IOrderService;

public class OrderServiceImpl implements IOrderService {
	private IOrderDAO orderDao;
	
	public IOrderDAO getOrderDao() {
		return orderDao;
	}

	public void setOrderDao(IOrderDAO orderDao) {
		this.orderDao = orderDao;
	}

	@Override
	public List<Orders> getOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> selectAllOrder(Page page) {
		// TODO Auto-generated method stub
		List<Orders> list=null;
		try {
			list=orderDao.selectAllOrder(page);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<OrderDetail> showOrderDetail(Map<String,Object> map){
		// TODO Auto-generated method stub
		List<OrderDetail> list=null;
		try {
			list=orderDao.showOrderDetail(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int UpdateOrderById(Orders o) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			result=orderDao.UpdateOrderById(o);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteOrderDetailById(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Orders> getOrderTable(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNum() {
		int result=0;
		try {
			result=orderDao.getNum();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
