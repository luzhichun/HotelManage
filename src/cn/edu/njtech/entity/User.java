package  cn.edu.njtech.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * user:
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * ä¸»é”®ID:ä¸»é”®ID
	 */
	private int id;

	/**
	 * å§“å��:å§“å��
	 */
	private String name;

	/**
	 * å¯†ç �:å¯†ç �
	 */
	private String pwd;

	/**
	 * ç”µè¯�:ç”µè¯�
	 */
	private String tel;

	/**
	 * åœ°åŒº:åœ°åŒº
	 */
	private String addr;

	/**
	 * é‚®ç®±:é‚®ç®±
	 */
	private String email;

	/**
	 * å¤´åƒ�:å¤´åƒ�
	 */
	private String picture;

	/**
	 * å¹´é¾„:å¹´é¾„
	 */
	private String age;

	/**
	 * å¤‡æ³¨:å¤‡æ³¨
	 */
	private String remark;

	/**
	 * è�Œä½�:è�Œä½�
	 */
	private String position;

	/**
	 * usertype:
	 */
	private int usertypeId;

	public User() {
		super();
	}

	public User(int id, String name, String pwd, String tel, String addr,
			String email, String picture, String age, String remark,
			String position, int usertype) {
		super();
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.tel = tel;
		this.addr = addr;
		this.email = email;
		this.picture = picture;
		this.age = age;
		this.remark = remark;
		this.position = position;
		this.usertypeId = usertype;
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

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getPwd() {
		return pwd;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getTel() {
		return tel;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getAddr() {
		return addr;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getPicture() {
		return picture;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAge() {
		return age;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setUsertype(int usertype) {
		this.usertypeId = usertype;
	}

	public int getUsertype() {
		return usertypeId;
	}

	public String toString() {
		return "User [id=" + id + ",name=" + name + ",pwd=" + pwd + ",tel="
				+ tel + ",addr=" + addr + ",email=" + email + ",picture="
				+ picture + ",age=" + age + ",remark=" + remark + ",position="
				+ position + ",usertypeId=" + usertypeId + "]";
	}

}
