package cn.edu.njtech.service;

import java.util.List;

import cn.edu.njtech.entity.Orders;

public interface IOrderService {
	public List<Orders> getOrder(int id);
	public List<Orders> selectAllOrder();
	public List<Orders> showOrderDetail(int id);
	public int deleteOrderById(int id);
	public int deleteOrderDetailById(int id);
	public List<Orders> getOrderTable(int id);
}
