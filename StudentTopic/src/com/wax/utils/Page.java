package com.wax.utils;

import java.util.List;
import java.util.Map;

public class Page {
	private List<Map<String, Object>> objectList;
	private int totalCount;
	private int currentPage;
	private int totalPage;
	public Page() {
		super();
	}
	public List<Map<String, Object>> getObjectList() {
		return objectList;
	}
	public void setObjectList(List<Map<String, Object>> objectList) {
		this.objectList = objectList;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = this.totalCount%8==0?this.totalCount/8:this.totalCount/8+1;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public Page(List<Map<String, Object>> objectList, int totalCount, int currentPage) {
		super();
		this.objectList = objectList;
		this.totalCount = totalCount;
		this.currentPage = currentPage;
		this.totalPage =  this.totalCount%8==0?this.totalCount/8:this.totalCount/8+1;
	}
}
