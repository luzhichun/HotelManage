package cn.edu.njtech.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.edu.njtech.dao.IFoodDAO;
import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.Foodtype;

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
