package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.vti.entity.Group;

public interface IGroupRepository extends JpaRepository<Group, Short>, JpaSpecificationExecutor<Group> {
	public boolean existsByGroupName(String groupName);
//	@Transactional
//	@Modifying
//	@Query("delete from group g where g.id in ?1")
//	public void deleteGroupsWithIds(List<Short> ids);
	
	@Transactional
	@Modifying
	@Query("delete from Group g where g.id in ?1")
	void deleteGroupsWithIds(List<Short> ids);
}
