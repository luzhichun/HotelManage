package cn.edu.njtech.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.Foodtype;

public interface IFoodDAO {
	public List<Foodtype> selectAllFoodType(String name)throws SQLException;
	public int addFoodType(Foodtype ft)throws SQLException;
	public int deleteFoodType(int id)throws SQLException;
	public List<Foodtype> selectById(int id)throws SQLException;
	public int updateType(Foodtype ft)throws SQLException;
	//food 方法
	public List<Food> selectAllFood(Map<String,Object> map)throws SQLException;
	public int addFood(Food f)throws SQLException;
	public int deleteFood(int id)throws SQLException;
	public List<Food> selectFoodById(int id)throws SQLException;
	public List<Food> selectFoodByTypeId(int id)throws SQLException;
	public int updateFood(Food f)throws SQLException;
	public List<Food> selectFoodByName(String name)throws SQLException;
	public int getFoodNum(String name)throws SQLException;
}
