package com.vti.DTO;

import java.util.Date;
import java.util.List;

import com.vti.entity.Account;
import com.vti.entity.Group;

public class viewGroupDTO {
	private short id;
	private String groupName;
	private short member;
	private Date createDate;
	private String creator;

	public viewGroupDTO(short id, String groupName, short member, Date createDate, String creator) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.member = member;
		this.createDate = createDate;
		this.creator = creator;
	}

	public viewGroupDTO() {
		super();
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreator() {
		return creator;
	}

	public short getMember() {
		return member;
	}

	public void setMember(short member) {
		this.member = member;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}


	@Override
	public String toString() {
		return "viewGroupDTO [id=" + id + ", groupName=" + groupName + ", member=" + member + ", createDate="
				+ createDate + ", creator=" + creator + "]";
	}

}
