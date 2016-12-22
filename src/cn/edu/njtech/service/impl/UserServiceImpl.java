package cn.edu.njtech.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.edu.njtech.dao.IUserDAO;
import cn.edu.njtech.entity.User;
import cn.edu.njtech.service.IUserService;

/**
 * 
 * FileName: UserServiceImpl
 * 
 * @Description: 用户Service接口实现类
 * 
 * @author: 刘明亮
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class UserServiceImpl implements IUserService {
	private IUserDAO userDao;//创建DAO对象
	
	public IUserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	/**						
	
	* 根据用于在数据库中查询所有的用户					
							
	*						
							
	* @param user对象，查询的关键字					
							
	* @return List					
							
	* @throws SQLException	数据库操作异常				
							
	*/						
		
	@Override
	public List<User> getUser(User u) {
		// TODO Auto-generated method stub
		List<User> list=null;
		try {
			list=userDao.getUser(u);//查询所有的用户
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;//返回结果
	}

	
	/**						
	
	* 注册用户的时候向数据库中插入一条用户数据					
							
	*						
							
	* @param user对象，插入的关键字					
							
	* @return int					
							
	* @throws SQLException	数据库操作异常				
							
	*/	
	@Override
	public int registerUser(User user) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			i=userDao.registerUser(user);//插入用户
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;//返回数据操作结果
	}

	
	
	/**						
	
	* 注册时根据注册名查询数据库是否存在该用户名				
							
	*						
							
	* @param name，数据库查询关键字					
							
	* @return List					
							
	* @throws SQLException	数据库操作异常				
							
	*/		
	@Override
	public List<User> selectUserByName(String name) {
		// TODO Auto-generated method stub
		List<User> list=null;
		try {
			list=userDao.selectUserByName(name);//调用selectUserByName方法，根据输入name查询用户
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;//返回数据操作结果
	}

}
