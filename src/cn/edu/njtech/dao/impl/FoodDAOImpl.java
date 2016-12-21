package cn.edu.njtech.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.edu.njtech.dao.IFoodDAO;
import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.Foodtype;

/**
 * 
 * FileName: FoodDAOImpl
 * 
 * @Description: 菜系以及菜品DAO实现类
 * 
 * @author: 倪志敏
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class FoodDAOImpl extends SqlMapClientDaoSupport implements IFoodDAO{
	private  IFoodDAO foodDao;
	
	public IFoodDAO getFoodDao() {
		return foodDao;
	}

	public void setFoodDao(IFoodDAO foodDao) {
		this.foodDao = foodDao;
	}

	@Override
	public List<Foodtype> selectAllFoodType(String name) throws SQLException {
		// TODO Auto-generated method stub
		Foodtype dt=new Foodtype();
		dt.setTypename(name);
		return getSqlMapClientTemplate().queryForList("selectfoodtype",dt);
	}

	@Override
	public int addFoodType(Foodtype ft) throws SQLException {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().insert("insertfoodtype", ft);
	}

	@Override
	public int deleteFoodType(int id) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().delete("deletefoodtype", id);
	}

	@Override
	public List<Foodtype> selectById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectfoodtypeById",id);	
	}

	@Override
	public int updateType(Foodtype ft) throws SQLException {
		return getSqlMapClientTemplate().update("updatefoodtype", ft);
	}

	@Override
	public List<Food> selectAllFood(Map<String,Object> map) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectAll",map);
	}

	@Override
	public int addFood(Food f) throws SQLException {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().insert("addFood", f);
	}

	@Override
	public int deleteFood(int id) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().delete("deleteFood", id);
	}

	@Override
	public List<Food> selectFoodById(int id) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectById", id);
	}

	@Override
	public List<Food> selectFoodByTypeId(int id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateFood(Food f) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().update("updateFood", f);
	}

	@Override
	public List<Food> selectFoodByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectFoodByName", name);
	}

	@Override
	public int getFoodNum(String name) throws SQLException {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().queryForList("getFoodNum", name).get(0);
	}

	

}
