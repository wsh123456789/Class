package com.wsh.bean;

import java.util.List;

public class City {

	private Integer id;

	private String name;

	private Integer parentId;

	private List<City> childList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<City> getChildList() {
		return childList;
	}

	public void setChildList(List<City> childList) {
		this.childList = childList;
	}

	@Override
	public String toString() {
		return "City [id=" + id + ", name=" + name + ", parentId=" + parentId + ", childList=" + childList + "]";
	}

	

}
