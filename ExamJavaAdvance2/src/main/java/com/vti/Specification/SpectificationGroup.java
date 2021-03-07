package com.vti.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import com.vti.entity.Group;

@SuppressWarnings("serial")
public class SpectificationGroup implements Specification<Group> {
	private SearchCriterior criterior;

	public SearchCriterior getCriterior() {
		return criterior;
	}

	public SpectificationGroup(SearchCriterior criterior) {
		super();
		this.criterior = criterior;
	}

	@Override
	public Predicate toPredicate(Root<Group> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		if (criterior.getOperater().equalsIgnoreCase("Like")) {
			return criteriaBuilder.like(root.get(criterior.getKey()), "%" + criterior.getValue() + "%");

		}
		if (criterior.getOperater().equalsIgnoreCase(">")) {
			return criteriaBuilder.greaterThan(root.get(criterior.getKey()), criterior.getValue().toString());

		}
		if (criterior.getOperater().equalsIgnoreCase("<")) {
			return criteriaBuilder.lessThan(root.get(criterior.getKey()), criterior.getValue().toString());
		}
		return null;
	}

}
