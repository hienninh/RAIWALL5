package com.vti.entity;

public class CPU {
	private float price;

	// class1
	public static class Processor {
		float coreAmount;
		String menufacturer;

		// method
		public float getCache() {
			return 4.3f;
		}

		// create
		public Processor(float coreAmount, String menufacturer) {
			super();
			this.coreAmount = coreAmount;
			this.menufacturer = menufacturer;
		}

		// get, set
		public float getCoreAmount() {
			return coreAmount;
		}

		public void setCoreAmount(float coreAmount) {
			this.coreAmount = coreAmount;
		}

		public String getMenufacturer() {
			return menufacturer;
		}

		public void setMenufacturer(String menufacturer) {
			this.menufacturer = menufacturer;
		}
	}

	// class2
	public static class Ram {
		String memory;
		String menufacturer;

		// Method
		public float getClockSpeed() {
			return 5.5f;
		}

		// create
		public Ram(String memory, String menufacturer) {
			super();
			this.memory = memory;
			this.menufacturer = menufacturer;
		}

		// get,set
		public String getMemory() {
			return memory;
		}

		public void setMemory(String memory) {
			this.memory = memory;
		}

		public String getMenufacturer() {
			return menufacturer;
		}

		public void setMenufacturer(String menufacturer) {
			this.menufacturer = menufacturer;
		}
	}
}