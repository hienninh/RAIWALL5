package com.vti.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;
import com.vti.entity.Group;
import com.vti.filter.FilterGroupDto;

public class SpectificatinDGroupBuilder {
	private FilterGroupDto filter;
	private String search;

	public FilterGroupDto getFilterGroup() {
		return filter;
	}

	public void setFilterGroup(FilterGroupDto filter) {
		this.filter = filter;
	}

	public String getSearch() {
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public SpectificatinDGroupBuilder(FilterGroupDto filter, String search) {
		super();
		this.filter = filter;
		this.search = search;
	}

	public Specification<Group> Builder() {
//		 init
//		  key; operater; value phải giống với giá trị đã khai báo trong method toPredicate bên dưới
		SearchCriterior searchCriterior = new SearchCriterior("groupName", "Like", "%" + search + "%");
		SearchCriterior minIdCriterior = new SearchCriterior("id", ">", filter.getMinId());
		SearchCriterior maxIdCriterior = new SearchCriterior("id", "<", filter.getMaxId());
		Specification<Group> where = null;
//  xét điều kiện để nhận giá trị where tương ứng
		if (search != null) {
			where = new SpectificationGroup(searchCriterior);
		}
		if (filter.getMinId() != 0) {
			if (where != null) {
				where = where.and(new SpectificationGroup(minIdCriterior));
			} else {
				where = new SpectificationGroup(minIdCriterior);
			}
		}
		if (filter.getMaxId() != 0) {
			if (where != null) {
				where = where.and(new SpectificationGroup(maxIdCriterior));
			} else {
				where = new SpectificationGroup(maxIdCriterior);
			}
		}
		return where;
	}
//
//	// filter id > ?
//	@SuppressWarnings("serial")
//	Specification<Group> greaterThanById(int id) {
//		return new Specification<Group>() {
//			@Override
//			public Predicate toPredicate(Root<Group> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//				return criteriaBuilder.greaterThan(root.get("id"), id);
//			}
//		};
//	}
//
//	// filter id > ?
//	@SuppressWarnings("serial")
//	Specification<Group> lessThanById(int id) {
//		return new Specification<Group>() {
//			@Override
//			public Predicate toPredicate(Root<Group> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//				return criteriaBuilder.lessThan(root.get("id"), id);
//			}
//		};
//	}
//
//	@SuppressWarnings("serial")
//	// filter by groupName
//	Specification<Group> searchByGroupName(String groupName) {
//		return new Specification<Group>() {
//
//			@Override
//			public Predicate toPredicate(Root<Group> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
//				return criteriaBuilder.like(root.get("groupName"), "%" + search + "%");
//			}
//		};
//	}
}
