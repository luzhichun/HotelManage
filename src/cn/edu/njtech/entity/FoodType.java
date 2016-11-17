package cn.edu.njtech.entity;

import java.io.Serializable;

public class FoodType implements Serializable{
	private int id;
	private String typeName;
	
	public FoodType() {
		super();
	}
	public FoodType(int id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
