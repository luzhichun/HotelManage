package cn.edu.njtech.mvc.action;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import cn.edu.njtech.entity.User;
import cn.edu.njtech.service.IUserService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * FileName: LoginAction
 * 
 * @Description: 登录Action
 * 
 * @author: 袁鑫磊，刘明亮
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class LoginAction extends ActionSupport implements ModelDriven<User> ,SessionAware{
	public IUserService userService;//创建User服务
	private User u=new User();//创建user对象
	public List<User> list;//创建user的list
	public Map<String,Object>session;
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	
	/**						
	
	* 登录时调用此方法，验证登录名和密码的正确性						
							
	*						
							
	* @return String					
							
	* @throws Exception				
							
	*/						
							
	public String login() throws Exception{
		list=userService.getUser(u);//查询所有的用户
		if(list.size()==0){//如果list的长度为0表示数据库中不存在该用户
			HttpServletResponse response = ServletActionContext.getResponse();			
			response.setContentType("text/html; charset=UTF-8"); //转码
			PrintWriter out = response.getWriter();
			out.flush();
			out.println("<script>");
			out.println("alert('用户名或密码错误，请重新登陆！');");
			out.println("</script>");
			return ERROR;
		}
		User getUser=list.get(0);
		if(getUser==null){
			return ERROR;
		}
		if(getUser.getUsertype()==2){//如果用户类型是2，表示是顾客
			return "fore";
		}
		if(u.getPwd().equals(getUser.getPwd())){
			session.put("User", getUser);
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	public String returnSystem(){
		session.remove("User");
		return SUCCESS;
	}
	@Override
	public User getModel() {
		// TODO Auto-generated method stub
		return this.u;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}

}
