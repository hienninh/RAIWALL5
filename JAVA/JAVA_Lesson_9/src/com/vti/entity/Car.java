package com.vti.entity;

public class Car {
	private String name;
	private String type;
	
	//create
	public Car(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}

//class1
	public static class Engine {
		String engineType;
		//create
		public Engine(String engineType) {
			super();
			this.engineType = engineType;
		}

		// get, set
		public String getEngineType() {
			return engineType;
		}

		public void setEngineType(String engineType) {
			this.engineType = engineType;
		}
	}
}
