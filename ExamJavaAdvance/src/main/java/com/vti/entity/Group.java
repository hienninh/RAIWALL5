package com.vti.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.vti.DTO.viewGroupDTO;

@Entity
@Table(name = "`Group`", catalog = "TESTING_SYSTEM_ASSIGNMENT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Group implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "group_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "group_name", length = 50, nullable = false)
	private String groupName;

	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	@CreationTimestamp
	private Date createtime;

	@Column(name = "amount_member")
	private short amountMember;

	@ManyToOne
	@JoinColumn(name = "creator_id", nullable = false)
	private Account creator;

	public Group() {
		super();
	}

	public Group(String groupName) {
		this.groupName = groupName;
	}

	public Group(short id, String groupName, Date createtime, short amountMember, Account creator) {
		super();
		this.id = id;
		this.groupName = groupName;
		this.createtime = createtime;
		this.amountMember = amountMember;
		this.creator = creator;
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

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public short getAmountMember() {
		return amountMember;
	}

	public void setAmountMember(short amountMember) {
		this.amountMember = amountMember;
	}

	public Account getCreator() {
		return creator;
	}

	public void setCreator(Account creator) {
		this.creator = creator;
	}

	@Override
	public String toString() {
		return "Group [id=" + id + ", groupName=" + groupName + ", createtime=" + createtime + ", amountMember="
				+ amountMember + ", creator=" + creator + "]";
	}

	public viewGroupDTO toEntity() {
		return new viewGroupDTO(id,groupName,amountMember, createtime, creator.getFullname());
	}
}
