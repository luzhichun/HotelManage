package cn.edu.njtech.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.njtech.entity.User;

/**
 * 
 * FileName: IUserDAO
 * 
 * @Description: 用户DAO
 * 
 * @author: 刘明亮
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public interface IUserDAO {
	public List<User> getUser(User u)throws SQLException;//根据用于在数据库中查询所有的用户	
	public int registerUser(User user)throws SQLException;//注册用户的时候向数据库中插入一条用户数据		
	public List<User>  selectUserByName(String name)throws SQLException;//注册时根据注册名查询数据库是否存在该用户名		
}
