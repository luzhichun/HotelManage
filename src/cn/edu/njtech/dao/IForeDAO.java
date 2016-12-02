package cn.edu.njtech.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.edu.njtech.entity.Dinnertable;
import cn.edu.njtech.entity.Food;

public interface IForeDAO {
	public List<Dinnertable> getFreeTable(int currentPage)throws SQLException;
	public int getFreeDinnerNum()throws SQLException;
	public List<Food> showFoodMenu(Map<String,Object> map)throws SQLException;
	public List<Food> showFoodMenuByTypeId(Map<String,Object> map)throws SQLException;
}
