package cn.edu.njtech.service;

import java.util.List;
import java.util.Map;

import cn.edu.njtech.entity.Dinnertable;


/**
 * 
 * FileName: IDinnerTableService
 * 
 * @Description: 餐桌Service接口
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public interface IDinnerTableService {
	public List<Dinnertable> selectAll(Map<String,Object> map);
	public int addTable(Dinnertable dt);
	public int deleteTable(int id);
	public int returnTable(int id);
	public List<Dinnertable> selectById(int id);
	public int getCounts(String name);
}
