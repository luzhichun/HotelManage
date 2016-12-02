package cn.edu.njtech.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.edu.njtech.dao.IForeDAO;
import cn.edu.njtech.entity.Dinnertable;
import cn.edu.njtech.entity.Food;

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

}
