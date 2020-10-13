package com.vti.entity.Static;

public class PrimaryStudent extends Student{

	public static int counterPrimary = 0;
	public PrimaryStudent (int id, String name) throws Exception{
		super(id, name);
		counterPrimary++;
	}

}
