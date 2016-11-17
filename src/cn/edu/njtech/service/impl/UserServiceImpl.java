package cn.edu.njtech.service.impl;

import java.sql.SQLException;
import java.util.List;

import cn.edu.njtech.dao.IUserDAO;
import cn.edu.njtech.entity.User;
import cn.edu.njtech.service.IUserService;

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

}
