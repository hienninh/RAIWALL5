package com.vti.service;

import java.util.List;

import com.vti.entity.Group;
import com.vti.filter.FilterGroupDto;

public interface IGroupService {

//	public Page<Group> getAllGroup(int pageNumber, int pageSize, String sortField, String sortType,
//			FilterGroupDto filte, String search);
	public Group getGroupByID(short Id);

	public Group createGroup(Group group);

	public void updateGroupById(Group group);

	public void deleteGroupByID(short Id);

	public boolean existByGroupName(String groupName);

	public boolean isGroupExistsByID(short id);

	public void deleteGroupByIds(List<Short> ids);

	List<Group> getAllGroup(FilterGroupDto filter, String search);

}
