package cn.edu.njtech.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.Foodtype;

/**
 * 
 * FileName: foodtype接口，food接口
 * 
 * @Description: 菜系DAO，菜品DAO
 * 
 * @author: 倪志敏，袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public interface IFoodDAO {
	// foodtype方法
	public List<Foodtype> selectAllFoodType(String name) throws SQLException;// 根据名字找所以菜系

	public int addFoodType(Foodtype ft) throws SQLException;// 添加菜系

	public int deleteFoodType(int id) throws SQLException;// 删除菜系

	public List<Foodtype> selectById(int id) throws SQLException;// 根据ID找菜系

	public int updateType(Foodtype ft) throws SQLException;// 修改菜系
	// food 方法

	public List<Food> selectAllFood(Map<String, Object> map)
			throws SQLException;// 查找所有菜品

	public int addFood(Food f) throws SQLException;// 添加菜品

	public int deleteFood(int id) throws SQLException;// 删除菜品

	public List<Food> selectFoodById(int id) throws SQLException;// 根据菜品ID找菜品

	public List<Food> selectFoodByTypeId(int id) throws SQLException;// 根据菜系ID找菜品

	public int updateFood(Food f) throws SQLException;// 修改菜品

	public List<Food> selectFoodByName(String name) throws SQLException;// 根据关键字找菜品

	public int getFoodNum(String name) throws SQLException;// 获取菜品名
}
