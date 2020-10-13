package com.vti.entity.Final;

// Question2_3
public class FinalStudent {
	private final int id;
	private String name;

	public FinalStudent( final int id, String name) {
	this.name = name;
	this.id = id;}

	public final void study() {
		System.out.println("Dang hoc bai ...");
	}
}
