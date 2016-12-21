package cn.edu.njtech.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.edu.njtech.dao.IForeDAO;
import cn.edu.njtech.entity.Dinnertable;
import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.Foodtype;
import cn.edu.njtech.entity.OrderDetail;
import cn.edu.njtech.entity.Orders;

/**
 * 
 * FileName: ForeDAOImpl
 * 
 * @Description: 前台页面DAO实现类
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class ForeDAOImpl extends SqlMapClientDaoSupport implements IForeDAO{
	private IForeDAO foreDao;
	
	public IForeDAO getForeDao() {
		return foreDao;
	}

	public void setForeDao(IForeDAO foreDao) {
		this.foreDao = foreDao;
	}

	@Override
	public List<Dinnertable> getFreeTable(int currentPage) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getFreeTable",currentPage);
	}

	@Override
	public int getFreeDinnerNum() throws SQLException {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().queryForList("getFreeTableNum").get(0);
	}

	@Override
	public List<Food> showFoodMenu(Map<String, Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("showFoodMenu", map);
	}

	@Override
	public List<Food> showFoodMenuByTypeId(Map<String, Object> map)
			throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("showFoodMenuByTypeId", map);
	}

	@Override
	public Food selectByFoodId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return (Food) getSqlMapClientTemplate().queryForList("selectByFoodId", id).get(0);
	}

	@Override
	public int updateTable(Dinnertable dt) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().update("updateDinnerTable", dt);
	}

	@Override
	public int addOrders(Orders o) throws SQLException {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().insert("addOrder", o);
	}

	@Override
	public List<Dinnertable> selectByTableId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectByTableId", id);
	}
	@Override
	public List<Orders> selectordersByTableId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectOrderByTableId",id);
	}

	@Override
	public int addOrderDetail(OrderDetail od) throws SQLException {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().insert("addOrderDetail", od);
	}

	@Override
	public int updateDetail(OrderDetail od) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().update("updateDetail", od);
	}

	@Override
	public int deleteDetail(OrderDetail od) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().delete("deleteDetailByFoodId", od);
	}

	@Override
	public List<OrderDetail> getOrderDetailByOrderId(OrderDetail od)
			throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectDetailByOrderIdAndFoodId", od);
	}

	@Override
	public List<OrderDetail> selectOrderDetailById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectOrderDetail", id);
	}

	@Override
	public int updateOrder(Orders o) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().update("updateOrders", o);
	}

	@Override
	public int getFood() throws SQLException {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().queryForList("FoodSize").get(0);
	}

	@Override
	public int getFoodByFoodType(int id) throws SQLException {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().queryForList("FoodSizeByFoodType", id).get(0);
	}

	@Override
	public List<Foodtype> getFoodType(int currentPage) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("getFoodType", currentPage);
	}

}
