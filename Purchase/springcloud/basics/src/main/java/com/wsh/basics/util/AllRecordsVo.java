package com.wsh.basics.util;

import java.util.List;

public class AllRecordsVo<T> {
	private Integer pageIndex;
	private Integer pageSize;
	private Integer totalPage;//总页数
	private Integer totalNumber;//总数量
	private List<T> dataList;//数据集合
	public Integer getPageIndex() {
		return pageIndex;
	}
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}
	public Integer getTotalNumber() {
		return totalNumber;
	}
	public void setTotalNumber(Integer totalNumber) {
		this.totalNumber = totalNumber;
	}
	public List<T> getDataList() {
		return dataList;
	}
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	//计算总页数
	public Integer countPage(Integer count){
		int totalPage = count/pageSize;

        if(count % pageSize != 0L) {
        	return ++totalPage;
        }
		return totalPage;
	}
	
}
