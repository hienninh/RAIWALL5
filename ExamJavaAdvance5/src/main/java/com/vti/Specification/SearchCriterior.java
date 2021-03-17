package com.vti.Specification;

public class SearchCriterior {
	private boolean isOrPredicate;
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
	

	public boolean isOrPredicate() {
		return isOrPredicate;
	}

	public SearchCriterior(boolean isOrPredicate, String key, String operater, Object value) {
		super();
		this.isOrPredicate = isOrPredicate;
		this.key = key;
		this.operater = operater;
		this.value = value;
	}
}
