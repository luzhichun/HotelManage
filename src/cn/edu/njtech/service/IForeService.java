package cn.edu.njtech.service;

import java.util.List;
import java.util.Map;

import cn.edu.njtech.entity.Dinnertable;
import cn.edu.njtech.entity.Food;

public interface IForeService {
	public List<Dinnertable> getFreeTable(int currentPage);
	public int getFreeDinnerNum();
	public List<Food> showFoodMenu(Map<String,Object> map);
	public List<Food> showFoodMenuByTypeId(Map<String,Object> map);
}
