package cn.edu.njtech.service;

import java.util.List;

import cn.edu.njtech.entity.Dinnertable;

public interface IDinnerTableService {
	public List<Dinnertable> selectAll(String name);
	public int addTable(Dinnertable dt);
	public int deleteTable(int id);
	public int returnTable(int id);
	public List<Dinnertable> selectById(int id);
}
