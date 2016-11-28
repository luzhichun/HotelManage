package cn.edu.njtech.mvc.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.edu.njtech.entity.Dinnertable;
import cn.edu.njtech.entity.Foodtype;
import cn.edu.njtech.service.IDinnerTableService;
import cn.edu.njtech.service.IFoodService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class FoodKindAction extends ActionSupport implements ModelDriven<Foodtype>,SessionAware{
	
	private IFoodService foodService;
	private Map<String , Object> foodtypesession;
	private String keyword;
	private Foodtype foodtype=new Foodtype();
	@Override
	public void setSession(Map<String, Object> arg0) {
		
	}

	@Override
	public Foodtype getModel() {
		return null;
	}
	
}
