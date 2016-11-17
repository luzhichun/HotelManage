package cn.edu.njtech.mvc.filter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

public class EncodingFilter implements Filter {
	private String charset= "" ; 
	public void init(FilterConfig filterConfig) throws ServletException {
		this.charset = filterConfig.getInitParameter("charset");
	}
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//类型转换
		HttpServletRequest request= (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		//System.out.println(request.getClass());
		if(request.getMethod().equals("POST")) {			
			request.setCharacterEncoding("utf-8");
			chain.doFilter(request, response);
		}else{
			request = new MyRequest(request);
			chain.doFilter(request, response);
		}
	}
	public void destroy() {
		
	}
	
	
	class MyRequest extends HttpServletRequestWrapper{
		private HttpServletRequest request ; 
		public MyRequest(HttpServletRequest request) {
			super(request);
			this.request = request ;
		}
		@Override
		public String getParameter(String name) {
			return  this.getParameterValues(name)==null?"":this.getParameterValues(name)[0];
		}
		@Override
		public String[] getParameterValues(String name) {
			if(name==null||name.trim().equals("")) {
				return null ; 
			}
			String[] values = request.getParameterValues(name);
			if(values!=null) {
				System.out.println(values.length);
				for(int i = 0 ;i<values.length;i++) {
					try {
						values[i] = new String(values[i].getBytes("iso-8859-1"),charset);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}
			}
			return values;
		}
	}
}
