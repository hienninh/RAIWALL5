package com.vti.DTO;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.vti.entity.Group;
import com.vti.validation.groupNameNotExist;

public class createGroupDTO {
	@NotBlank(message = "{createGroupDTO.groupName.NotBlank}")
	@Size(min = 6, max = 50, message = "{createGroupDTO.groupName.Size}")
	@groupNameNotExist
	private String groupName;

	public createGroupDTO() {
	}

	public createGroupDTO(String groupName) {
		this.groupName = groupName;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "createGroupDTO [groupName=" + groupName + "]";
	}

	// Convert Dto sang Group
	public Group toEntity() {
		return new Group(groupName);

	}
}
