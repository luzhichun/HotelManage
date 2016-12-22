package cn.edu.njtech.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import cn.edu.njtech.entity.Dinnertable;

/**
 * 
 * FileName: IDinnerTableDAO
 * 
 * @Description: 餐桌DAO
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public interface IDinnerTableDAO {
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回餐桌的搜索结果
	 * @throws 异常类型 SQLException
	 */
	public List<Dinnertable> selectAll(Map<String, Object> map)
			throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回添加餐桌的结果
	 * @throws 异常类型 SQLException
	 */
	public int addTable(Dinnertable dt) throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回删除餐桌的结果
	 * @throws 异常类型 SQLException
	 */
	public int deleteTable(int id) throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回更新餐桌的结果
	 * @throws 异常类型 SQLException
	 */
	public int updateTable(int id) throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回按id搜素餐桌的结果
	 * @throws 异常类型 SQLException
	 */
	public List<Dinnertable> selectById(int id) throws SQLException;
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回总餐桌数的结果
	 * @throws 异常类型 SQLException
	 */
	public int getDinnerNum(String name) throws SQLException;
}
