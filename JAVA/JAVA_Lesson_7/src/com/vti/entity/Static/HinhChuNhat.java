package com.vti.entity.Static;

public class HinhChuNhat extends HinhHoc {
	private static int counterHinhChuNhat = 0;

	public HinhChuNhat() {
		super();
		counterHinhChuNhat++;
	}
}
