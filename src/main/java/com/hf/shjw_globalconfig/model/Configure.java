package com.hf.shjw_globalconfig.model;

public class Configure {
	private Integer id;
	private String configureKeyName;
	private Integer parentId;
	private String memo;
	private String type;
	private String sort;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getConfigureKeyName() {
		return configureKeyName;
	}

	public void setConfigureKeyName(String configureKeyName) {
		this.configureKeyName = configureKeyName;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}
	
}
