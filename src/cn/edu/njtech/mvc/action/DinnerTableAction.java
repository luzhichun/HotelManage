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
 * @Description: 餐桌管理Action
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class DinnerTableAction extends ActionSupport implements
		ModelDriven<Dinnertable>, SessionAware {
	private IDinnerTableService dinnerTableService;// 餐桌service对象
	private Map<String, Object> session;// map的session对象
	private String keyword;// 获取的模糊查询的关键字
	private Dinnertable dinnerTable = new Dinnertable();// 页面获取的餐桌封装的对象
	private int currentPage = 1;// 当前页面初始值为1
	Map<String, Object> map = new HashMap<String, Object>();// 处理json 的result
															// map集合
	private String tableName;// 获取的餐桌名

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return tableName
	 */
	public String getTableName() {
		return tableName;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param tableName
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param arg0
	 */
	public void setSession(Map<String, Object> arg0) {
		// TODO Auto-generated method stub
		this.session = arg0;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return dinnerTableService
	 */
	public IDinnerTableService getDinnerTableService() {
		return dinnerTableService;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param dinnerTableService
	 */
	public void setDinnerTableService(IDinnerTableService dinnerTableService) {
		this.dinnerTableService = dinnerTableService;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return keyword
	 */
	public String getKeyword() {
		return keyword;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param keyword
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @param currentPage
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 */
	public String showboardList() {
		DinnerTablePage page = new DinnerTablePage();
		page.setCurrentPage(currentPage);
		String name = keyword;
		if (name == null) {
			name = "";
		} else {
			page.setCurrentPage(1);
		}
		int total = dinnerTableService.getCounts(name);
		page.setTotalPage((total - 1) / page.getPageSize() + 1);
		map.put("tableName", name);
		map.put("currentPage", page.getCurrentPage());
		map.put("pageSize", page.getPageSize());
		List<Dinnertable> list = dinnerTableService.selectAll(map);
		session.put("list", list);
		session.put("name", name);
		session.put("DcurrentPage", currentPage);
		session.put("DtotalPage", page.getTotalPage());
		return "boardList";
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 * @throws 异常类型 Exception
	 */
	public String addTable() throws Exception {
		Dinnertable dt = new Dinnertable();
		map.put("tableName", dinnerTable.getTableName());
		List<Dinnertable> list = dinnerTableService.selectAll(map);
		if (list.size() > 0) {
			return ERROR;
		}
		dt.setTableName(dinnerTable.getTableName());
		// dt.setTablename(0);
		dt.setOrderDate(null);
		if (dinnerTableService.addTable(dt) > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 * @throws 异常类型 Exception
	 */
	public String deleteTable() throws Exception {
		Dinnertable dt = dinnerTableService
				.selectById(dinnerTable.getTableId()).get(0);
		if (dt.getTableStatus() == 1) {
			return ERROR;
		}
		if (dinnerTableService.deleteTable(dinnerTable.getTableId()) > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 * @throws 异常类型 Exception
	 */
	public String returnTable() throws Exception {
		if (dinnerTableService.returnTable(dinnerTable.getTableId()) > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Override
	public Dinnertable getModel() {
		// TODO Auto-generated method stub
		return dinnerTable;
	}
}