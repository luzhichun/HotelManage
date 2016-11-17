package cn.edu.njtech.service;

import java.util.List;

import cn.edu.njtech.entity.DinnerTable;

public interface IDinnerTableService {
	public List<DinnerTable> selectAll(String name);
	public int addTable(DinnerTable dt);
	public int deleteTable(int id);
	public int returnTable(int id);
	public List<DinnerTable> selectById(int id);
}
