package cn.edu.njtech.mvc.action;

import java.util.List;
import java.util.Map;
import org.apache.struts2.interceptor.SessionAware;
import cn.edu.njtech.entity.Foodtype;
import cn.edu.njtech.service.IFoodService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * FileName: FoodTypeAction
 * 
 * @Description: 菜系Action
 * 
 * @author: 倪志敏
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class FoodTypeAction extends ActionSupport implements
		ModelDriven<Foodtype>, SessionAware {

	private IFoodService foodService;// 菜系的service对象
	private Map<String, Object> foodtypesession;// 菜系session对象
	private String keyword;// 获取的模糊查询的关键字
	private Foodtype foodtype = new Foodtype();// 页面获取的菜系封装的对象

	public IFoodService getFoodService() {
		return foodService;
	}

	public void setFoodService(IFoodService foodService) {
		this.foodService = foodService;
	}

	public Map<String, Object> getFoodtypesession() {
		return foodtypesession;
	}

	public void setFoodtypesession(Map<String, Object> foodtypesession) {
		this.foodtypesession = foodtypesession;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Foodtype getFoodtype() {
		return foodtype;
	}

	public void setFoodtype(Foodtype foodtype) {
		this.foodtype = foodtype;
	}

	// 返回菜系list
	public String showcuisineList() {
		String name = keyword;
		if (name == null) {
			name = "";
		}
		List<Foodtype> list = foodService.selectAllFoodType(name);
		foodtypesession.put("foodTypelist", list);
		foodtypesession.put("foodTypename", name);
		return "cuisineList";
	}

	// 添加菜系名
	public String addCuisine() throws Exception {
		Foodtype ft = new Foodtype();
		String typename = foodtype.getTypename();
		List<Foodtype> list = foodService.selectAllFoodType(typename);
		if (list.size() > 0) {
			return ERROR;
		}
		ft.setTypename(typename);

		if (foodService.addFoodType(ft) > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	// 获取前端页面的菜系名字
	public String beforeupdate() throws Exception {
		Foodtype ft = new Foodtype();
		ft = foodService.selectById(foodtype.getFoodtypeid()).get(0);
		foodtypesession.put("ft", ft);
		return "beforeupdate";

	}

	// 修改菜系的名字
	public String updateCuisine() throws Exception {
		Foodtype ft2 = new Foodtype();
		ft2.setFoodtypeid(foodtype.getFoodtypeid());
		ft2.setTypename(foodtype.getTypename());
		if (foodService.updateType(ft2) > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	// 删除菜系名称
	public String deleteCuisine() throws Exception {
		int id = foodtype.getFoodtypeid();
		if (foodService.deleteFoodType(id) > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.foodtypesession = arg0;
	}

	@Override
	public Foodtype getModel() {
		return foodtype;
	}

}
