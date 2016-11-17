package cn.edu.njtech.mvc.action;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import cn.edu.njtech.entity.DinnerTable;
import cn.edu.njtech.service.IDinnerTableService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class DinnerTableAction extends ActionSupport implements ModelDriven<DinnerTable>,SessionAware{
	private IDinnerTableService dinnerTableService;
	private Map<String , Object> session;
	private String keyword;
	private DinnerTable dinnerTable=new DinnerTable();
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
	public String showboardList(){
		String name=keyword;
		if(name==null){
			name="";
		}
		List<DinnerTable> list=dinnerTableService.selectAll(name);
		session.put("list", list);
		session.put("name", name);
		return "boardList";
	}
	public String addTable() throws Exception{
		DinnerTable dt=new DinnerTable();
		String tableName=dinnerTable.getTableName();
		List<DinnerTable> list=dinnerTableService.selectAll(tableName);
		if(list.size()>0){
			return ERROR;
		}
		dt.setTableName(tableName);
		dt.setTableStatus(0);
		dt.setOrderDate(null);
		if(dinnerTableService.addTable(dt)>0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	public String deleteTable() throws Exception{
		DinnerTable dt=dinnerTableService.selectById(dinnerTable.getId()).get(0);
		if(dt.getTableStatus()==1){
			return ERROR;
		}
		if(dinnerTableService.deleteTable(dinnerTable.getId())>0){
			return SUCCESS;
		}else{
			System.out.println("shanchushibai");
			return ERROR;
		}
	}
	public String returnTable() throws Exception{
		if(dinnerTableService.returnTable(dinnerTable.getId())>0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	@Override
	public DinnerTable getModel() {
		// TODO Auto-generated method stub
		return dinnerTable;
	}
}