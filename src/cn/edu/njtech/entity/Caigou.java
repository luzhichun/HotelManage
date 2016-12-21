package cn.edu.njtech.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * 
 * FileName: Caigou
 * 
 * @Description: 采购实体类
 * 
 * @author: 刘明亮
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class Caigou implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * é‡‡è´­ä¸»é”®id:é‡‡è´­ä¸»é”®id
	 */
	private int id;

	/**
	 * é‡‡è´­å��ç§°:é‡‡è´­å��ç§°
	 */
	private String name;

	/**
	 * é‡‡è´­æ•°é‡�:é‡‡è´­æ•°é‡�
	 */
	private String nums;

	/**
	 * é‡‡è´­å‘˜:é‡‡è´­å‘˜
	 */
	private String buyer;

	/**
	 * é‡‡è´­æ—¥æœŸ:é‡‡è´­æ—¥æœŸ
	 */
	private String time;

	/**
	 * é¢„è®¡é‡‘é¢�:é¢„è®¡é‡‘é¢�
	 */
	private String money;

	public Caigou() {
		super();
	}

	public Caigou(int id, String name, String nums, String buyer, String time,
			String money) {
		super();
		this.id = id;
		this.name = name;
		this.nums = nums;
		this.buyer = buyer;
		this.time = time;
		this.money = money;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setNums(String nums) {
		this.nums = nums;
	}

	public String getNums() {
		return nums;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getMoney() {
		return money;
	}

	public String toString() {
		return "Caigou [id=" + id + ",name=" + name + ",nums=" + nums
				+ ",buyer=" + buyer + ",time=" + time + ",money=" + money + "]";
	}

}
