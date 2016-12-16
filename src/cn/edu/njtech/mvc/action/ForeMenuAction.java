package cn.edu.njtech.mvc.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.struts2.interceptor.SessionAware;

import cn.edu.njtech.common.Page;
import cn.edu.njtech.entity.Dinnertable;
import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.Foodtype;
import cn.edu.njtech.entity.OrderDetail;
import cn.edu.njtech.entity.Orders;
import cn.edu.njtech.service.IFoodService;
import cn.edu.njtech.service.IForeService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class ForeMenuAction extends ActionSupport implements ModelDriven<OrderDetail>, SessionAware{
	private IForeService foreService;
	private IFoodService foodService;
	private int type=0;
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

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
	private int foodtypeid;
	private int foodId;
	private int oid;
	private OrderDetail od=new OrderDetail();
	private double totalPay=0;
	private int FFcurrentPage=1;
	private int FTcurrentPage=1;
	
	public int getFTcurrentPage() {
		return FTcurrentPage;
	}

	public void setFTcurrentPage(int fTcurrentPage) {
		FTcurrentPage = fTcurrentPage;
	}

	public int getFFcurrentPage() {
		return FFcurrentPage;
	}

	public void setFFcurrentPage(int fFcurrentPage) {
		FFcurrentPage = fFcurrentPage;
	}

	@Override
	public OrderDetail getModel() {
		// TODO Auto-generated method stub
		return od;
	}
	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public int getFoodtypeid() {
		return foodtypeid;
	}

	public void setFoodtypeid(int foodtypeid) {
		this.foodtypeid = foodtypeid;
	}

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
	public String getFoodType(){
		Map<String, Object> chatroom = new HashMap<String, Object>();
		Page typePage=new Page(1, 4);
		typePage.setCurrentPage(FTcurrentPage);
		List<Foodtype> foodTypeList=foreService.getFoodType(typePage.getCurrentPage());
		int total=foodService.selectAllFoodType("").size();
		foreSession.put("FTtotalPage",(total-1)/typePage.getPageSize()+1);
		System.out.println();
		foreSession.put("FTcurrentPage", FTcurrentPage);
		chatroom.put("list", foodTypeList);
		JSONObject jo = JSONObject.fromObject(chatroom);
		this.result = jo.toString();
		return SUCCESS;
	}
	public String menusList(){
		System.out.println(tableId);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		String date=sdf.format(new Date());
		//判断餐桌的状态 要是餐桌的状态空闲就更新
		Dinnertable checkDt=foreService.selectByTableId(tableId);
		if(checkDt==null){
			//更新餐桌
			System.out.println("11111");
			Dinnertable dt=new Dinnertable();
			dt.setTableId(tableId);
			dt.setOrderDate(date);
			dt.setTableStatus(1);
			foreService.updateTable(dt);
		}
		//判断订单的状态 如果订单已存在并且未结账就不用创建
		Orders checkO=foreService.selectordersByTableId(tableId);
		if(checkO==null){
			//创建order
			System.out.println("12121");
			Orders o=new Orders();
			o.setOrderDate(date);
			o.setTableId(tableId);
			o.setOrderStatus(0);
			o.setTotalPrice(0.0);
			foreService.addOrders(o);
		}
		Page typePage=new Page(1, 4);
		List<Foodtype> foodTypeList=foreService.getFoodType(typePage.getCurrentPage());
		int total=foodService.selectAllFoodType("").size();
		foreSession.put("FTtotalPage",(total-1)/typePage.getPageSize()+1);
		foreSession.put("FTcurrentPage", FTcurrentPage);
		foreSession.put("ftl", foodTypeList);
		Map<String,Object>map=new HashMap<String, Object>();
		if(foodName==null){
			foodName="";
		}
		System.out.println(foodName+"11111");
		Page page=new Page(1, 6);
		page.setCurrentPage(FFcurrentPage);
		map.put("foodName", foodName);
		map.put("currentPage",page.getCurrentPage());
		map.put("pageSize",page.getPageSize());
		List<Food> foodList=foreService.showFoodMenu(map);
		int ffsize=foreService.getFood();
		page.setTotalPage((ffsize-1)/page.getPageSize()+1);
		foreSession.put("FFtotalPage", page.getTotalPage());
		foreSession.put("foodList", foodList);
		foreSession.put("FFcurrentPage",FFcurrentPage);
		foreSession.put("type",type);
		return SUCCESS;
	}
	public String menusByType(){
		Map<String,Object>map=new HashMap<String, Object>();
		if(foodName==null){
			foodName="";
		}
		Page page=new Page(1, 6);
		page.setCurrentPage(FFcurrentPage);
		map.put("foodName", foodName);
		map.put("currentPage",page.getCurrentPage());
		map.put("pageSize",page.getPageSize());
		map.put("foodType_id", foodtypeid);
		int ffsize=foreService.getFoodByFoodType(foodtypeid);
		page.setTotalPage((ffsize-1)/page.getPageSize()+1);
		List<Food> foodList=foreService.showFoodMenuByTypeId(map);
		foreSession.put("foodList", foodList);
		foreSession.put("FFtotalPage", page.getTotalPage());
		foreSession.put("FFcurrentPage",FFcurrentPage);
		foreSession.put("type",type);
		return SUCCESS;
	}
	public String foodInformation(){
		Food food=foreService.selectByFoodId(foodId);
		foreSession.put("sFood", food);
		System.out.println(food);
		return SUCCESS;
	}
	public String addFoodByShopping(){
		return SUCCESS;
	}
	public String createOrderDetail(){
		Orders checkO=foreService.selectordersByTableId(tableId);
		oid=checkO.getOrdersId();
		OrderDetail od=new OrderDetail();
		od.setFood_id(foodId);
		od.setOrderId(checkO.getOrdersId());
		od.setFoodCount(1);
		List<OrderDetail> list=foreService.getOrderDetailByOrderId(od);
		if(list.size()==0){
			//如果没有就创建
			foreService.addOrderDetail(od);
		}else{
			OrderDetail ood=list.get(0);
			if(foodId==ood.getFood_id()){
				//如果菜品是一样的就改变菜的数量如果不一样就创建详细
				ood.setFoodCount(ood.getFoodCount()+1);
				foreService.updateDetail(ood);
			}else{
				foreService.addOrderDetail(od);
			}
		}
		return SUCCESS;
	}
	public String dealOrderDetail(){
		List<OrderDetail> odlist=foreService.selectOrderDetailById(oid);
		totalPay=0;
		for (OrderDetail orderDetail : odlist) {
			totalPay=orderDetail.getPrice()*orderDetail.getFoodCount()+totalPay;
		}
		foreSession.put("odList", odlist);
		foreSession.put("totalPay", totalPay);
		return SUCCESS;
	}
	public String changeCount(){
		System.out.println(od);
		foreService.updateDetail(od);
		List<OrderDetail> odlist=foreService.selectOrderDetailById(od.getOrderId());
		totalPay=0;
		for (OrderDetail orderDetail : odlist) {
			totalPay=orderDetail.getPrice()*orderDetail.getFoodCount()+totalPay;
		}
		Map<String, Object> chatroom = new HashMap<String, Object>();
		chatroom.put("totalPay", totalPay);
		JSONObject jo = JSONObject.fromObject(chatroom);
		this.result = jo.toString();
		return SUCCESS;
	}
	public String deleteDetail(){
		System.out.println(od);
		foreService.deleteDetail(od);
		return SUCCESS;
	}
	public String createOrder(){
		Orders o=new Orders();
		o.setOrdersId(oid);
		o.setTotalPrice(totalPay);
		o.setOrderStatus(0);
		foreService.updateOrder(o);
		List<OrderDetail> odlist=foreService.selectOrderDetailById(oid);
		foreSession.put("odList", odlist);
		foreSession.put("totalPay", totalPay);
		return SUCCESS;
	}
	public String jiezhang(){
		Orders o=new Orders();
		o.setOrdersId(oid);
		o.setTotalPrice(totalPay);
		o.setOrderStatus(1);
		foreService.updateOrder(o);
		return SUCCESS;
	}
}
