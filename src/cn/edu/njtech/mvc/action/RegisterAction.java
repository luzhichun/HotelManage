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
public class RegisterAction extends ActionSupport implements SessionAware{
	public IUserService userService;
	private String name;
	private int usertypeId;
	private String pwd;
	private String position;
	public String checkName;
	public String cname;
	public String result;
	public String checkPwdName;
	public String cpwd;
	
	
	
	public String getCpwd() {
		return cpwd;
	}

	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}

	public String getCheckPwdName() {
		return checkPwdName;
	}

	public void setCheckPwdName(String checkPwdName) {
		this.checkPwdName = checkPwdName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
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


	User u=new User();
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
	public String register() throws Exception{
		u.setName(name);
		u.setPwd(pwd);
		u.setUsertype(usertypeId);
		u.setPosition(position);
		System.out.println(u);
		if(userService.registerUser(u)>0){
//			HttpServletResponse response = ServletActionContext.getResponse();			
//			response.setContentType("text/html; charset=UTF-8"); //转码
//			PrintWriter out = response.getWriter();
//			out.flush();
//			out.println("<script>");
//			out.println("alert('您已成功注册，请登陆！');");
//			out.println("</script>");
			return SUCCESS;
		}else{
			return ERROR;
			}
		
	}

	public String checkName() {
		Map<String, Object> chatroom = new HashMap<String, Object>();
		
			List<User> list = userService.selectUserByName(checkName);
			for(int i =0;i<list.size();i++){
				System.out.println(list.get(i));
			}
			if (checkName.length() == 0) {
				chatroom.put("result", "登录名不能为空");
			} else {
				if (list.size() > 0) {
					chatroom.put("result", "登录名已经存在");
				} 
			}
		
		JSONObject jo = JSONObject.fromObject(chatroom);
		this.result = jo.toString();
		return SUCCESS;
	}
	public String checkPwd() {
		Map<String, Object> chatroom = new HashMap<String, Object>();
		System.out.println(checkPwdName);
		System.out.println(cpwd);
		
			if (!checkPwdName.trim().equals(cpwd.trim())) {
				chatroom.put("result", "两次输入不同，密码不可用");
			}
			if (checkPwdName.length() == 0) {
				chatroom.put("result", "密码不能为空");
			} else{
				chatroom.put("result", "两次输入相同，密码可用");
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
