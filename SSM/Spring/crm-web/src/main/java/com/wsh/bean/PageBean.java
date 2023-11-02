package com.wsh.bean;

import java.util.List;

import org.springframework.stereotype.Component;

import com.wsh.utils.ParamUtils;

@Component
public class PageBean {
		// 当前页
		private int currentPage = ParamUtils.ONE;
		// 总页数据数
		private int totalSize;
		// 总页数
		private int totalPage;
		// 查询类型
		private String queryType;
		// 查询内容
		private String queryContent;
		// 客户列表
		private List<CustomerShow> customerList;
		public int getCurrentPage() {
			return currentPage;
		}
		public void setCurrentPage(int currentPage) {
			this.currentPage = currentPage;
		}
		public int getTotalSize() {
			return totalSize;
		}
		public void setTotalSize(int totalSize) {
			this.totalSize = totalSize;
		}
		public int getTotalPage() {
			return totalPage;
		}
		public void setTotalPage(int totalPage) {
			this.totalPage = totalPage;
		}
		public List<CustomerShow> getCustomerList() {
			return customerList;
		}
		public void setCustomerList(List<CustomerShow> customerList) {
			this.customerList = customerList;
		}
		
		public String getQueryType() {
			return queryType;
		}
		public void setQueryType(String queryType) {
			this.queryType = queryType;
		}
		public String getQueryContent() {
			return queryContent;
		}
		public void setQueryContent(String queryContent) {
			this.queryContent = queryContent;
		}
		@Override
		public String toString() {
			return "PageDetils [currentPage=" + currentPage + ", totalSize=" + totalSize + ", totalPage=" + totalPage
					+ ", customerList=" + customerList + "]";
		}
		
		
}
