package cn.edu.njtech.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.edu.njtech.dao.IDinnerTableDAO;
import cn.edu.njtech.entity.Dinnertable;

public class DinnerTableDAOImpl extends SqlMapClientDaoSupport implements IDinnerTableDAO{

	private IDinnerTableDAO dinnerTableDao;
	
	public IDinnerTableDAO getDinnerTableDao() {
		return dinnerTableDao;
	}

	public void setDinnerTableDao(IDinnerTableDAO dinnerTableDao) {
		this.dinnerTableDao = dinnerTableDao;
	}

	public List<Dinnertable> selectAll(String name) throws SQLException {
		// TODO Auto-generated method stub
		Dinnertable dt=new Dinnertable();
		dt.setTablename(name);
		return getSqlMapClientTemplate().queryForList("selectTable",dt);
	}

	@Override
	public int addTable(Dinnertable dt) throws SQLException {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().insert("insertTable", dt);
	}

	@Override
	public int deleteTable(int id) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().delete("deleteTable", id);
	}

	@Override
	public int updateTable(int id) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().update("updateTable", id);
	}

	@Override
	public List<Dinnertable> selectById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectTableById",id);
	}

}
