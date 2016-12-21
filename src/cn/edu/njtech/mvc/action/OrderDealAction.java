package cn.edu.njtech.mvc.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.edu.njtech.common.Page;
import cn.edu.njtech.entity.OrderDetail;
import cn.edu.njtech.entity.Orders;
import cn.edu.njtech.service.IForeService;
import cn.edu.njtech.service.IOrderService;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 
 * FileName: OrderDealAction
 * 
 * @Description: 订单详细Action
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class OrderDealAction extends ActionSupport implements SessionAware {
	private Map<String, Object> orderSession;
	private IOrderService orderService;
	private IForeService foreService;
	private int ordersId;
	private int currentPage;
	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	Map<String,Object> map=new HashMap<String,Object>();
	public int getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(int ordersId) {
		this.ordersId = ordersId;
	}

	public IOrderService getOrderService() {
		return orderService;
	}

	public void setOrderService(IOrderService orderService) {
		this.orderService = orderService;
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
		this.orderSession = arg0;
	}
	public String showOrderList(){
		if(currentPage==0){
			currentPage=1;
		}
		Page page = new Page(currentPage, 5);
		int total = orderService.getNum();
		page.setTotalPage((total - 1) / page.getPageSize() + 1);
		List<Orders> list=orderService.selectAllOrder(page);
		orderSession.put("orders", list);
		orderSession.put("DcurrentPage", currentPage);
		orderSession.put("DtotalPage", page.getTotalPage());
		return SUCCESS;
	}
	public String showOrderDetailList(){
		Page page=new Page(1, 10);
		map.put("orderId",ordersId);
		map.put("currentPage", page.getCurrentPage());
		map.put("pageSize",page.getPageSize());
		List<OrderDetail> list=orderService.showOrderDetail(map);
//		for (OrderDetail orderDetail : list) {
//			System.out.println(orderDetail);
//		}
		orderSession.put("orderDetail", list);
		return SUCCESS;
	}
	public String changOrders(){
		List<OrderDetail> list=foreService.selectOrderDetailById(ordersId);
		double totalPay=0;
		for (OrderDetail orderDetail : list) {
			totalPay=orderDetail.getPrice()*orderDetail.getFoodCount()+totalPay;
		}
		Orders o=new Orders();
		o.setOrdersId(ordersId);
		o.setTotalPrice(totalPay);
		o.setOrderStatus(1);
		orderService.UpdateOrderById(o);
		return SUCCESS;
	}
}
