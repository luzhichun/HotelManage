package cn.edu.njtech.service;

import java.util.List;
import java.util.Map;

import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.Foodtype;

/**
 * 
 * FileName: IFoodService
 * 
 * @Description: 菜IFoodService
 * 
 * @author: 倪志敏，袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public interface IFoodService {
	public List<Foodtype> selectAllFoodType(String name);
	public int addFoodType(Foodtype ft);
	public int deleteFoodType(int id);
	public List<Foodtype> selectById(int id);
	public int updateType(Foodtype ft);
	
	
	public List<Food> selectAllFood(Map<String,Object> map);
	public int addFood(Food f);
	public int deleteFood(int id);
	public List<Food> selectFoodById(int id);
	public int updateFood(Food f);
	public List<Food> selectFoodByTypeId(int id);
	public List<Food> selectFoodByName(String name);
	public int getFoodNum (String name);
}
