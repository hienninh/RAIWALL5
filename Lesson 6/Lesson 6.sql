-- CREATE PROCEDURE IN
DROP PROCEDURE IF EXISTS Position_Full_Name;
DeLimiter $$
CREATE	PROCEDURE	Position_Full_Name (IN IN_Full_Name VARCHAR(50))
BEGIN
	SELECT	A.POSITION_ID, POSITION_NAME, FULL_NAME
	FROM	Position P
	JOIN	`Account` A	ON	A.Position_ID = P.Position_ID
	WHERE	FULL_NAME = IN_Full_Name;
END$$
DeLimiter ;
-- Using
Call	Position_Full_Name ('Tong Quang Anh');

/*==== CREATE PROCEDURE OUT====*/

-- Testing_System_6.pdf
-- Question 1: Tạo store để người dùng nhập vào tên phòng ban và in ra tất cả các account thuộc phòng ban đó
DROP PROCEDURE IF EXISTS	Account_of_A_Department;
DeLimiter $$
CREATE	PROCEDURE	Account_of_A_Department (IN IN_DEPARTMENT_ID TINYINT UNSIGNED)
BEGIN
SELECT	D.DEPARTMENT_ID, D.DEPARTMENT_NAME, A.FULL_NAME
From	`Account`	A
RIGHT	JOIN	Department	D ON	A.DEPARTMENT_ID = D.DEPARTMENT_ID
WHERE	D.DEPARTMENT_ID = IN_DEPARTMENT_ID;
END$$
DeLimiter ;
Call	Account_of_A_Department (6);

-- Question 2: Tạo store để in ra số lượng account trong mỗi group
DROP	PROCEDURE	IF EXISTS Count_Account_of_Group;
DeLimiter $$
CREATE	PROCEDURE	Count_Account_of_Group	(IN in_Group_ID TINYINT	UNSIGNED)
BEGIN
SELECT	DISTINCT	 Group_ID, Count(Account_ID), GROUP_CONCAT(ACCOUNT_ID)
FROM		Groupaccount
WHERE		Group_ID = 8
GROUP BY	Group_ID;
END$$
DeLimiter ;
Call	Count_Account_of_Group (8);

-- Question 3: Tạo store để thống kê mỗi type question có bao nhiêu question được tạo trong tháng hiện tại
DROP	PROCEDURE	IF EXISTS Type_Question_Of_Month;
DeLimiter $$
CREATE	PROCEDURE Type_Question_Of_Month ()
BEGIN
SELECT	TQ.TYPE_ID, TYPE_NAME,  CREATE_DATE,Count(QUESTION_ID), Group_Concat(Q.CONTENT)
FROM	Question Q
JOIN	Typequestion TQ	ON Q.TYPE_ID = TQ.TYPE_ID
WHERE	MONTH (CREATE_DATE) = month(NOW())
GROUP BY MONTH (CREATE_DATE);
END$$;
DELIMITER $$
Call	Type_Question_Of_Month ();	
-- Tai sao phai lenh where roi moi Group by

-- Question 4: Tạo store để trả ra id của type question có nhiều câu hỏi nhất
DROP	PROCEDURE	IF EXISTS Tyde_Have_Max_Count_Question;
DeLimiter $$
CREATE	PROCEDURE Tyde_Have_Max_Count_Question ()
BEGIN
With	Max_Count_Question_Of_Tyde AS
(Select	Count(QUESTION_ID)
FROM		Question Q
JOIN		Typequestion TQ	ON Q.TYPE_ID = TQ.TYPE_ID
GROUP BY	Q.TYPE_ID
LIMIT 		1)
SELECT		TQ.TYPE_ID, TYPE_NAME,  CREATE_DATE,Count(QUESTION_ID), Group_Concat(Q.CONTENT)
FROM		Question Q
JOIN		Typequestion TQ	ON Q.TYPE_ID = TQ.TYPE_ID
GROUP BY	Q.TYPE_ID
HAVING		Count(QUESTION_ID) = (Select * FROM	Max_Count_Question_Of_Tyde);
END$$
DeLimiter ;
Call	Tyde_Have_Max_Count_Question();
