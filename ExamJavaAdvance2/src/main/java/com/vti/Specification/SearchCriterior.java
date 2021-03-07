package com.vti.Specification;

public class SearchCriterior {
	private String key;
	private String operater;
	private Object value;

	public String getKey() {
		return key;
	}

	public String getOperater() {
		return operater;
	}

	public Object getValue() {
		return value;
	}

	public SearchCriterior(String key, String operater, Object value) {
		super();
		this.key = key;
		this.operater = operater;
		this.value = value;
	}
}
