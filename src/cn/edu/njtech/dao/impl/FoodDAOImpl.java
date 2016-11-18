package cn.edu.njtech.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import cn.edu.njtech.dao.IFoodDAO;
import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.Foodtype;

public class FoodDAOImpl implements IFoodDAO{

	@Override
	public List<Foodtype> selectAllFoodType(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addFoodType(Foodtype ft) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFoodType(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Foodtype> selectById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateType(Foodtype ft) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Food> selectAllFood(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addFood(Food f) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteFood(int id) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Food> selectFoodById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Food> selectFoodByTypeId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateFood(Food f) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
