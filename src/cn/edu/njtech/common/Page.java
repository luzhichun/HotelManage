package cn.edu.njtech.common;


/**
 * 
 * FileName: Page
 * 
 * @Description: 分页
 * 
 * @author: 袁鑫磊
 * 
 * @Createdate:2016/12/01
 * 
 * @version:1.0
 */
public class Page {
	private int currentPage=1;
	private int pageSize=5;
	private int totalPage;
	public int getCurrentPage() {
		return pageSize*(currentPage-1);
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public Page(int currentPage, int pageSize) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
	}
	
	
}
