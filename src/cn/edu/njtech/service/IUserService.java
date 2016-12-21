package cn.edu.njtech.service;

import java.util.List;

import cn.edu.njtech.entity.User;

public interface IUserService {
	public List<User> getUser(User u);
	public int registerUser(User user);
	public List<User>  selectUserByName(String name);
}
