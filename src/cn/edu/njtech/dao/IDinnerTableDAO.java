package cn.edu.njtech.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.njtech.entity.DinnerTable;
//ddd
public interface IDinnerTableDAO {
	public List<DinnerTable> selectAll(String name) throws SQLException;
	public int addTable(DinnerTable dt)throws SQLException;
	public int deleteTable(int id)throws SQLException;
	public int updateTable(int id)throws SQLException;
	public List<DinnerTable> selectById(int id) throws SQLException;
}
