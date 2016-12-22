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

/**
 * 
 * FileName: ForeMenuAction
 * 
 * @Description: 前台Action
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/03
 * 
 * @version:1.0
 * 
 *              * Modification History:
 * 
 *              Date Author Version Description
 * 
 *              2016/12/10 倪志敏 1.1 前台Action
 * 
 */
public class ForeMenuAction extends ActionSupport implements
		ModelDriven<OrderDetail>, SessionAware {
	private IForeService foreService;// 前台的service对象
	private IFoodService foodService;// 菜品的service对象
	private int type = 0;// 查询的方式0：按菜查询1：按菜系查询
	private Map<String, Object> foreSession;// map的session对象
	private int tableId;// 获取餐桌id
	private int OcurrentPage = 1;// 订单的当前页
	private String foodName;// 获取food的名字
	private String key;// 模糊查询获取的关键字
	private int foodtypeid;// 菜系的id
	private int foodId;// food的id
	private int oid;// order的id
	private OrderDetail od = new OrderDetail();// 页面获取的订单详细封装的对象
	private double totalPay = 0;// 总共的页数
	private int FFcurrentPage = 1;// 菜单的当前页
	private int FTcurrentPage = 1;// 菜系的当前页
	public String result;// json的返回结果对象

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return key
	 */
	public String getKey() {
		return key;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param cname
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return type
	 */
	public int getType() {
		return type;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return foodService
	 */
	public IFoodService getFoodService() {
		return foodService;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param foodService
	 */
	public void setFoodService(IFoodService foodService) {
		this.foodService = foodService;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return FTcurrentPage
	 */
	public int getFTcurrentPage() {
		return FTcurrentPage;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param FFcurrentPage
	 */
	public void setFTcurrentPage(int fTcurrentPage) {
		FTcurrentPage = fTcurrentPage;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return FFcurrentPage
	 */
	public int getFFcurrentPage() {
		return FFcurrentPage;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param foodId
	 */
	public void setFFcurrentPage(int fFcurrentPage) {
		FFcurrentPage = fFcurrentPage;
	}

	@Override
	public OrderDetail getModel() {
		// TODO Auto-generated method stub
		return od;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return cname
	 */
	public int getFoodId() {
		return foodId;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param foodId
	 */
	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return foodtypeid
	 */
	public int getFoodtypeid() {
		return foodtypeid;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param foodtypeid
	 */
	public void setFoodtypeid(int foodtypeid) {
		this.foodtypeid = foodtypeid;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return foodName
	 */
	public String getFoodName() {
		return foodName;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param foodName
	 */
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return ocurrentPage
	 */
	public int getOcurrentPage() {
		return OcurrentPage;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param ocurrentPage
	 */
	public void setOcurrentPage(int ocurrentPage) {
		OcurrentPage = ocurrentPage;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return tableId
	 */
	public int getTableId() {
		return tableId;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param tableId
	 */
	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return result
	 */
	public String getResult() {
		return result;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param result
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return foreService
	 */
	public IForeService getForeService() {
		return foreService;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param foreService
	 */
	public void setForeService(IForeService foreService) {
		this.foreService = foreService;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.foreSession = arg0;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 */
	public String getFreeTable() {
		Map<String, Object> chatroom = new HashMap<String, Object>();
		Page page = new Page(OcurrentPage, 4);
		foreSession.put("OcurrentPage", OcurrentPage);
		List<Dinnertable> list = foreService
				.getFreeTable(page.getCurrentPage());
		int totalNum = foreService.getFreeDinnerNum();
		page.setTotalPage((totalNum - 1) / page.getPageSize() + 1);
		foreSession.put("OtotalPage", page.getTotalPage());
		chatroom.put("list", list);
		JSONObject jo = JSONObject.fromObject(chatroom);
		this.result = jo.toString();
		return SUCCESS;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 */
	public String getFoodType() {
		Map<String, Object> chatroom = new HashMap<String, Object>();
		Page typePage = new Page(1, 4);
		typePage.setCurrentPage(FTcurrentPage);
		List<Foodtype> foodTypeList = foreService.getFoodType(typePage
				.getCurrentPage());
		int total = foodService.selectAllFoodType("").size();
		foreSession
				.put("FTtotalPage", (total - 1) / typePage.getPageSize() + 1);
		foreSession.put("FTcurrentPage", FTcurrentPage);
		chatroom.put("list", foodTypeList);
		JSONObject jo = JSONObject.fromObject(chatroom);
		this.result = jo.toString();
		return SUCCESS;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 */
	public String menusList() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		String date = sdf.format(new Date());
		// 判断餐桌的状态 要是餐桌的状态空闲就更新
		Dinnertable checkDt = foreService.selectByTableId(tableId);
		if (checkDt == null) {
			// 更新餐桌
			Dinnertable dt = new Dinnertable();
			dt.setTableId(tableId);
			dt.setOrderDate(date);
			dt.setTableStatus(1);
			foreService.updateTable(dt);
		}
		// 判断订单的状态 如果订单已存在并且未结账就不用创建
		Orders checkO = foreService.selectordersByTableId(tableId);
		if (checkO == null) {
			// 创建order
			Orders o = new Orders();
			o.setOrderDate(date);
			o.setTableId(tableId);
			o.setOrderStatus(0);
			o.setTotalPrice(0.0);
			foreService.addOrders(o);
		}
		Page typePage = new Page(1, 4);
		List<Foodtype> foodTypeList = foreService.getFoodType(typePage
				.getCurrentPage());
		int total = foodService.selectAllFoodType("").size();
		foreSession
				.put("FTtotalPage", (total - 1) / typePage.getPageSize() + 1);
		foreSession.put("FTcurrentPage", FTcurrentPage);
		foreSession.put("ftl", foodTypeList);
		Map<String, Object> map = new HashMap<String, Object>();
		String keyword = key;
		if (keyword == null) {
			keyword = "";
		}
		Page page = new Page(1, 6);
		page.setCurrentPage(FFcurrentPage);
		map.put("foodName", keyword);
		map.put("currentPage", page.getCurrentPage());
		map.put("pageSize", page.getPageSize());
		List<Food> foodList = foreService.showFoodMenu(map);
		int ffsize = foreService.getFood();
		page.setTotalPage((ffsize - 1) / page.getPageSize() + 1);
		foreSession.put("FFtotalPage", page.getTotalPage());
		foreSession.put("foodList", foodList);
		foreSession.put("FFcurrentPage", FFcurrentPage);
		foreSession.put("type", type);
		foreSession.put("foodName", keyword);
		return SUCCESS;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 */
	public String menusByType() {
		Map<String, Object> map = new HashMap<String, Object>();
		if (foodName == null) {
			foodName = "";
		}
		Page page = new Page(1, 6);
		page.setCurrentPage(FFcurrentPage);
		map.put("foodName", foodName);
		map.put("currentPage", page.getCurrentPage());
		map.put("pageSize", page.getPageSize());
		map.put("foodType_id", foodtypeid);
		int ffsize = foreService.getFoodByFoodType(foodtypeid);
		page.setTotalPage((ffsize - 1) / page.getPageSize() + 1);
		List<Food> foodList = foreService.showFoodMenuByTypeId(map);
		foreSession.put("foodList", foodList);
		foreSession.put("FFtotalPage", page.getTotalPage());
		foreSession.put("FFcurrentPage", FFcurrentPage);
		foreSession.put("type", type);
		return SUCCESS;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 */
	public String foodInformation() {
		Food food = foreService.selectByFoodId(foodId);
		foreSession.put("sFood", food);
		return SUCCESS;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 */
	public String createOrderDetail() {
		Orders checkO = foreService.selectordersByTableId(tableId);
		oid = checkO.getOrdersId();
		OrderDetail od = new OrderDetail();
		od.setFood_id(foodId);
		od.setOrderId(checkO.getOrdersId());
		od.setFoodCount(1);
		List<OrderDetail> list = foreService.getOrderDetailByOrderId(od);
		if (list.size() == 0) {
			// 如果没有就创建
			foreService.addOrderDetail(od);
		} else {
			OrderDetail ood = list.get(0);
			if (foodId == ood.getFood_id()) {
				// 如果菜品是一样的就改变菜的数量如果不一样就创建详细
				ood.setFoodCount(ood.getFoodCount() + 1);
				foreService.updateDetail(ood);
			} else {
				foreService.addOrderDetail(od);
			}
		}
		return SUCCESS;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 */
	public String dealOrderDetail() {
		List<OrderDetail> odlist = foreService.selectOrderDetailById(oid);
		totalPay = 0;
		for (OrderDetail orderDetail : odlist) {
			totalPay = orderDetail.getPrice() * orderDetail.getFoodCount()
					+ totalPay;
		}
		foreSession.put("odList", odlist);
		foreSession.put("totalPay", totalPay);
		return SUCCESS;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 */
	public String changeCount() {
		foreService.updateDetail(od);
		List<OrderDetail> odlist = foreService.selectOrderDetailById(od
				.getOrderId());
		totalPay = 0;
		for (OrderDetail orderDetail : odlist) {
			totalPay = orderDetail.getPrice() * orderDetail.getFoodCount()
					+ totalPay;
		}
		Map<String, Object> chatroom = new HashMap<String, Object>();
		chatroom.put("totalPay", totalPay);
		JSONObject jo = JSONObject.fromObject(chatroom);
		this.result = jo.toString();
		return SUCCESS;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 */
	public String deleteDetail() {
		foreService.deleteDetail(od);
		return SUCCESS;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 */
	public String createOrder() {
		Orders o = new Orders();
		o.setOrdersId(oid);
		o.setTotalPrice(totalPay);
		o.setOrderStatus(0);
		foreService.updateOrder(o);
		List<OrderDetail> odlist = foreService.selectOrderDetailById(oid);
		foreSession.put("odList", odlist);
		foreSession.put("totalPay", totalPay);
		return SUCCESS;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 */
	public String jiezhang() {
		Orders o = new Orders();
		o.setOrdersId(oid);
		o.setTotalPrice(totalPay);
		o.setOrderStatus(1);
		foreService.updateOrder(o);
		return SUCCESS;
	}
}
