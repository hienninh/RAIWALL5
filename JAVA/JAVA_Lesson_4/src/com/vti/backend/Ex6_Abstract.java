package com.vti.backend;

import com.vti.question.AbstractQ1.VNPhone;

public class Ex6_Abstract {

//		Question 1: abstract class & abstract method
//		Tạo 1 class Phone để lưu thông tin liên lạc, trong Phone có chứa 1
//		property có kiểu dữ liệu là Array contacts, trong từng contact có lưu
//		thông tin number, name
//		a) Tạo các abstract method
//		a. void insertContact(String name, String phone)
//		b. void removeContact(String name)
//		c. void updateContact(String name, String newPhone)
//		d. void searchContact(String name)
//		b) Tạo class VietnamesePhone kế thừa Phone và triển khai các
//		method abstract
//		Viết chương trình demo 
	public void Question1() {
		VNPhone vnPhone = new VNPhone();
		vnPhone.insertContact();
		vnPhone.printContacts();
		vnPhone.removeContact();
		vnPhone.updateContact();
		vnPhone.searchContact();
	}

}
