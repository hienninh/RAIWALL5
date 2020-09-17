-- G:\My Drive\EPD_03\SQL_Document\Assignment\Testing System\SQL – Assignment 3

-- Question 2: lấy ra tất cả các phòng ban
SELECT *
FROM Department;
SELECT DEPARTMENT_NAME
FROM Department;

-- Question 3: lấy ra id của phòng ban "Sale"
SELECT	DEPARTMENT_ID
FROM 	Department
where 	DEPARTMENT_Name ='sale';

-- Question 4: lấy ra thông tin account có full name dài nhất
SELECT *
From `account`
WHERE LENGTH(Full_name) = (SELECT Max(LENGTH(Full_name)) From `account`);

-- Question 5: Lấy ra thông tin account có full name dài nhất và thuộc phòng ban có id = 3
WITH Account_Department3 AS
(SELECT *
From `account`
WHERE  DEPARTMENT_ID = 3)
SELECT *
FROM	Account_Department3 
WHERE length(Full_name) = (SELECT Max(LENGTH(Full_name)) From Account_Department3);

-- Question 6: Lấy ra tên group đã tham gia trước ngày 20/12/2019
SELECT *
From `group`
WHERE CREATE_DATE < '2019-12-20';

-- Question 7: Lấy ra ID của question có >= 2 câu trả lời

SELECT 		Question_ID, count(ANSWER_ID) AS So_Luong
FROM		answer
GROUP BY 	QUESTION_ID
HAVING		count(ANSWER_ID) >= 2;

SELECT 		Question_ID, GROUP_CONCAT(ANSWER_ID SEPARATOR ':') AS So_Luong -- Liệt kê các Answer_ID , ngăn cách bằng :)
From		answer
group by	QUESTION_ID
HAVING		count(ANSWER_ID) >= 2;

SELECT GROUP_CONCAT(CONTENT SEPARATOR ';')
FROM answer;
-- Question 8: Lấy ra các ACCOUNT_ID co ten bat dau bang chu "N" và được tạo trước ngày 01/04/2020
SELECT	*
From 	`Account`
WHERE	FULL_NAME like ('N%') and	CREATE_DATE < '2020-04-01';

-- Question 8: Lấy ra các mã đề thi có thời gian thi >= 60 phút và được tạo trước ngày 20/12/2019
SELECT	*
From	exam
WHERE	DURATION >= 60 AND CREATE_DATE < '2019-12-20';

-- Question 9: Lấy ra 5 group được tạo gần đây nhất
SELECT *
From `group`
ORDER BY CREATE_DATE DESC
LIMIT 5;

-- Question 10: Đếm số nhân viên thuộc department có id = 4
SELECT 	DEPARTMENT_ID, count(ACCOUNT_ID), GROUP_CONCAT(FULL_NAME SEPARATOR ';')
From	`account`
WHERE 	DEPARTMENT_ID = 4;

-- Question 11: Lấy ra nhân viên có tên bắt đầu bằng chữ "D" và kết thúc bằng chữ "o"
SELECT *
From `account`
WHERE FULL_NAME like	('D%O');

-- Question 12: Xóa tất cả các Group được tạo trước ngày 20/12/2019
SELECT	* FROM `Group`;

DELETE
FROM	`Group`
WHERE	CREATE_DATE < '2019-12-20';
-- Xóa thêm Foreign Key của bảng GroupAccount
-- Question 13: Xóa tất cả các question có nội dung bắt đầu bằng từ "câu hỏi"
SELECT	* FROM Question;

DELETE
FROM	Question
WHERE	CONTENT LIKE 'câu hỏi %';
-- Xóa thêm Foreign Key của bảng Ansrew và ExamQuestion
-- Question 14: Update thông tin của account có id = 5 thành tên "Nguyễn Bá Lộc" và email thành loc.nguyenba@vti.com.vn
update	`account`
SET		FULL_NAME = N'Nguyễn Bá Lộc',
		Email = 'loc.nguyenba@vti.com.vn'
WHERE 	ACCOUNT_ID = 5;
SELECT	* FROM	`account`;
-- Question 15: update account có id = 5 sẽ thuộc group có id = 4
SELECT 	*
From 	groupaccount
where	GROUP_ID = 4;

update	groupaccount
set		ACCOUNT_ID = 5
where	GROUP_ID = 4;
