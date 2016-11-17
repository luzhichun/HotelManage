package cn.edu.njtech.service;

import java.util.List;

import cn.edu.njtech.entity.Order;
import cn.edu.njtech.entity.OrderBean;

public interface IOrderService {
	public List<Order> getOrder(int id);
	public List<Order> selectAllOrder();
	public List<OrderBean> showOrderDetail(int id);
	public int deleteOrderById(int id);
	public int deleteOrderDetailById(int id);
	public List<Order> getOrderTable(int id);
}
