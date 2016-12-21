package cn.edu.njtech.service;

import java.util.List;

import cn.edu.njtech.entity.User;

/**
 * 
 * FileName: IUserService
 * 
 * @Description: 用户Service接口
 * 
 * @author: 刘明亮
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public interface IUserService {
	public List<User> getUser(User u);
	public int registerUser(User user);
	public List<User>  selectUserByName(String name);
}
