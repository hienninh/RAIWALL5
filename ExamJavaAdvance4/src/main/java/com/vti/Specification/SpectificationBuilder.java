package com.vti.Specification;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;
import com.vti.entity.Group;

public class SpectificationBuilder<T> {
	private List<SearchCriterior> searchCriteriors;

	public SpectificationBuilder() {
		searchCriteriors = new ArrayList<>();
	}

	public SpectificationBuilder<T> with(SearchCriterior search) {
		searchCriteriors.add(search);
		return this;
	}

	public SpectificationBuilder<T> with(boolean isOrPredicate, String key, String operater, Object value) {
		searchCriteriors.add(new SearchCriterior(isOrPredicate, key, operater, value));
		return this;
	}

	public Specification<T> Builder() {
		if (searchCriteriors.size() == 0) {
			return null;
		}
//		get element (0)
		Specification<T> specifications = new SpectificationCustom<T>(searchCriteriors.get(0));
		for (int i = 1; i < searchCriteriors.size(); i++) {
//		get element (0) + (i)
			specifications = searchCriteriors.get(i).isOrPredicate()
//					true => or
					? specifications.or(new SpectificationCustom<>(searchCriteriors.get(i)))
//					false => and
					: specifications.and(new SpectificationCustom<>(searchCriteriors.get(i)));
		}
		return specifications;
	}
}
