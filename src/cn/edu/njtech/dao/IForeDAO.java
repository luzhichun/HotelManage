package cn.edu.njtech.dao;

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
 * FileName: IForeDAO
 * 
 * @Description: 前台DAO
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public interface IForeDAO {
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回空闲餐桌的搜索结果
	 * @throws 异常类型 SQLException
	 */
	public List<Dinnertable> getFreeTable(int currentPage) throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回空闲餐桌数的搜索结果
	 * @throws 异常类型 SQLException
	 */
	public int getFreeDinnerNum() throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回菜品的搜索结果
	 * @throws 异常类型 SQLException
	 */
	public List<Food> showFoodMenu(Map<String, Object> map) throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回按菜系id查询菜品的搜索结果
	 * @throws 异常类型 SQLException
	 */
	public List<Food> showFoodMenuByTypeId(Map<String, Object> map)
			throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回按菜品id的搜索结果
	 * @throws 异常类型 SQLException
	 */
	public Food selectByFoodId(int id) throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回更新餐桌的搜索结果
	 * @throws 异常类型 SQLException
	 */
	public int updateTable(Dinnertable dt) throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回添加订单的搜索结果
	 * @throws 异常类型 SQLException
	 */
	public int addOrders(Orders o) throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回按餐桌id查询餐桌的搜索结果
	 * @throws 异常类型 SQLException
	 */
	public List<Dinnertable> selectByTableId(int id) throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回按餐桌id查询order的搜索结果
	 * @throws 异常类型 SQLException
	 */
	public List<Orders> selectordersByTableId(int id) throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回添加订单详细的结果
	 * @throws 异常类型 SQLException
	 */
	public int addOrderDetail(OrderDetail od) throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回更新订单详细的结果
	 * @throws 异常类型 SQLException
	 */
	public int updateDetail(OrderDetail od) throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回删除订单详细的结果
	 * @throws 异常类型 SQLException
	 */
	public int deleteDetail(OrderDetail od) throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回按订单id搜索订单详细的搜索结果
	 * @throws 异常类型 SQLException
	 */
	public List<OrderDetail> getOrderDetailByOrderId(OrderDetail od)
			throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回餐桌的搜索结果
	 * @throws 异常类型 SQLException
	 */
	public List<OrderDetail> selectOrderDetailById(int id) throws SQLException;
	/**
	 * 	
	 * @param o
	 * @return 返回更新订单的结果
	 * @throws SQLException
	 */
	public int updateOrder(Orders o) throws SQLException;
	/**
	 * 
	 * @return 返回总的菜品的个数
	 * @throws SQLException
	 */
	public int getFood() throws SQLException;
	/**
	 * 
	 * @param id
	 * @return 返回菜系的总个数
	 * @throws SQLException
	 */
	public int getFoodByFoodType(int id) throws SQLException;
	/**
	 * 
	 * @param currentPage
	 * @return 返回菜系的搜索结果
	 * @throws SQLException
	 */
	public List<Foodtype> getFoodType(int currentPage) throws SQLException;
}
