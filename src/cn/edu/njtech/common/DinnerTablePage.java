package cn.edu.njtech.common;

public class DinnerTablePage {
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
	
	
}
