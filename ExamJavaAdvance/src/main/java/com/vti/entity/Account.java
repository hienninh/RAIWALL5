package com.vti.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Account", catalog = "TESTING_SYSTEM_ASSIGNMENT")
@Inheritance(strategy = InheritanceType.JOINED)
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "account_id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short id;

	@Column(name = "fullname", nullable = false, length = 50)
	private String fullname;

	@OneToMany(mappedBy = "creator")
	private List<Group> createdGroups;

	public Account() {
		super();
	}

	public Account(String fullname) {
		this.fullname = fullname;
	}

	public Account(short id, String fullname, List<Group> createdGroups) {
		this.id = id;
		this.fullname = fullname;
		this.createdGroups = createdGroups;
	}

	public short getId() {
		return id;
	}

	public void setId(short id) {
		this.id = id;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public List<Group> getCreatedGroups() {
		return createdGroups;
	}

	public void setCreatedGroups(List<Group> createdGroups) {
		this.createdGroups = createdGroups;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", fullname=" + fullname + "]";
	}

}
