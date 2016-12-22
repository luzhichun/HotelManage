package cn.edu.njtech.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.edu.njtech.entity.Dinnertable;
import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.Foodtype;
import cn.edu.njtech.entity.OrderDetail;
import cn.edu.njtech.entity.Orders;

/**
 * 
 * FileName: IForeService
 * 
 * @Description: 前台Service
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public interface IForeService {
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回空闲餐桌的搜索结果
	 */
	public List<Dinnertable> getFreeTable(int currentPage);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回空闲餐桌数的搜索结果
	 */
	public int getFreeDinnerNum();
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回菜品的搜索结果
	 */
	public List<Food> showFoodMenu(Map<String, Object> map);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回按菜系id查询菜品的搜索结果
	 */
	public List<Food> showFoodMenuByTypeId(Map<String, Object> map);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回按菜品id的搜索结果
	 */
	public Food selectByFoodId(int id);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回更新餐桌的搜索结果
	 */
	public int updateTable(Dinnertable dt);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回添加订单的搜索结果
	 */
	public int addOrders(Orders o);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回按餐桌id查询餐桌的搜索结果
	 */
	public Dinnertable selectByTableId(int id);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回按餐桌id查询order的搜索结果
	 */
	public Orders selectordersByTableId(int id);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回添加订单详细的结果
	 */
	public int addOrderDetail(OrderDetail od);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回更新订单详细的结果
	 */
	public int updateDetail(OrderDetail od);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回删除订单详细的结果
	 */
	public int deleteDetail(OrderDetail od);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回按订单id搜索订单详细的搜索结果
	 */
	public List<OrderDetail> getOrderDetailByOrderId(OrderDetail od);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回餐桌的搜索结果
	 */
	public List<OrderDetail> selectOrderDetailById(int id);
	/**
	 * 	
	 * @param o
	 * @return 返回更新订单的结果
	 */
	public int updateOrder(Orders o);
	/**
	 * 
	 * @return 返回总的菜品的个数
	 */
	public int getFood();
	/**
	 * 
	 * @param id
	 * @return 返回菜系的总个数
	 */
	public int getFoodByFoodType(int id);
	/**
	 * 
	 * @param currentPage
	 * @return 返回菜系的搜索结果
	 */
	public List<Foodtype> getFoodType(int currentPage);
}
