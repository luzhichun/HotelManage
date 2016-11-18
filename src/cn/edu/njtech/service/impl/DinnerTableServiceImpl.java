package cn.edu.njtech.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.edu.njtech.dao.IDinnerTableDAO;
import cn.edu.njtech.entity.Dinnertable;
import cn.edu.njtech.service.IDinnerTableService;

public class DinnerTableServiceImpl implements IDinnerTableService{
	private IDinnerTableDAO dinnerTableDao;
	
	public IDinnerTableDAO getDinnerTableDao() {
		return dinnerTableDao;
	}
	public void setDinnerTableDao(IDinnerTableDAO dinnerTableDao) {
		this.dinnerTableDao = dinnerTableDao;
	}
	@Override
	public List<Dinnertable> selectAll(String name) {
		// TODO Auto-generated method stub
		List<Dinnertable>list=null;
		try {
			 list=dinnerTableDao.selectAll(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return list;
	}
	@Override
	public int addTable(Dinnertable dt) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			result=dinnerTableDao.addTable(dt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public int deleteTable(int id) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			result=dinnerTableDao.deleteTable(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public int returnTable(int id) {
		// TODO Auto-generated method stub
		int result=0;
		try {
			result=dinnerTableDao.updateTable(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	@Override
	public List<Dinnertable> selectById(int id) {
		// TODO Auto-generated method stub
		List<Dinnertable> list=null;
		try {
			list=dinnerTableDao.selectById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
