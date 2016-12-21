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
	private IUserDAO userDao;
	
	public IUserDAO getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public List<User> getUser(User u) {
		// TODO Auto-generated method stub
		List<User> list=null;
		try {
			list=userDao.getUser(u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public int registerUser(User user) {
		// TODO Auto-generated method stub
		int i=0;
		try {
			i=userDao.registerUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public List<User> selectUserByName(String name) {
		// TODO Auto-generated method stub
		List<User> list=null;
		try {
			list=userDao.selectUserByName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
