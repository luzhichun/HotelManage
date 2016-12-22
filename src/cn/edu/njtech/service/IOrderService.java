package cn.edu.njtech.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.edu.njtech.common.Page;
import cn.edu.njtech.entity.OrderDetail;
import cn.edu.njtech.entity.Orders;

/**
 * 
 * FileName: IOrderService
 * 
 * @Description: 订单Service
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public interface IOrderService {
	/**
	 * 
	 * @param id
	 * @return 返回按id搜索的订单
	 */
	public List<Orders> getOrder(int id);
	/**
	 * 
	 * @param page
	 * @return 返回所有的订单
	 */
	public List<Orders> selectAllOrder(Page page);
	/**
	 * 
	 * @param map
	 * @return 返回搜索的订单详细
	 */
	public List<OrderDetail> showOrderDetail(Map<String, Object> map);
	/**
	 * 
	 * @param o
	 * @return 返回更新订单的结果
	 */
	public int UpdateOrderById(Orders o);
	/**
	 * 
	 * @param id
	 * @return 返回删除订单详细的结果
	 */
	public int deleteOrderDetailById(int id);
	/**
	 * 
	 * @param id
	 * @return 返回按餐桌id查询订单的搜素结果
	 */
	public List<Orders> getOrderTable(int id);
	/**
	 * 
	 * @return 返回总的订单数
	 */
	public int getNum();
}
