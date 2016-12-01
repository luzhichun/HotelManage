package cn.edu.njtech.mvc.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

	private IFoodService foodService;
	private Map<String, Object> foodsession;
	private String keyword;
	private Food food = new Food();
	private int currentPage = 1;
	private Map<String, Object> map = new HashMap<String, Object>();
	private String result;
	private String checkFoodName;
	private String imageName;

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getCheckFoodName() {
		return checkFoodName;
	}

	public void setCheckFoodName(String checkFoodName) {
		this.checkFoodName = checkFoodName;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public IFoodService getFoodService() {
		return foodService;
	}

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

	public String showFoodList() {
		Page page = new Page(currentPage, 5);
		String name = keyword;
		if (name == null) {
			name = "";
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

	public String addFood() throws Exception {
		uploadFile();
		food.setImg(fileFileName);
		System.out.println(food);
		if (foodService.addFood(food) > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String checkFoodName() {
		Map<String, Object> chatroom = new HashMap<String, Object>();
		List<Food> list = foodService.selectFoodByName(checkFoodName);
		System.out.println(checkFoodName);
		if (checkFoodName.length() == 0) {
			chatroom.put("result", "菜名不能为空");
		} else {
			if (list.size() > 0) {
				chatroom.put("result", "菜名不可用");
			} else {
				chatroom.put("result", "菜名可用");
			}
		}
		JSONObject jo = JSONObject.fromObject(chatroom);
		this.result = jo.toString();
		return SUCCESS;
	}

	public String selectById() {
		Food f = foodService.selectFoodById(food.getFoodId()).get(0);
		List<Foodtype> list = foodService.selectAllFoodType("");
		foodsession.put("foodType", list);
		foodsession.put("nf", f);
		return SUCCESS;
	}

	public String updateFood() throws Exception {
		System.out.println("filen"+fileFileName);
		System.out.println("imageName"+imageName);
		if (fileFileName!=imageName&&fileFileName!=null) {
			uploadFile();
			food.setImg(fileFileName);
		}else{
			food.setImg(imageName);
		}
		System.out.println(food);
		if (foodService.updateFood(food) > 0) {
			return SUCCESS;
		} else {
			return ERROR;
		}
	}
	public String deleteFood(){
		if(foodService.deleteFood(food.getFoodId())>0){
			return SUCCESS;
		}else{
			return ERROR;
		}
	}
	// ======================================文件上传方法
	public void uploadFile() throws Exception {
		String root = ServletActionContext.getServletContext().getRealPath(
				"/upload");
		InputStream is = new FileInputStream(file);
		OutputStream os = new FileOutputStream(new File(root, fileFileName));
		System.out.println("fileFileName: " + fileFileName);
		// 因为file是存放在临时文件夹的文件，我们可以将其文件名和文件路径打印出来，看和之前的fileFileName是否相同
		System.out.println("file: " + file.getName());
		System.out.println("file: " + file.getPath());
		byte[] buffer = new byte[500];
		int length = 0;
		while (-1 != (length = is.read(buffer))) {
			os.write(buffer, 0, length);
		}
		os.close();
		is.close();
	}
	public void downloadFile() {

	}
}
