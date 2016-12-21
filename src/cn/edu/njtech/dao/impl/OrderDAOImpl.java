package cn.edu.njtech.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.edu.njtech.common.Page;
import cn.edu.njtech.dao.IOrderDAO;
import cn.edu.njtech.entity.OrderDetail;
import cn.edu.njtech.entity.Orders;

/**
 * 
 * FileName: OrderDAOImpl
 * 
 * @Description: 订单DAO实现类
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class OrderDAOImpl extends SqlMapClientDaoSupport implements IOrderDAO{
	@Override
	public List<Orders> getOrder(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Orders> selectAllOrder(Page page) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectAllOrder", page);
	}

	@Override
	public List<OrderDetail> showOrderDetail(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectOrderDetailByOrderId", map);
	}

	@Override
	public int UpdateOrderById(Orders o) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().update("updateOrders", o);
	}

	@Override
	public int deleteOrderDetailById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Orders> getOrderTable(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getNum() {
		return (int) getSqlMapClientTemplate().queryForList("getNum").get(0);
	}
	
}
