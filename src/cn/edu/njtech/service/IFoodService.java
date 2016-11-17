package cn.edu.njtech.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.FoodType;

public interface IFoodService {
	public List<FoodType> selectAllFoodType(String name);
	public int addFoodType(FoodType ft);
	public int deleteFoodType(int id);
	public List<FoodType> selectById(int id);
	public int updateType(FoodType ft);
	
	
	public List<Food> selectAllFood(String name);
	public int addFood(Food f);
	public int deleteFood(int id);
	public List<Food> selectFoodById(int id);
	public int updateFood(Food f);
	public List<Food> selectFoodByTypeId(int id);
}
