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
	public List<Orders> getOrder(int id)throws SQLException;
	public List<Orders> selectAllOrder(Page page)throws SQLException;
	public List<OrderDetail> showOrderDetail(Map<String,Object> map)throws SQLException;
	public int UpdateOrderById(Orders o)throws SQLException;
	public int deleteOrderDetailById(int id)throws SQLException;
	public List<Orders> getOrderTable(int id)throws SQLException;
	public int getNum();
}
