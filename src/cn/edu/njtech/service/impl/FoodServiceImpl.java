package cn.edu.njtech.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.edu.njtech.dao.IFoodDAO;
import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.Foodtype;
import cn.edu.njtech.service.IFoodService;

public class FoodServiceImpl implements IFoodService {
	private IFoodDAO dao;
	
	public IFoodDAO getDao() {
		return dao;
	}

	public void setDao(IFoodDAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Foodtype> selectAllFoodType(String name) {
		List<Foodtype> list=null;
		try {
			list= dao.selectAllFoodType(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addFoodType(Foodtype ft) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			i=dao.addFoodType(ft);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteFoodType(int id) {
		// TODO Auto-generated method stub
		int i =0;
		try {
			i=dao.deleteFoodType(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Foodtype> selectById(int id) {
		// TODO Auto-generated method stub
		List<Foodtype> list=null;
		try {
			list=dao.selectById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updateType(Foodtype ft) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			i=dao.updateType(ft);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<Food> selectAllFood(Map<String,Object> map) {
		// TODO Auto-generated method stub
		List<Food> list=null;
		try {
			list=dao.selectAllFood(map);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int addFood(Food f) {
		// TODO Auto-generated method stub
		int i =0;
		try {
			i=dao.addFood(f);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public int deleteFood(int id) {
		// TODO Auto-generated method stub
		int result =0;
		try {
			result=dao.deleteFood(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Food> selectFoodById(int id) {
		// TODO Auto-generated method stub
		List<Food> list=null;
		try {
			list=dao.selectFoodById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int updateFood(Food f) {
		// TODO Auto-generated method stub
		int result =0;
		try {
			result=dao.updateFood(f);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Food> selectFoodByTypeId(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> selectFoodByName(String name) {
		// TODO Auto-generated method stub
		List<Food> list=null;
		try {
			list=dao.selectFoodByName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int getFoodNum(String name) {
		// TODO Auto-generated method stub
		int result =0;
		try {
			result=dao.getFoodNum(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
