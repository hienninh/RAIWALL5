package com.vti.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.vti.entity.Group;

public interface IGroupService {
	public Page<Group> getAllGroup(int pageNumber, int pageSize, String sortField, String sortType);

	public Group getGroupByID(short Id);

	public Group createGroup(Group group);

	public void updateGroupById(Group group);

	public void deleteGroupByID(short Id);

	public boolean existByGroupName(String groupName);
	
	public boolean isGroupExistsByID(short id);

	public void deleteGroupByIds(List<Short> ids);
}
