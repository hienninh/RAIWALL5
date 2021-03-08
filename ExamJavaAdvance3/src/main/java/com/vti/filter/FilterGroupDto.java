package com.vti.filter;

public class FilterGroupDto {
	private int minId;
	private int maxId;
	private String name;
	public FilterGroupDto(int minId, int maxId, String name) {
		super();
		this.minId = minId;
		this.maxId = maxId;
		this.name = name;
	}
	public int getMinId() {
		return minId;
	}
	public void setMinId(int minId) {
		this.minId = minId;
	}
	public int getMaxId() {
		return maxId;
	}
	public void setMaxId(int maxId) {
		this.maxId = maxId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
