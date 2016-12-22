package cn.edu.njtech.mvc.action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;
import org.apache.struts2.interceptor.SessionAware;
import cn.edu.njtech.entity.User;
import cn.edu.njtech.service.IUserService;

import com.opensymphony.xwork2.ActionSupport;
@SuppressWarnings("serial")


/**
 * 
 * FileName: RegisterAction
 * 
 * @Description: 注册管理Action
 * 
 * @author: 刘明亮
 * 
 * @Createdate:2016/12/20
 * 
 * @version:1.0
 */
public class RegisterAction extends ActionSupport implements SessionAware{
	
	public IUserService userService;//创建服务
	private String name;//用户名称
	private int usertypeId;//用户类型
	private String pwd;//密码
	private String position;//职位
	public String checkName;//用户名称检验
	public String result;//结果
	
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}


	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public User getU() {
		return u;
	}

	public void setU(User u) {
		this.u = u;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	User u=new User();//创建User对象
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUsertypeId() {
		return usertypeId;
	}

	public void setUsertypeId(int usertypeId) {
		this.usertypeId = usertypeId;
	}


	public List<User> list;
	public Map<String,Object>session;
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	
	/**						
	
	* 注册时调用此方法	，获取注册的参数，名称、密码、用户类型					
							
	* @return String				
							
	* @throws Exception 				
							
	*/						

	public String register() throws Exception{
		u.setName(name);//获取名称
		u.setPwd(pwd);//获取 密码
		u.setUsertype(usertypeId);//获取用户类型
		if(userService.registerUser(u)>0){//根据user对象查询结果，如果结果大于0 ，则表示数据插入成功
			return SUCCESS;//如果数据插入成功，返回SUCCESS
		}else{
			return ERROR;//否则返回 ERROR
			}
		
	}
	/**						
	
	* 注册时检测用户名是否已经存在					
							
	*						
							
	* @param checkName,获取输入的名称					
							
	* @return String	
							
	*/						

	public String checkName() {
		Map<String, Object> chatroom = new HashMap<String, Object>();
			List<User> list = userService.selectUserByName(checkName);//根据输入 的名字调用selectUserByName方法，查询结果放入list中
			if (checkName.length() == 0) {
				chatroom.put("result", "登录名不能为空");//如果输入名称长度为0，提示登录名不能为空
			} else {
				if (list.size() > 0) {
					chatroom.put("result", "登录名已经存在");//如果list长度大于0，则用户名已经存在
				} 
			}
		JSONObject jo = JSONObject.fromObject(chatroom);
		this.result = jo.toString();
		return SUCCESS;
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}

}
