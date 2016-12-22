package cn.edu.njtech.service;

import java.util.List;
import java.util.Map;
import cn.edu.njtech.entity.Dinnertable;
/**
 * 
 * FileName: IDinnerTableService
 * 
 * @Description: 餐桌Service
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public interface IDinnerTableService {
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回餐桌的搜索结果
	 */
	public List<Dinnertable> selectAll(Map<String, Object> map);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回添加餐桌的结果
	 */
	public int addTable(Dinnertable dt);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回删除餐桌的结果
	 */
	public int deleteTable(int id);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回更新餐桌的结果
	 */
	public int returnTable(int id);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回按id搜素餐桌的结果
	 */
	public List<Dinnertable> selectById(int id);
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回总餐桌数的结果
	 */
	public int getCounts(String name);
}
