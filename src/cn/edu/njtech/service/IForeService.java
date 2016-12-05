package cn.edu.njtech.service;

import java.util.List;
import java.util.Map;

import cn.edu.njtech.entity.Dinnertable;
import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.OrderDetail;
import cn.edu.njtech.entity.Orders;

public interface IForeService {
	public List<Dinnertable> getFreeTable(int currentPage);

	public int getFreeDinnerNum();

	public List<Food> showFoodMenu(Map<String, Object> map);

	public List<Food> showFoodMenuByTypeId(Map<String, Object> map);

	public Food selectByFoodId(int id);

	public int updateTable(Dinnertable dt);

	public int addOrders(Orders o);

	public Dinnertable selectByTableId(int id);

	public Orders selectordersByTableId(int id);

	public int addOrderDetail(OrderDetail od);

	public int updateDetail(OrderDetail od);

	public int deleteDetail(OrderDetail od);

	public List<OrderDetail> getOrderDetailByOrderId(OrderDetail od);

	public List<OrderDetail> selectOrderDetailById(int id);

	public int updateOrder(Orders o);
}
