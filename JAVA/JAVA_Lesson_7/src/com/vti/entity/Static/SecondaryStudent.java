package com.vti.entity.Static;

public class SecondaryStudent extends Student{
	public static int counterSecondary = 0;
	public SecondaryStudent(int id, String name) {
		super(id, name);
		counterSecondary++;
	}

}
