package cn.edu.njtech.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.njtech.entity.Dinnertable;


/**
 * 
 * @author liumingliang
 *
 */
public interface IDinnerTableDAO {
	public List<Dinnertable> selectAll(String name) throws SQLException;
	public int addTable(Dinnertable dt)throws SQLException;
	public int deleteTable(int id)throws SQLException;
	public int updateTable(int id)throws SQLException;
	public List<Dinnertable> selectById(int id) throws SQLException;
}
