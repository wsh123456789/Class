package com.ah.bean;

import java.util.List;

public class PageVo<T> {
	//��ǰҳ
	private int currentPage;
	//������
	private int totalNum;
	//��ҳ��
	private int totalPage;
	//��ѯ����
	private List<T> userList;
	
	public PageVo(){
		
	}

	public PageVo(int currentPage, int totalNum, int totalPage, List<T> userList) {
		super();
		this.currentPage = currentPage;
		this.totalNum = totalNum;
		this.totalPage = totalPage;
		this.userList = userList;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(int totalNum) {
		this.totalNum = totalNum;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getUserList() {
		return userList;
	}

	public void setUserList(List<T> userList) {
		this.userList = userList;
	}
    
}
