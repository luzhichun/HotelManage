package cn.edu.njtech.service;

import java.util.List;
import java.util.Map;

import cn.edu.njtech.common.Page;
import cn.edu.njtech.entity.OrderDetail;
import cn.edu.njtech.entity.Orders;

public interface IOrderService {
	public List<Orders> getOrder(int id);
	public List<Orders> selectAllOrder(Page page);
	public List<OrderDetail> showOrderDetail(Map<String,Object> map);
	public int UpdateOrderById(Orders o);
	public int deleteOrderDetailById(int id);
	public List<Orders> getOrderTable(int id);
}
