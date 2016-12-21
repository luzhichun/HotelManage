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
	public List<Dinnertable> selectAll(Map<String,Object> map) throws SQLException;
	public int addTable(Dinnertable dt)throws SQLException;
	public int deleteTable(int id)throws SQLException;
	public int updateTable(int id)throws SQLException;
	public List<Dinnertable> selectById(int id) throws SQLException;
	public int getDinnerNum(String name) throws SQLException;
}
