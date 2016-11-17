package cn.edu.njtech.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.FoodType;

public interface IFoodDAO {
	public List<FoodType> selectAllFoodType(String name)throws SQLException;
	public int addFoodType(FoodType ft)throws SQLException;
	public int deleteFoodType(int id)throws SQLException;
	public List<FoodType> selectById(int id)throws SQLException;
	public int updateType(FoodType ft)throws SQLException;
	
	public List<Food> selectAllFood(String name)throws SQLException;
	public int addFood(Food f)throws SQLException;
	public int deleteFood(int id)throws SQLException;
	public List<Food> selectFoodById(int id)throws SQLException;
	public List<Food> selectFoodByTypeId(int id)throws SQLException;
	public int updateFood(Food f)throws SQLException;
}
