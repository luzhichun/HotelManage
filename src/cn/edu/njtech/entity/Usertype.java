package cn.edu.njtech.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * usertype:
 */
public class Usertype implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键ID
	 */
	private int id;

	/**
	 * 类型
	 */
	private String name;

	/**
	 * user:
	 */
	private Set<User> userSet = new HashSet<User>(0);

	public Usertype() {
		super();
	}

	public Usertype(int id, String name, Set<User> userSet) {
		super();
		this.id = id;
		this.name = name;
		this.userSet = userSet;
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

	public void setUserSet(Set<User> userSet) {
		this.userSet = userSet;
	}

	public Set<User> getUserSet() {
		return userSet;
	}

	public String toString() {
		return "Usertype [id=" + id + ",name=" + name + ",userSet=" + userSet
				+ "]";
	}

}
