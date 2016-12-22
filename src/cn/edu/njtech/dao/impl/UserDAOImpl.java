package cn.edu.njtech.dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import cn.edu.njtech.dao.IUserDAO;
import cn.edu.njtech.entity.User;

/**
 * 
 * FileName: UserDAOImpl
 * 
 * @Description: 用户DAO实现类
 * 
 * @author: 刘明亮
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class UserDAOImpl extends SqlMapClientDaoSupport implements IUserDAO {

	
	/**						
	
	* 根据用于在数据库中查询所有的用户					
							
	*						
							
	* @param user对象，查询的关键字					
							
	* @return List					
							
	* @throws SQLException	数据库操作异常				
							
	*/						
							

	@Override
	public List<User> getUser(User u) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectUser", u);
	}

	/**						
	
	* 注册用户的时候向数据库中插入一条用户数据					
							
	*						
							
	* @param user对象，插入的关键字					
							
	* @return int					
							
	* @throws SQLException	数据库操作异常				
							
	*/						
				
	@Override
	public int registerUser(User user) throws SQLException {
		// TODO Auto-generated method stub
		return (int) getSqlMapClientTemplate().insert("insertUser", user);
	}
	
	/**						
	
	* 注册时根据注册名查询数据库是否存在该用户名				
							
	*						
							
	* @param name，数据库查询关键字					
							
	* @return List					
							
	* @throws SQLException	数据库操作异常				
							
	*/		
	@Override
	public  List<User> selectUserByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return getSqlMapClientTemplate().queryForList("selectUsertypeByName", name);
	}

}
