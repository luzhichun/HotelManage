package cn.edu.njtech.mvc.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import cn.edu.njtech.common.DinnerTablePage;
import cn.edu.njtech.entity.Dinnertable;
import cn.edu.njtech.service.IDinnerTableService;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * FileName: DinnerTableAction
 * 
 * @Description: 餐桌Action
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class DinnerTableAction extends ActionSupport implements ModelDriven<Dinnertable>,SessionAware{
	private IDinnerTableService dinnerTableService;
	private Map<String , Object> session;
	private String keyword;
	private Dinnertable dinnerTable=new Dinnertable();
	private int currentPage=1;
	Map<String,Object> map=new HashMap<String,Object>();
	private String tableName;
	
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session=arg0;
	}
	public IDinnerTableService getDinnerTableService() {
		return dinnerTableService;
	}
	public void setDinnerTableService(IDinnerTableService dinnerTableService) {
		this.dinnerTableService = dinnerTableService;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public String showboardList(){
		DinnerTablePage page=new DinnerTablePage();
		page.setCurrentPage(currentPage);
		String name=keyword;
		if(name==null){
			name="";
		}else{
			page.setCurrentPage(1);
		}
		int total=dinnerTableService.getCounts(name);
		page.setTotalPage((total-1)/page.getPageSize()+1);
		map.put("tableName",name);
		map.put("currentPage", page.getCurrentPage());
		map.put("pageSize",page.getPageSize());
		List<Dinnertable> list=dinnerTableService.selectAll(map);
		session.put("list", list);
		session.put("name", name);
		session.put("DcurrentPage", currentPage);
		session.put("DtotalPage", page.getTotalPage());
//		System.out.println(page.getTotalPage());
		return "boardList";
	}
	public String addTable() throws Exception{
		Dinnertable dt=new Dinnertable();
		map.put("tableName", dinnerTable.getTableName());
		List<Dinnertable> list=dinnerTableService.selectAll(map);
//		System.out.println(tableName+"1231");
//		System.out.println(list+"123qw1");
//		System.out.println(dinnerTable.getTableName()+"11111");
		if(list.size()>0){
			return ERROR;
		}
		dt.setTableName(dinnerTable.getTableName());
	//	dt.setTablename(0);
		dt.setOrderDate(null);
		if(dinnerTableService.addTable(dt)>0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	public String deleteTable() throws Exception{
		Dinnertable dt=dinnerTableService.selectById(dinnerTable.getTableId()).get(0);
		if(dt.getTableStatus()==1){
			return ERROR;
		}
		if(dinnerTableService.deleteTable(dinnerTable.getTableId())>0){
			return SUCCESS;
		}else{
//			System.out.println("shanchushibai");
			return ERROR;
		}
	}
	public String returnTable() throws Exception{
		if(dinnerTableService.returnTable(dinnerTable.getTableId())>0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	@Override
	public Dinnertable getModel() {
		// TODO Auto-generated method stub
		return dinnerTable;
	}
}