package cn.edu.njtech.mvc.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.SessionAware;

import cn.edu.njtech.common.Page;
import cn.edu.njtech.entity.Dinnertable;
import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.Foodtype;
import cn.edu.njtech.service.IFoodService;
import cn.edu.njtech.service.IForeService;

import com.opensymphony.xwork2.ActionSupport;

public class ForeMenuAction extends ActionSupport implements SessionAware{
	private IForeService foreService;
	private IFoodService foodService;
	public IFoodService getFoodService() {
		return foodService;
	}

	public void setFoodService(IFoodService foodService) {
		this.foodService = foodService;
	}
	private Map<String,Object> foreSession;
	private int tableId;
	private int OcurrentPage=1;
	private String foodName;
	
	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public int getOcurrentPage() {
		return OcurrentPage;
	}

	public void setOcurrentPage(int ocurrentPage) {
		OcurrentPage = ocurrentPage;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}
	public String result;
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public IForeService getForeService() {
		return foreService;
	}

	public void setForeService(IForeService foreService) {
		this.foreService = foreService;
	}
	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.foreSession=arg0;
	}
	public String getFreeTable(){
		Map<String, Object> chatroom = new HashMap<String, Object>();
		Page page=new Page(OcurrentPage,4);
		foreSession.put("OcurrentPage", OcurrentPage);
		List<Dinnertable> list = foreService.getFreeTable(page.getCurrentPage());
		int totalNum=foreService.getFreeDinnerNum();
		page.setTotalPage((totalNum-1)/page.getPageSize()+1);
		foreSession.put("OtotalPage", page.getTotalPage());
		chatroom.put("list", list);
		JSONObject jo = JSONObject.fromObject(chatroom);
		this.result = jo.toString();
		return SUCCESS;
	}
	public String menusList(){
		System.out.println(tableId);
		List<Foodtype> foodTypeList=foodService.selectAllFoodType("");
		foreSession.put("ftl", foodTypeList);
		Map<String,Object>map=new HashMap<String, Object>();
		if(foodName==null){
			foodName="";
		}
		map.put("foodName", foodName);
		map.put("currentPage", 1);
		map.put("pageSize", 6);
		List<Food> foodList=foreService.showFoodMenu(map);
		foreSession.put("foodList", foodList);
		return SUCCESS;
	}
}
