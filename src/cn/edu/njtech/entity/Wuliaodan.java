package cn.edu.njtech.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 
 * FileName: Wuliaodan
 * 
 * @Description: 物料单实体类
 * 
 * @author: 刘明亮
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class Wuliaodan implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private int id;

	/**
	 * 库存名称
	 */
	private String name;

	/**
	 * 物料剩余
	 */
	private String surplus;

	/**
	 * 已使用
	 */
	private String use;

	public Wuliaodan() {
		super();
	}

	public Wuliaodan(int id, String name, String surplus, String use) {
		super();
		this.id = id;
		this.name = name;
		this.surplus = surplus;
		this.use = use;
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

	public void setSurplus(String surplus) {
		this.surplus = surplus;
	}

	public String getSurplus() {
		return surplus;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getUse() {
		return use;
	}

	public String toString() {
		return "Wuliaodan [id=" + id + ",name=" + name + ",surplus=" + surplus
				+ ",use=" + use + "]";
	}

}
