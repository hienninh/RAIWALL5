package com.vti.backend;

import com.vti.question.InheritanceQ1.QLCB;
import com.vti.question.InheritanceQ3.HighSchoolStudent;
import com.vti.question.InheritanceQ4.QLTV;

public class Ex5_Inheritance {

//		Exercise 5: Inheritance
//		Chú ý: áp dụng cả encapsulation cho các question ở dưới

	public void question1() {
		QLCB qlcb = new QLCB();
		qlcb.addCanBo();
		qlcb.print();
		qlcb.findName();
		qlcb.delete();

//		Question 1: inheritance
//		Một đơn vị sản xuất gồm có các cán bộ là công nhân, kỹ sư, nhân viên.
//		Mỗi cán bộ cần quản lý các dữ liệu: Họ tên, tuổi, giới tính(name, nữ,
//		khác), địa chỉ.
//		Cấp công nhân sẽ có thêm các thuộc tính riêng: Bậc (1 đến 10).
//		Cấp kỹ sư có thuộc tính riêng: Nghành đào tạo.
//		Các nhân viên có thuộc tính riêng: công việc.
//		Hãy xây dựng các lớp CongNhan, KySu, NhanVien kế thừa từ lớp
//		CanBo.
	}
//	Question 3 (Optional): constructor inheritance
//	Tạo class abstract Person gồm các property name và tạo constructor có
//	1 parameter name
//	Tạo class abstract Student kế thừa Person gồm các property id, name
//	và tạo constructor có 2 parameter id, name
//	Tạo class HighSchoolStudent kế thừa Student bao gồm các property id,
//	name, clazz (Lớp đang học), desiredUniversity (trường đại học mong
//	muốn vào) và tạo constructor có 4 parameter id, name, clazz,
//	desiredUniversity.
//	Hãy khởi tạo Object HighSchoolStudent với các giá trị: id = 1, name =
//	"Nam", clazz = "Chuyên Văn", desiredUniversity = "Đại học công
//	nghệ"

	HighSchoolStudent str = new HighSchoolStudent(1, "Nam", "Chuyen Van", "DH Cong nghe");

//Question 4 (Optional):
//Một thư viện cần quản lý các tài liệu bao gồm Sách, Tạp chí, Báo. Mỗi
//tài liệu gồm có các thuộc tính sau: Mã tài liệu(Mã tài liệu là duy nhất),
//Tên nhà xuất bản, số bản phát hành.
//Các loại sách cần quản lý thêm các thuộc tính: tên tác giả, số trang.
//Các tạp chí cần quản lý thêm: Số phát hành, tháng phát hành.
//Các báo cần quản lý thêm: Ngày phát hành.
//Xây dựng chương trình để quản lý tài liệu (QLTV) cho thư viện một
//cách hiệu quả.
//Xây dựng lớp QuanLySach có các chức năng sau
//a) Thêm mới tài liêu: Sách, tạp chí, báo.
//b) Xoá tài liệu theo mã tài liệu.
//c) Hiện thị thông tin về tài liệu.
//d) Tìm kiếm tài liệu theo loại: Sách, tạp chí, báo.
//e) Thoát khỏi chương trình

	public void question4() {
		QLTV qltv = new QLTV();
		qltv.addTaiLieu();
		qltv.delete();
		qltv.prin();
		qltv.findTL();
	}
}
