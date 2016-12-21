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
	public List<User> getUser(User u)throws SQLException;
	public int registerUser(User user)throws SQLException;
	public List<User>  selectUserByName(String name)throws SQLException;
}
