package com.vti.frontend;

import java.io.IOException;

import com.vti.backend.FileManager;
import com.vti.entity.Final.NotFail_IfExists;
import com.vti.entity.Final.SameNameException;

public class File_ex3 {
	public static void main(String[] args) throws NotFail_IfExists, IOException, Exception,SameNameException  {
		FileManager ex3 = new FileManager();
		// ex3.Question1();
		// ex3.Question2();
//	try {ex3.Question4();
//	} catch (Exception e) {
//		System.err.println(e.getMessage());
//	}
//	ex3.Question5();
//	ex3.Question6();
//		try {
//			ex3.Question8();
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}
//		try {
//			ex3.Question9();
//		} catch (SameNameException sm) {
//			System.out.println(sm.getMessage());
//		} catch (Exception e) {
//			System.err.println(e.getMessage());
//		}
ex3.Question10();
	}
}
