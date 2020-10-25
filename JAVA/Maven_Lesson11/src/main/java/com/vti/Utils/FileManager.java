package com.vti.Utils;

import java.io.File;
import java.io.IOException;

import com.vti.entity.NotFail_IfExists;
import com.vti.entity.SameNameException;

public class FileManager {

	public static void Question1() {

//	Question 1: Check File is exists
//	Tạo 1 method có đầu vào là String path để check xem path đó có tồn
//	tại hay không.
//	VD: path = "C:\Users\pc\Desktop\Test.txt"
//	Gợi ý: Tạo method boolean isFileExists(String pathFile)

		File file = new File("C:\\Users\\Admin\\Desktop\\aaaaaaaa\\b.docx");
		if (file.exists()) {
			System.out.println("file co ton tai");
		} else {
			System.out.println("file nay khong ton tai");
		}
	}

	// Question 2: Create new file
	public static void Question2() throws NotFail_IfExists, IOException {
		try {
			File file = new File("C:\\Users\\Admin\\Desktop\\aaaaaaaa\\b.docx");
			if (file.exists()) {
				throw new NotFail_IfExists("File is exists, Create fail");
			} else {
				file.createNewFile();
			}
		} catch (NotFail_IfExists nfie) {
			System.err.println(nfie.getMessage());
		}
	}

	// Question 4: Delete file
	public static void Question4() throws Exception {
		File file = new File("C:\\Users\\Admin\\Desktop\\aaaaaaaa\\b.docx");
		if (file.exists()) {
			file.delete();
			System.out.println("Delete successfully!");
		} else {
			throw new Exception("Error! file not exist");
		}
	}

	// Question5: Check path is File or Folder

	public static void Question5() {
		File file = new File("C:\\Users\\Admin\\Desktop\\aaaaaaaa");
		System.out.println(file.isDirectory() ? "Path is Folder" : "Path is file");
	}

	// Question 6: Get all File name of Folder
	public static void Question6() {
		File file = new File("C:\\Users\\Admin\\Desktop\\b");
		for (String b : file.list()) {
			System.out.println(b);
		}
	}

	// Question 7: Copy File
// Question 8: Moving file
	public static void Question8() throws Exception {
		File file = new File("C:\\Users\\Admin\\Desktop\\b\\a.docx");
		if (file.renameTo(new File("C:\\Users\\Admin\\Desktop\\aaaaaaaa" + file.getName()))) {
			System.out.println("File is moved successful!");
		} else {
			throw new Exception("Error! file not exist");
		}
	}

	// Question 9: Rename File
	public static void Question9() throws Exception {
		File oldfile = new File("C:\\Users\\Admin\\Desktop\\b\\d.docx");
		File newfile = new File("C:\\Users\\Admin\\Desktop\\b\\d.docx");
		if (oldfile.exists()) {
			throw new Exception("Error! file not exist");
		} else if (newfile.exists()) {
			throw new SameNameException("Error! Name is Exist");
		} else {
			boolean success = oldfile.renameTo(newfile);
			System.out.println("Rename successfully!");
		}
	}
	//Question 10: Create new folder
	public static void Question10() {
	//	tuong tu cau 1
	}
}
