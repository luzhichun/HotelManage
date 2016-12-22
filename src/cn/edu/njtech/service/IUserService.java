package cn.edu.njtech.service;

import java.sql.SQLException;
import java.util.List;

import cn.edu.njtech.entity.User;

/**
 * 
 * FileName: IUserService
 * 
 * @Description: 用户Service接口
 * 
 * @author:  袁鑫磊，刘明亮
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public interface IUserService {
	
	public List<User> getUser(User u);//根据用于在数据库中查询所有的用户	
	public int registerUser(User user);//注册用户的时候向数据库中插入一条用户数据		
	public List<User>  selectUserByName(String name);//注册时根据注册名查询数据库是否存在该用户名		
}
