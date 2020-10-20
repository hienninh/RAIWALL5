package com.vti.frontend;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import com.vti.backend.CRUD;
import com.vti.entity.ScannerUtils;

public class Ex2CRUD {
	public static void main(String[] args) throws Exception {
		CRUD ex2 = new CRUD();
		//ex2.getDepartment();
		//ex2.getDepartmentById5();
		//ex2.getDepartmentById();
		
//	System.out.print("Moi ban nhap vao ten phong ban: ");
//	String name = ScannerUtils.inputString();
//	System.out.println(ex2.isDepartmentNameExists(name));
	
	System.out.println("Ban nhap vao ten phong ban: ");
	String Name = ScannerUtils.inputString();
	new CRUD().createDepartment(Name);
	System.out.println("create success!");
	}
	

}

