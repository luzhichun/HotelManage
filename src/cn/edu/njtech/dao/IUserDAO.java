package cn.edu.njtech.dao;

import java.sql.SQLException;
import java.util.List;

import cn.edu.njtech.entity.User;

public interface IUserDAO {
	public List<User> getUser(User u)throws SQLException;
}
