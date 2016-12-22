package cn.edu.njtech.mvc.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import cn.edu.njtech.common.Page;
import cn.edu.njtech.entity.Food;
import cn.edu.njtech.entity.Foodtype;
import cn.edu.njtech.service.IFoodService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**
 * 
 * FileName: FoodKindAction
 * 
 * @Description: 菜品Action
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class FoodKindAction extends ActionSupport implements ModelDriven<Food>,
		SessionAware {
	// 注意，file并不是指前端jsp上传过来的文件本身，而是文件上传过来存放在临时文件夹下面的文件
	private File file;
	// 提交过来的file的名字
	private String fileFileName;
	// 提交过来的file的MIME类型
	private String fileContentType;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getFileFileName() {
		return fileFileName;
	}

	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}

	public String getFileContentType() {
		return fileContentType;
	}

	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}

	private IFoodService foodService;// 菜品的service对象
	private Map<String, Object> foodsession;// map的session对象
	private String keyword;// 获取的模糊查询的关键字
	private Food food = new Food();// 页面获取的菜品封装的对象
	private int currentPage = 1;// 当前页面初始值为1
	private Map<String, Object> map = new HashMap<String, Object>();// 处理json 的result map集合
	private String result;//json的返回结果对象
	private String checkFoodName;//获取页面的输入的菜品名字
	private String imageName;//获取页面的图片的名
	private String cname;//获取检查的菜名
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return cname
	 */
	public String getCname() {
		return cname;
	}
	/**
	 *  类方法的详细使用说明
	 * 
	 * @param cname
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return imageName
	 */
	public String getImageName() {
		return imageName;
	}
	/**
	 *  类方法的详细使用说明
	 * 
	 * @param imageName
	 */
	public void setImageName(String imageName) {
		this.imageName = imageName;
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
	 * @return cname
	 */
	public String getCheckFoodName() {
		return checkFoodName;
	}
	/**
	 *  类方法的详细使用说明
	 * 
	 * @param checkFoodName
	 */
	public void setCheckFoodName(String checkFoodName) {
		this.checkFoodName = checkFoodName;
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

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.foodsession = arg0;
	}

	@Override
	public Food getModel() {
		return food;
	}
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 * @throws 异常类型 Exception
	 */
	public String showFoodList() {
		Page page = new Page(currentPage, 5);
		String name = keyword;
		if (name == null) {
			name = "";
		} else {
			page.setCurrentPage(1);
		}
		int total = foodService.getFoodNum(name);
		page.setTotalPage((total - 1) / page.getPageSize() + 1);
		map.put("foodName", name);
		map.put("currentPage", page.getCurrentPage());
		map.put("pageSize", page.getPageSize());
		List<Food> list = foodService.selectAllFood(map);
		foodsession.put("list", list);
		foodsession.put("FcurrentPage", currentPage);
		foodsession.put("FtotalPage", page.getTotalPage());
		return SUCCESS;
	}
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 * @throws 异常类型 Exception
	 */
	public String getFoodType() {
		// Map<String, Object> chatroom = new HashMap<String, Object>();
		// List<Foodtype> list = foodService.selectAllFoodType("");
		// chatroom.put("list", list);
		// JSONObject jo = JSONObject.fromObject(chatroom);
		// this.result = jo.toString();
		List<Foodtype> list = foodService.selectAllFoodType("");
		foodsession.put("foodType", list);
		return SUCCESS;
	}
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 * @throws 异常类型 Exception
	 */
	public String addFood() throws Exception {
		uploadFile();
		food.setImg(fileFileName);
		if (foodService.addFood(food) > 0) {
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
	public String checkFoodName() {
		Map<String, Object> chatroom = new HashMap<String, Object>();
		if (checkFoodName.equals(cname)) {
			chatroom.put("result", "菜名未改变");
		} else {
			List<Food> list = foodService.selectFoodByName(checkFoodName);
			if (checkFoodName.length() == 0) {
				chatroom.put("result", "菜名不能为空");
			} else {
				if (list.size() > 0) {
					chatroom.put("result", "菜名不可用");
				} else {
					chatroom.put("result", "菜名可用");
				}
			}
		}
		JSONObject jo = JSONObject.fromObject(chatroom);
		this.result = jo.toString();
		return SUCCESS;
	}
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 * @throws 异常类型 Exception
	 */
	public String selectById() {
		Food f = foodService.selectFoodById(food.getFoodId()).get(0);
		List<Foodtype> list = foodService.selectAllFoodType("");
		foodsession.put("foodType", list);
		foodsession.put("nf", f);
		return SUCCESS;
	}
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 * @throws 异常类型 Exception
	 */
	public String updateFood() throws Exception {
		if (fileFileName != imageName && fileFileName != null) {
			uploadFile();
			food.setImg(fileFileName);
		} else {
			food.setImg(imageName);
		}
		if (foodService.updateFood(food) > 0) {
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
	public String deleteFood() {
		if (foodService.deleteFood(food.getFoodId()) > 0) {
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
	public String changeImage() throws Exception {
		uploadFile();
		return result;
	}
	/**
	 *  类方法的详细使用说明
	 * 
	 * @return 返回页面跳转的结果
	 * @throws 异常类型 Exception
	 */
	// ======================================文件上传方法
	public void uploadFile() throws Exception {
		String root = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		InputStream is = new FileInputStream(file);
		OutputStream os = new FileOutputStream(new File(root, fileFileName));
		// // 因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
		byte[] buffer = new byte[500];
		int length = 0;
		while (-1 != (length = is.read(buffer))) {
			os.write(buffer, 0, length);
		}
		os.close();
		is.close();
	}
}
