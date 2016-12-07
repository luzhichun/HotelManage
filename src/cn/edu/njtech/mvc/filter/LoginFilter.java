package cn.edu.njtech.mvc.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.edu.njtech.entity.User;

public class LoginFilter implements Filter {
	@Override
	public void destroy() {
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) resp;
		String path = request.getRequestURI();
		//System.out.println(path);
		User u=(User) request.getSession().getAttribute("User");
		if(path.contains("login.jsp")||path.contains("wdetail")||path.contains("login")||path.contains("fore.jsp")){
			chain.doFilter(request, response);
			return;
		}else{
			if(u==null||u.getUsertype()!=1){
				response.sendRedirect("login.jsp");
			}else{
				chain.doFilter(request, response);
			}
		}
//		if(path.contains("login.jsp")){
//			chain.doFilter(request, response);
//			return;
//		}else{
//			if(u==null){
//				response.sendRedirect("login.jsp");
//			}else{
//				chain.doFilter(request, response);
//			}
//		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
