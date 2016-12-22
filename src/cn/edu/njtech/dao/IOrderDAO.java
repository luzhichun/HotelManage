package cn.edu.njtech.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import cn.edu.njtech.common.Page;
import cn.edu.njtech.entity.OrderDetail;
import cn.edu.njtech.entity.Orders;

/**
 * 
 * FileName: IOrderDAO
 * 
 * @Description: 订单DAO
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public interface IOrderDAO {
	/**
	 * 
	 * @param id
	 * @return 返回按id搜索的订单
	 * @throws SQLException
	 */
	public List<Orders> getOrder(int id) throws SQLException;
	/**
	 * 
	 * @param page
	 * @return 返回所有的订单
	 * @throws SQLException
	 */
	public List<Orders> selectAllOrder(Page page) throws SQLException;
	/**
	 * 
	 * @param map
	 * @return 返回搜索的订单详细
	 * @throws SQLException
	 */
	public List<OrderDetail> showOrderDetail(Map<String, Object> map)
			throws SQLException;
	/**
	 * 
	 * @param o
	 * @return 返回更新订单的结果
	 * @throws SQLException
	 */
	public int UpdateOrderById(Orders o) throws SQLException;
	/**
	 * 
	 * @param id
	 * @return 返回删除订单详细的结果
	 * @throws SQLException
	 */
	public int deleteOrderDetailById(int id) throws SQLException;
	/**
	 * 
	 * @param id
	 * @return 返回按餐桌id查询订单的搜素结果
	 * @throws SQLException
	 */
	public List<Orders> getOrderTable(int id) throws SQLException;
	/**
	 * 
	 * @return 返回总的订单数
	 */
	public int getNum();
}
