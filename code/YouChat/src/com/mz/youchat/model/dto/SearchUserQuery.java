package com.mz.youchat.model.dto;

public class SearchUserQuery {

	public String keyword;
	public String currentUid;
	
	
	public int page=0;
	public int pagesize=10;
	public String contentType = "user";
	
	
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	public String getCurrentUid() {
		return currentUid;
	}
	public void setCurrentUid(String currentUid) {
		this.currentUid = currentUid;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPagesize() {
		return pagesize;
	}
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}
	
}
