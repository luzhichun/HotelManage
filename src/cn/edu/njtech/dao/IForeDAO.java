package cn.edu.njtech.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.core.annotation.Order;

import cn.edu.njtech.entity.Dinnertable;
import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.Foodtype;
import cn.edu.njtech.entity.OrderDetail;
import cn.edu.njtech.entity.Orders;

/**
 * 
 * FileName: IForeDAO
 * 
 * @Description: 前台页面DAO
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public interface IForeDAO {
	public List<Dinnertable> getFreeTable(int currentPage)throws SQLException;
	public int getFreeDinnerNum()throws SQLException;
	public List<Food> showFoodMenu(Map<String,Object> map)throws SQLException;
	public List<Food> showFoodMenuByTypeId(Map<String,Object> map)throws SQLException;
	public Food selectByFoodId(int id)throws SQLException;
	public int updateTable(Dinnertable dt)throws SQLException;
	public int addOrders(Orders o)throws SQLException;
	public List<Dinnertable> selectByTableId(int id)throws SQLException;
	public List<Orders> selectordersByTableId(int id)throws SQLException;
	public int addOrderDetail(OrderDetail od)throws SQLException;
	public int updateDetail(OrderDetail od)throws SQLException;
	public int deleteDetail(OrderDetail od)throws SQLException;
	public List<OrderDetail> getOrderDetailByOrderId(OrderDetail od)throws SQLException;
	public List<OrderDetail> selectOrderDetailById(int id)throws SQLException;
	public int updateOrder(Orders o)throws SQLException;
	public int getFood()throws SQLException;
	public int getFoodByFoodType(int id)throws SQLException;
	public List<Foodtype> getFoodType(int currentPage) throws SQLException;
}
