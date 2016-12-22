package cn.edu.njtech.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


/**
 * 
 * FileName: Food
 * 
 * @Description: 菜品实体类
 * 
 * @author: 刘明亮
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class Food implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * foodId:菜品ID
	 */
	private int foodId;

	/**
	 * foodName:菜品名称
	 */
	private String foodName;

	/**
	 * price:价格
	 */
	private double price;

	/**
	 * mprice:会员价格
	 */
	private double mprice;

	/**
	 * remark:评价
	 */
	private String remark;

	/**
	 * img:图片
	 */
	private String img;

	/**
	 * foodtype:所属菜系
	 */
	private int foodType_id;

	/**
	 * orderdetail:订单详细
	 */
	private String foodType;
	
	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	private Set<OrderDetail> orderdetailSet = new HashSet<OrderDetail>(0);

	public Food() {
		super();
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getMprice() {
		return mprice;
	}

	public void setMprice(double mprice) {
		this.mprice = mprice;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getFoodType_id() {
		return foodType_id;
	}

	public void setFoodType_id(int foodType_id) {
		this.foodType_id = foodType_id;
	}

	public Set<OrderDetail> getOrderdetailSet() {
		return orderdetailSet;
	}

	public void setOrderdetailSet(Set<OrderDetail> orderdetailSet) {
		this.orderdetailSet = orderdetailSet;
	}

	public Food(int foodId, String foodName, double price, double mprice,
			String remark, String img, int foodType_id,
			Set<OrderDetail> orderdetailSet) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
		this.mprice = mprice;
		this.remark = remark;
		this.img = img;
		this.foodType_id = foodType_id;
		this.orderdetailSet = orderdetailSet;
	}

	@Override
	public String toString() {
		return "Food [foodId=" + foodId + ", foodName=" + foodName + ", price="
				+ price + ", mprice=" + mprice + ", remark=" + remark
				+ ", img=" + img + ", foodType_id=" + foodType_id
				+ ", foodType=" + foodType + ", orderdetailSet="
				+ orderdetailSet + "]";
	}
	
}
