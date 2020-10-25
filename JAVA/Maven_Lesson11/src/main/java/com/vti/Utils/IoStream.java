package com.vti.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class IoStream {
	public void ReadFile(String pathFile) throws Exception {
		// file not exists
		if (!new File(pathFile).exists()) {
			throw new Exception("Error! File not exist");
		}
		// file exist
		// read 1KB
		byte[] b = new byte[1024];
		// convert KB to String.length
		FileInputStream fileInputStream = new FileInputStream(pathFile);
		int length = fileInputStream.read(b);
		System.out.println(length);
		// read content of file
		// read file from position b0
		while (length > -1) {
			String content = new String(b, 0, length);
			System.out.println(content);
			System.out.println("-----------------");
			// continue read file from position (b1, b2,...)
			length = fileInputStream.read(b);
		}
		fileInputStream.close();
	}

	// Question 2: Tạo method write content to File
	public void WriteContentToFile(String pathFile, boolean isContinuing, String content) throws Exception {
		// file not exists
		if (!new File(pathFile).exists()) {
			throw new Exception("Error! File not exist");
		}
		// file exist
		FileOutputStream fileOutputStream = new FileOutputStream(pathFile, isContinuing);
		fileOutputStream.write(content.getBytes());
		System.out.println("Write content to file successfully!");
		fileOutputStream.close();
	}

	// Question 3: Tạo method write Object
	public void WriteObjectToFile(Object object, String pathFile, String fileName) throws Exception {
		// Object is null
		if (new Object() == null) {
			throw new Exception("Error! Object is null");
		}
		// Object exist
		FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
		ObjectOutputStream ObjOutputStream = new ObjectOutputStream(fileOutputStream);
		ObjOutputStream.writeObject(object);
		ObjOutputStream.close();
	}
}
