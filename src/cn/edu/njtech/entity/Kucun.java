package cn.edu.njtech.entity;

import java.io.Serializable;
import javax.persistence.*;
/**
 * 
 * FileName: Kucun
 * 
 * @Description: 库存实体类
 * 
 * @author: 刘明亮
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class Kucun implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ä¸»é”®id:ä¸»é”®id
	 */
	private int id;

	/**
	 * ç‰©æ–™å��ç§°:ç‰©æ–™å��ç§°
	 */
	private String name;

	/**
	 * ç‰©æ–™å‰©ä½™:ç‰©æ–™å‰©ä½™
	 */
	private String kuSurplus;

	/**
	 * ç‰©æ–™å°šéœ€:ç‰©æ–™å°šéœ€
	 */
	private String need;

	public Kucun() {
		super();
	}

	public Kucun(int id, String name, String kuSurplus, String need) {
		super();
		this.id = id;
		this.name = name;
		this.kuSurplus = kuSurplus;
		this.need = need;
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

	public void setKuSurplus(String kuSurplus) {
		this.kuSurplus = kuSurplus;
	}

	public String getKuSurplus() {
		return kuSurplus;
	}

	public void setNeed(String need) {
		this.need = need;
	}

	public String getNeed() {
		return need;
	}

	public String toString() {
		return "Kucun [id=" + id + ",name=" + name + ",kuSurplus=" + kuSurplus
				+ ",need=" + need + "]";
	}

}
