-- G:\My Drive\EPD_03\SQL_Document\Assignment\Testing System\SQL – Assignment 3

-- Question 2: lấy ra tất cả các phòng ban
SELECT *
FROM Department;
SELECT DEPARTMENT_NAME
FROM Department;

-- Question 3: lấy ra id của phòng ban "Sale"
SELECT *
FROM department
where DEPARTMENT_Name ='sale';

-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT *
From `account`
WHERE LENGTH(Full_name) = (SELECT Max(LENGTH(Full_name)) From `account`)
ORDER BY Full_name DESC;

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 4
SELECT *
From `account`
WHERE LENGTH(Full_name) = (SELECT Max(LENGTH(Full_name)) From `account`) AND DEPARTMENT_ID = 4;

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT *
From `group`
WHERE CREATE_DATE < '2019-12-20';

-- Question 7: Lấy ra ID của question có >= 4 câu trả lời
SELECT *
From question;

-- Question 8: Lấy ra các ACCOUNT_ID co ten bat dau bang chu "N" và được tạo trước ngày 01/04/2020
SELECT	*
From 	`Account`
WHERE	FULL_NAME like ('N%') and	CREATE_DATE < '2020-04-01';
SELECT *
From exam;

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT *
From `group`
ORDER BY CREATE_DATE DESC
LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 2
SELECT count(*)
From department
WHERE DEPARTMENT_ID = 2;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT *
From `account`
WHERE FULL_NAME like	('D%O');
-- Question 12: Xóa tất cả các Group được tạo trước ngày 20/12/2019

-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn

update	`account`
SET		FULL_NAME = N'Nguyễn Bá Lộc',
		Email = 'loc.nguyenba@vti.com.vn'
WHERE 	ACCOUNT_ID = 5;

-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
SELECT 	*
From 	groupaccount
where	GROUP_ID = 4;

update	groupaccount
set		ACCOUNT_ID = 5
where	GROUP_ID = 4;
