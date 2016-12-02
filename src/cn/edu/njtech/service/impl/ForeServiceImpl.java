package cn.edu.njtech.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.edu.njtech.dao.IForeDAO;
import cn.edu.njtech.entity.Dinnertable;
import cn.edu.njtech.entity.Food;
import cn.edu.njtech.service.IForeService;

public class ForeServiceImpl implements IForeService{
	private IForeDAO foreDao;
	
	public IForeDAO getForeDao() {
		return foreDao;
	}

	public void setForeDao(IForeDAO foreDao) {
		this.foreDao = foreDao;
	}
	@Override
	public List<Dinnertable> getFreeTable(int currentPage) {
		// TODO Auto-generated method stub
		List<Dinnertable> list=null;
		try {
			list=foreDao.getFreeTable(currentPage);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getFreeDinnerNum() {
		// TODO Auto-generated method stub
		int result=0;
		try {
			result=foreDao.getFreeDinnerNum();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Food> showFoodMenu(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Food> list=null;
		try {
			list=foreDao.showFoodMenu(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Food> showFoodMenuByTypeId(Map<String, Object> map) {
		// TODO Auto-generated method stub
		List<Food> list=null;
		try {
			list=foreDao.showFoodMenuByTypeId(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
