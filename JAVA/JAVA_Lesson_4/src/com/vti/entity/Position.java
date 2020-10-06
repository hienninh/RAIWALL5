package com.vti.entity;

public class Position {
	 short id;
	 PositionName name;

	public Position() {
	}

	public Position(short id, PositionName name) {
		this.id = id;
		this.name = name;
	}
	//getter && setter

	public short getId() {
		return id;
	}

	public PositionName getName() {
		return name;
	}

	public void setName(PositionName name) {
		this.name = name;
	}

}

