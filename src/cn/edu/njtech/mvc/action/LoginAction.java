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
public class LoginAction extends ActionSupport implements ModelDriven<User> ,SessionAware{
	public IUserService userService;
	private User u=new User();
	public List<User> list;
	public Map<String,Object>session;
	
	public IUserService getUserService() {
		return userService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	}
	public String login() throws Exception{
		list=userService.getUser(u);
		if(list.size()==0){
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
		if(getUser.getUsertype()==2){
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
