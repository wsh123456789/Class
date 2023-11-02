package com.wsh.bean;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class PermissionVo {
	private Integer id;
	
	private String name;
	
	private String url;
	
	private Integer parentTop;
	
	private Integer parentId;
	
	private List<PermissionVo> sonList;

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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getParentTop() {
		return parentTop;
	}

	public void setParentTop(Integer parentTop) {
		this.parentTop = parentTop;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<PermissionVo> getSonList() {
		return sonList;
	}

	public void setSonList(List<PermissionVo> sonList) {
		this.sonList = sonList;
	}

	@Override
	public String toString() {
		return "PermissionVo [id=" + id + ", name=" + name + ", url=" + url + ", parentTop=" + parentTop + ", parentId="
				+ parentId + ", sonList=" + sonList + "]";
	}
	
	
}
