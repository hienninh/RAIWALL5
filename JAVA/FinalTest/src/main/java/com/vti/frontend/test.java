package com.vti.frontend;

import com.vti.Utils.ScannerUtils;

public class test {
	public static void main(String[] args) throws Exception {

		// inputfullname
//	System.out.println("Moi nhap ho ten: ");
//	String name = ScannerUtils.inputFullName();
//	System.out.println(name);
//	
		// inputEmail
//	System.out.println("Moi nhap vao email: ");
//	String email = ScannerUtils.email("Ban phai them duoi @gmail.com");
//	System.out.println(email);
		// inputpassword
//	System.out.print("Moi nhap pass: ");
//	String pass = ScannerUtils.LengthPassword("Phai nhap 6 den 12 ky tu");
//	System.out.println(pass);

//		 pass có ít nhất 1 chữ viết hoa
//		System.out.print("Mời nhập vào password: ");
//		String password = ScannerUtils.UpcasePassword("Password phải có ít nhất 1 chữ viết hoa");
//		System.out.println(password);
	// nhap pass co it nhat 1 chu viet hoa va dai tu 6 - 12 chu
		
		System.out.print("Mời nhập vào password: ");
		try {
			String password = ScannerUtils.inputPassword("Phai co it nhat 1 chu hoa va dai 6 -12 tu");
			System.out.println(password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
